package KDTree;

import KDTree.Point;
import java.util.List;

public interface Axis {
	public Axis getPerpendicular();

	public void setL( List<Point> listofPoints );

	public double compare( Point p1 );

	public double getCoord();
}
