package com.fvarasg.inicio.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fvarasg.inicio.models.dao.ProductoDao;
import com.fvarasg.inicio.models.entity.Producto;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	ProductoDao productoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		return productoDao.findAll();
	}

	@Override
	public void createProducto(Producto producto) throws Exception {
		
		if(producto.getId() == null) {
			productoDao.save(producto);
			return;
		}
		throw new Exception("Contacto repetido");
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findById(Long id) {
		return productoDao.findById(id).orElse(null);
	}

}
