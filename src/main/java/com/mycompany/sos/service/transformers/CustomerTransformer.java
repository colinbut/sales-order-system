/**
 * 
 */
package com.mycompany.sos.service.transformers;

import com.mycompany.sos.dao.entities.CustomerEntity;
import com.mycompany.sos.model.dto.Customer;

/**
 * CustomerTransformer interface
 * 
 * @author colin
 *
 */
public interface CustomerTransformer {

	Customer getDtoFromEntity(CustomerEntity customerEntity);
	
	CustomerEntity getEntityFromDto(Customer customer);
}
