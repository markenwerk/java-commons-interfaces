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
package net.markenwerk.commons.exceptions;

import net.markenwerk.commons.interfaces.Producer;

/**
 * A {@link CreationException} indicates that a {@link Producer} failed to
 * produce a product.
 * 
 * @author Torsten Krause (tk at markenwerk dot net)
 * @since 1.0.0
 * 
 * @see Producer
 */
public final class CreationException extends RuntimeException {

	private static final long serialVersionUID = 8658949883506215155L;

	/**
	 * Constructs a {@link CreationException} with the given message and cause.
	 * The given cause is chained to this exception.
	 *
	 * @param message
	 *            The message.
	 * @param cause
	 *            The cause of this {@link CreationException}.
	 */
	public CreationException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructs a {@link CreationException} with the given message.
	 *
	 * @param message
	 *            The message.
	 */
	public CreationException(String message) {
		super(message);
	}

	/**
	 * Constructs a {@link CreationException} with the given cause. The given
	 * cause is chained to this exception.
	 *
	 * @param cause
	 *            The cause of this {@link CreationException}.
	 */
	public CreationException(Throwable cause) {
		super(cause);
	}

}