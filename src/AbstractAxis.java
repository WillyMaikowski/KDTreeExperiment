public abstract class AbstractAxis implements Axis {
    protected double coord;

    public double getCoord() {
	return this.coord;
    }
    
    protected int random( int i, int n ) {
	return (int) Math.round( ( i + ( n - i ) * Math.random() ) );
    }
}
