package org.otrs.costos.service;

import java.util.Optional;

import org.otrs.costos.exception.ResourceNotFoundException;
import org.otrs.costos.model.ConsultaEstado;
import org.otrs.costos.repository.ConsultaEstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultaEstadoService {
	@Autowired
	ConsultaEstadoRepository consultaEstadoRepository;

	public  ConsultaEstado getConsultaEstadoService(String id) throws ResourceNotFoundException{
		return 	consultaEstadoRepository.getConsultaEstadoById(id);
	}
	public  ConsultaEstado getConsultaEstadoService(String id, String nit) throws ResourceNotFoundException{
		return 	consultaEstadoRepository.getConsultaEstadoById(id,nit);
	}
}
