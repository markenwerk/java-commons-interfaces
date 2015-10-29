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

import net.markenwerk.commons.interfaces.exceptions.PredicateException;

/**
 * A {@link Predicate} is used to perform arbitrary test on test subject. It is
 * usually used in a scenario where some sort of data provider wants to offer
 * the possibility to filter values before delivery or during the data
 * processing.
 * 
 * @param <Subject>
 *            The type of the values to perform tests on.
 * @since 1.0.0
 * @author Torsten Krause (tk at markenwerk dot net)
 */
public interface Predicate<Subject> {

	/**
	 * Performs the test on a given test subject.
	 * 
	 * <p>
	 * It lies in the responsibility of the caller, to handle unwanted
	 * {@literal null}-values by replacing them with a sensible default value or
	 * throwing a {@link NullPointerException}.
	 * 
	 * <p>
	 * Implementers should catch any exception and wrap them in a
	 * {@link PredicateException}.
	 * 
	 * @param subject
	 *            The test subject.
	 * @return Whether the test subject passed the test.
	 * @throws PredicateException
	 *             If testing the test subject failed.
	 */
	public boolean test(Subject subject) throws PredicateException;

}
