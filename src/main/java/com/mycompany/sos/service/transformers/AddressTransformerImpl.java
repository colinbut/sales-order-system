/**
 * 
 */
package com.mycompany.sos.service.transformers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.sos.dao.entities.AddressEntity;
import com.mycompany.sos.model.Address;

/**
 * @author colin
 *
 */
@Component
public class AddressTransformerImpl implements AddressTransformer {

	@Autowired
	private CustomerTransformer customerTransformer; 
	
	@Override
	public Address getDtoFromEntity(AddressEntity addressEntity) {
		
		Address address = new Address();
		address.setHouseFlatNo(addressEntity.getHouseFlatNo());
		address.setStreet(addressEntity.getStreet());
		address.setPostCode(addressEntity.getPostCode());
		address.setCity(addressEntity.getCity());
		address.setCountry(addressEntity.getCountry());
		address.setCustomers(customerTransformer.getDtoListFromEntityList(addressEntity.getCustomers()));
		return address;
	}

	@Override
	public AddressEntity getEntityFromDto(Address address) {
		AddressEntity addressEntity = new AddressEntity();
		addressEntity.setHouseFlatNo(address.getHouseFlatNo());
		addressEntity.setStreet(address.getStreet());
		addressEntity.setPostCode(address.getPostCode());
		addressEntity.setCity(address.getCity());
		addressEntity.setCountry(address.getCountry());
		addressEntity.setCustomers(customerTransformer.getEntityListFromDtoList(address.getCustomers()));
		return addressEntity;
	}

}
