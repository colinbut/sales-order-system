/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.service.transformers;

import com.mycompany.sos.model.Address;
import com.mycompany.sos.repository.entities.AddressEntity;

/**
 * AddressTransformer interface
 * 
 * @author colin
 *
 */
public interface AddressTransformer {

	Address getDtoFromEntity(AddressEntity addressEntity);
	
	AddressEntity getEntityFromDto(Address address);
}
