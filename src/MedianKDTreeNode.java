import java.awt.Point;
import java.util.ArrayList;

@SuppressWarnings( "serial" )
public class MedianKDTreeNode extends AbstractKDTreeNode {

	public MedianKDTreeNode( ArrayList<Point> points ) {
		this( points, new MedianXAxis() );
	}

	public MedianKDTreeNode( ArrayList<Point> points, Axis axis ) {
		super( points, axis );
	}

	public KDTree createNode( ArrayList<Point> points, Axis axis ) {
		return new MedianKDTreeNode( points, axis );
	}
}
