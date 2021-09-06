package com.dan.pgm.danmssueldos.database;

import com.dan.pgm.danmssueldos.model.ReciboSueldo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SueldoRepository extends CrudRepository<ReciboSueldo, Integer> {
}
