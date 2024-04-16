import domain.Student;
import org.junit.Before;
import org.junit.Test;
import repository.StudentXMLRepository;
import validation.StudentValidator;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

public class StudentTest {

    private StudentXMLRepository studentRepository;

    @Before
    public void setUp() {
        studentRepository = new StudentXMLRepository(new StudentValidator(), "students.xml");
    }

    @Test
    public void testSaveStudent_ValidInput() {
        Student student = new Student("123", "John Doe", 500);
        Student savedStudent1 = studentRepository.save(student);

        assertNotNull(savedStudent1);


        Student savedStudent = studentRepository.findOne("123");
        assertNotNull(savedStudent);
        assertEquals("123", savedStudent.getID());
        assertEquals("John Doe", savedStudent.getNume());
        assertEquals(500, savedStudent.getGrupa());
    }

    @Test
    public void testSaveStudent_InvalidInput() {

        Student student = new Student("-1", "John Doe", 1000);
        Student savedStudent1 = studentRepository.save(student);


        assertEquals(null, savedStudent1);


        Student savedStudent = studentRepository.findOne("456");
        assertEquals(null, savedStudent);
    }
}
