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

import org.otrs.costos.exception.ResourceNotFoundException;
import org.otrs.costos.model.ConsultaEstado;
import org.otrs.costos.model.Contrato;
import org.otrs.costos.service.ConsultaEstadoService;


/**
 * @apiNote Expone los servicios para hacer crud de lo contratado
 * @author José Pascual Gómez Blanco
 * @serial 24/05/2022
 */
@RestController
@RequestMapping("/EstadoTicket")
@CrossOrigin(origins = "*", methods ={RequestMethod.GET})
public class ConsultaEstadoController {
@Autowired
private ConsultaEstadoService consultaEstadoService;

@GetMapping("/{id}")
public ConsultaEstado get(@PathVariable String id) throws ResourceNotFoundException {
    ConsultaEstado consultaEstado = consultaEstadoService.getConsultaEstadoService(id);        
   return consultaEstado;                
}
@GetMapping("/{id}/nit/{nit}")
public ConsultaEstado get(@PathVariable String id, @PathVariable String nit) throws ResourceNotFoundException {
    ConsultaEstado consultaEstado = consultaEstadoService.getConsultaEstadoService(id,nit);        
   return consultaEstado;                
}
}
