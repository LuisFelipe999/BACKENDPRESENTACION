package com.example.demo.repositorios;



import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Producto;


@Repository
public interface ProductoRepositorio extends CrudRepository<Producto,Long> {

	
     List<Producto> findAll();
	
	
}