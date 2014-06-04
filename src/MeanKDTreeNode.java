
import java.awt.Point;
import java.util.ArrayList;

@SuppressWarnings( "serial" )
public class MeanKDTreeNode extends AbstractKDTreeNode {

	public MeanKDTreeNode( ArrayList<Point> points ) {
		this( points, new MeanXAxis() );
	}

	public MeanKDTreeNode( ArrayList<Point> points, Axis axis ) {
		super( points, axis );
	}

	public KDTree createNode( ArrayList<Point> points, Axis axis ) {

		return new MeanKDTreeNode( points, axis );
	}

}
