import java.awt.Point;
import java.util.ArrayList;

public class MeanXAxis extends AbstractAxis {

	private double coord;

	public Axis getPerpendicular() {
		return new MeanYAxis();
	}

	public void setL( ArrayList<Point> points ) {
		Point min = points.get( 0 );
		Point max = points.get( 0 );
		for( Point p : points ) {
			if( p.x < min.x ) min = p;
			if( p.x > max.x ) max = p;
		}
		this.coord = ( min.x + max.x ) / 2;
	}

	public int compare( Point p2 ) {
		return (int) this.coord - p2.x;
	}

}
