import java.awt.Point;
import java.util.ArrayList;


public abstract class AbstractAxis implements Axis {

	public abstract Axis getPerpendicular();
	public abstract Point getL( ArrayList<Point> points );
	public abstract int compare( Point p1, Point p2 );

}
