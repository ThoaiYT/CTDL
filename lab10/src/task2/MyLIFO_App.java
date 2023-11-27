package task2;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.management.Query;

public class MyLIFO_App {
	// method stutter that accepts a queue of integers as a parameter and replaces
	// every element of the queue with two copies of that element
	// front [1, 2, 3] back
	// becomes
	// front [1, 1, 2, 2, 3, 3] back

	public static <E> void stutter(Queue<E> input) {
		// TODO
		ArrayDeque<E> re = new ArrayDeque<E>();
		while (input.size() > 0) {
			E e = input.poll();
			System.out.println(e);
			System.out.println("~~~~~~~~~");
			re.add(e);
			re.add(e);
		}
		input.addAll(re);
		System.out.println("<--------------------->");
	}

	// Method mirror that accepts a queue of strings as a parameter and appends the
	// queue's contents to itself in reverse order
	// front [a, b, c] back
	// becomes
	// front [a, b, c, c, b, a] back
	public static <E> void mirror(Queue<E> input) {
		// TODO
		// lam bieng vl viet v cho de
		ArrayDeque<E> re1 = new ArrayDeque<E>();
		Stack<E> re2 = new Stack<E>();
		re2.addAll(input);
//		while (input.size() > 0) {
//			E e = input.poll();
//			re1.add(e);
//			re2.push(e);
//		}
//		input.addAll(re1);
		while(re2.size()>0) {
			E e = re2.pop();
			input.add(e);
		}
		
		
	}

	public static void main(String[] args) {
		Queue<Integer> a = new ArrayDeque<Integer>();
		a.add(1);
		a.add(2);
		a.add(3);
		stutter(a);
		System.out.println(a);
		mirror(a);
		System.out.println(a);
	}
}
