package com.example.democrud.service.iml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.democrud.commons.GenericServiceImpl;
import com.example.democrud.dao.api.ActividadDaoApi;
import com.example.democrud.model.Actividad;
import com.example.democrud.service.api.ActividadServiceApi;

@Service
public class ActividadServiceImp extends GenericServiceImpl<Actividad, Long> implements ActividadServiceApi {

	@Autowired
	private ActividadDaoApi actividadDaoApi;
	
	@Override
	public CrudRepository<Actividad, Long> getDao() {
		
		return actividadDaoApi;
	}
}
