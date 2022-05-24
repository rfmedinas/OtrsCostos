package org.otrs.costos.repositorios;

import org.otrs.costos.entidades.Contrato;
import org.otrs.costos.entidades.ContratoId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaz de Persistencia de los tiempos contratados con
 * @author José Pascual Gómez Blanco
 * @serial 25/05/2022
 */
@Repository
public interface ContratoCrudRepository extends CrudRepository<Contrato, ContratoId> {

}
    

