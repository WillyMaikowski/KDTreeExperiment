package experiment;

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
     * int c = 1; int n = 10; int x = (int) ( c * Math.sqrt( Math.pow( 2, n ) )
     * ) * 10; int y = (int) ( c * Math.sqrt( Math.pow( 2, n ) ) ) * 10;
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
	int c = 1;
	int n = 21;
	List<Point> listofPoints = generateRandomPoints( c, n );

	KDTree tree = new MeanKDTreeNode( listofPoints );

	System.out.println( tree.height() );

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
		    (int) ( c * Math.sqrt( numPoints ) ),
		    (int) ( c * Math.sqrt( numPoints ) ) ) );
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
	Point result = new Point( random( x0, x1 ), random( y0, y1 ) );

	return result;
    }

    public static double random( double i, double n ) {
	return i + ( n - i ) * Math.random();
    }

}
