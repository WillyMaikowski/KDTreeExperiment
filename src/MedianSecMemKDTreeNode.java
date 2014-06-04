import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import recordfile.RecordsFileException;

@SuppressWarnings( "serial" )
public class MedianSecMemKDTreeNode extends AbstractSecMemKDTree {

	public MedianSecMemKDTreeNode( ArrayList<Point> points, String recordsFile ) throws IOException, RecordsFileException {
		this( points, new MedianXAxis(), recordsFile );
	}
	
	public MedianSecMemKDTreeNode( ArrayList<Point> points, Axis axis, String recordsFile ) throws IOException, RecordsFileException {
	   super( points, axis, recordsFile );
   }
	
	public KDTree createNode( ArrayList<Point> points, Axis axis ) {
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
