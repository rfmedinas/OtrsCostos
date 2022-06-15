package org.otrs.costos.service;

import java.util.List;
import java.util.Optional;

import org.otrs.costos.exception.ResourceNotFoundException;
import org.otrs.costos.model.Contrato;
import org.otrs.costos.model.ContratoId;
import org.otrs.costos.repository.ContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContratoService {
    @Autowired
    ContratoRepository contratoRepository;


    public Page<Contrato> getPaginator(Pageable pageable){
        return contratoRepository.getPaginator(pageable);
    };

    public List<Contrato> getContratos() {
        return contratoRepository.getContratos();
    }

    public Optional<Contrato> getContrato(int id) {
        return contratoRepository.getContratoById(id);
    }

    public Contrato saveContrato(Contrato contrato) {
        return contratoRepository.saveContrato(contrato);
    }

    public Contrato updateContrato(Contrato contrato)  {
        // getContrato(contrato.getId()).map(p -> {
		// 	return contratoRepository.saveContrato(p);
		// }).orElseThrow(() -> new ResourceNotFoundException("Contrato: "));
        
        if (contrato != null) {
            return contratoRepository.saveContrato(contrato);
        }
        return contrato;
    }

    public void deleteAll() {
        contratoRepository.deleteAll();
    }

    // public void delete(ContratoId id) {
    //     Optional<Contrato> oContrato = getContrato(id);
    //     if (!oContrato.isEmpty()) {
    //         contratoRepository.deleteContrato(oContrato.get());
    //     }
    // }
    public void delete(int id) {
        Optional<Contrato> oContrato = getContrato(id);
        if (!oContrato.isEmpty()) {
            contratoRepository.deleteContrato(oContrato.get());
        }
    }
}
