package ssvv.lab2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import ssvv.lab2.domain.Nota;
import ssvv.lab2.domain.Student;
import ssvv.lab2.domain.Tema;
import ssvv.lab2.repository.NotaXMLRepository;
import ssvv.lab2.repository.StudentRepository;
import ssvv.lab2.repository.StudentXMLRepository;
import ssvv.lab2.repository.TemaXMLRepository;
import ssvv.lab2.service.Service;
import ssvv.lab2.validation.NotaValidator;
import ssvv.lab2.validation.StudentValidator;
import ssvv.lab2.validation.TemaValidator;
import ssvv.lab2.validation.Validator;

import java.util.UUID;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void studentAddedSuccessfully(){
        Validator<Student> studentValidator = new StudentValidator();
        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        Service service = new Service(fileRepository1, null, null);

        assertEquals(1, service.saveStudent(String.valueOf(UUID.randomUUID()), "Leo", 935));
    }

    @Test
    public void studentNotAdded(){
        Validator<Student> studentValidator = new StudentValidator();
        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        Service service = new Service(fileRepository1, null, null);

        assertEquals(0, service.saveStudent("1", "Leo", 935));
    }

    @Test
    public void addStudentWithInvalidIdEmpty() {
        Validator<Student> studentValidator = new StudentValidator();
        StudentXMLRepository studentRepository = new StudentXMLRepository(studentValidator, "studenti.xml");
        Service service = new Service(studentRepository, null, null);

        assertEquals(1, service.saveStudent("", "Help", 666));
    }

    @Test
    public void addStudentWithInvalidIdNull() {
        Validator<Student> studentValidator = new StudentValidator();
        StudentXMLRepository studentRepository = new StudentXMLRepository(studentValidator, "studenti.xml");
        Service service = new Service(studentRepository, null, null);

        assertEquals(1, service.saveStudent(null, "Help", 666));
    }

    @Test
    public void addStudentWithValidGroup() {
        Validator<Student> studentValidator = new StudentValidator();
        StudentXMLRepository studentRepository = new StudentXMLRepository(studentValidator, "studenti.xml");
        Service service = new Service(studentRepository, null, null);

        assertEquals(0, service.saveStudent("1", "Help", 420));
    }

    @Test
    public void addStudentWithInvalidGroupLower() {
        Validator<Student> studentValidator = new StudentValidator();
        StudentXMLRepository studentRepository = new StudentXMLRepository(studentValidator, "studenti.xml");
        Service service = new Service(studentRepository, null, null);

        assertEquals(1, service.saveStudent("1", "Help", 42));
    }

    @Test
    public void addStudentWithInvalidGroupHigher() {
        Validator<Student> studentValidator = new StudentValidator();
        StudentXMLRepository studentRepository = new StudentXMLRepository(studentValidator, "studenti.xml");
        Service service = new Service(studentRepository, null, null);

        assertEquals(1, service.saveStudent("1", "Help", 42069));
    }

    @Test
    public void addStudentWithInvalidGroupLowerLimit() {
        Validator<Student> studentValidator = new StudentValidator();
        StudentXMLRepository studentRepository = new StudentXMLRepository(studentValidator, "studenti.xml");
        Service service = new Service(studentRepository, null, null);

        assertEquals(1, service.saveStudent("1", "Help", 110));
    }

    @Test
    public void addStudentWithInvalidGroupUpperLimit() {
        Validator<Student> studentValidator = new StudentValidator();
        StudentXMLRepository studentRepository = new StudentXMLRepository(studentValidator, "studenti.xml");
        Service service = new Service(studentRepository, null, null);

        assertEquals(1, service.saveStudent("1", "Help", 938));
    }

    @Test
    public void addStudentWithInvalidGroupNull() {
        Validator<Student> studentValidator = new StudentValidator();
        StudentXMLRepository studentRepository = new StudentXMLRepository(studentValidator, "studenti.xml");
        Service service = new Service(studentRepository, null, null);

        assertEquals(1, service.saveStudent("1", "Help", 98));
    }

    @Test
    public void addStudentWithValidName() {
        Validator<Student> studentValidator = new StudentValidator();
        StudentXMLRepository studentRepository = new StudentXMLRepository(studentValidator, "studenti.xml");
        Service service = new Service(studentRepository, null, null);

        assertEquals(0, service.saveStudent("1", "A very valid name", 666));
    }

    @Test
    public void addStudentWithInvalidNameEmpty() {
        Validator<Student> studentValidator = new StudentValidator();
        StudentXMLRepository studentRepository = new StudentXMLRepository(studentValidator, "studenti.xml");
        Service service = new Service(studentRepository, null, null);

        assertEquals(1, service.saveStudent("1", "", 666));
    }

    @Test
    public void addStudentWithInvalidNameNull() {
        Validator<Student> studentValidator = new StudentValidator();
        StudentXMLRepository studentRepository = new StudentXMLRepository(studentValidator, "studenti.xml");
        Service service = new Service(studentRepository, null, null);

        assertEquals(1, service.saveStudent("1", null, 666));
    }
}
