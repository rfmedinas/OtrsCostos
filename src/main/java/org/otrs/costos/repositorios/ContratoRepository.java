package org.otrs.costos.repositorios;

import java.util.List;
import java.util.Optional;

import org.otrs.costos.entidades.Contrato;
import org.otrs.costos.entidades.ContratoId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Definición de lo contratado
 * @author José Pascual Gómez Blanco
 * @serial 24/05/2022
 */
@Repository
public class ContratoRepository {
    @Autowired
    private ContratoCrudRepository contratoCrudRepository;

    /**
     * @apiNote Permite listar todos los contratados
     * @return Listado de contratados
     */
    public List<Contrato> getContratos() {
        return (List<Contrato>) contratoCrudRepository.findAll();
    }

    /**
     * @apiNote consultar un contratado
     * @param contratadoId identificador del usuario a consultar
     * @return contratado consultado
     */
    public Optional <Contrato> getContratoById(ContratoId contratadoId) {
        return contratoCrudRepository.findById(contratadoId);
    }


    /**
     * @apiNote Permite crear un Contratado
     * @param contratado datos para crear el nuevo Contratado
     * @return Contratado creado
     */
    public Contrato saveContrato (Contrato contratado){
        return contratoCrudRepository.save(contratado);
    }

    /**
     * @apiNote Eliminar un contrato por objeto
     * @param contrato contrato a eliminar
     */
    public void deleteContrato(Contrato contrato){
        contratoCrudRepository.delete(contrato);
    }

    /**
     * @apiNote Eliminar todo los contratos
     */
    public void deleteAll(){
        contratoCrudRepository.deleteAll();;
    }

    /**
     * @apiNote Permite eliminar un Usuario
     * @param id Indentificador del Usuario e eliminar
     */
    public void deleteContratoById(ContratoId id){
        contratoCrudRepository.deleteById(id);
    }
}
