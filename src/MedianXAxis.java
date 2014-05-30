import java.awt.Point;
import java.util.ArrayList;

public class MedianXAxis extends AbstractAxis {

    private double coord;

    public Axis getPerpendicular() {
	return new MedianYAxis();
    }

    public void setL( ArrayList<Point> points ) {
	this.coord = randomizedSelect( (Point[])points.toArray(),0, points.size(), points.size()/2 );
    }
    
    private int randomizedSelect( Point[] A, int p, int r, int i ) {
	if ( p == r )
	    return A[p].x;
	int q = randomized_Partition( A, p, r );
	int k = q - p + 1;

	if ( i == k )
	    return randomizedSelect( A, p, q - 1, i );
	else
	    return randomizedSelect( A, q + 1, r, i - k );
    }
    
    private int randomized_Partition( Point[] A, int p, int r){
	int i = this.random( p, r );
	Point aux = A[i];
	A[i]=A[r];
	A[r]=aux;
	return partition( A, p, r );
    }
    
    private int partition( Point A[], int p, int r ) {
	Point pivot = A[r];
	int i = p - 1;
	for ( int j = p; j <= r - 1; j++ ){
	    if ( A[j].x <= pivot.x ){
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

    public int compare( Point p2 ) {
	return (int) this.coord - p2.x;
    }

}
