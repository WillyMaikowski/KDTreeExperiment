import java.awt.Point;
import java.util.ArrayList;

public class MedianXAxis extends AbstractAxis {

    private double coord;

    public Axis getPerpendicular() {
	return new MedianYAxis();
    }

    public void setL( ArrayList<Point> points ) {
	// implementar metodo visto en clases
    }

    public int compare( Point p2 ) {
	return (int) this.coord - p2.x;
    }

}
