package KDTree;

import KDTree.Point;

import java.util.List;

@SuppressWarnings( "serial" )
public class MeanKDTreeNode extends AbstractKDTreeNode {

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
