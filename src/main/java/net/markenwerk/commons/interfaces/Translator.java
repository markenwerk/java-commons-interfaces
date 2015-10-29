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

import net.markenwerk.commons.interfaces.exceptions.ConverterException;

/**
 * A {@link Translator} is used to convert (transform, translate, project,
 * evaluate, ...) values from one form into another and back. As such, a
 * {@link Translator} is little more than an arbitrary function and its reveres
 * function.It is usually used in a scenario where some sort of data provider
 * wants to offer the possibility to convert values into the desired type before
 * delivery or during the data processing.
 * 
 * <p>
 * Common use cases of a {@link Converter} include:
 * 
 * <ul>
 * <li>Translation from a simple type into a more complex type and back.<br>
 * 
 * <pre>
 * Converter&lt;String, UUID&gt; uuidTranslator = new Translator&lt;String, UUID&gt; () {
 *   {@literal@}Override
 *   public UUID convert(String uuidString) throws ConverterException {
 *     try{
 *       return UUID.fromString(uuidString);
 *     } catch (IllegalArgumentException e) {
 *       throw new ConverterException(e);
 *     }
 *   }
 *    
 *   {@literal@}Override
 *   public String revert(UUID uuid) {
 *     return uuid.toString();
 *   }
 * };
 * </pre>
 * 
 * </li>
 * <li>Projection of a complex type to one of it's key components and back.<br>
 * 
 * <pre>
 * Converter&lt;Entity, Integer&gt; idConverter = new Converter&lt;Entity, Integer&gt; () {
 *   {@literal@}Override
 *   public Integer convert(Entity entity) throws ConverterException {
 *     return entity.getId();
 *   }
 *   
 *   {@literal@}Override
 *   public Entity revert(Integer id) {
 *     try{
 *       return EntityDao.getById(id);
 *     } catch (EntityDaoException e) {
 *       throw new ConverterException(e);
 *     }
 *   }
 * };
 * </pre>
 * 
 * </li>
 * </ul>
 * 
 * @param <From>
 *            The type to translate values from and to.
 * @param <To>
 *            The type to translate values to and from.
 * @since 1.0.0
 * @author Torsten Krause (tk at markenwerk dot net)
 * @see Converter
 */
public interface Translator<From, To> extends Converter<From, To> {

	/**
	 * Called to revert a given value. This is the reverse function of
	 * {@link Translator#convert(Object)}.
	 * 
	 * <p>
	 * Depending on the use case, if the given value {@literal null}, the
	 * {@link Translator} should return {@literal null}.
	 * 
	 * <p>
	 * It lies in the responsibility of the caller, to handle unwanted
	 * {@literal null}-values by replacing them with a sensible default value or
	 * throwing a {@link NullPointerException}.
	 * 
	 * <p>
	 * Implementers should catch any exception and wrap them in a
	 * {@link ConverterException}.
	 * 
	 * @param to
	 *            The value to be reverted.
	 * @return The reverted value.
	 * @throws ConverterException
	 *             If the reversion failed.
	 */
	public From revert(To to) throws ConverterException;

}