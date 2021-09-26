package com.example.demo.servicio;

import javax.validation.Valid;
import java.util.Optional;

import org.springframework.stereotype.Service;
import java.util.List;

import com.example.demo.models.Producto;
import com.example.demo.repositorios.ProductoRepositorio;

@Service
public class ProductoServicio {
	// logica de negocio o empresarial
	// dependencia repository
	private final ProductoRepositorio pr;

	public ProductoServicio(ProductoRepositorio productoRepositorio) {
		this.pr = productoRepositorio;
	}

	public Producto insertarProducto(@Valid Producto producto) {
		// TODO Auto-generated method stub
		return pr.save(producto);
	}

	public List<Producto> findAll() {
		// retorna una lista de empleados
		return pr.findAll();
	}

	public void eliminarProducto(Long id) {
		// TODO Auto-generated method stub
		pr.deleteById(id);
	}

	public void modificarProducto(@Valid Producto producto) {
		// TODO Auto-generated method stub
		pr.save(producto);

	}

	public Producto buscarProducto(Long id) {
		// TODO Auto-generated method stub

		Optional<Producto> oProducto = pr.findById(id);

		if (oProducto.isPresent()) {
			return oProducto.get();
		}
		return null;
	}
}
