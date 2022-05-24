package org.otrs.costos.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @apiNote Expone los servicios para hacer crud de lo contratado
 * @author José Pascual Gómez Blanco
 * @serial 24/05/2022
 */
@RestController
@RequestMapping("api/Contratado")
@CrossOrigin(origins = "*", methods ={RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ContratadoController {
    @Autowired
    private 

}
