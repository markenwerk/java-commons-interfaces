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

import net.markenwerk.commons.interfaces.exceptions.ProductionException;

/**
 * A {@link Producer} produces values of the corresponding product type.
 * 
 * <p>
 * Implementers must produce a new instance of the product, each time
 * {@link Producer#produce()} is called.
 * 
 * <p>
 * It is therefore okay to use {@link Producer Producers} for products that are
 * stateful.
 * 
 * <p>
 * {@link Producer Producers} are intended to be used in situatuation, where a
 * mechanism to retreive a value is more desirable than having the value from
 * the start and a {@link Provider} is not sufficient (i.e. because the product
 * is stateful).
 * 
 * <p>
 * {@link Producer Producers} ar espacially helpful, if it is likely that
 * multiple instances of a stateful product will be used (i.e. multiple
 * {@link Iterator Iterators} over the same underlying data). Another use case
 * where a {@link Producer} may be more favourable than a {qlink Provider} is,
 * if it is not desirable to keep the value in memory.
 * 
 * @param <Product>
 *            The type of the values to be produced.
 * @since 1.0.0
 * @author Torsten Krause (tk at markenwerk dot net)
 * @see Provider
 */
public interface Producer<Product>  {

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
	 * {@link ProductionException}.
	 * 
	 * @return The produced product.
	 * @throws ProductionException
	 *             If the production of the product failed.
	 */
	public Product produce() throws ProductionException;

}
