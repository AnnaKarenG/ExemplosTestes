package test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StudentTest {

    @Test
    public void testGetName() {
       
        Student student = new Student("Anna", 22);

        String name = student.getName();

        
        Assertions.assertEquals("Anna", name);
    }

    @Test
    public void testGetAge() {
        
        Student student = new Student("Anna", 22);

        int age = student.getAge();

        Assertions.assertEquals(22, age);
    }
}
