package com.example.demo.servicio;

import javax.validation.Valid;
import java.util.Optional;

import org.springframework.stereotype.Service;
import java.util.List;


import com.example.demo.models.Venta;

import com.example.demo.repositorios.VentaRepositorio;



@Service
public class VentaServicio {
	//logica de negocio o empresarial
		//dependencia repository
		private final VentaRepositorio vr;
		
		public VentaServicio(VentaRepositorio ventaRepositorio) {
			this.vr = ventaRepositorio;
		}

		public Venta insertarVenta(@Valid Venta venta) {
			// TODO Auto-generated method stub
			return vr.save(venta);
		}

		public List<Venta> findAll() {
			// retorna una lista de empleados
			return vr.findAll();
		}

		//public List<Venta> listarVenta(String rutComprador) {
			// retorna una lista de empleados
		//	return ep.listarVenta(rutComprador);
		//}


		public void eliminarVenta(Long id) {
			// TODO Auto-generated method stub
			vr.deleteById(id);
		}

		
		public void modificarVenta(@Valid Venta venta) {
			// TODO Auto-generated method stub
			vr.save(venta);
		
		

		
} 
		//public void totalizarVenta(@Valid Venta venta) {
			
			
	//	}

		public Venta buscarVenta(Long id) {
			// TODO Auto-generated method stub
			
			Optional<Venta> oVenta= vr.findById(id);
			
			if(oVenta.isPresent()) {
				return oVenta.get();
			}
			return null; 
		} 
}
