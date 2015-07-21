/**
 * 
 */
package com.mycompany.sos.service.transformers;

import com.mycompany.sos.dao.entities.CustomerPaymentDetailEntity;
import com.mycompany.sos.model.CustomerPaymentDetails;

/**
 * CustomerPaymentDetailTransformer interface
 * 
 * @author colin
 *
 */
public interface CustomerPaymentDetailTransformer {

	CustomerPaymentDetails getDtoFromEntity(CustomerPaymentDetailEntity customerPaymentDetailEntity);
	
	
}
