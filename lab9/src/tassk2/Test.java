package tassk2;

import java.util.ArrayList;
import java.util.List;

public class Test {
public static void main(String[] args) {
//	Magazine m = new Magazine(null, null, 0, 0, 0, null);
//	ReferenceBook r = new ReferenceBook(null, null, 0, 0, 0, null, null);
//	System.out.println(m.whatIsThis());
//	System.out.println(r.whatIsThis());
	
	
	Chapter chap1 = new Chapter("Canh cua than ky", 4);
	Chapter chap2 = new Chapter("Den pin thu hoach", 5);
	Chapter chap3 = new Chapter("Cell va vo dai toi thuong", 6);
	Chapter chap4 = new Chapter("Super Kamehame Ha", 7);
	
	List<Chapter> cli1 = new ArrayList<Chapter>();
	cli1.add(chap1);
	cli1.add(chap2);
	
	List<Chapter> cli2 = new ArrayList<Chapter>();
	cli2.add(chap3);
	cli2.add(chap4);
	
	ReferenceBook rbook1 = new ReferenceBook("Doremon", "F F F", 9, 1970, 20000, "manga", cli1);
	ReferenceBook rbook2 = new ReferenceBook("DBZ", "AkiraToriyama", 9, 1986, 20000, "manga", cli2);
	
	Magazine m1 = new Magazine("Tap chi meo den", "An danh", 10, 2023, 15000, "Cosplay Maids");
	Magazine m2 = new Magazine("Tap chi hoa la he", "An danh", 10, 2011, 15000, "Hoa nhiet doi");
	Magazine m3 = new Magazine("Tap chi noi that", "An danh", 10, 2011, 15000, "Noi com dien cho cac ba noi tro");
	Magazine m4 = new Magazine("Tap chi vu khi quan dung", "An danh", 10, 2011, 15000, "AK47 va nhung con hang sieu nong");
	
	
	List<Publication> booklist = new ArrayList<Publication>();
	booklist.add(rbook1);
	booklist.add(rbook2);
	booklist.add(m1);
	booklist.add(m2);
	booklist.add(m3);
	booklist.add(m4);
	
	BookStore store = new BookStore(booklist);
	System.out.println(store.isContainThisMagazine("Hoa nhiet doi"));
	System.out.println(store.magazinesPublicInThisYear(2023).size());
	store.mostPageReferenceBook();
	
	//System.out.println(store.statisticalByYear());
	
}
}
