package com.videoclub.videoclubNestor.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;


@Entity
@Table(name="alquileres")
public class Alquiler implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	@Column(name="importe_alquiler")
	private Double importeAlquiler;
	@Column(name="fecha_alquiler")
	private Date fechaAlquiler;
	
	@OneToMany(mappedBy="alquiler",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.LAZY)
	private List<LineaAlquiler> lineas;
	
	public Double getImporteAlquiler() {
		return importeAlquiler;
	}

	public void setImporteAlquiler(Double importeAlquiler) {
		this.importeAlquiler = importeAlquiler;
	}

	public List<LineaAlquiler> getLineas() {
		return lineas;
	}

	public void setLineas(List<LineaAlquiler> lineas) {
		this.lineas = lineas;
	}

	public Alquiler() {
		
		this.lineas = new ArrayList<LineaAlquiler>();
	}
	
	@PrePersist
	public void prePersist() {
		this.fechaAlquiler = new Date();
	}
	
	public Double getImporte() {
		return importeAlquiler;
	}

	public void setImporte(Double importeAlquiler) {
		this.importeAlquiler = importeAlquiler;
	}

	public Date getFechaAlquiler() {
		return fechaAlquiler;
	}

	public void setFechaAlquiler(Date fechaAlquiler) {
		this.fechaAlquiler = fechaAlquiler;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	
}
