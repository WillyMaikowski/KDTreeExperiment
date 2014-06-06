package secondary;

import java.io.IOException;
import java.util.List;

import KDTree.Axis;
import KDTree.KDTree;
import KDTree.MedianXAxis;
import KDTree.Point;
import recordfile.RecordsFileException;

@SuppressWarnings( "serial" )
public class MedianKDTreeNodeSecMem extends AbstractKDTreeNodeSecMemory {

	public MedianKDTreeNodeSecMem( List<Point> points ) throws IOException, RecordsFileException {
		this( points, new MedianXAxis() );
	}
	
	public MedianKDTreeNodeSecMem( List<Point> points, Axis axis ) throws IOException, RecordsFileException {
	   super( points, axis );
   }
	
	public KDTree createNode( List<Point> points, Axis axis ) {
		KDTree node = null;
		try {
			node = new MedianKDTreeNodeSecMem( points, axis );
		}
		catch( RecordsFileException|IOException e ) {
			e.printStackTrace();
		}
		return node;
	}
}
