package ex2;

import java.util.Comparator;

public class OrderItem implements Comparable<OrderItem> {
	private Product p;
	private int quality;
	public OrderItem(Product p, int quality) {
		super();
		this.p = p;
		this.quality = quality;
	}
	public double cost() {
		return p.getPrice()*quality;
	}
	@Override
	public int compareTo(OrderItem o) {
		return p.compareTo(o.p);
	}
	public String toString() {
		return p.toString() + ", quality: "+ quality+ ", cost: "+cost()+"\t";
	}
	public int compareProduct(Product otherP) {
		return p.compareProduct(otherP);
	}
	public Product getProduct() {
		return p;
	}
	public boolean filterType(String type) {
		return p.filterType(type);
	}

}
