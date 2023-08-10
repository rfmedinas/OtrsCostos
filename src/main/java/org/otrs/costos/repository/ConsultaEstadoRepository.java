package org.otrs.costos.repository;

import java.util.List;
import java.util.Optional;
import org.otrs.costos.exception.ResourceNotFoundException;
import org.otrs.costos.model.ConsultaEstado;
import org.otrs.costos.model.Contrato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
@Repository
public class ConsultaEstadoRepository {
	@Autowired
	private ConsultaEstadoCrudRepository consultaEstadoCrudRepository;

	public ConsultaEstado getConsultaEstadoById(String id) throws ResourceNotFoundException {
		return consultaEstadoCrudRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No existe el número ticket"));
	}
	public ConsultaEstado getConsultaEstadoById(String id, String nit) throws ResourceNotFoundException {
		
		ConsultaEstado resultado= consultaEstadoCrudRepository.findById(id)
		 				.orElseThrow(() -> new ResourceNotFoundException("No existe el número ticket"));
		if (nit.equals(resultado.getNit())){
			return resultado;
		}
		throw new ResourceNotFoundException("El Ticket no pertenece a la entidad");
	}

}
