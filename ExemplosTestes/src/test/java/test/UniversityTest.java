package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class UniversityTest {
	
    private University university;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setup() {
        university = new University("Universidade federal do ceará");
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testAddStudent() {
        Student student = new Student("Anna", 20);
        university.addStudent(student);
        Assertions.assertEquals(1, university.getStudents().size());
        Assertions.assertTrue(university.getStudents().contains(student));
    }

    @Test
    public void testDisplayStudents() {
        Student student1 = new Student("Anna", 20);
        Student student2 = new Student("Karen", 22);
        university.addStudent(student1);
        university.addStudent(student2);

        university.displayStudents();

        String expectedOutput = "Universidade federal do ceará\n" +
                "Students:\n" +
                "Name: Anna\n" +
                "Age: 20\n" +
                "Name: Karen\n" +
                "Age: 22\n";

        Assertions.assertEquals(expectedOutput, outputStream.toString());
        
    }
}
