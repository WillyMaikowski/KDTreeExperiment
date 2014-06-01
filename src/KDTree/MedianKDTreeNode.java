package KDTree;

import KDTree.Point;

import java.util.List;

public class MedianKDTreeNode extends AbstractKDTreeNode {

	/**
	 * 
	 */
   private static final long serialVersionUID = 8640158115201191638L;

	public MedianKDTreeNode( List<Point> points ) {
		this( points, new MedianXAxis() );
	}

	/**
	 * points Nunca llega con un punto o vacio
	 * 
	 * @param points
	 * @param axis
	 */
	public MedianKDTreeNode( List<Point> points, Axis axis ) {
		super( points, axis );
	}

	public KDTree createNode( List<Point> points, Axis axis ) {
		return new MedianKDTreeNode( points, axis );
	}
}
