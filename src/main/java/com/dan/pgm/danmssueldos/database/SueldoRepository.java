package com.dan.pgm.danmssueldos.database;

import com.dan.pgm.danmssueldos.model.ReciboSueldo;
import org.springframework.data.repository.CrudRepository;

public interface SueldoRepository extends CrudRepository<Integer, ReciboSueldo> {
}
