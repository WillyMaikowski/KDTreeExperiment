package KDTree;

import KDTree.Point;

import java.util.List;

public interface KDTree {
	public Point VecinoMasCercano( KDTree T, Point q );

	public Point VecinoMasCercano( Point q );

	public KDTree createLeaf( Point q );

	public KDTree createNode( List<Point> points, Axis axis );

	public int height();
}
