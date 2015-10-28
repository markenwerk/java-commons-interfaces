package net.markenwerk.commons.interfaces;

import net.markenwerk.commons.interfaces.exceptions.ConverterException;

public abstract class BaseConverter<From, To> implements Converter<From, To> {

	@Override
	public final To convert(From from) throws ConverterException {
		try {
			return null == from ? null : doConvert(from);
		} catch (ConverterException e) {
			throw e;
		} catch (Throwable t) {
			throw new ConverterException(t);
		}
	}

	protected abstract To doConvert(From from) throws Exception;

}
