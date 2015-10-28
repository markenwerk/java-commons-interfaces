package net.markenwerk.commons.interfaces;

import net.markenwerk.commons.interfaces.exceptions.InitializationException;

public abstract class BaseLazy<Subject> implements Lazy<Subject> {

	private boolean initialized;

	private InitializationException initializationException;

	private Subject subject;

	@Override
	public synchronized Subject get() throws InitializationException {
		if (!initialized) {
			try {
				subject = doGet();
			} catch (InitializationException e) {
				initializationException = e;
				throw initializationException;
			} catch (Throwable t) {
				initializationException = new InitializationException(t);
				throw initializationException;
			}
		}
		if (null != initializationException) {
			InitializationException initializationException = new InitializationException(
					"Former initialization of this did fail.");
			initializationException.initCause(this.initializationException);
			throw initializationException;
		}
		return subject;
	}

	protected abstract Subject doGet() throws Exception;

}
