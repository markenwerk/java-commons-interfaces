/*
 * Copyright (c) 2015 Torsten Krause, Markenwerk GmbH
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package net.markenwerk.commons.interfaces;

import net.markenwerk.commons.exceptions.ConversionException;

/**
 * A {@link Converter} is used to convert (transform, translate, project,
 * evaluate, ...) values from one form into another.
 * 
 * <p>
 * Common use cases of a {@link Converter} include:
 * 
 * <ul>
 * <li>Conversion from a simple type into a more complex type.<br>
 * 
 * <pre>
 *  Converter&lt;String, UUID&gt; uuidConverter = new Converter&lt;String, UUID&gt; () {
 *    {@literal @}Override
 *    public UUID convert(String uuidString) throws ConverterException {
 *      try{
 *        return UUID.fromString(uuidString);
 *      } catch (IllegalArgumentException e) {
 *        throw new ConverterException(e);
 *      }
 *    }
 *  };
 * </pre>
 * 
 * </li>
 * <li>Projection of a complex type to one of it's components.<br>
 * 
 * <pre>
 * Converter&lt;Entity, Integer&gt; idConverter = new Converter&lt;Entity, Integer&gt; () {
 *   {@literal @}Override
 *   public Integer convert(Entity entity) throws ConverterException {
 *     return entity.getId();
 *   }
 * };
 * </pre>
 * 
 * </li>
 * </ul>
 * 
 * @param <From>
 *            The type to convert values from.
 * @param <To>
 *            The type to convert values to.
 * @author Torsten Krause (tk at markenwerk dot net)
 * @since 1.0.0
 */
public interface Converter<From, To> {

	/**
	 * Called to convert a given value.
	 * 
	 * <p>
	 * Implementers should catch any exception and wrap them in a
	 * {@link ConversionException}.
	 * 
	 * <p>
	 * Depending on the use case, if the given value {@literal null}, the
	 * {@link Converter} should return {@literal null}.
	 * 
	 * <p>
	 * It lies in the responsibility of the caller, to handle unwanted
	 * {@literal null}-values by replacing them with a sensible default value or
	 * throwing an appropriate {@link ConversionException}.
	 * 
	 * @param from
	 *            The value to be converted.
	 * @return The converted value.
	 * @throws ConversionException
	 *             If the conversion failed.
	 */
	public To convert(From from) throws ConversionException;

}