import java.awt.Point;
import java.util.ArrayList;

public interface Axis {
	public Axis getPerpendicular();
	public Point getL( ArrayList<Point> points );
	public int compare( Point p1, Point p2 );
}
