package test;

import java.util.List;
import java.util.Map;

import org.junit.runner.RunWith;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class AdicionarAlunosSteps {
    private University university;

    @DataTableType
    public Student studentEntry(Map<String, String> entry) {
        String name = entry.get("Nome");
        int age = Integer.parseInt(entry.get("Idade"));
        return new Student(name, age);
    }

    @Given("Eu tenho uma universidade {string}")
    public void euTenhoUmaUniversidade(String universityName) {
        university = new University(universityName);
    }

    @When("Eu adiciono um aluno chamado {string} com idade {int}")
    public void euAdicionoUmAluno(String name, int age) {
        Student student = new Student(name, age);
        university.addStudent(student);
    }

    @Then("A universidade {string} deve conter os seguintes alunos:")
    public void aUniversidadeDeveConterOsSeguintesAlunos(String universityName, List<Student> students) {
        assert universityName.equals(university.getName());

        List<Student> universityStudents = university.getStudents();
        assert universityStudents.size() == students.size();

        for (int i = 0; i < students.size(); i++) {
            Student expectedStudent = students.get(i);
            Student actualStudent = universityStudents.get(i);

            assert expectedStudent.getName().equals(actualStudent.getName());
            assert expectedStudent.getAge() == actualStudent.getAge();
        }
    }
}

