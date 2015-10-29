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

import java.io.InputStream;

import net.markenwerk.commons.interfaces.exceptions.ProducerException;

/**
 * A {@link Producer} may be used in situation where it is either not certain
 * that a value that is not suitable to be provided by a {@link Provider} (i.e.
 * because it is stateful) will be used or where multiple instances of the same
 * data (i.e. a subsystem that repeatedly consumes data that is provided as an
 * {@link InputStream} or a subsystem that needs an encryption key at arbitrary
 * times and wants to discard it after every use).
 * 
 * <p>
 * Implementers must produce a new instance of the product, each time this
 * method is called.
 * 
 * @param <Product>
 *            The type of the values to be produced.
 * @since 1.0.0
 * @author Torsten Krause (tk at markenwerk dot net)
 * @see Factory
 * @see Provider
 */
public interface Producer<Product> {

	/**
	 * Produces a new product. This may be a costly operation
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
	 * {@link ProducerException}.
	 * 
	 * @return The produced product.
	 * @throws ProducerException
	 *             If the production of the product failed.
	 */
	public Product produce() throws ProducerException;

}
