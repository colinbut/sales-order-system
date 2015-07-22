/**
 * 
 */
package com.mycompany.sos.service.transformers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.sos.dao.entities.CustomerPaymentDetailEntity;
import com.mycompany.sos.model.CustomerPaymentDetails;

/**
 * CustomerPaymentDetailTransformerImpl class implementation of CustomerPaymentDetailTransformer interface
 * 
 * @author colin
 *
 */
@Component
public class CustomerPaymentDetailTransformerImpl implements CustomerPaymentDetailTransformer{

	@Autowired
	private CustomerTransformer customerTransformer;
	
	@Override
	public CustomerPaymentDetails getDtoFromEntity(
			CustomerPaymentDetailEntity customerPaymentDetailEntity) {
		
		CustomerPaymentDetails customerPaymentDetails = new CustomerPaymentDetails();
		customerPaymentDetails.setCustomerReference(customerPaymentDetailEntity.getCustomerReference() == null ?"" : "");
		customerPaymentDetails.setCardExpiryDate(customerPaymentDetailEntity.getCardExpiryDate()== null ?"" : "");
		customerPaymentDetails.setCardNo(customerPaymentDetailEntity.getCardNo() == null ?"" : "");
		//customerPaymentDetails.setCustomer(customerTransformer.getDtoFromEntity(customerPaymentDetailEntity.getCustomer()));
		
		
		return customerPaymentDetails;
	}

	@Override
	public CustomerPaymentDetailEntity getEntityFromDto(
			CustomerPaymentDetails customerPaymentDetails) {
		
		CustomerPaymentDetailEntity customerPaymentDetailEntity = new CustomerPaymentDetailEntity();
		
		customerPaymentDetailEntity.setCustomerReference(customerPaymentDetails.getCustomerReference());
		customerPaymentDetailEntity.setCardExpiryDate(customerPaymentDetails.getCardExpiryDate());
		customerPaymentDetailEntity.setCardNo(customerPaymentDetails.getCardNo());
		customerPaymentDetailEntity.setCustomer(customerTransformer.getEntityFromDto(customerPaymentDetails.getCustomer()));
		
		return customerPaymentDetailEntity;
	}

}
