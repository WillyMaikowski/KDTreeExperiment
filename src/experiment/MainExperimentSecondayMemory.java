package experiment;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import recordfile.RecordsFileException;
import secmemorywilly.MeanSecMemKDTreeNode;
import KDTree.KDTree;
import KDTree.Point;

public class MainExperimentSecondayMemory {

	public static void main( String[] args ) {
		int minN = 10;
		int maxN = 10;
		KDTree experimentTree;
		long startTime;
		long stopTime;
		long elapsedTime;
		String treeName;
		String pointName;
		PrintWriter writer;
		double c = 1.0;

		try {
			
			// MeanKDTree con puntos de baja discrepancia
			{
				treeName = "MeanKDTreeSecondaryMemory";
				pointName = "LowDiscrepancy";
				writer = new PrintWriter( "resultados_construccion_" + treeName
				      + "_" + pointName + " _" + Math.random() + ".txt" );

				for( int size = minN; size <= maxN; size++ ) {
					SecondaryMemoryExperimentContainer expCont = new SecondaryMemoryExperimentContainer(
					      treeName, pointName, (int) Math.pow( 2, size ) );

					while( !expCont.finished() ) {
						List<Point> listofPoints = generateLowDiscrepancyPoints( c,
						      size );
						startTime = System.currentTimeMillis();
						experimentTree = new MeanSecMemKDTreeNode( listofPoints, "SecondaryMemory_"+size+"_"+Math.random()+".txt" );
						stopTime = System.currentTimeMillis();
						elapsedTime = stopTime - startTime;
						expCont.addObservation( experimentTree.height(), elapsedTime,
								experimentTree.getLenghtOfFile(), experimentTree.getNumAccess() );
					}
					writer.println( expCont.getResult() );
					System.out.println( "Termino 2^" + size + " " + treeName + " "
					      + pointName );
				}
				writer.close();
			}

		}
		catch( FileNotFoundException e ) {
			e.printStackTrace();
		}
		catch( IOException e ) {
			e.printStackTrace();
		}
      catch( RecordsFileException e ) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
      }
	}

	/**
	 * genera 2^n puntos al azar
	 * 
	 * @param n
	 * @return
	 */
	public static List<Point> generateRandomPoints( double c, int n ) {
		List<Point> result = new ArrayList<Point>();
		double numPoints = Math.pow( 2, n );
		for( int i = 1; i <= numPoints; i++ ) {
			result.add( generateRandomPoint( 0, 0, ( c * Math.sqrt( numPoints ) ),
			      ( c * Math.sqrt( numPoints ) ) ) );
		}
		return result;
	}

	public static List<Point> generateLowDiscrepancyPoints( double c, int n ) {
		List<Point> result = new ArrayList<Point>();
		double numPoints = Math.pow( 2, n );
		double delta = c;

		for( double i = 0; i < c * Math.sqrt( numPoints ); i = i + delta ) {
			for( double j = 0; j < c * Math.sqrt( numPoints ); j = j + delta ) {
				result.add( generateRandomPoint( i, j, i + delta, j + delta ) );
			}
		}

		return result;
	}

	public static Point generateRandomPoint( double x0, double y0, double x1,
	      double y1 ) {
		Point result = new Point( random( x0, x1 ), random( y0, y1 ) );
		return result;
	}

	public static double random( double i, double n ) {
		return i + ( n - i ) * Math.random();
	}

}
