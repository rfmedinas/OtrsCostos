package org.otrs.costos;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CostosApplication {
	// Manejo de errores
	static Log LOGGER = LogFactory.getLog(CostosApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CostosApplication.class, args);

	}

}
