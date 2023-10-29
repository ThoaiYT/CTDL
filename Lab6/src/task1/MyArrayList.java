package task1;

import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<E> {
	private E[] elements;
	private int size;
	private final int DEFAULT_CAPACITY = 10;

	public MyArrayList() {
		// TODO Auto-generated constructor stub
		this.elements = (E[]) new Object[DEFAULT_CAPACITY];

	}

	public MyArrayList(int capacity) {
		this.elements = (E[]) new Object[capacity];
	}

	public void growSize() {
		E[] temp = Arrays.copyOf(elements, elements.length);
		if (size == elements.length)
			size *= 2;
		elements = (E[]) new Object[size];
		System.arraycopy(temp, 0, elements, 0, temp.length);
	}

	public int size() {
		return size;
	}

	public boolean isEmty() {
		return size == 0;
	}

	public E get(int i) throws IndexOutOfBoundsException {
//		for (int j = 0; j <= elements.length-1; j++) {
//			if (i==j)
//				return elements[i];
//		}
		// return null;
		if (i < 0 || i > elements.length - 1) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		return elements[i];
	}

	public E set(int i, E e) throws IndexOutOfBoundsException {
		if (i < 0 || i > elements.length - 1) {
			throw new IndexOutOfBoundsException("Ngu");
		}
		E rs = elements[i];
		elements[i] = e;
		return rs;
	}

	public boolean add(E e) {
		if (size >= elements.length)
			growSize();
		elements[size++] = e;
		return true;

	}

	public void add(int i, E e) throws IndexOutOfBoundsException {
		if (i < 0 || i > elements.length - 1) {
			throw new IndexOutOfBoundsException("Ngu");
		}
		// 0 1 2 3 4 5
		// 0 1 2 9 4 5
		// i 3
		// e 9
		if (i >= size) {
			add(e);
		}
		E temp;
		for (int j = i; j < size-1; j++) {
			temp = elements[j];
			elements[i]= e;
			elements[i+1]=temp;
		}
		size++;
		

	}

	public void remove(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i > size - 1) {
			throw new IndexOutOfBoundsException("Ngu");
		}
		System.arraycopy(elements, i + 1, elements, i, elements.length - i - 1);
		elements[elements.length - 1] = null;
		size--;
		// 0 1 2 3 4 5 6 7
		// 0 1 2 3 4 5 6 7
		// i 0
		// i 5
	}

	public void clear() {
		elements = (E[]) new Object[elements.length];
	}

	public int lastIndexOf(Object o) {
		int re = -1;
		for (int i = 0; i < size; i++) {
			if (elements[i].equals(o))
				re = i;
		}
		return re;
	}

	public E[] toArray() {
		E[] temp = Arrays.copyOfRange(elements, 0, size - 1);
		return temp;
	}

	public int indexOf(Object o) {
		for (int i = 0; i < size; i++) {
			if (elements[i].equals(o))
				return i;
		}
		return -1;
	}

	public boolean contain(Object o) {
		for (int i = 0; i < size; i++) {
			if (elements[i].equals(o))
				return true;
		}
		return false;
	}
	public MyArrayList<E> clone(){ 
		MyArrayList<E> asr = new MyArrayList<E>();
		asr.size = this.size;
		asr.elements = this.elements.clone();
		return asr;
	}
	public static void main(String[] args) {
	MyArrayList<Integer> list = new MyArrayList<Integer>();
	Integer i1 =1,i2=2,i3=3,i4=4;
	list.add(i1);
	list.add(i2);
	list.add(i3);
	list.remove(1);
	System.out.println(list.size);
	}

}
