package woodProject;

public class Node {
	
	protected int quantity;
	protected double price; 
	
	protected Node next; //address of next node
	
	//constructor
	public Node(int quantity, double price) {
		
		this.quantity = quantity;
		this.price = price;
	}
	
	//getter for quantity
	public int getQuantity() {
		
		return quantity;
	}
	
	//getter for price
	public double getPrice() {
		
		return price;
	}
	
	//returns the next node
	public Node getNext() {
		
		return next;
	}
	
	//sets quantity to specified quantity
	public void setQuantity(int quantity) {
		
		this.quantity = quantity;
	}
	
	//sets "next" node to specified node
	public void setNext(Node next) {
		
		this.next = next; 
	}
}
