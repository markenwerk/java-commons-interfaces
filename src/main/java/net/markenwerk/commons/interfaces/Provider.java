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

import java.util.Iterator;

import net.markenwerk.commons.exceptions.ProvisioningException;

/**
 * A {@link Provider} provides values of the corresponding product type.
 * 
 * <p>
 * Implementers may provide a new instance of the product each time
 * {@link Provider#provide()} is called, but aren't requiered to do so. An
 * instance of the product that has already been returned once, may be returned
 * again for any or all following calls.
 * 
 * <p>
 * It is therefore not recommended to use {@link Provider Provides} for products
 * that are stateful unless the internal state of a values doesn't change the
 * value. It is for example okay to use {@link String} as the product type,
 * although instances are stateful ({@link String} instances store their hash
 * value after it has been calculated for the first time and are therefore
 * technically stateful), but it is not okay to use {@link Iterator} as the
 * product type, because every call to {@link Iterator#next()} actually changes
 * the {@link Iterator} instance.
 * 
 * <p>
 * {@link Provider Providers} are intended to be used in situatuation, where a
 * mechanism to retreive a value is more desirable than having the value from
 * the start. Theese are usually, but not necessarily, situations where the
 * following two conditions are met.
 * 
 * <ul>
 * <li>It is not certein that the value will be used.</li>
 * <li>It is likeley that it is a costly operation to create the value.</li>
 * </ul>
 * 
 * <p>
 * The second condition may only be true for the first call to
 * {@link Provider#provide()} since {@link Provider Providers} are allowed to
 * cache and reuse the value.
 * 
 * @param <Product>
 *            The type of the values to be provided.
 * @since 1.0.0
 * @author Torsten Krause (tk at markenwerk dot net)
 * @see Producer
 */
public interface Provider<Product> {

	/**
	 * Provides a product, This may be a costly operation.
	 * 
	 * <p>
	 * Implementers may provide a new instance of the product each time this
	 * method is called, but aren't requiered to do so. An instance of the
	 * product that has already been returned once, may be returned again in any
	 * or all following calls.
	 * 
	 * <p>
	 * It lies in the responsibility of the caller, to handle unwanted
	 * {@literal null}-values by replacing them with a sensible default value or
	 * throwing a {@link NullPointerException}.
	 * 
	 * <p>
	 * Implementers should catch any exception and wrap them in a
	 * {@link ProvisioningException}.
	 * 
	 * @return The provided product.
	 * @throws ProvisioningException
	 *             If the provisioning of the product failed.
	 */
	public Product provide() throws ProvisioningException;

}
