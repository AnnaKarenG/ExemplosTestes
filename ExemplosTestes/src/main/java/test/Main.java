package test;

public class Main {
	
	public static void main(String[] args) {
        University university = new University("Universidade federal do ceará");

        Student student1 = new Student("Anna", 20);
        university.addStudent(student1);

        Student student2 = new Student("Karen", 22);
        university.addStudent(student2);

        displayStudents(university);
    }
    
    public static void displayStudents(University university) {
        System.out.println("University: " + university.getName());
        System.out.println("Students:");
        for (Student student : university.getStudents()) {
            System.out.println("Name: " + student.getName());
            System.out.println("Age: " + student.getAge());
        }
    }
}