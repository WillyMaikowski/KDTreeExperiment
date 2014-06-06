package KDTree;

import KDTree.Point;

import java.io.IOException;
import java.util.List;

import recordfile.RecordsFileException;

@SuppressWarnings( "serial" )
public class KDTreeLeaf implements KDTree {

	private Point value;

	public KDTreeLeaf( Point p ) {
		this.value = p;
	}

	public Point VecinoMasCercano( Point q ) {
		return this.value;
	}

	public KDTree createLeaf( Point q ) {
		return null;
	}

	public KDTree createNode( List<Point> points, Axis axis ) {
		return null;
	}

	public int height() {
		return 1;
	}

	public Point VecinoMasCercano( KDTree T, Point q ) {
		return T.VecinoMasCercano( q );
	}

	public Point VecinoMasCercano( Point q, Point mejorPrevio,
	      double distMejorPrevio ) {

		return this.VecinoMasCercano( q );
	}

   public int getNumAccess() {
	   return 0;
   }
   
   public int getLenghtOfFile() throws IOException, RecordsFileException{
		return 0;
	}

}
