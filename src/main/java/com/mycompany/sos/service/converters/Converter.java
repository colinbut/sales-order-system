/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.sos.service.converters;

/**
 * @author colin
 *
 */
@FunctionalInterface
public interface Converter<T, F> {

	/**
	 * Convert from type F to type T
	 * 
	 * @param from
	 * @return
	 */
	T convert(F from);
}
