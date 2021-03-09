package ssvv.lab2.repository;

import ssvv.lab2.domain.Tema;
import ssvv.lab2.validation.Validator;

public class TemaRepository extends AbstractCRUDRepository<String, Tema> {
    public TemaRepository(Validator<Tema> validator) {
        super(validator);
    }
}

