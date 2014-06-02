package KDTree;

public abstract class AbstractAxis implements Axis {
	
   private static final long serialVersionUID = -5983350815452628144L;
   protected double coord;

	protected int random( int i, int n ) {
		return (int) Math.round( ( i + ( n - i ) * Math.random() ) );
	}
}
