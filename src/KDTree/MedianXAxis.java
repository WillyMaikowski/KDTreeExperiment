package KDTree;

import KDTree.Point;

import java.util.List;

@SuppressWarnings( "serial" )
public class MedianXAxis extends AbstractAxis {

	public Axis getPerpendicular() {
		return new MedianYAxis();
	}

	public void setL( List<Point> points ) {
		this.coord = this.randomizedSelect(
		      points.toArray( new Point[points.size()] ), 0, points.size() - 1,
		      points.size() / 2 );
	}

	private double randomizedSelect( Point[] A, int p, int r, int i ) {
		if( p == r ) return A[p].getX();
		int q = randomized_Partition( A, p, r );
		int k = q - p + 1;

		if( i == k ) return A[q].getX();
		else if( i < k ) return randomizedSelect( A, p, q - 1, i );
		else return randomizedSelect( A, q + 1, r, i - k );
	}

	private int randomized_Partition( Point[] A, int p, int r ) {
		int i = this.random( p, r );
		Point aux = A[i];
		A[i] = A[r];
		A[r] = aux;
		return partition( A, p, r );
	}

	private int partition( Point A[], int p, int r ) {
		Point pivot = A[r];
		int i = p - 1;
		for( int j = p; j <= r - 1; j++ ) {
			if( A[j].getX() <= pivot.getX() ) {
				i++;
				Point dummy = A[i];
				A[i] = A[j];
				A[j] = dummy;
			}
		}
		Point dummy = A[i + 1];
		A[i + 1] = A[r];
		A[r] = dummy;
		return i + 1;
	}

	public double compare( Point p2 ) {
		return this.coord - p2.getX();
	}

}
