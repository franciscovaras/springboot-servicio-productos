package com.fvarasg.inicio.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fvarasg.inicio.models.entity.Producto;

public interface ProductoDao extends JpaRepository<Producto, Long> {

}
