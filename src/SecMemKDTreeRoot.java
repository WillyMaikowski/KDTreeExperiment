import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import recordfile.*;

public class SecMemKDTreeRoot {
	private RecordsFile recordsFile;
	private String root;

	public SecMemKDTreeRoot( ArrayList<Point> points, Axis axis ) throws IOException, RecordsFileException {
		this.recordsFile = new RecordsFile( "example.smdb", 32 );
		String uniqueId = UUID.randomUUID().toString();
		RecordWriter rw = new RecordWriter( uniqueId );
		rw.writeObject( new SecMemKDTree( points, axis, recordsFile ) );
		recordsFile.updateRecord( rw );
		this.root = uniqueId;
	}

	
}
