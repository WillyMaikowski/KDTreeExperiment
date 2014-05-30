import java.awt.Point;
import java.util.ArrayList;

public class MeanKDTreeNode extends AbstractKDTreeNode {

    public MeanKDTreeNode( ArrayList<Point> points ) {
	this( points, new MeanXAxis() );
    }

    /**
     * points Nunca llega con un punto o vacio
     * 
     * @param points
     * @param axis
     */
    public MeanKDTreeNode( ArrayList<Point> points, Axis axis ) {
	super( points, axis );
    }

    public KDTree createNode( ArrayList<Point> points, Axis axis ) {

	return new MeanKDTreeNode( points, axis );
    }

}