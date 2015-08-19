/**
 * 
 */
package com.mycompany.sos.service.transformers;

import org.springframework.stereotype.Component;

import com.mycompany.sos.model.Address;
import com.mycompany.sos.repository.entities.AddressEntity;

/**
 * @author colin
 *
 */
@Component
public class AddressTransformerImpl implements AddressTransformer {
	
	@Override
	public Address getDtoFromEntity(AddressEntity addressEntity) {
		
		Address address = new Address();
		address.setHouseFlatNo(addressEntity.getHouseFlatNo());
		address.setStreet(addressEntity.getStreet());
		address.setPostCode(addressEntity.getPostCode());
		address.setCity(addressEntity.getCity());
		address.setCountry(addressEntity.getCountry());
		//address.setCustomers(customerTransformer.getDtoListFromEntityList(addressEntity.getCustomers()));
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
		//addressEntity.setCustomers(customerTransformer.getEntityListFromDtoList(address.getCustomers()));
		return addressEntity;
	}

}
