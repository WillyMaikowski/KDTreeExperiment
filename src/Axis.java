import java.awt.Point;
import java.util.ArrayList;

public interface Axis {
	public Axis getPerpendicular();

	public void setL( ArrayList<Point> points );

	public int compare( Point p1 );

	public double getCoord();
}
