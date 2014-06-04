package KDTree;

@SuppressWarnings( "serial" )
public class Point implements  java.io.Serializable{

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

	public double distance( Point q ) {
		return Math.sqrt( Math.pow( this.getX() - q.getX(), 2 )
		      + Math.pow( this.getY() - q.getY(), 2 ) );
	}

	public String toString() {
		return getClass().getName() + "[x=" + x + ",y=" + y + "]";
	}
}
