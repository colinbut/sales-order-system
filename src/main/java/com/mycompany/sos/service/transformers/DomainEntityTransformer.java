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

	D getDtoFromEntity(E entity);
	
	E getEntityFromDto(D dto);
	
	List<D> getDtoListFromEntityList(Set<E> entityList);
	
	Set<E> getEntityListFromDtoList(List<D> dtoList);
}
