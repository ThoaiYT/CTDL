package task2;

public class Node<E> {// Generic
	private E data;
	private Node<E> next;

	public Node(E data) {
		this.data = data;
	}

	public Node(E data, Node<E> next) {
		this.data = data;
		this.next = next;
	}

	E getData() {
		return data;
	}
	//trả về data ở vị trí cuối
	E getNext() {
		if (next == null)
			return data;
		else
			return next.getNext();
	}
	//đặt node cuối cùng = null
	void removeLast() {
		if (next.returnNext()==null)
			next=null;
		else next.removeLast();
			
	}
	Node<E> returnNext(){
		return next;
	}
	//trả về Node cuối cùng
	Node<E> returnLast(){
		if (next!=null) {
			return next.returnLast();
		}
		else return next;
	}

	void addLast(E lolll) {
		if (next == null) {
			next = new Node(lolll);
		}
			
		else {
			//Node<E> newest = new Node(lolll);
			next.addLast(lolll);

		}
	}

	void setNext(Node<E> n) {
		next = n;
	}

	String printData() {
		if (next == null)
			return (String) data;
		return (String) data+" "+ next.printData() ;
	}
}
