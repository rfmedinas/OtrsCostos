package org.otrs.costos.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.otrs.costos.entidades.Contrato;
import org.otrs.costos.entidades.ContratoId;
import org.otrs.costos.servicios.contratoService;

/**
 * @apiNote Expone los servicios para hacer crud de lo contratado
 * @author José Pascual Gómez Blanco
 * @serial 24/05/2022
 */
@RestController
@RequestMapping("api/Contratado")
@CrossOrigin(origins = "*", methods ={RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ContratoController {
    @Autowired
    private  contratoService contratoService;

    /**
     * @apiNote Permite listar todos los Contratos 
     * @return Listado de Contratos
     */
    @GetMapping("/all")
    public List<Contrato> getContratos(){
        return contratoService.getContratos();
    }

    /**
     * @apiNote Permite crear un Contrato
     * @param Contrato datos para crear el nuevo Contrato
     * @return Contrato creado
     */
    @PostMapping("/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Contrato saveContratos(@RequestBody Contrato contrato){
        Contrato contratoSave = contratoService.saveContrato(contrato);
        return contratoSave;
    }

    /**
     * @apiNote Permite crear un Contrato
     * @param Contrato datos para crear el nuevo Contrato
     * @return Mensaje de Contrato Creado
     */
    @PostMapping("/saveMensaje")
    public ResponseEntity<String> withResponseEntity(@RequestBody Contrato contrato) {
        Contrato contratoSave = contratoService.saveContrato(contrato);
        return ResponseEntity.status(HttpStatus.CREATED).body("El contrato de nit " +contratoSave.getIdCliente() + " e Ip " + contratoSave.getIp() +"; fue creado \n");
    } 


    /**
     * @apiNote Permite actualizar un Contrato existente
     * @param contrato datos con los que se actualiza el Contrato
     * @return Contrato actualizado
     */
    @PutMapping("/update")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Contrato updateContrato(@RequestBody Contrato contrato){
        Contrato contratoSave = contratoService.updateContrato(contrato);
        return contratoSave;
    }

    /**
     * @apiNote Permite actualizar un Contrato existente
     * @param contrato datos con los que se actualiza el Contrato
     * @return Contrato actualizado
     */
    @PutMapping("/update1")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public Contrato update1Contrato(@RequestBody Contrato contrato){
        Contrato contratoSave = contratoService.saveContrato(contrato);
        return contratoSave;
    }

    /**
     * @apiNote Permite eliminar todos los Contratos
     */
    @DeleteMapping("/deleteAll")
    public void deleteAllContrato(){
        contratoService.deleteAll();
    }
  
    /**
     * @apiNote Permite eliminar un Contrato
     * @param id Indentificador del Contrato e eliminar
     */
    @DeleteMapping(value = "/{idclient}/{ip}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void deleteId(@PathVariable Integer idclient, @PathVariable String ip) {
        ContratoId contratoId = new ContratoId(idclient, ip);
        contratoService.delete(contratoId); 
    }
}
