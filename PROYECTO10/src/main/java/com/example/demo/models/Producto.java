package com.example.demo.models;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;




@Entity //representacion de entidad modelo
@Table(name="productos")
public class Producto {


//id
	@Id //clave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY)//auto incrementar
	private Long id;
	private String tipo;
	private String nombreProducto;
	private String descripcion;
	private String codigo;
	private int inventario;
	private int precio; 
	
	
  @Column(updatable=false)
  @DateTimeFormat(pattern="yyyy-MM-dd")
  private Date createdAt;
  @DateTimeFormat(pattern="yyyy-MM-dd")
  private Date updatedAt;
	
	public Producto() {
		super();
	}

	public Producto(String tipo, String nombreProducto, String descripcion, String codigo, int inventario, int precio ) {
		super();
		this.tipo = tipo;
		this.nombreProducto = nombreProducto;
		this.descripcion = descripcion;
		this.codigo = codigo;
		this.inventario = inventario;
		this.precio = precio;
		//this.usuarios=usuarios; 
	}

	@OneToMany(mappedBy = "producto",fetch = FetchType.LAZY)
	private List<Venta> ventas;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getCodigo() {
		return codigo;
	}

	public int getInventario() {
		return inventario;
	}

	public int getPrecio() {
		return precio;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setCodigo(String codigo) {
		this.codigo =codigo ;
	}

	public void setInventario(int inventario) {
		this.inventario = inventario;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
  @PrePersist//se ejecuta antes de que sea insertado
  protected void onCreate(){
      this.createdAt = new Date();
  }
  @PreUpdate // se ejecuta antes de que sea actualizado
  protected void onUpdate(){
      this.updatedAt = new Date();
  }

public Object findAll() {
	// TODO Auto-generated method stub
	return null;
}
}
