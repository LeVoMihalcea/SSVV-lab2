package ssvv.lab2;

import ssvv.lab2.console.UI;
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

public class App {
    public static void main(String[] args) {
        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();

        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
        NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

        Service service = new Service(fileRepository1, fileRepository2, fileRepository3);
        UI consola = new UI(service);
        consola.run();

        //PENTRU GUI
        // de avut un check: daca profesorul introduce sau nu saptamana la timp
        // daca se introduce nota la timp, se preia saptamana din sistem
        // altfel, se introduce de la tastatura
    }
}

