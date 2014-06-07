package secondary;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import KDTree.Axis;
import KDTree.KDTree;
import KDTree.MedianKDTreeNode;
import KDTree.MedianXAxis;
import KDTree.Point;
import recordfile.RecordReader;
import recordfile.RecordWriter;
import recordfile.RecordsFile;
import recordfile.RecordsFileException;

@SuppressWarnings( "serial" )
public class MedianKDTreeNodeFile implements KDTree {
	
	String key;
	int height;
	int numAccess;
		
	public MedianKDTreeNodeFile( List<Point> points ) throws IOException, RecordsFileException {
		this( points, new MedianXAxis() );
	}
	
	public MedianKDTreeNodeFile( List<Point> points, Axis axis ) throws IOException, RecordsFileException {
		
	   this.key = UUID.randomUUID().toString();
		
	   KDTree kdtree = new MedianKDTreeNode(points, axis);
	   this.height = kdtree.height();
	   
	   RecordsFile rf = null;
		try {
			rf = new RecordsFile( this.key, "rw" );
		}
		catch( RecordsFileException e ) {
			try {
				rf = new RecordsFile( this.key, 1 );
			}
			catch( RecordsFileException ex ) {
				throw ex;
			}
		}
		finally {
			if( rf == null ) throw new RecordsFileException( "Problems to open/create the RecordsFile" );
		}

		this.numAccess=1;
		
		
		RecordWriter rw = new RecordWriter( this.key );
		rw.writeObject( kdtree );
		rf.insertRecord( rw );
		
		rf.close();
		
		kdtree = null;
		rf = null;
		points = null;
		axis = null;
	   
   }
	
	//Do nothing
	public KDTree createNode( List<Point> points, Axis axis ) {
		return null;
	}

	
   public Point VecinoMasCercano( KDTree T, Point q ) {
	   
	   return T.VecinoMasCercano( q );
   }

	
   public Point VecinoMasCercano( Point q ) {
	   
   	RecordsFile rf = null;
   	KDTree tree;

		try {
			rf = new RecordsFile( this.key, "r" );
			RecordReader rr = rf.readRecord( this.key );
			tree = (KDTree) rr.readObject();
			rf.close();
			this.numAccess++;
			Point p = tree.VecinoMasCercano( q );
			tree = null;
			return p;
		}
		catch( RecordsFileException | IOException | ClassNotFoundException e ) {
			e.printStackTrace();
		}
   	
	   return null;
   }

	
   public Point VecinoMasCercano( Point q, Point mejorPrevio,
         double distMejorPrevio ) {
	   
	   return VecinoMasCercano( q );
   }

	
   public KDTree createLeaf( Point q ) {
	   
	   return null;
   }

	
   public int height() {
	   return this.height;
   }

	
   public int getNumAccess() {
	   return this.numAccess;
   }

	
   public int getLenghtOfFile() throws IOException, RecordsFileException {
   	RecordsFile rf = null;
		try {
			rf = new RecordsFile( this.key, "r" );
		}
		catch( RecordsFileException e ) {
			e.printStackTrace();
		}
		finally {
			if( rf == null ) throw new RecordsFileException( "Problems to open/create the RecordsFile" );
		}
		
		int size = rf.getLenghtOfFile();
		rf.close();
		
		return size;
   }
   
   public void reInitialize(){
   	this.numAccess = 0;
   }
}
