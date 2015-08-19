/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.service.transformers;

import com.mycompany.sos.model.CustomerPaymentDetails;
import com.mycompany.sos.repository.entities.CustomerPaymentDetailEntity;

/**
 * CustomerPaymentDetailTransformer interface
 * 
 * @author colin
 *
 */
public interface CustomerPaymentDetailTransformer {

	CustomerPaymentDetails getDtoFromEntity(CustomerPaymentDetailEntity customerPaymentDetailEntity);
	
	CustomerPaymentDetailEntity getEntityFromDto(CustomerPaymentDetails customerPaymentDetails);
	
}
