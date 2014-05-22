
public class BinaryNode {
	private Object value;
	protected BinaryNode next;
	protected BinaryNode prev;
	
	public BinaryNode( Object value, BinaryNode next, BinaryNode prev ) {
		this.value = value;
		this.next = next;
		this.prev = prev;
	}

	public BinaryNode getNext() {
		return this.next;
	}
	
	public BinaryNode getPrev() {
		return this.prev;
	}
	
	public Object getVaue() {
		return this.value;
	}
	
	public void setNext( BinaryNode next ) {
		this.next = next;
	}
	
	public void setPrev( BinaryNode prev ) {
		this.prev = prev;
	}
	
	public void setValue( Object value ) {
		this.value = value;
	}
}
