package com.videoclub.videoclubNestor.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Lineas_alquiler")
public class LineaAlquiler implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private Date fechaDevolucion;
	private Integer diasAlquiler;
	@Column(name="importe_linea_alquiler")
	private Double importeLineaAlquiler;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Alquiler alquiler;
	
	public Alquiler getAlquiler() {
		return alquiler;
	}

	public void setAlquiler(Alquiler alquiler) {
		this.alquiler = alquiler;
	}

	public LineaAlquiler() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getFechaDevolucion() {
		return fechaDevolucion;
	}
	public void setFechaDevolucion(Date fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}
	public Integer getDiasAlquiler() {
		return diasAlquiler;
	}
	public void setDiasAlquiler(Integer diasAlquiler) {
		this.diasAlquiler = diasAlquiler;
	}
	public Double getImporteLineaAlquiler() {
		return importeLineaAlquiler;
	}
	public void setImporteLineaAlquiler(Double importeLineaAlquiler) {
		this.importeLineaAlquiler = importeLineaAlquiler;
	}
	
	
}
