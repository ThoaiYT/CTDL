package lab9;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Falculty {
	private String name;
	private String address;
	private List<Course> courses;

	public Falculty(String name, String address, List<Course> courses) {
		super();
		this.name = name;
		this.address = address;
		this.courses = courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public Course getMaxPraticalCourse() {
		int max = 0;
		Course re = null;
		for (Course c : courses) {
			if (c.getType().trim().equalsIgnoreCase("practical") && c.getStudents().size() >= max)
				max = c.getStudents().size();
			re = c;
		}
		System.out.println(max);
		return re;
	}

	public Map<Integer, List<Student>> groupStudentsByYear() {
		Map<Integer, List<Student>> re = new HashMap<Integer, List<Student>>();
		for (Course c : courses) {
			for (Student t : c.getStudents()) {
				if (!re.containsKey(t.getYear())) {
					// re.put(t.getYear(),);
					List<Student> li = new ArrayList<Student>();
					li.add(t);
					re.put(t.getYear(), li);
					 System.out.println(t.getYear()+ " "+ t.getName());

				} else {
					List<Student> li = re.get(t.getYear());
					li.add(t);
					 System.out.println(t.getYear()+ " "+ t.getName());
				}
			}
		}
		return re;

	}

	public Set<Course> filterCourses(String type) {

		Set<Course> re = new TreeSet<Course>(new Comparator<Course>() {

			@Override
			public int compare(Course c1, Course c2) {
				// TODO Auto-generated method stub
				return c2.getStudents().size() - c1.getStudents().size();
			}

		});
		for (Course c : courses) {
			if (c.getType().equals(type))
				re.add(c);
		}
		return re;

	}

	public static void main(String[] args) {
		Falculty f = new Falculty("", "", null);
		List<Course> li = new ArrayList<Course>();
		Course c1 = new Course("001", "Course 1", null, "practical", "");
		Course c2 = new Course("002", "Course 2", null, "non-practical", "");
		Course c3 = new Course("003", "Course 3", null, "practical", "");

		Student stu1 = new Student("001", "A", 2001);
		Student stu2 = new Student("002", "B", 2001);
		Student stu3 = new Student("003", "C", 2001);
		Student stu4 = new Student("004", "D", 2031);
		Student stu5 = new Student("005", "E", 1991);

		List<Student> list1 = new ArrayList<Student>();
		list1.add(stu1);
		list1.add(stu2);
		List<Student> list2 = new ArrayList<Student>();
		list2.add(stu3);
		list2.add(stu4);
		List<Student> list3 = new ArrayList<Student>();
		list3.add(stu5);
		
		c1.setStudents(list1);
		c2.setStudents(list2);
		c3.setStudents(list3);
		
		li.add(c1);
		li.add(c2);
		li.add(c3);
		f.setCourses(li);
		f.getMaxPraticalCourse();
		System.out.println(f.groupStudentsByYear());
		System.out.println(f.filterCourses("non-practical"));
	}

}
