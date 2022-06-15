package org.otrs.costos.repository;

import org.otrs.costos.model.Contrato;
import org.otrs.costos.model.ContratoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaz de Persistencia de los tiempos contratados con
 * @author José Pascual Gómez Blanco
 * @serial 25/05/2022
 */
// @Repository
// public interface ContratoCrudRepository extends CrudRepository<Contrato, ContratoId> {

// }
/**
 * Interfaz de Persistencia de los tiempos contratados con
 * @author José Pascual Gómez Blanco
 * @serial 25/05/2022
 */
@Repository
// public interface ContratoCrudRepository extends CrudRepository<Contrato, Integer> {
// public interface ContratoCrudRepository extends PagingAndSortingRepository<Contrato, Integer>  {
public interface ContratoCrudRepository extends JpaRepository<Contrato, Integer>  {

}

