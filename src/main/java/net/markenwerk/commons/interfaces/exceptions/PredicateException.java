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
package net.markenwerk.commons.interfaces.exceptions;

import net.markenwerk.commons.interfaces.Predicate;

/**
 * A {@code PredicateException} indicates that the evaluation of a
 * {@code Predicate} has failed.
 * 
 * @author Torsten Krause (tk at markenwerk dot net)
 * @since 1.0.0
 * 
 * @see Predicate
 */
public final class PredicateException extends RuntimeException {

	private static final long serialVersionUID = -1717421532938676308L;

	/**
	 * Constructs a {@code PredicateException} with the given message and cause.
	 * The given cause is chained to this exception.
	 *
	 * @param message
	 *            The message.
	 * @param cause
	 *            The cause of this {@code PredicateException}.
	 */
	public PredicateException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructs a {@code PredicateException} with the given message.
	 *
	 * @param message
	 *            The message.
	 */
	public PredicateException(String message) {
		super(message);
	}

	/**
	 * Constructs a {@code PredicateException} with the given cause. The given
	 * cause is chained to this exception.
	 *
	 * @param cause
	 *            The cause of this {@code PredicateException}.
	 */
	public PredicateException(Throwable cause) {
		super(cause);
	}

}