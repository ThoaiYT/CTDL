package task2;

public class SinglyLinkedList<E> {
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size;

	public SinglyLinkedList() {
		super();
	}

// Returns the number of elements in the list.
	public int size() {
		return size;
	}

// Returns true if the list is empty, and false otherwise.
	public boolean isEmpty() {
		return size==0;
	}

// Returns (but does not remove) the first element in the list.
	public E first() {
		return this.head.getData();
	}

// Returns (but does not remove) the last element in the list.
	public E last() {
		if (tail==null)
			return head.getData();
		else return tail.getNext();
	}

	public void addFirst(E e) {
		Node<E> newest = new Node(e,head);
		head= newest;
		size++;
	}

	// Adds a new element to the end of the list.
	public void addLast(E e) {
		Node<E> newest = new Node(e,null);
		//tail.setNext(newest);
		tail=newest;
		head.addLast(e);
		size++;
		
	}

	// Removes and returns the first element of the list.
	public E removeFirst() {
		//Node<E> newest = (Node<E>) head.getNext();
		E re = head.getData();
		head= (Node<E>) head.returnNext();
		size--;
		return re;
	}

	// Removes and returns the last element of the list.
	public E removeLast() {
		//lấy data ở vị trí cuối
		E re = head.getNext();
		//bỏ last node
		head.removeLast();
		//đặt tail = node ở vị trí cuối
		tail=head.returnLast();
		//giảm size
		size--;
		return re;
	}
	public String printRa() {
		return head.printData();
	}
	public static void main(String[] args) {
		SinglyLinkedList<String> sll = new SinglyLinkedList<String>();
		sll.addFirst("First");	
		sll.addFirst("NewFirst");
		sll.addFirst("NewestFirst");
		sll.addLast("CeeJay");
		sll.addLast("ThisIsLastAndItWillBeRemoved");
		sll.removeFirst();
		sll.removeLast();
		System.out.println(sll.printRa());
		System.out.println(sll.size());
	}
}