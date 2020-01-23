package com.example.democrud.service.iml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.democrud.commons.GenericServiceImpl;
import com.example.democrud.dao.api.TareaDaoAPI;
import com.example.democrud.model.Tarea;
import com.example.democrud.service.api.TareaServiceApi;

import demo.example.democrud.dto.TareaDto;

@Service
public class TareaServiceImp extends GenericServiceImpl<Tarea, Long> implements TareaServiceApi{

    @Autowired
	private TareaDaoAPI tareaDaoAPI;
	
	@Override
	public CrudRepository<Tarea, Long> getDao() {
		
		return tareaDaoAPI;
	}


	
	
}
