package com.example.demo.repositorios;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.example.demo.models.Venta;


@Repository
public interface VentaRepositorio extends CrudRepository<Venta,Long> {

	
     List<Venta> findAll();
   //  @Query("SELECT u FROM User u WHERE u.status = ?1")
    // Venta findVentaByStatus(Integer status);
     // List<Venta> findVemtaByUsuario(Set<String> usuario ); 
      // @Query(value ="SELECT u FROM Venta u WHERE u.rutComprador = ?1")  
       //List<Venta>listarVenta(String rutComprador) ;

	
}
