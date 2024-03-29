package KDTree;

import KDTree.Point;

import java.util.List;

@SuppressWarnings( "serial" )
public class MeanXAxis extends AbstractAxis {

	public Axis getPerpendicular() {
		return new MeanYAxis();
	}

	public void setL( List<Point> points ) {
		Point min = points.get( 0 );
		Point max = points.get( 0 );
		for( Point p : points ) {
			if( p.getX() < min.getX() ) min = p;
			if( p.getX() > max.getX() ) max = p;
		}
		points = null;
		this.coord = 1.0 * ( min.getX() + max.getX() ) / 2.0;
	}

	public double compare( Point p2 ) {
		return this.coord - p2.getX();
	}

}
