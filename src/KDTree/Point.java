package KDTree;

public class Point {

    private double x;
    private double y;

    public Point( double x, double y ) {
	super();
	this.x = x;
	this.y = y;
    }

    public double getX() {
	return x;
    }

    public void setX( double x ) {
	this.x = x;
    }

    public double getY() {
	return y;
    }

    public void setY( double y ) {
	this.y = y;
    }

    public double distance( Point mejorActual ) {

	return Math.sqrt( Math.pow( this.getX() + mejorActual.getX(), 2 )
		+ Math.pow( this.getY() + mejorActual.getY(), 2 ) );
    }

}
