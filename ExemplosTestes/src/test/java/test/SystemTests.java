package test;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import java.util.List;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class SystemTests {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private University universityMock;

    @InjectMocks
    private Main main;

    @Test
    public void testDisplayStudents() {
        when(universityMock.getName()).thenReturn("Universidade federal do ceará");

        Student student1 = new Student("Anna", 20);
        Student student2 = new Student("Karen", 22);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        main.displayStudents(universityMock);

        String consoleOutput = outputStream.toString().trim();

        String expectedOutput = "University: Universidade federal do ceará\n" +
                "Students:\n" +
                "Name: Anna\n" +
                "Age: 20\n" +
                "Name: Karen\n" +
                "Age: 22";
        assertEquals(expectedOutput, consoleOutput);
    }
}
