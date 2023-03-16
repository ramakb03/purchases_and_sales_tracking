package woodProject;
public class LinkedLists {
	
	/*
	 * class is a linked list class made using queues
	 */
	private int length;
	private Node front;
	private Node rear; 
	
	//constructor receives no parameter
	public LinkedLists() {
		
		front = null;
		rear = null;
		length = 0;
	}
	
	//isEmpty() method returns true if linked list is empty and false if it isn't
	public boolean isEmpty() {
		
		return length == 0;
	}
	
	//getLength() returns length
	public int getLength() {
		
		return length; 
	}
	
	/*
	 * push() method adds  a new node to the end of the list
	 */
	public void push(int quantity, double price) { 
		
		
		Node new_node = new Node(quantity, price);
		
		if(isEmpty()) {
			
			front = new_node;
			rear = new_node;
		}
		else {
			
			rear.setNext(new_node);
			rear = new_node;
		}
		length++;
	}
	
	/*
	 * peek() method returns node at the front of the list
	 * Throws an unavilableNodeException() if list is empty
	 */
	public Node peek() throws UnavailableNodeException {
		
		if(!isEmpty()) {
			
			return front;
		}
		
		throw new UnavailableNodeException();
	}
	
	/*
	 * pop() method removes a node from the front of the list
	 * Throws an unavailableNodeException() if list is empty
	 */
	public void pop() throws UnavailableNodeException {
		
		if(!isEmpty()) {
			
			if(front.getNext() != null) {
				
			    front = front.getNext();  
			    length--;
			}
			
			else {
			length--;
			front = null;
			rear = null;
			}
		}
		
		else {
			
			throw new UnavailableNodeException();
		}
	}
}

