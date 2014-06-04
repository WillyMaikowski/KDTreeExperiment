package experiment;

import java.util.ArrayList;
import java.util.List;

import KDTree.KDTree;
import KDTree.MeanKDTreeNode;

import KDTree.Point;

public class TestNeighestNeighbour {

	public static void main( String[] args ) {

		KDTree experimentTree;

		double c = 1.0;

		double minDistance = Double.MAX_VALUE;
		Point minDistancePoint = new Point( Double.MAX_VALUE, Double.MAX_VALUE );

		List<Point> listofPoints = generateRandomPoints( c, 20 );
		experimentTree = new MeanKDTreeNode( listofPoints );

		Point ff = generateRandomPoints( c, 20 ).get(
		      (int) random( 0, listofPoints.size() - 1 ) );

		for( int i = 0; i < listofPoints.size(); i++ ) {
			double dist = ff.distance( listofPoints.get( i ) );
			if( dist < minDistance ) {
				minDistance = dist;
				minDistancePoint = listofPoints.get( i );
			}
		}

		System.out.println( "Punto fuerza bruta =" + minDistancePoint );
		System.out.println( "Distancia fuerza bruta =" + minDistance );

		Point res = experimentTree.VecinoMasCercano( ff );

		System.out.println( "Punto kd =" + res );
		System.out.println( "Distancia kd =" + ff.distance( res ) );

		System.out
		      .println( "Deberia ser 0.0: " + res.distance( minDistancePoint ) );

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
