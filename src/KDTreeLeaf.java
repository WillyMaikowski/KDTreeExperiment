import java.awt.Point;
import java.util.ArrayList;

@SuppressWarnings( "serial" )
public class KDTreeLeaf implements KDTree {
	private Point value;

	public KDTreeLeaf( Point p ) {
		this.value = p;
	}

	public Point VecinoMasCercano( Point q ) {
		return this.value;
	}

	public KDTree createLeaf( Point q ) {
		return null;
	}

	public KDTree createNode( ArrayList<Point> points, Axis axis ) {
		return null;
	}

	@Override
	public Point VecinoMasCercano( KDTree T, Point q ) {
		return T.VecinoMasCercano( q );
	}
}
