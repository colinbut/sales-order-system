/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.service.transformers;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.mycompany.sos.model.CustomerPaymentDetails;
import com.mycompany.sos.repository.entities.CustomerPaymentDetailEntity;

/**
 * {@link CustomerPaymentDetailTransformerImpl} class
 * 
 * @author colin
 *
 */
@Component
public class CustomerPaymentDetailTransformerImpl implements DomainEntityTransformer<CustomerPaymentDetails, CustomerPaymentDetailEntity>{
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public CustomerPaymentDetails getDtoFromEntity(CustomerPaymentDetailEntity customerPaymentDetailEntity) {
		
		CustomerPaymentDetails customerPaymentDetails = new CustomerPaymentDetails();
		customerPaymentDetails.setCustomerReference(customerPaymentDetailEntity.getCustomerReference() == null ?"" : "");
		customerPaymentDetails.setCardExpiryDate(customerPaymentDetailEntity.getCardExpiryDate() == null ? new Date() 
				: customerPaymentDetailEntity.getCardExpiryDate());
		customerPaymentDetails.setCardNo(customerPaymentDetailEntity.getCardNo() == null ?"" : "");
		
		return customerPaymentDetails;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public CustomerPaymentDetailEntity getEntityFromDto(
			CustomerPaymentDetails customerPaymentDetails) {
		
		CustomerPaymentDetailEntity customerPaymentDetailEntity = new CustomerPaymentDetailEntity();
		
		customerPaymentDetailEntity.setCustomerReference(customerPaymentDetails.getCustomerReference());
		customerPaymentDetailEntity.setCardExpiryDate(customerPaymentDetails.getCardExpiryDate());
		customerPaymentDetailEntity.setCardNo(customerPaymentDetails.getCardNo());
		
		return customerPaymentDetailEntity;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<CustomerPaymentDetails> getDtoListFromEntityList(Set<CustomerPaymentDetailEntity> entityList) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<CustomerPaymentDetailEntity> getEntityListFromDtoList(List<CustomerPaymentDetails> dtoList) {
		// TODO Auto-generated method stub
		return null;
	}

}
