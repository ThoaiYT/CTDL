package ex2;

import java.util.Comparator;

public class Product implements Comparable<Product> {
	private String id;
	private String name;
	private double price;
	private String type;

	public Product(String id, String name, double price, String type) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public String toString() {
		return "Id: " + id + ", product: " + name + ", type: " + type;
	}

	@Override
	public int compareTo(Product o) {
		int i1 = Integer.valueOf(id);
		int i2 = Integer.valueOf(o.id);
		if (i1 > i2)
			return 1;
		if (i1 < i2)
			return -1;
		return 0;
	}
	public int compareProduct(Product p) {
		return  Integer.valueOf(id) - Integer.valueOf(p.id);
	}
	public boolean filterType(String thatType) {
		return type.equals(thatType);
	}

}
