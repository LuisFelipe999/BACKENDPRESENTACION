package com.example.demo.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity // representacion de entidad modelo
@Table(name = "ventas")
public class Venta {

//id
	@Id // clave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto incrementar
	private Long id;
	private String productoenCarro;
	private int precioProductoenCarro;
    //private String rutComprador;
	private int cantidad;

	@javax.persistence.ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "producto_id")
	private Producto producto;

	@javax.persistence.ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

	public Venta() {
		super();
	}

	public Venta(String productoenCarro, int precioProductoenCarro, int cantidad) {
		super();
		this.productoenCarro = productoenCarro;
		this.precioProductoenCarro = precioProductoenCarro;
		this.cantidad = cantidad;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getproductoenCarro() {
		return productoenCarro;
	}

	public int getCantidad() {
		return cantidad;
	}

	public int getprecioProductoenCarro() {
		return precioProductoenCarro;
	}

	public void setProductoenCarro(String productoenCarro) {
		this.productoenCarro = productoenCarro;
	}

	public void setPrecioProductoenCarro(int precioProductoenCarro) {
		this.precioProductoenCarro = precioProductoenCarro;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	

	@PrePersist // se ejecuta antes de que sea insertado
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate // se ejecuta antes de que sea actualizado
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
}
