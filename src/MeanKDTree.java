
import java.awt.Point;
import java.util.ArrayList;

public class MeanKDTree extends AbstractKDTree {

	private BinaryNode root;
	
	public MeanKDTree() {
		this.root = null;
	}
	
	public MeanKDTree( BinaryNode r ) {
		this.root = r;
	}
	
	public MeanKDTree( ArrayList<Point> points, Axis axis ) {
		if( points.size() == 0 ) return;
		if( points.size() == 1 ) {
			this.root = new BinaryNode( points.get( 0 ) );
			return;
		}
		
		Axis nAxis = axis.getPerpendicular();
		Point l = nAxis.getL( points );
		ArrayList<Point> p1 = new ArrayList<Point>();
		ArrayList<Point> p2 = new ArrayList<Point>();
		for( Point p : points ) {
			if( axis.compare( p, l ) <= 0 ) {
				p1.add( p );
			}
			else {
				p2.add( p );
			}
		}
		
		MeanKDTree left = new MeanKDTree( p1, nAxis );
		MeanKDTree right = new MeanKDTree( p2, nAxis );
		this.root = new BinaryNode( l, left.root, right.root );
	}
	

}
