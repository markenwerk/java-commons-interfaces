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

import net.markenwerk.commons.interfaces.exceptions.ProviderException;

/**
 * A {@link Provider} may be used in situation where it is not certain that a
 * value will be used, but the provisioning of the value may be costly (i.e. a
 * subsystem that may need some information which is usually stored in a file or
 * database).
 * 
 * A subsystem that requires access to a non-trivial value, but not necessarily
 * uses it, should ask for a {@code Provider} for that value, instead of the value
 * itself.
 * 
 * Implementers may produce a new instance of the product, each time this method
 * is called or reuse an already provided instance (i.e. by referring to a
 * cache, whereby the provider holds the fixed lookup key, or by storing a
 * reference to the value, once it has been resolved), but every provided object
 * must be equal to any previously provided value.
 * 
 * A {@code Provider} should only be used to provide stateless values,
 * especially, if those values can only be consumed once. For those situations,
 * it may be more appropriate to use a {@link Producer}.
 * 
 * @param <Product>
 *            The type of the values to be provided.
 * @since 1.0.0
 * @author Torsten Krause (tk at markenwerk dot net)
 * @see Factory
 * @see Producer
 */
public interface Provider<Product> {

	/**
	 * Provides a product, which may be a costly operation.
	 * 
	 * <p>
	 * Implementers may produce a new instance of the product, each time this
	 * method is called or reuse an already provided instance.
	 * 
	 * <p>
	 * It lies in the responsibility of the caller, to handle unwanted
	 * {@literal null}-values by replacing them with a sensible default value or
	 * throwing a {@link NullPointerException}.
	 * 
	 * <p>
	 * Implementers should catch any exception and wrap them in a
	 * {@link ProviderException}.
	 * 
	 * @return The provided product.
	 * @throws ProviderException
	 *             If the provisioning of the product failed.
	 */
	public Product provide() throws ProviderException;

}
