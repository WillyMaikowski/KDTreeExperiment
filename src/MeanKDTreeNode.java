import java.awt.Point;
import java.util.ArrayList;

public class MeanKDTreeNode extends AbstractKDTree {

   
    /**
     * points Nunca llega con un punto o vacio
     * 
     * @param points
     * @param axis
     */
    public MeanKDTreeNode( ArrayList<Point> points, Axis axis ) {
	this.axis = axis;

	
	this.axis.setL( points );
	ArrayList<Point> p1 = new ArrayList<Point>();
	ArrayList<Point> p2 = new ArrayList<Point>();
	for ( Point p : points ){
	    if ( this.axis.compare( p ) <= 0 ){
		p1.add( p );
	    }else{
		p2.add( p );
	    }
	}
	
	Axis nAxis = axis.getPerpendicular();

	if ( p1.size() == 1 )
	    this.left = new MeanKDTreeLeaf( p1.get( 0 ) );
	else if ( p1.size() > 1 )
	    this.left = new MeanKDTreeNode( p1, nAxis );

	if ( p2.size() == 1 )
	    this.right = new MeanKDTreeLeaf( p2.get( 0 ) );
	else if ( p2.size() > 1 )
	    this.right = new MeanKDTreeNode( p2, nAxis );
    }

}
