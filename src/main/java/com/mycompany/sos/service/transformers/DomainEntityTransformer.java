/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.service.transformers;

import java.util.List;
import java.util.Set;

/**
 * {@link DomainEntityTransformer} interface
 * 
 * @author colin
 *
 */
public interface DomainEntityTransformer<D, E> {

	/**
	 * Maps an entity to a dto
	 * 
	 * @param entity the entity of type E
	 * @return the dto of type D
	 */
	D getDtoFromEntity(E entity);
		
	/**
	 * Maps a dto to an entity
	 * 
	 * @param dto the dto of type D
	 * @return the entity of type E
	 */
	E getEntityFromDto(D dto);
	
	/**
	 * Maps list of entities to list of dtos
	 * 
	 * @param entityList list of entities of type <E>
	 * @return list of dtos of type <D>
	 */
	List<D> getDtoListFromEntityList(Set<E> entityList);
	
	/**
	 * maps list of dtos to entities
	 * 
	 * @param dtoList list of dtos of type <D>
	 * @return list of entities of type <E>
	 */
	Set<E> getEntityListFromDtoList(List<D> dtoList);
}
