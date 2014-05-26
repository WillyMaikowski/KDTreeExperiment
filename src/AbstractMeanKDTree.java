import java.awt.Point;
import java.util.ArrayList;

public abstract class AbstractMeanKDTree extends AbstractKDTree {

    private BinaryNode root;

    public AbstractMeanKDTree() {
	this.root = null;
    }

    public AbstractMeanKDTree( BinaryNode r ) {
	this.root = r;
    }

    

}
