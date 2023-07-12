package test;
import java.util.ArrayList;
import java.util.List;

public class University {
	 private String name;
	    private List<Student> students;

	    public University(String name) {
	        this.name = name;
	        this.students = new ArrayList<Student>();
	    }

	    public void addStudent(Student student) {
	        students.add(student);
	    }

	    public void displayStudents() {
	        System.out.println("University: " + name);
	        System.out.println("Students:");
	        for (Student student : students) {
	            System.out.println("Name: " + student.getName());
	            System.out.println("Age: " + student.getAge());
	        }
	    }
	    
	    public List<Student> getStudents() {
	        return students;
	    }
	    
	    public String getName() {
	        return name;
	    }
}
