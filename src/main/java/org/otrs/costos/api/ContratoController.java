package org.otrs.costos.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import org.otrs.costos.model.Contrato;
import org.otrs.costos.model.ContratoId;
import org.otrs.costos.service.ContratoService;

/**
 * @apiNote Expone los servicios para hacer crud de lo contratado
 * @author José Pascual Gómez Blanco
 * @serial 24/05/2022
 */
@RestController
@RequestMapping("api/contratos")
@CrossOrigin(origins = "*", methods ={RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ContratoController {
    @Autowired
    private  ContratoService contratoService;

    @GetMapping("/page")
	public Page<Contrato> getContratoList(@RequestParam(defaultValue = "0") int page, 
                                          @RequestParam(defaultValue = "10") int size,
                                          @RequestParam(defaultValue = "ip") String order,
                                          @RequestParam(defaultValue = "true") boolean asc
            ) {
                Pageable paging = PageRequest.of(page, size, Sort.by(order).ascending());
                if(!asc){
                    paging = PageRequest.of(page, size, Sort.by(order).descending());            
                }
		
		return contratoService.getPaginator(paging);
	}

    // @GetMapping("/paises")
    // public ResponseEntity<Page<Pais>> paginas(
    //         @RequestParam(defaultValue = "0") int page,
    //         @RequestParam(defaultValue = "10") int size,
    //         @RequestParam(defaultValue = "nombre") String order,
    //         @RequestParam(defaultValue = "true") boolean asc
    // ){
    //     Page<Pais> paises = paisService.paginas(
    //             PageRequest.of(page, size, Sort.by(order)));
    //     if(!asc)
    //         paises = paisService.paginas(
    //                 PageRequest.of(page, size, Sort.by(order).descending()));
    //     return new ResponseEntity<Page<Pais>>(paises, HttpStatus.OK);
    // }


    /**
     * @apiNote Permite listar todos los Contratos 
     * @return Listado de Contratos
     */
    @GetMapping()
    public List<Contrato> getContratos(){
        return contratoService.getContratos();
    }


    /**
     * @apiNote Permite consultar un Contrato
     * @param id Indentificador del Contrato a consultar
     */
    @GetMapping("/{id}")
    public Optional<Contrato> getContrato(@PathVariable Integer id) {
        Optional<Contrato> contrato = contratoService.getContrato(id);
        return contrato;
        
    }

    /**
     * @apiNote Permite crear un Contrato
     * @param Contrato datos para crear el nuevo Contrato
     * @return Contrato creado
     */
    @PostMapping("")
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
    @PutMapping("/{id}")
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
    // @DeleteMapping(value = "/{idclient}/{ip}")
    // @ResponseStatus(code = HttpStatus.ACCEPTED)
    // public void deleteId(@PathVariable Integer idclient, @PathVariable String ip) {
    //     ContratoId contratoId = new ContratoId(idclient, ip);
    //     contratoService.delete(contratoId); 
    // }
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void deleteId(@PathVariable Integer id) {
        contratoService.delete(id); 
    }
}
