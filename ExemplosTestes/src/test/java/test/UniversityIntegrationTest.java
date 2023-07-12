package test;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(Arquillian.class)
public class UniversityIntegrationTest {

    @Inject
    private University university;

    @PersistenceContext
    private EntityManager entityManager;

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClasses(University.class, Student.class)
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml");
    }

    @Test
    public void testAddStudent() {
        Student student = new Student("Anna", 22);

        university.addStudent(student);

        entityManager.flush();
        entityManager.clear();

        Student persistedStudent = entityManager.find(Student.class, student.getId());

        Assert.assertEquals(student.getName(), persistedStudent.getName());
        Assert.assertEquals(student.getAge(), persistedStudent.getAge());
    }
}

