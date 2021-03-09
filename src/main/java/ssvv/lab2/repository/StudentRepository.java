package ssvv.lab2.repository;

import ssvv.lab2.domain.Student;
import ssvv.lab2.validation.Validator;

public class StudentRepository extends AbstractCRUDRepository<String, Student> {
    public StudentRepository(Validator<Student> validator) {
        super(validator);
    }
}

