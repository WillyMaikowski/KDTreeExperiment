package KDTree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import recordfile.RecordsFileException;

@SuppressWarnings( "serial" )
public abstract class AbstractKDTreeNode implements KDTree {

	protected Axis axis;
	protected KDTree right;
	protected KDTree left;
	

	public AbstractKDTreeNode( List<Point> listofPoints, Axis axis ) {
		this.axis = axis;

		this.axis.setL( listofPoints );
		ArrayList<Point> p1 = new ArrayList<Point>();
		ArrayList<Point> p2 = new ArrayList<Point>();
		for( Point p : listofPoints )
			if( this.axis.compare( p ) >= 0 ) p1.add( p );
			else p2.add( p );

		listofPoints = null;
		Axis nAxis = axis.getPerpendicular();

		if( p1.size() == 1 ) this.left = this.createLeaf( p1.get( 0 ) );
		else if( p1.size() > 1 ) this.left = this.createNode( p1, nAxis );

		if( p2.size() == 1 ) this.right = this.createLeaf( p2.get( 0 ) );
		else if( p2.size() > 1 ) this.right = this.createNode( p2, nAxis );
	}

	public Point VecinoMasCercano( KDTree T, Point q ) {
		return T.VecinoMasCercano( q );
	}

	public int height() {
		return Math.max( this.left.height(), this.right.height() ) + 1;
	}

	public Point VecinoMasCercano( Point q ) {
		return VecinoMasCercano( q, new Point( Double.MAX_VALUE, Double.MAX_VALUE ), Double.MAX_VALUE );
	}

	public Point VecinoMasCercano( Point q, Point mejorPrevio, double distMejorPrevio ) {

		Point mejorActual;
		double distActual;
		if( this.axis.compare( q ) < 0 ) {// el eje es menor al punto => buscar a
			                               // la derecha

			mejorActual = this.right.VecinoMasCercano( q, mejorPrevio, distMejorPrevio );
			distActual = q.distance( mejorActual );

			if( distActual > distMejorPrevio ) {
				mejorActual = mejorPrevio;
				distActual = distMejorPrevio;
			}

			if( Math.abs( this.axis.compare( q ) ) < distActual ) {
				Point mejorActualIzq = this.left.VecinoMasCercano( q );
				double distActualIzq = q.distance( mejorActualIzq );

				if( distActual > distActualIzq ) {
					mejorActual = mejorActualIzq;
					distActual = distActualIzq;
				}
			}
		}
		else {
			mejorActual = this.left.VecinoMasCercano( q );
			distActual = q.distance( mejorActual );

			if( distActual > distMejorPrevio ) {
				mejorActual = mejorPrevio;
				distActual = distMejorPrevio;
			}

			if( Math.abs( this.axis.compare( q ) ) < distActual ) {
				Point mejorActualDer = this.right.VecinoMasCercano( q );
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
	
	public int getNumAccess() {
	   return 0;
   }
	
	public int getLenghtOfFile() throws IOException, RecordsFileException{
		return 0;
	}
	
	public void reInitialize(){
		
	}
}
