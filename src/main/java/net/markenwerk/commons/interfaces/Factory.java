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

import net.markenwerk.commons.interfaces.exceptions.FactoryException;

/**
 * A {@link Factory} may be used in situation where a simple {@link Producer} is
 * not sufficient because it needs some control to specify some parameters of
 * the produced values.
 * 
 * <p>
 * Implementers must produce a new instance of the product, each time this
 * method is called.
 * 
 * @param <ProductSpecification>
 *            The type of specification for the produced values.
 * @param <Product>
 *            The type of the provided values.
 * @since 1.0.0
 * @author Torsten Krause (tk at markenwerk dot net)
 * @see Producer
 * @see Provider
 */
public interface Factory<ProductSpecification, Product> {

	/**
	 * Produces a new and custom made product that fulfills the given
	 * specification. This may be a costly operation
	 * 
	 * <p>
	 * Implementers must produce a new instance of the product, each time this
	 * method is called.
	 * 
	 * <p>
	 * It lies in the responsibility of the caller, to handle unwanted
	 * {@literal null}-values by replacing them with a sensible default value or
	 * throwing a {@link NullPointerException}.
	 * 
	 * <p>
	 * Implementers should catch any exception and wrap them in a
	 * {@link FactoryException}.
	 * 
	 * @param specification
	 *            The specification to fulfill.
	 * @return The produced product.
	 * @throws FactoryException
	 *             If the production of the product failed.
	 */
	public Product produce(ProductSpecification specification) throws FactoryException;

}
