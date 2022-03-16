package com.ejemplo.springboot.di.app.models.domain;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
// se crea en cada peticion http
@RequestScope
// persistencia en la sesion
//@SessionScope
// se guarda en el contexto servlet
//@ApplicationScope
public class Factura implements Serializable{

	private static final long serialVersionUID = 7837364651824947173L;
	
	@Value("${factura.descripcion}")

	private String descripcion;
	@Autowired
	private Cliente cliente;

	@Autowired
	@Qualifier("itemsFacturaOficina")
	private List<ItemFactura> items;
	
	// se ejecuta despues de crear el objeto e inyectado dependencias
	@PostConstruct
	public void inicializar() {
		cliente.setNombre(cliente.getNombre().concat(" ").concat(" nombre 2"));
		descripcion = descripcion.concat(" del cliente ").concat(cliente.getNombre());
	}
	
	// se ejecuta cuando el objeto es destruido, se puede usar para cerrar conexiones
	@PreDestroy
	public void destruir() {
		System.out.println("Factura destruida".concat(descripcion));
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemFactura> getItems() {
		return items;
	}

	public void setItems(List<ItemFactura> items) {
		this.items = items;
	}

}
