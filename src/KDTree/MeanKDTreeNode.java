package KDTree;

import KDTree.Point;
import java.util.List;

public class MeanKDTreeNode extends AbstractKDTreeNode {

	/**
	 * 
	 */
   private static final long serialVersionUID = 1240840444210419274L;

	public MeanKDTreeNode( List<Point> listofPoints ) {
		this( listofPoints, new MeanXAxis() );
	}

	/**
	 * points Nunca llega con un punto o vacio
	 * 
	 * @param listofPoints
	 * @param axis
	 */
	public MeanKDTreeNode( List<Point> listofPoints, Axis axis ) {
		super( listofPoints, axis );
	}

	public KDTree createNode( List<Point> points, Axis axis ) {

		return new MeanKDTreeNode( points, axis );
	}

}
