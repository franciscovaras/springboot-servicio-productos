package com.fvarasg.inicio.models.service;

import java.util.List;

import com.fvarasg.inicio.models.entity.Producto;

public interface ProductoService {
	
	public List<Producto>findAll();
	public void createProducto(Producto producto) throws Exception;
	public Producto findById(Long id);
}
