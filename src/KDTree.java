
import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;

public interface KDTree extends Serializable {
	public Point VecinoMasCercano( KDTree T, Point q );

	public Point VecinoMasCercano( Point q );

	public KDTree createLeaf( Point q );

	public KDTree createNode( ArrayList<Point> points, Axis axis );
}
