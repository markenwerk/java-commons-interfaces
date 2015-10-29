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

import java.lang.ref.WeakReference;

/**
 * For an arbitrary process, that will eventually yield a result, a
 * {@link Callback} is used, to convey that result from the executor of the
 * process (hereafter: executor) back to the initiator of the process
 * (hereafter: initiator).
 * 
 * <p>
 * A {@link Callback} is most likely, but not necessarily, used in a
 * multithreaded scenario.
 * 
 * <p>
 * Depending on the concrete scenario, the initiator may reuse the same instance
 * of {@link Callback} for multiple processes and even for the same executor,
 * although the letter is unusual.
 * 
 * <p>
 * The executor must eventually call {@link Callback#onResult(Object)}, at least
 * once.
 * 
 * <p>
 * One common exception to this rule is, when the executor can ensure, that the
 * result wont't be needed by the initiator, because the initiator itself is not
 * needed anymore. This is usually implemented by placing the {@link Callback}
 * in a {@link WeakReference}. This should be noted in the contract of the
 * method, that is used to convey the {@link Callback} to the executor, because
 * using anonymous instances of {@link Callback} will fail in this case.
 * 
 * <p>
 * The executor may call {@link Callback#onResult(Object)}, more than once,
 * depending o the concrete scenario, to convey partial or updated results. This
 * should be noted in the contract of the method, that is used to convey the
 * {@link Callback} to the executor.
 * 
 * <p>
 * The executor must not call {@link Callback#onResult(Object)} more than once
 * for the same result.
 * 
 * @param <Result>
 *            The result of the process.
 * @since 1.0.0
 * @author Torsten Krause (tk at markenwerk dot net)
 */
public interface Callback<Result> {

	/**
	 * Called by the executor when a result is available.
	 * 
	 * @param result
	 *            The result.
	 */
	public void onResult(Result result);

}
