package secondary;

import java.io.IOException;
import java.util.List;

import KDTree.Axis;
import KDTree.KDTree;
import KDTree.MedianXAxis;
import KDTree.Point;
import recordfile.RecordsFileException;

@SuppressWarnings( "serial" )
public class MedianSecMemKDTreeNode extends AbstractSecMemKDTree {

	public MedianSecMemKDTreeNode( List<Point> points, String recordsFile ) throws IOException, RecordsFileException {
		this( points, new MedianXAxis(), recordsFile );
	}
	
	public MedianSecMemKDTreeNode( List<Point> points, Axis axis, String recordsFile ) throws IOException, RecordsFileException {
	   super( points, axis, recordsFile );
   }
	
	public KDTree createNode( List<Point> points, Axis axis ) {
		KDTree node = null;
		try {
			node = new MedianSecMemKDTreeNode( points, axis, this.recordsFile );
		}
		catch( RecordsFileException|IOException e ) {
			e.printStackTrace();
		}
		return node;
	}
}
