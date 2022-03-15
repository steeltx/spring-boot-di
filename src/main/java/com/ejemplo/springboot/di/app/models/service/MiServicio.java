package com.ejemplo.springboot.di.app.models.service;

import org.springframework.stereotype.Component;

@Component
public class MiServicio {
	
	public String operacion() {
		return "ejecutando un proceso";
	}
}
