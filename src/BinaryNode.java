
public class BinaryNode {
	private Object value;
	protected BinaryNode left, right;
	
	public BinaryNode( Object value ) {
		this.value = value;
		this.left = null;
		this.right = null;
	}
	
	public BinaryNode( Object value, BinaryNode left, BinaryNode right ) {
		this.value = value;
		this.left = left;
		this.right = right;
	}

	public BinaryNode getLeft() {
		return this.left;
	}
	
	public BinaryNode getRight() {
		return this.right;
	}
	
	public Object getVaue() {
		return this.value;
	}
	
	public void setNext( BinaryNode left ) {
		this.left = left;
	}
	
	public void setPrev( BinaryNode right ) {
		this.right = right;
	}
	
	public void setValue( Object value ) {
		this.value = value;
	}
}
