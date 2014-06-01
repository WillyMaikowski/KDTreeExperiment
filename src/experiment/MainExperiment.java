package experiment;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import draw.DrawablePoint;
import KDTree.KDTree;
import KDTree.MeanKDTreeNode;
import KDTree.Point;

public class MainExperiment {

	/*
	 * public static void main( String[] args ) {
	 * 
	 * int c = 1; int n = 20; int x = (int) ( c * Math.sqrt( Math.pow( 2, n ) ) )
	 * * 10; int y = (int) ( c * Math.sqrt( Math.pow( 2, n ) ) ) * 10;
	 * 
	 * List<Point> listofPoints = generateRandomPoints( c, n );
	 * 
	 * JFrame frame = new JFrame( "Points" ); frame.setDefaultCloseOperation(
	 * JFrame.EXIT_ON_CLOSE ); frame.setSize( x, y );
	 * 
	 * frame.add( new DrawablePoint( listofPoints ) );
	 * 
	 * frame.setVisible( true ); }
	 */

	public static void main( String[] args ) {
		/*
		 * int c = 1; int n = 20; List<Point> listofPoints = generateRandomPoints(
		 * c, n ); List<Point> listofPoints2 = listofPoints;
		 * 
		 * long startTime = System.currentTimeMillis(); KDTree tree = new
		 * MeanKDTreeNode( listofPoints ); long stopTime =
		 * System.currentTimeMillis(); long elapsedTime = stopTime - startTime;
		 * System.out.println( "Tiempo crear mean= " + elapsedTime );
		 * 
		 * startTime = System.currentTimeMillis(); KDTree tree2 = new
		 * MedianKDTreeNode( listofPoints2 ); stopTime =
		 * System.currentTimeMillis(); elapsedTime = stopTime - startTime;
		 * System.out.println( "Tiempo crear median= " + elapsedTime );
		 * 
		 * System.out.println( "Altura mean= " + tree.height() );
		 * System.out.println( "Altura median= " + tree2.height() );
		 * 
		 * startTime = System.currentTimeMillis(); System.out.println(
		 * tree.VecinoMasCercano( listofPoints.get( listofPoints.size() -1 ) ) );
		 * stopTime = System.currentTimeMillis(); elapsedTime = stopTime -
		 * startTime; System.out.println( "Tiempo consulta mean= " + elapsedTime
		 * );
		 * 
		 * startTime = System.currentTimeMillis(); System.out.println(
		 * tree2.VecinoMasCercano( listofPoints.get( listofPoints.size() -1 ) ) );
		 * stopTime = System.currentTimeMillis(); elapsedTime = stopTime -
		 * startTime; System.out.println( "Tiempo consulta median= " + elapsedTime
		 * );
		 */

		int minN = 10;
		int maxN = 10;
		KDTree experimentTree;
		long startTime;
		long stopTime;
		long elapsedTime;

		try {
			// MeanKDTree con puntos aleatorios
			{
				double rndNumber = Math.random();
				PrintWriter writer = new PrintWriter(
				      "resultados_MeanKDTree_RandomPoints" + "_" + rndNumber
				            + ".txt" );

				for( int size = minN; size <= maxN; size++ ) {
					StructExperimentContainer expCont = new StructExperimentContainer(
					      "MeanKDTree", "RandomPoints", (int) Math.pow( 2, size ) );

					while( !expCont.finished() ) {
						List<Point> listofPoints = generateRandomPoints( 1, size );
						startTime = System.currentTimeMillis();
						experimentTree = new MeanKDTreeNode( listofPoints );
						stopTime = System.currentTimeMillis();
						elapsedTime = stopTime - startTime;
						expCont.addObservation( experimentTree.height(), elapsedTime, sizeof( experimentTree ) );
					}
					writer.println( expCont.getResult() );
				}
				writer.close();
			}

			// MeanKDTree con puntos de baja discrepancia

			// MedianKDTree con puntos aleatorios

			// MedianKDTree con puntos de baja discrepancia
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
	public static List<Point> generateRandomPoints( int c, int n ) {
		List<Point> result = new ArrayList<Point>();
		double numPoints = Math.pow( 2, n );

		for( int i = 1; i <= numPoints; i++ ) {
			result.add( generateRandomPoint( 0, 0,
			      (int) ( c * Math.sqrt( numPoints ) ),
			      (int) ( c * Math.sqrt( numPoints ) ) ) );
		}

		return result;
	}

	public static List<Point> generateLowDiscrepancyPoints( int c, int n ) {
		List<Point> result = new ArrayList<Point>();
		double numPoints = Math.pow( 2, n );
		double delta = Math.pow( c, 2 );

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
