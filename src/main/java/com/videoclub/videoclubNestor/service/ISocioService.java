package com.videoclub.videoclubNestor.service;

import java.util.List;

import com.videoclub.videoclubNestor.entity.Socio;

public interface ISocioService {

	public Socio getSocioById(Long id);
	public List<Socio> getAllSocio();
}
