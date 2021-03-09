package ssvv.lab2.repository;

import ssvv.lab2.domain.Nota;
import ssvv.lab2.domain.Pair;
import ssvv.lab2.validation.Validator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class NotaRepository extends AbstractCRUDRepository<Pair<String, String>, Nota> {
    public NotaRepository(Validator<Nota> validator) {
        super(validator);
    }
}
