package KDTree;

import KDTree.Point;
import java.util.List;

public class MeanYAxis extends AbstractAxis {

	/**
	 * 
	 */
   private static final long serialVersionUID = 6554929641089841312L;
	
	public Axis getPerpendicular() {
		return new MeanXAxis();
	}

	public void setL( List<Point> points ) {
		Point min = points.get( 0 );
		Point max = points.get( 0 );
		for( Point p : points ) {
			if( p.getY() < min.getY() ) min = p;
			if( p.getY() > max.getY() ) max = p;
		}
		points = null;
		this.coord = 1.0 * ( min.getY() + max.getY() ) / 2.0;

	}

	/**
	 * > 0 si p1 > p2 = < 0 si p1 < p2
	 */
	public double compare( Point p2 ) {
		return this.coord - p2.getY();
	}

}
