package org.otrs.costos.servicios;

import java.util.List;
import java.util.Optional;

import org.otrs.costos.entidades.Contrato;
import org.otrs.costos.entidades.ContratoId;
import org.otrs.costos.repositorios.ContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class contratoService {
    @Autowired
    ContratoRepository contratoRepository;

    public List<Contrato> getContratos() {
        return contratoRepository.getContratos();
    }

    public Optional<Contrato> getContrato(ContratoId id) {
        return contratoRepository.getContratoById(id);
    }

    public Contrato saveContrato(Contrato contrato) {
        return contratoRepository.saveContrato(contrato);
    }

    public Contrato updateContrato(Contrato contrato) {
        if (contrato != null) {
            return contratoRepository.saveContrato(contrato);
        }
        return contrato;
    }

    public void deleteAll() {
        contratoRepository.deleteAll();
    }

    public void delete(ContratoId id) {
        Optional<Contrato> oContrato = getContrato(id);
        if (!oContrato.isEmpty()) {
            contratoRepository.deleteContrato(oContrato.get());
        }
    }
}
