package ex2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class Order implements Comparator<OrderItem> {
	private OrderItem[] items;

	public Order(OrderItem[] items) {
		super();
		this.items = items;
	}

	public void sort() {
		Arrays.sort(items, new Comparator<OrderItem>() {

			@Override
			public int compare(OrderItem o1, OrderItem o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		});
	}

	public String toString() {
		String str = "";
		sort();
		for (int i = 0; i < items.length; i++) {
			str += items[i].toString() + "\n";
		}
		return str;
	}

	public double cost() {
		double co = 0;
		for (OrderItem o : items) {
			co += o.cost();
		}
		return co;
	}

	// using binary search
	// Trong điều kiện search = id :))
	public boolean contains(Product p) {
		sort();
		int left = 0;
		int right = items.length - 1;
		while (left < right) {
			int mid = (left + right) / 2;
			if (items[mid].compareProduct(p) == 0)
				return true;
			if (items[mid].compareProduct(p) < 0)
				left = mid;
			if (items[mid].compareProduct(p) > 0)
				right = mid;
		}
		return false;
	}

	public Product[] filter(String type) {
		sort();
		int len = 0, index = 0;
		for (int i = 0; i < items.length; i++) {
			if (items[i].filterType(type))
				len++;
		}
		Product[] result = new Product[len];
		for (int i = 0; i < items.length; i++) {
			if (items[i].filterType(type)) {
				result[index] = items[i].getProduct();
				index++;
			}
		}
		return result;
	}

	@Override
	public int compare(OrderItem o1, OrderItem o2) {
		return o1.compareTo(o2);
	}

	public static void main(String[] args) {
		Product p1 = new Product("007", "Cocacola", 10000.0, "Drink");
		Product p2 = new Product("002", "Number One", 10000.0, "Drink");
		Product p3 = new Product("003", "Gundam TRP-1231", 100000.0, "Toy");
		Product p4 = new Product("004", "KSADCKAS", 50000.0, "Something?");
		Product p5 = new Product("005", "KSKAS", 2000.0, "Something?");
		Product p6 = new Product("006", "CKAS", 1000.0, "Something?");
		OrderItem o1 = new OrderItem(p1, 2);
		OrderItem o2 = new OrderItem(p2, 3);
		OrderItem o3 = new OrderItem(p3, 1);
		OrderItem o4 = new OrderItem(p4, 1);
		OrderItem o5 = new OrderItem(p5, 1);
		OrderItem o6 = new OrderItem(p6, 1);

		OrderItem[] items = new OrderItem[] { o5, o6, o1, o2, o4, o3 };
		Order o = new Order(items);

		System.out.println(o.toString());
		System.out.println(Arrays.toString(o.filter("Drink")));

	}
}
