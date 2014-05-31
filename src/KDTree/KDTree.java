package KDTree;

import java.awt.Point;
import java.util.ArrayList;

public interface KDTree {
	public Point VecinoMasCercano( KDTree T, Point q );

	public Point VecinoMasCercano( Point q );

	public KDTree createLeaf( Point q );

	public KDTree createNode( ArrayList<Point> points, Axis axis );
	
	public int height();
}
