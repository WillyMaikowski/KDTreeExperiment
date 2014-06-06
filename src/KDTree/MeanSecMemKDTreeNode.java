package KDTree;

import java.io.IOException;
import java.util.List;
import recordfile.RecordsFileException;

@SuppressWarnings( "serial" )
public class MeanSecMemKDTreeNode extends AbstractSecMemKDTree {

	public MeanSecMemKDTreeNode( List<Point> points, String recordsFile ) throws IOException, RecordsFileException {
		this( points, new MeanXAxis(), recordsFile );
	}

	public MeanSecMemKDTreeNode( List<Point> points, Axis axis, String recordsFile ) throws IOException, RecordsFileException {
		super( points, axis, recordsFile );
	}

	public KDTree createNode( List<Point> points, Axis axis ) {
		KDTree node = null;
		try {
			node = new MeanSecMemKDTreeNode( points, axis, this.recordsFile );
		}
		catch( RecordsFileException|IOException e ) {
			e.printStackTrace();
		}

		return node;
	}
}
