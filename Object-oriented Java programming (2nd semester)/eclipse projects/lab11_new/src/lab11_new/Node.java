package lab11_new;

import lab11_new.Node;

public class Node {

	private Node next;
	private String data;
	
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