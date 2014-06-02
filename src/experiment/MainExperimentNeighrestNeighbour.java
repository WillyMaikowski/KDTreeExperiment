package experiment;

import java.io.FileNotFoundException;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import KDTree.KDTree;
import KDTree.MeanKDTreeNode;
import KDTree.MedianKDTreeNode;
import KDTree.Point;

public class MainExperimentNeighrestNeighbour {

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
		List<Point> q;
		int inputSize = 7;

		try {
			// MeanKDTree con puntos aleatorios
			{
				treeName = "MeanKDTree";
				pointName = "RandomPoints";
				writer = new PrintWriter( "resultados_nn_" + treeName + "_"
				      + pointName + " _" + Math.random() + ".txt" );

				for( int size = minN; size <= maxN; size++ ) {

					// construyo el arbol
					List<Point> listofPoints = generateRandomPoints( c, size );
					experimentTree = new MeanKDTreeNode( listofPoints );

					q = generateRandomPoints( c, inputSize );
					startTime = System.currentTimeMillis();
					for( Point p : q ) {
						experimentTree.VecinoMasCercano( p );
					}
					stopTime = System.currentTimeMillis();
					elapsedTime = stopTime - startTime;
					writer.println( "RandomPoints \t" + size + "\t"
					      + Math.pow( 2, size ) + "\t" + elapsedTime );

					q = generateLowDiscrepancyPoints( c, inputSize );
					startTime = System.currentTimeMillis();
					for( Point p : q ) {
						experimentTree.VecinoMasCercano( p );
					}
					stopTime = System.currentTimeMillis();
					elapsedTime = stopTime - startTime;
					writer.println( "LowDiscrepancyPoints \t" + size + "\t"
					      + Math.pow( 2, size ) + "\t" + elapsedTime );

					System.out.println( "Listo 1 2^" + size );
				}
				writer.close();
			}
			System.out.println( "Listo 1 Todo" );

			// MeanKDTree con puntos de baja discrepancia
			{
				treeName = "MeanKDTree";
				pointName = "LowDiscrepancyPoints";
				writer = new PrintWriter( "resultados_nn_" + treeName + "_"
				      + pointName + " _" + Math.random() + ".txt" );

				for( int size = minN; size <= maxN; size++ ) {

					// construyo el arbol
					List<Point> listofPoints = generateLowDiscrepancyPoints( c, size );
					experimentTree = new MeanKDTreeNode( listofPoints );

					q = generateRandomPoints( c, inputSize );
					startTime = System.currentTimeMillis();
					for( Point p : q ) {
						experimentTree.VecinoMasCercano( p );
					}
					stopTime = System.currentTimeMillis();
					elapsedTime = stopTime - startTime;
					writer.println( "RandomPoints \t" + size + "\t"
					      + Math.pow( 2, size ) + "\t" + elapsedTime );

					q = generateLowDiscrepancyPoints( c, inputSize );
					startTime = System.currentTimeMillis();
					for( Point p : q ) {
						experimentTree.VecinoMasCercano( p );
					}
					stopTime = System.currentTimeMillis();
					elapsedTime = stopTime - startTime;
					writer.println( "LowDiscrepancyPoints \t" + size + "\t"
					      + Math.pow( 2, size ) + "\t" + elapsedTime );
					System.out.println( "Listo 2 2^" + size );
				}
				writer.close();
			}
			System.out.println( "Listo 2 Todo" );

			// MedianKDTree con puntos aleatorios
			{
				treeName = "MedianKDTree";
				pointName = "RandomPoints";
				writer = new PrintWriter( "resultados_nn_" + treeName + "_"
				      + pointName + " _" + Math.random() + ".txt" );

				for( int size = minN; size <= maxN; size++ ) {

					// construyo el arbol
					List<Point> listofPoints = generateRandomPoints( c, size );
					experimentTree = new MedianKDTreeNode( listofPoints );

					q = generateRandomPoints( c, inputSize );
					startTime = System.currentTimeMillis();
					for( Point p : q ) {
						experimentTree.VecinoMasCercano( p );
					}
					stopTime = System.currentTimeMillis();
					elapsedTime = stopTime - startTime;
					writer.println( "RandomPoints \t" + size + "\t"
					      + Math.pow( 2, size ) + "\t" + elapsedTime );

					q = generateLowDiscrepancyPoints( c, inputSize );
					startTime = System.currentTimeMillis();
					for( Point p : q ) {
						experimentTree.VecinoMasCercano( p );
					}
					stopTime = System.currentTimeMillis();
					elapsedTime = stopTime - startTime;
					writer.println( "LowDiscrepancyPoints \t" + size + "\t"
					      + Math.pow( 2, size ) + "\t" + elapsedTime );

					System.out.println( "Listo 3 2^" + size );
				}
				writer.close();
			}
			System.out.println( "Listo 3 Todo" );

			// MedianKDTree con puntos de baja discrepancia
			{
				treeName = "MedianKDTree";
				pointName = "LowDiscrepancy";
				writer = new PrintWriter( "resultados_nn_" + treeName + "_"
				      + pointName + " _" + Math.random() + ".txt" );

				for( int size = minN; size <= maxN; size++ ) {

					// construyo el arbol
					List<Point> listofPoints = generateLowDiscrepancyPoints( c, size );
					experimentTree = new MedianKDTreeNode( listofPoints );

					q = generateRandomPoints( c, inputSize );
					startTime = System.currentTimeMillis();
					for( Point p : q ) {
						experimentTree.VecinoMasCercano( p );
					}
					stopTime = System.currentTimeMillis();
					elapsedTime = stopTime - startTime;
					writer.println( "RandomPoints \t" + size + "\t"
					      + Math.pow( 2, size ) + "\t" + elapsedTime );

					q = generateLowDiscrepancyPoints( c, inputSize );
					startTime = System.currentTimeMillis();
					for( Point p : q ) {
						experimentTree.VecinoMasCercano( p );
					}
					stopTime = System.currentTimeMillis();
					elapsedTime = stopTime - startTime;
					writer.println( "LowDiscrepancyPoints \t" + size + "\t"
					      + Math.pow( 2, size ) + "\t" + elapsedTime );

					System.out.println( "Listo 4 2^" + size );
				}
				writer.close();
			}
			System.out.println( "Listo 4 Todo" );

		}
		catch( FileNotFoundException e ) {
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
			result.add( generateRandomPoint( 0, 0,
			      (int) ( c * Math.sqrt( numPoints ) ),
			      (int) ( c * Math.sqrt( numPoints ) ) ) );
		}

		return result;
	}

	public static List<Point> generateLowDiscrepancyPoints( double c, int n ) {
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
