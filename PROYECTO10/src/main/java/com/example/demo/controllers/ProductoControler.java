package com.example.demo.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Producto;

import com.example.demo.servicio.ProductoServicio;

@Controller
@RequestMapping("/producto")
public class ProductoControler {

			
			//dependencia servicio
			private final ProductoServicio ps;
			
			public ProductoControler(ProductoServicio productoServicio) {
				this.ps = productoServicio;
			}
			
		//@ModelAttribute("empleado") Empleado empleado, ejemplo pasar entidad a un jsp
			@RequestMapping("")
			public String index(@ModelAttribute("producto") Producto producto,Model model ) {
				//System.out.println("index");
				
				List<Producto> lista_productos = ps.findAll();
				model.addAttribute("lista_productos", lista_productos);
				
				return "producto.jsp";
			}
			
			@RequestMapping(value="/crear", method = RequestMethod.POST)
			public String crear(@Valid @ModelAttribute("producto") Producto producto) {
				System.out.println("crear "+ producto);
				//llamado a guardar la entidad
			
				Producto product =  ps.insertarProducto(producto);
				
					return "redirect:/producto";
				 } 
				  
				
			
			
			@RequestMapping(value="/actualizar/{id}", method = RequestMethod.GET)
			public String actualizar(@PathVariable("id") Long id, Model model) {
				System.out.println("actualizar id: "+ id); 
				
				Producto producto=ps.buscarProducto(id); 
				model.addAttribute("producto", producto);
				//model.addAttribute("lista_usuarios",usuarioServicio.findAll())
				
				return "modificarProducto.jsp";
			} 
			
			
			@RequestMapping(value="/modificar", method = RequestMethod.PUT)
			public String modificar(@Valid @ModelAttribute("producto") Producto producto) {
				System.out.println("modificar");
				ps.modificarProducto(producto);
				
				
			
				return "redirect:/producto";
			}
			
			
			
			@RequestMapping(value="/eliminar", method = RequestMethod.POST)
			public String eliminar(@RequestParam("id") Long id) {
			System.out.println("Eliminar id: "+ id);
				ps.eliminarProducto(id);
				return "redirect:/producto";
		}
			
			
			@RequestMapping(value="/eliminar2/{id}", method = RequestMethod.DELETE)
			public String eliminar2(@PathVariable("id") Long id) {
				System.out.println("Eliminar2 id: "+ id);
				ps.eliminarProducto(id);
				return "redirect:/producto";
		}
			
			
			@RequestMapping("/buscar")
			public String buxcar() {
				return "redirect:/producto";
			}
		

	}

