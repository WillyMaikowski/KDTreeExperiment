import java.awt.Point;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

import recordfile.RecordWriter;
import recordfile.RecordsFile;

public class SecMemKDTree implements Serializable {

	RecordsFile recordsFile;
	protected Axis axis;
	protected String keyRight;
	protected String keyLeft;

	public SecMemKDTree( ArrayList<Point> points, Axis axis, RecordsFile recordsFile ) throws IOException {
		this.recordsFile = recordsFile;
		this.axis = axis;

		//Tenemos que cambiar esta parte para suponer que nuestra memoria principal no da mas alla que los puntos
		this.axis.setL( points );
		ArrayList<Point> p1 = new ArrayList<Point>();
		ArrayList<Point> p2 = new ArrayList<Point>();
		for( Point p : points ) {
			if( this.axis.compare( p ) <= 0 ) {
				p1.add( p );
			}
			else {
				p2.add( p );
			}
		}

		Axis nAxis = axis.getPerpendicular();

		String uniqueIdLeft = UUID.randomUUID().toString();
		RecordWriter rwLeft = new RecordWriter( uniqueIdLeft );
		if( p1.size() == 1 ) rwLeft.writeObject( this.createLeaf( p1.get( 0 ) ) );
		else if( p1.size() > 1 ) rwLeft.writeObject( this.createNode( p1, nAxis ) );
		this.keyLeft = uniqueIdLeft;

		String uniqueIdRight = UUID.randomUUID().toString();
		RecordWriter rwRight = new RecordWriter( uniqueIdRight );
		if( p2.size() == 1 ) rwRight.writeObject( this.createLeaf( p2.get( 0 ) ) );
		else if( p2.size() > 1 ) rwRight.writeObject( this.createNode( p2, nAxis ) );
		this.keyRight = uniqueIdRight;
	}

	private Object createNode( ArrayList<Point> p2, Axis nAxis ) {
	   return null;
   }

	private Object createLeaf( Point point ) {
	   return null;
   }
}
