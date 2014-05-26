import java.awt.Point;

public class MeanKDTreeLeaf extends AbstractMeanKDTree {

    private Point value;

    public MeanKDTreeLeaf( Point p ) {
	this.value = p;
    }

    public KDTree getLeft() {
	return null;
    }

    public KDTree getRight() {
	return null;
    }
    
    public Point VecinoMasCercano( Point q ){
	return this.value;
    }
    
}
