import java.awt.Point;
import java.util.ArrayList;


public class YAxis extends AbstractAxis {

	public Axis getPerpendicular() {
		return new XAxis();
	}

	public Point getL( ArrayList<Point> points ) {
		Point min = points.get( 0 );
		Point max = points.get( 0 );
		for( Point p : points ) {
			if( p.y < min.y ) min = p;
			if( p.y > max.y ) max = p;
		}
		Point l = new Point( 0, ( min.y+max.y )/2 );
		return l;
	}

	public int compare( Point p1, Point p2 ) {
		return p1.y - p2.y;
	}

}
