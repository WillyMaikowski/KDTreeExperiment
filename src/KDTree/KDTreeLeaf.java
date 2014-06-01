package KDTree;

import KDTree.Point;

import java.util.List;

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

	public KDTree createNode( List<Point> points, Axis axis ) {
		return null;
	}

	public int height() {
		return 1;
	}

	public Point VecinoMasCercano( KDTree T, Point q ) {
		return T.VecinoMasCercano( q );
	}
}