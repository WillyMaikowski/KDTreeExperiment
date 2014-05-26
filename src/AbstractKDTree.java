import java.awt.Point;

public abstract class AbstractKDTree implements KDTree {

    protected Axis axis;
    protected KDTree right;
    protected KDTree left;

    public Point VecinoMasCercano( KDTree T, Point q ) {
	return T.VecinoMasCercano( q );
    }

    public Point VecinoMasCercano( Point q ) {

	Point mejorActual;
	double distActual;
	if ( this.axis.compare( q ) > 0 ){

	    mejorActual = this.right.VecinoMasCercano( q );
	    distActual = q.distance( mejorActual );

	    if ( Math.abs( this.axis.compare( q ) ) < distActual ){
		Point mejorActualIzq = this.left.VecinoMasCercano( q );
		double distActualIzq = q.distance( mejorActualIzq );

		if ( distActual > distActualIzq ){
		    mejorActual = mejorActualIzq;
		    distActual = distActualIzq;
		}
	    }
	}else{
	    mejorActual = this.left.VecinoMasCercano( q );
	    distActual = q.distance( mejorActual );

	    if ( Math.abs( this.axis.compare( q ) ) < distActual ){
		Point mejorActualDer = this.right.VecinoMasCercano( q );
		double distActualDer = q.distance( mejorActualDer );

		if ( distActual > distActualDer ){
		    mejorActual = mejorActualDer;
		    distActual = distActualDer;
		}
	    }
	}

	return mejorActual;
    }

}
