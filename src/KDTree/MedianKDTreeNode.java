package KDTree;

import java.awt.Point;
import java.util.ArrayList;

public class MedianKDTreeNode extends AbstractKDTreeNode {

	public MedianKDTreeNode( ArrayList<Point> points ) {
		this( points, new MedianXAxis() );
	}

	/**
	 * points Nunca llega con un punto o vacio
	 * 
	 * @param points
	 * @param axis
	 */
	public MedianKDTreeNode( ArrayList<Point> points, Axis axis ) {
		super( points, axis );
	}

	public KDTree createNode( ArrayList<Point> points, Axis axis ) {
		return new MedianKDTreeNode( points, axis );
	}
}
