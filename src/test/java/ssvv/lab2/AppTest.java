package ssvv.lab2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import ssvv.lab2.domain.Nota;
import ssvv.lab2.domain.Student;
import ssvv.lab2.domain.Tema;
import ssvv.lab2.repository.NotaXMLRepository;
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
}
