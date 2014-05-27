import java.awt.Point;

public class MeanKDTreeLeaf extends AbstractKDTree {

    private Point value;

    public MeanKDTreeLeaf( Point p ) {
	this.value = p;
    }
    
    public Point VecinoMasCercano( Point q ){
	return this.value;
    }
    
}
