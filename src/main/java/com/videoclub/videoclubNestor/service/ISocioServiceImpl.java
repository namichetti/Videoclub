package com.videoclub.videoclubNestor.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.videoclub.videoclubNestor.dao.SocioDao;
import com.videoclub.videoclubNestor.entity.Socio;

@Service
public class ISocioServiceImpl implements ISocioService {
	
	@Autowired
	private SocioDao socioDao;

	@Override
	@Transactional
	public Socio getSocioById(Long id) {
		return this.socioDao.findById(id).orElseGet(null);
	}

	@Override
	@Transactional
	public List<Socio> getAllSocio() {
		return (List<Socio>) this.socioDao.findAll();
	}

}
