package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MainTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setup() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testMain() {
    	
        University university = new University("Universidade federal do ceará");

        Student student1 = new Student("Anna", 20);
        university.addStudent(student1);

        Student student2 = new Student("Karen", 22);
        university.addStudent(student2);

        String expectedOutput = "University: Universidade federal do ceará\n" +
                "Students:\n" +
                "Name: Anna\n" +
                "Age: 20\n" +
                "Name: Karen\n" +
                "Age: 22\n";

        Main.main(null);
        String actualOutput = outputStream.toString();

        Assertions.assertEquals(expectedOutput, actualOutput);
    }
}
