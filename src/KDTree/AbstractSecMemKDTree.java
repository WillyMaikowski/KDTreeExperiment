package KDTree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import recordfile.RecordReader;
import recordfile.RecordWriter;
import recordfile.RecordsFile;
import recordfile.RecordsFileException;

@SuppressWarnings( "serial" )
public abstract class AbstractSecMemKDTree implements SecMemKDTree {

	String recordsFile;
	protected int numAccess;
	protected Axis axis;
	protected String keyRight;
	protected String keyLeft;

	public AbstractSecMemKDTree( List<Point> points, Axis axis, String recordsFile ) throws IOException,
	      RecordsFileException {
		this.recordsFile = recordsFile;
		this.axis = axis;
		this.numAccess = 0;

		RecordsFile rf = null;
		try {
			rf = new RecordsFile( recordsFile, "rw" );
		}
		catch( RecordsFileException e ) {
			try {
				rf = new RecordsFile( recordsFile, 64 );
			}
			catch( RecordsFileException ex ) {
				throw ex;
			}
		}
		finally {
			if( rf == null ) throw new RecordsFileException( "Problems to open/create the RecordsFile" );
		}

		this.numAccess++;
		
		// Tenemos que cambiar esta parte para suponer que nuestra
		// memoria principal no da mas alla que los puntos
		
		this.axis.setL( points );
		List<Point> p1 = new ArrayList<Point>();
		List<Point> p2 = new ArrayList<Point>();
		for( Point p : points ) {
			if( this.axis.compare( p ) <= 0 ) p1.add( p );
			else p2.add( p );

		}

		points = null;
		Axis nAxis = axis.getPerpendicular();

		String uniqueIdLeft = UUID.randomUUID().toString();
		RecordWriter rwLeft = new RecordWriter( uniqueIdLeft );
		if( p1.size() == 1 ) rwLeft.writeObject( this.createLeaf( p1.get( 0 ) ) );
		else if( p1.size() > 1 ) rwLeft.writeObject( this.createNode( p1, nAxis ) );
		rf.updateRecord( rwLeft );
		this.keyLeft = uniqueIdLeft;

		String uniqueIdRight = UUID.randomUUID().toString();
		RecordWriter rwRight = new RecordWriter( uniqueIdRight );
		if( p2.size() == 1 ) rwRight.writeObject( this.createLeaf( p2.get( 0 ) ) );
		else if( p2.size() > 1 ) rwRight.writeObject( this.createNode( p2, nAxis ) );
		rf.updateRecord( rwRight );
		this.keyRight = uniqueIdRight;

		rf.close();
	}

	public int height() {
		SecMemKDTree right = null;
		SecMemKDTree left = null;
		RecordsFile rf = null;

		try {
			rf = new RecordsFile( this.recordsFile, "r" );
			RecordReader rrRight = rf.readRecord( keyRight );
			RecordReader rrLeft = rf.readRecord( keyLeft );
			right = (SecMemKDTree) rrRight.readObject();
			left = (SecMemKDTree) rrLeft.readObject();
			rf.close();
		}
		catch( RecordsFileException | IOException | ClassNotFoundException e ) {
			e.printStackTrace();
		}
		this.numAccess++;
		return Math.max( left.height(), right.height() ) + 1;
	}

	public Point VecinoMasCercano( KDTree T, Point q ) {
		return T.VecinoMasCercano( q );
	}

	public Point VecinoMasCercano( Point q ) {
		return VecinoMasCercano( q, new Point( Double.MAX_VALUE, Double.MAX_VALUE ), Double.MAX_VALUE );
	}

	public Point VecinoMasCercano( Point q, Point mejorPrevio, double distMejorPrevio ) {
		Point mejorActual;
		double distActual;
		SecMemKDTree right = null;
		SecMemKDTree left = null;
		RecordsFile rf = null;

		try {
			rf = new RecordsFile( this.recordsFile, "r" );
			RecordReader rrRight = rf.readRecord( keyRight );
			RecordReader rrLeft = rf.readRecord( keyLeft );
			right = (SecMemKDTree) rrRight.readObject();
			left = (SecMemKDTree) rrLeft.readObject();
			rf.close();
		}
		catch( RecordsFileException | IOException | ClassNotFoundException e ) {
			e.printStackTrace();
		}
		this.numAccess++;
		
		if( this.axis.compare( q ) < 0 ) {

			mejorActual = right.VecinoMasCercano( q, mejorPrevio, distMejorPrevio );
			distActual = q.distance( mejorActual );

			if( distActual > distMejorPrevio ) {
				mejorActual = mejorPrevio;
				distActual = distMejorPrevio;
			}

			if( Math.abs( this.axis.compare( q ) ) < distActual ) {
				Point mejorActualIzq = left.VecinoMasCercano( q );
				double distActualIzq = q.distance( mejorActualIzq );

				if( distActual > distActualIzq ) {
					mejorActual = mejorActualIzq;
					distActual = distActualIzq;
				}
			}
		}
		else {
			mejorActual = left.VecinoMasCercano( q );
			distActual = q.distance( mejorActual );

			if( distActual > distMejorPrevio ) {
				mejorActual = mejorPrevio;
				distActual = distMejorPrevio;
			}

			if( Math.abs( this.axis.compare( q ) ) < distActual ) {
				Point mejorActualDer = right.VecinoMasCercano( q );
				double distActualDer = q.distance( mejorActualDer );

				if( distActual > distActualDer ) {
					mejorActual = mejorActualDer;
					distActual = distActualDer;
				}
			}
		}

		return mejorActual;
	}

	public KDTree createLeaf( Point q ) {
		return new KDTreeLeaf( q );
	}

	public int getLenghtOfFile() throws IOException, RecordsFileException {
		RecordsFile rf = null;
		try {
			rf = new RecordsFile( recordsFile, "rw" );
		}
		catch( RecordsFileException e ) {
			try {
				rf = new RecordsFile( recordsFile, 64 );
			}
			catch( RecordsFileException ex ) {
				throw ex;
			}
		}
		finally {
			if( rf == null ) throw new RecordsFileException( "Problems to open/create the RecordsFile" );
		}
		
		int size = rf.getLenghtOfFile();
		rf.close();
		
		return size;
	}
	
	public int getNumAccess() {
		SecMemKDTree right = null;
		SecMemKDTree left = null;
		RecordsFile rf = null;

		try {
			rf = new RecordsFile( this.recordsFile, "r" );
			RecordReader rrRight = rf.readRecord( keyRight );
			RecordReader rrLeft = rf.readRecord( keyLeft );
			right = (SecMemKDTree) rrRight.readObject();
			left = (SecMemKDTree) rrLeft.readObject();
			rf.close();
		}
		catch( RecordsFileException | IOException | ClassNotFoundException e ) {
			e.printStackTrace();
		}
		
		return this.numAccess + left.getNumAccess() + right.getNumAccess();
	}
}
