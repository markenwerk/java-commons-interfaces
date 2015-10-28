package net.markenwerk.commons.interfaces;

import net.markenwerk.commons.interfaces.exceptions.ConverterException;

public abstract class BaseTranslator<From, To> extends BaseConverter<From, To> implements Translator<From, To> {

	@Override
	public final From revert(To to) throws ConverterException {
		try {
			return null == to ? null : doRevert(to);
		} catch (ConverterException e) {
			throw e;
		} catch (Throwable t) {
			throw new ConverterException(t);
		}
	}

	protected abstract From doRevert(To to) throws Exception;
}
