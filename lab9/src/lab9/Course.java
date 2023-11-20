package lab9;

import java.util.List;

public class Course {
	private String id;
	private 	String tittle;
	private 	List<Student> students;
	private 	String type, lecturer;

	public Course(String id, String tittle, List<Student> students, String type, String lecturer) {
		super();
		this.id = id;
		this.tittle = tittle;
		this.students = students;
		this.type = type;
		this.lecturer = lecturer;
	}
	public String getType() {
		return type;
	}
	public List<Student> getStudents(){
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students=students;
	}
}
