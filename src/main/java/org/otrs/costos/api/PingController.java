package org.otrs.costos.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/ping")
@CrossOrigin(origins = "*", methods ={RequestMethod.GET})
public class PingController {
	@GetMapping()
	public String ping () {
		return "ok";
	}
}
