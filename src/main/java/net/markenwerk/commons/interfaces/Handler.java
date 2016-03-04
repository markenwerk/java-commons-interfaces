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

/**
 * For an arbitrary process, that may encounter some kind of event and needs to
 * delegate the event handling, a {@link Handler} is used, to convey that event
 * from the executor of the process (hereafter: executor) back to the initiator
 * of the process (hereafter: initiator).
 * 
 * <p>
 * Depending on the concrete scenario, the initiator may reuse the same instance
 * of {@link Handler} for multiple processes and even for the same executor,
 * although the letter is unusual.
 * 
 * <p>
 * The executor may or may not call {@link Handler#handle(Object)}.
 * 
 * <p>
 * The executor may call {@link Handler#handle(Object)}, more than once,
 * depending o the concrete scenario, to convey partial or updated results. This
 * should be noted in the contract of the method, that is used to convey the
 * {@link Handler} to the executor.
 * 
 * <p>
 * The executor must not call {@link Handler#handle(Object)} more than once for
 * the same event.
 * 
 * @param <Event>
 *            The type of the event of the process.
 * @since 3.0.0
 * @author Torsten Krause (tk at markenwerk dot net)
 */
public interface Handler<Event> {

	/**
	 * Called by the executor when an event occurs.
	 * 
	 * @param event
	 *            The event.
	 */
	public void handle(Event event);

}
