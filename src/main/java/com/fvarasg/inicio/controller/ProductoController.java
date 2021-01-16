package com.fvarasg.inicio.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fvarasg.inicio.models.entity.Producto;
import com.fvarasg.inicio.models.service.ProductoService;

@RestController
public class ProductoController {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private ProductoService productoService;
	
	@GetMapping("/listar")
	public List<Producto> buscarTodosLosProductos(){
		return productoService.findAll().stream().map(producto -> {
			producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			return producto;
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/ver/{id}")
	public Producto buscarProducto(@PathVariable Long id) {
		Producto producto = productoService.findById(id);
		producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		return producto;
	}
	
	@PostMapping("/productos")
	public void crearContactos(@RequestBody Producto producto) throws Exception {
		productoService.createProducto(producto);
	}
	
}
