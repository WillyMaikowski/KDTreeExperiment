package secondary;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import KDTree.Axis;
import KDTree.KDTree;
import KDTree.MedianKDTreeNode;
import KDTree.MedianXAxis;
import KDTree.Point;
import recordfile.RecordsFileException;
import secmemorywilly.AbstractSecMemKDTree;

@SuppressWarnings( "serial" )
public class MedianKDTreeNodeSecMem implements KDTree {
	
	String fileName;
		
	public MedianKDTreeNodeSecMem( List<Point> points ) throws IOException, RecordsFileException {
		this( points, new MedianXAxis() );
	}
	
	public MedianKDTreeNodeSecMem( List<Point> points, Axis axis ) throws IOException, RecordsFileException {
		this.fileName = UUID.randomUUID().toString();
		
	   KDTree kdtree = new MedianKDTreeNode(points, axis);
	   
	   
   }
	
	public KDTree createNode( List<Point> points, Axis axis ) {
		return null;
	}

	
   public Point VecinoMasCercano( KDTree T, Point q ) {
	   
	   return null;
   }

	
   public Point VecinoMasCercano( Point q ) {
	   
	   return null;
   }

	
   public Point VecinoMasCercano( Point q, Point mejorPrevio,
         double distMejorPrevio ) {
	   
	   return null;
   }

	
   public KDTree createLeaf( Point q ) {
	   
	   return null;
   }

	
   public int height() {
	   
	   return 0;
   }

	
   public int getNumAccess() {
	   
	   return 0;
   }

	
   public int getLenghtOfFile() throws IOException, RecordsFileException {
	   
	   return 0;
   }
}
