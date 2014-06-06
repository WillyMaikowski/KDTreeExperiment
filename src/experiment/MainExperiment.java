package experiment;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import KDTree.KDTree;
import KDTree.MeanKDTreeNode;
import KDTree.MedianKDTreeNode;
import KDTree.Point;

public class MainExperiment {

	public static void main( String[] args ) {
		int minN = 10;
		int maxN = 20;
		KDTree experimentTree;
		long startTime;
		long stopTime;
		long elapsedTime;
		String treeName;
		String pointName;
		PrintWriter writer;
		double c = 1.0;
		
		/*List<Point> listofsPoints = generateRandomPoints( c, 6 );
		experimentTree = new MeanKDTreeNode( listofsPoints );
		try {
	      int treeSize = sizeof( experimentTree );
	      System.out.println(treeSize);
      }
      catch( IOException e1 ) {
	      // TODO Auto-generated catch block
	      e1.printStackTrace();
      }*/
		
		try {
			// MeanKDTree con puntos aleatorios
			{
				treeName = "MeanKDTree";
				pointName = "RandomPoints";
				writer = new PrintWriter( "resultados_construccion_" + treeName
				      + "_" + pointName + " _" + Math.random() + ".txt" );

				for( int size = minN; size <= maxN; size++ ) {
					StructExperimentContainer expCont = new StructExperimentContainer(
					      treeName, pointName, (int) Math.pow( 2, size ) );

					while( !expCont.finished() ) {
						List<Point> listofPoints = generateRandomPoints( c, size );
						startTime = System.currentTimeMillis();
						experimentTree = new MeanKDTreeNode( listofPoints );
						stopTime = System.currentTimeMillis();
						elapsedTime = stopTime - startTime;
						expCont.addObservation( experimentTree.height(), elapsedTime,
						      sizeof( experimentTree ) );
					}
					writer.println( expCont.getResult() );
					System.out.println( "Termino 2^" + size + " " + treeName + " "
					      + pointName );
				}
				writer.close();
			}

			// MeanKDTree con puntos de baja discrepancia
			{
				treeName = "MeanKDTree";
				pointName = "LowDiscrepancy";
				writer = new PrintWriter( "resultados_construccion_" + treeName
				      + "_" + pointName + " _" + Math.random() + ".txt" );

				for( int size = minN; size <= maxN; size++ ) {
					StructExperimentContainer expCont = new StructExperimentContainer(
					      treeName, pointName, (int) Math.pow( 2, size ) );

					while( !expCont.finished() ) {
						List<Point> listofPoints = generateLowDiscrepancyPoints( c,
						      size );
						startTime = System.currentTimeMillis();
						experimentTree = new MeanKDTreeNode( listofPoints );
						stopTime = System.currentTimeMillis();
						elapsedTime = stopTime - startTime;
						expCont.addObservation( experimentTree.height(), elapsedTime,
						      sizeof( experimentTree ) );
					}
					writer.println( expCont.getResult() );
					System.out.println( "Termino 2^" + size + " " + treeName + " "
					      + pointName );
				}
				writer.close();
			}

			// MedianKDTree con puntos aleatorios
			{
				treeName = "MedianKDTree";
				pointName = "RandomPoints";
				writer = new PrintWriter( "resultados_construccion_" + treeName
				      + "_" + pointName + " _" + Math.random() + ".txt" );

				for( int size = minN; size <= maxN; size++ ) {
					StructExperimentContainer expCont = new StructExperimentContainer(
					      treeName, pointName, (int) Math.pow( 2, size ) );

					while( !expCont.finished() ) {
						List<Point> listofPoints = generateRandomPoints( c, size );
						startTime = System.currentTimeMillis();
						experimentTree = new MedianKDTreeNode( listofPoints );
						stopTime = System.currentTimeMillis();
						elapsedTime = stopTime - startTime;
						expCont.addObservation( experimentTree.height(), elapsedTime,
						      sizeof( experimentTree ) );
					}
					writer.println( expCont.getResult() );
					System.out.println( "Termino 2^" + size + " " + treeName + " "
					      + pointName );
				}
				writer.close();
			}

			// MedianKDTree con puntos de baja discrepancia
			{
				treeName = "MedianKDTree";
				pointName = "LowDiscrepancy";
				writer = new PrintWriter( "resultados_construccion_" + treeName
				      + "_" + pointName + " _" + Math.random() + ".txt" );

				for( int size = minN; size <= maxN; size++ ) {
					StructExperimentContainer expCont = new StructExperimentContainer(
					      treeName, pointName, (int) Math.pow( 2, size ) );

					while( !expCont.finished() ) {
						List<Point> listofPoints = generateLowDiscrepancyPoints( c,
						      size );
						startTime = System.currentTimeMillis();
						experimentTree = new MedianKDTreeNode( listofPoints );
						stopTime = System.currentTimeMillis();
						elapsedTime = stopTime - startTime;
						expCont.addObservation( experimentTree.height(), elapsedTime,
						      sizeof( experimentTree ) );
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
	}

	public static int sizeof( Object obj ) throws IOException {

		ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(
		      byteOutputStream );

		objectOutputStream.writeObject( obj );
		objectOutputStream.flush();
		objectOutputStream.close();

		return byteOutputStream.toByteArray().length;
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
