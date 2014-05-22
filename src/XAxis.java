import java.awt.Point;
import java.util.ArrayList;


public class XAxis extends AbstractAxis {

	public Axis getPerpendicular() {
		return new YAxis();
	}

	public Point getL( ArrayList<Point> points ) {
		Point min = points.get( 0 );
		Point max = points.get( 0 );
		for( Point p : points ) {
			if( p.x < min.x ) min = p;
			if( p.x > max.x ) max = p;
		}
		Point l = new Point( (min.x+max.x)/2, 0 );
		return l;
	}

	public int compare( Point p1, Point p2 ) {
		return p1.x - p2.x;
	}

}
