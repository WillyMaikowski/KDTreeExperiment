package KDTree;

import KDTree.Point;
import java.util.List;

public interface Axis extends java.io.Serializable{
	public Axis getPerpendicular();

	public void setL( List<Point> listofPoints );

	public double compare( Point p1 );

}
