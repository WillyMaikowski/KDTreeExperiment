package experiment;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class MainExperiment {

    public static void main( String[] args ) {

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

	for ( int i = 1; i <= numPoints; i++ ){
	    result.add( generateRandomPoint( 0, 0,
		    ( c * Math.sqrt( numPoints ) ),
		    ( c * Math.sqrt( numPoints ) ) ) );
	}

	return result;
    }

    public static List<Point> generateLowDiscrepancyPoints( int c, int n ) {
	List<Point> result = new ArrayList<Point>();
	double numPoints = Math.pow( 2, n );
	double delta = Math.pow( c, 2 );

	for ( double i = 0; i < c * Math.sqrt( numPoints ); i = i + delta ){
	    for ( double j = 0; j < c * Math.sqrt( numPoints ); j = j + delta ){
		result.add( generateRandomPoint( i, j, i + delta, j + delta ) );
	    }
	}

	return result;
    }

    public static Point generateRandomPoint( double x0, double y0, double x1,
	    double y1 ) {
	Point result = new Point();
	result.setLocation( random( x0, x1 ), random( y0, y1 ) );
	return result;
    }

    public static double random( double i, double n ) {
	return Math.round( ( i + ( n - i ) * Math.random() ) );
    }

}
