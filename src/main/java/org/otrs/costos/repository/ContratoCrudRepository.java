package org.otrs.costos.repository;

import org.otrs.costos.model.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Interfaz de Persistencia de los tiempos contratados con
 * @author José Pascual Gómez Blanco
 * @serial 25/05/2022
 */
public interface ContratoCrudRepository extends JpaRepository<Contrato, Integer>  {

}

