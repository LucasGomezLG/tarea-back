package com.example.democrud.commons;

import com.example.democrud.model.Tarea;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface GenericServiceAPI<T, ID extends Serializable> {

	T save(T entity);
	
	void delete(ID id);
	
	T get(ID id);
	
	List<T> getAll();

    Optional<T> findById(ID id);

	Iterable<T> saveAll(Iterable<T> entities);

	void deleteAll();
}
