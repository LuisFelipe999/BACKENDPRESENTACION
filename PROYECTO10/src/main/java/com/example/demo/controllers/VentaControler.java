package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Producto;

import com.example.demo.models.Venta;
import com.example.demo.servicio.ProductoServicio;
import com.example.demo.servicio.UserService;


import com.example.demo.servicio.VentaServicio;

@Controller
@RequestMapping("/venta")
public class VentaControler {

	
	@Autowired
	private UserService us;

	@Autowired
	private ProductoServicio ps;

	@Autowired
	// dependencia servicio
	private final VentaServicio vs;

	public VentaControler(VentaServicio ventaServicio) {
		this.vs = ventaServicio;
	}

	// @ModelAttribute("empleado") Empleado empleado, ejemplo pasar entidad a un jsp
	@RequestMapping("")
	public String index(@ModelAttribute("venta") Venta venta, Model model) {
		// System.out.println("index");

		List<Venta> lista_ventas = vs.findAll(); 
		model.addAttribute("lista_ventas", lista_ventas);
		
		model.addAttribute("lista_productos", ps.findAll()); 
		
		int total = 0;
		for (Venta fila : lista_ventas) {
			total = total + fila.getprecioProductoenCarro()*fila.getCantidad(); 
		}  
		


		
		
		model.addAttribute("tot",total);
		return "venta.jsp";
	}

	@RequestMapping(value = "/crear", method = RequestMethod.POST)
	public String crear(@Valid @ModelAttribute("venta") Venta venta) {
		System.out.println("crear " + venta);
		Venta vent = vs.insertarVenta(venta);
		return "venta.jsp";
	}

	@RequestMapping(value = "/actualizar/{id}", method = RequestMethod.GET)
	public String actualizar(@PathVariable("id") Long id, Model model) {
		System.out.println("actualizar id: " + id);

		Venta venta = vs.buscarVenta(id);
		model.addAttribute("venta", venta);
		// model.addAttribute("lista_usuarios",usuarioServicio.findAll())

		return "modificarventa.jsp";
	}

	@RequestMapping(value = "/modificar", method = RequestMethod.PUT)
	public String modificar(@Valid @ModelAttribute("venta") Venta venta) {
		System.out.println("modificar");
		vs.modificarVenta(venta);

		
		return "redirect:/venta";
	}

	@RequestMapping(value = "/eliminar", method = RequestMethod.POST)
	public String eliminar(@RequestParam("id") Long id) {
		System.out.println("Eliminar id: " + id);
		vs.eliminarVenta(id);
		return "redirect:/venta";
	}

	@RequestMapping(value = "/eliminar2/{id}", method = RequestMethod.DELETE)
	public String eliminar2(@PathVariable("id") Long id) {
		System.out.println("Eliminar2 id: " + id);
		vs.eliminarVenta(id);
		return "redirect:/venta";
	}

	@RequestMapping("/buscar")
	public String buxcar() {
		return "redirect:/venta";
	}

	// @RequestMapping(value="/totalizar", method = RequestMethod.PUT)
	// public String totalizar(@Valid @ModelAttribute("venta") Venta venta) {

	// }

}
