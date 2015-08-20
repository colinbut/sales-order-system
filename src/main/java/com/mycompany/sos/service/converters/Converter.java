/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.service.converters;

/**
 * {@link Converter} interface
 * 
 * @author colin
 *
 */
@FunctionalInterface
public interface Converter<T, F> {

	/**
	 * Convert from type F to type T
	 * 
	 * @param from the type to convert from
	 * @return the type T converted to
	 */
	T convert(F from);
}
