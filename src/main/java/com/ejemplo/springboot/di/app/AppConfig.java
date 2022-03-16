package com.ejemplo.springboot.di.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.ejemplo.springboot.di.app.models.domain.ItemFactura;
import com.ejemplo.springboot.di.app.models.domain.Producto;
import com.ejemplo.springboot.di.app.models.service.IServicio;
import com.ejemplo.springboot.di.app.models.service.MiServicio;
import com.ejemplo.springboot.di.app.models.service.MiServicioComplejo;

@Configuration
public class AppConfig {

	@Bean("miServicioSimple")
	@Primary
	public IServicio registrarMiServicio() {
		return new MiServicio();
	}

	@Bean("miServicioComplejo")
	public IServicio registrarMiServicioComplejo() {
		return new MiServicioComplejo();
	}

	@Bean("itemsFactura")
	public List<ItemFactura> registrarItems() {
		Producto producto1 = new Producto("Laptop", 100);
		Producto producto2 = new Producto("PC", 200);

		ItemFactura linea1 = new ItemFactura(producto1, 2);
		ItemFactura linea2 = new ItemFactura(producto2, 4);

		return Arrays.asList(linea1, linea2);
	}
	
	@Bean("itemsFacturaOficina")
	public List<ItemFactura> registrarItemsOficina() {
		Producto producto1 = new Producto("Monitor", 70);
		Producto producto2 = new Producto("TV", 95);
		Producto producto3 = new Producto("Impresora", 55);
		Producto producto4 = new Producto("Escritorio", 80);

		ItemFactura linea1 = new ItemFactura(producto1, 2);
		ItemFactura linea2 = new ItemFactura(producto2, 4);
		ItemFactura linea3 = new ItemFactura(producto3, 1 );
		ItemFactura linea4 = new ItemFactura(producto4, 1);

		return Arrays.asList(linea1, linea2, linea3, linea4);
	}

}
