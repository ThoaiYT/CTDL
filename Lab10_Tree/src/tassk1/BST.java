package tassk1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BST<E extends Comparable<E>> {
	private BNode<E> root;

	public BST() {
		this.root = null;
	}

	public void add(E e) {
		if (root == null)
			root = new BNode<E>(e);
		else
			root.add(e);
	}

	public void add(Collection<E> col) {
		for (E e : col) {
			add(e);
		}
	}

	public int depth(E node) {
		return root.depth(node);
	}

	public boolean contains(E e) {
		return root.contains(e);
	}

	public int size() {

		if (root == null)
			return 0;
		else
			return root.size();
	}

	public E findMin() {
		if (root == null)
			return null;
		return root.findMin();
	}

	public E findMax() {
		if (root == null)
			return null;
		return root.findMax();
	}

	public boolean remove(E e) {
		return root.remove(root, e);
	}

	public void inorder() {
		root.inorder();
		System.out.println();
	}

	public int height() {
		return root.height();
	}

	public void preorder() {
		root.preorder();
		System.out.println();
	}

	public List<E> descendants(E data) {
		return root.descendants(data);
	}

	public List<E> ancestors(E data) {
		List<E> re = new ArrayList<E>();
		root.ancestors(data, re);
		return re;
	}

	public static void main(String[] args) {
		BST<Integer> dic = new BST<Integer>();
		dic.add(5);
		dic.add(2);
		dic.add(6);
		dic.add(1);
		dic.add(7);
		dic.add(3);
		dic.add(10);
		System.out.println("This tree contains 5 is " + dic.contains(5));
		System.out.println("Tree's height is " + dic.height() + ", node 5's depth is " + dic.depth(5));
		System.out.println("Min: " + dic.findMin() + "; Max: " + dic.findMax());
		System.out.print("Inorder Traversal before removing node 5: ");
		dic.inorder();
		dic.remove(5);
		System.out.print("Inorder Traversal after removing node 5: ");
		dic.inorder();
		System.out.println("Descendants of node 6: " + dic.descendants(6));
		System.out.println("Ancestors of node 10: " + dic.ancestors(10));

	}
}
