package ssvv.lab2;

import org.junit.Test;
import ssvv.lab2.domain.Tema;
import ssvv.lab2.repository.TemaXMLRepository;
import ssvv.lab2.service.Service;
import ssvv.lab2.validation.TemaValidator;
import ssvv.lab2.validation.Validator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AssignmentTest {

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void assignmentAddedSuccessfully(){
        Validator<Tema> temaValidator = new TemaValidator();
        TemaXMLRepository fileRepository1 = new TemaXMLRepository(temaValidator, "teme.xml");
        Service service = new Service(null, fileRepository1, null);

        assertEquals(0, service.saveTema("tema_01", "o descriere cumsecade", 8, 7));
    }

    @Test
    public void addAssignmentDeadlineLowerThanStartLine(){
        Validator<Tema> temaValidator = new TemaValidator();
        TemaXMLRepository fileRepository1 = new TemaXMLRepository(temaValidator, "teme.xml");
        Service service = new Service(null, fileRepository1, null);

        assertEquals(1, service.saveTema("tema_01", "o descriere cumsecade", 6, 7));
    }
}
