//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import domain.Student;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import repository.StudentXMLRepository;
import validation.StudentValidator;

public class AppTest {
    private StudentXMLRepository studentRepository;

    public StudentTest() {
    }

    @Before
    public void setUp() {
        this.studentRepository = new StudentXMLRepository(new StudentValidator(), "students.xml");
    }

    @Test
    public void testSaveStudent_ValidInput() {
        Student student = new Student("123", "John Doe", 500);
        Student savedStudent1 = (Student)this.studentRepository.save(student);
        TestCase.assertNotNull(savedStudent1);
        Student savedStudent = (Student)this.studentRepository.findOne("123");
        TestCase.assertNotNull(savedStudent);
        Assert.assertEquals("123", savedStudent.getID());
        Assert.assertEquals("John Doe", savedStudent.getNume());
        Assert.assertEquals(500L, (long)savedStudent.getGrupa());
    }

    @Test
    public void testSaveStudent_InvalidInput() {
        Student student = new Student("-1", "John Doe", 1000);
        Student savedStudent1 = (Student)this.studentRepository.save(student);
        Assert.assertEquals((Object)null, savedStudent1);
        Student savedStudent = (Student)this.studentRepository.findOne("456");
        Assert.assertEquals((Object)null, savedStudent);
    }
}
