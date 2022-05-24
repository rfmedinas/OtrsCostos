package org.otrs.costos.servicios;

import java.util.List;
import java.util.Optional;

import org.otrs.costos.entidades.Contrato;
import org.otrs.costos.entidades.ContratoId;
import org.otrs.costos.repositorios.ContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class contratadoService {
    @Autowired
    ContratoRepository contratoRepository;
    
    public List<Contrato> getContratos(){
        return contratoRepository.getContratos();
    }

    public Optional<Contrato> getContrato(ContratoId id){
        return contratoRepository.getContratoById(id);
    }

    public Contrato saveContrato(Contrato contrato){
        return contratoRepository.saveContrato(contrato);
    }

    public Contrato updateContrato(Contrato contrato){
        if (contrato != null) {
            if (contrato.getId() != null){
                Optional<Contrato> oContrato = getContrato(contrato.getId());
                if (!oContrato.isEmpty()){
                    Contrato sco = oContrato.get();
                    if (contrato.getName() !=null){
                        sco.setName(contrato.getName());
                    }
                    if (contrato.geteMail() !=null){
                        sco.seteMail(contrato.geteMail());
                    }
                    if (contrato.getPassword() !=null){
                        sco.setPassword(contrato.getPassword());
                    }
                    return contratoRepository.saveContrato(sco);
                }
            }
        }
        return contrato;
    }

    public void deleteAll(){
        contratoRepository.deleteAll();
    }

    public void delete(ContratoId id){
        Optional<Contrato> oContrato = getContrato(id);
        if (!oContrato.isEmpty()){
            contratoRepository.deleteContrato(oContrato.get());                        
        }        
    }
}
