/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.service.transformers;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.mycompany.sos.model.Address;
import com.mycompany.sos.repository.entities.AddressEntity;

/**
 * {@link AddressTransformer} class
 * 
 * @author colin
 *
 */
@Component
public class AddressTransformer implements DomainEntityTransformer<Address, AddressEntity> {
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Address getDtoFromEntity(AddressEntity addressEntity) {
		Address address = new Address();
		address.setHouseFlatNo(addressEntity.getHouseFlatNo());
		address.setStreet(addressEntity.getStreet());
		address.setPostCode(addressEntity.getPostCode());
		address.setCity(addressEntity.getCity());
		address.setCountry(addressEntity.getCountry());
		return address;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AddressEntity getEntityFromDto(Address address) {
		AddressEntity addressEntity = new AddressEntity();
		addressEntity.setHouseFlatNo(address.getHouseFlatNo());
		addressEntity.setStreet(address.getStreet());
		addressEntity.setPostCode(address.getPostCode());
		addressEntity.setCity(address.getCity());
		addressEntity.setCountry(address.getCountry());
		return addressEntity;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Address> getDtoListFromEntityList(Set<AddressEntity> entityList) {
		// TODO
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<AddressEntity> getEntityListFromDtoList(List<Address> dtoList) {
		// TODO Auto-generated method stub
		return null;
	}

}
