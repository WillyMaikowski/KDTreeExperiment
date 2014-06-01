package KDTree;

import KDTree.Point;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractKDTreeNode implements KDTree {

	protected Axis axis;
	protected KDTree right;
	protected KDTree left;

	public AbstractKDTreeNode( List<Point> listofPoints, Axis axis ) {
		this.axis = axis;

		this.axis.setL( listofPoints );
		ArrayList<Point> p1 = new ArrayList<Point>();/* contiene los puntos */
		ArrayList<Point> p2 = new ArrayList<Point>();/*
																	 * contiene los puntos
																	 * mayores al axis
																	 */
		for( Point p : listofPoints ) {

			if( this.axis.compare( p ) >= 0 ) {// el axis es mayor que el punto =>
				                                // punto va al lado izquierdo
				p1.add( p );
			}
			else {
				p2.add( p );
			}
		}
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

		Point mejorActual;
		double distActual;
		if( this.axis.compare( q ) > 0 ) {

			mejorActual = this.right.VecinoMasCercano( q );
			distActual = q.distance( mejorActual );

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
}
