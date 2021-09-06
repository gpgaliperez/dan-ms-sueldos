package com.dan.pgm.danmssueldos.database;

import com.dan.pgm.danmssueldos.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface VentaRepository extends JpaRepository<Venta, Integer> {

    List<Venta> findAll();
    List<Venta> findAllByFechaVentaAfter(LocalDate fechaInicioMes);
}
