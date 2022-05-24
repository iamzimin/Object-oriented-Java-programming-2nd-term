package lab11;

public class Node {

	private String data;
	private Node next;
 
	public String getData() {
		return data;
	}
	public void setData(String str) {
		this.data = str;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
}