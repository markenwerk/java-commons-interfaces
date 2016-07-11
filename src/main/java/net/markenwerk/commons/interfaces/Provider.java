/*
 * Copyright (c) 2015, 2016 Torsten Krause, Markenwerk GmbH
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

import net.markenwerk.commons.exceptions.ProvisioningException;

/**
 * A {@link Provider} provides values of the corresponding product type.
 * 
 * <p>
 * Implementers may provide a new instance of the product each time
 * {@link Provider#provide()} is called, but aren't required to do so. An
 * instance of the product that has already been returned once, may be returned
 * again for any or all following calls.
 * 
 * <p>
 * A {@link Provider} is intended to be used in a situation, where a
 * mechanism to retrieve a value is more desirable than having the value from
 * the start. These are usually, but not necessarily, situations where the
 * following two conditions are met.
 * 
 * <ul>
 * <li>It is not certain that the value will be used.</li>
 * <li>It is likely that it is a costly operation to create the value.</li>
 * </ul>
 * 
 * <p>
 * The second condition may only be true for the first call to
 * {@link Provider#provide()} since the {@link Provider} is allowed to
 * cache and reuse the value.
 * 
 * @param <Product>
 *            The type of the values to be provided.
 * @author Torsten Krause (tk at markenwerk dot net)
 * @since 1.0.0
 */
public interface Provider<Product> {

	/**
	 * Provides a product, This may be a costly operation.
	 * 
	 * <p>
	 * Implementers should catch any exception and wrap them in a
	 * {@link ProvisioningException}.
	 * 
	 * <p>
	 * Implementers may provide a new instance of the product each time this
	 * method is called, but aren't required to do so. An instance of the
	 * product that has already been returned once, may be returned again in any
	 * or all following calls.
	 * 
	 * @return The provided product.
	 * @throws ProvisioningException
	 *             If the provisioning of the product failed.
	 */
	public Product provide() throws ProvisioningException;

}
