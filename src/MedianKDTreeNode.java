import java.awt.Point;
import java.util.ArrayList;

public class MedianKDTreeNode extends AbstractKDTreeNode {

	public MedianKDTreeNode( ArrayList<Point> points ) {
		this( points, new XAxis() );
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

	public KDTree createLeaf( Point q ) {
		return new MeanKDTreeLeaf( q );
	}

	public KDTree createNode( ArrayList<Point> points, Axis axis ) {

		return new MeanKDTreeNode( points, axis );
	}
}
