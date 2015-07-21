/**
 * 
 */
package com.mycompany.sos.service.transformers;

import com.mycompany.sos.dao.entities.AddressEntity;
import com.mycompany.sos.model.Address;

/**
 * @author colin
 *
 */
public interface AddressTransformer {

	Address getDtoFromEntity(AddressEntity addressEntity);
	
	AddressEntity getEntityFromDto(Address address);
}
