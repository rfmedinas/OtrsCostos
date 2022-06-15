package org.otrs.costos.repository;

import java.util.List;
import java.util.Optional;

import org.otrs.costos.model.Contrato;
import org.otrs.costos.model.ContratoId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

/**
 * Definición de lo contratado
 * @author José Pascual Gómez Blanco
 * @serial 24/05/2022
 */
@Repository
public class ContratoRepository {
    @Autowired
    private ContratoCrudRepository contratoCrudRepository  ;

    public Page<Contrato> getPaginator(Pageable pageable) {
        return (Page<Contrato>) contratoCrudRepository.findAll(pageable);
    }

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
    // public Optional <Contrato> getContratoById(int contratadoId) {
    //     return contratoCrudRepository.findById(contratadoId);
    // }

    /**
     * @apiNote consultar un contratado
     * @param Id identificador del usuario a consultar
     * @return contratado consultado
     */
    public Optional <Contrato> getContratoById(int Id) {
        return contratoCrudRepository.findById(Id);
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
    // public void deleteContratoById(ContratoId id){
    //     contratoCrudRepository.deleteById(id);
    // }
    public void deleteContratoById(int id){
        contratoCrudRepository.deleteById(id);
     }

    
}
