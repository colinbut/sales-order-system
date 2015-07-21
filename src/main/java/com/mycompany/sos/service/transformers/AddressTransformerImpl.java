/**
 * 
 */
package com.mycompany.sos.service.transformers;

import org.springframework.stereotype.Component;

import com.mycompany.sos.dao.entities.AddressEntity;
import com.mycompany.sos.model.Address;

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
		address.setCustomers(addressEntity.getCustomers());
		return address;
	}

	@Override
	public AddressEntity getEntityFromDto(Address address) {
		// TODO Auto-generated method stub
		return null;
	}

}
