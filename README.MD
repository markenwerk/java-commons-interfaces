# Some common interfaces for Java

[![Build Status](https://travis-ci.org/markenwerk/java-commons-interfaces.svg?branch=master)](https://travis-ci.org/markenwerk/java-commons-interfaces)
[![Dependency Status](https://www.versioneye.com/user/projects/56323f1636d0ab0016001bc4/badge.svg)](https://www.versioneye.com/user/projects/56323f1636d0ab0016001bc4)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/net.markenwerk/commons-interfaces/badge.svg)](https://maven-badges.herokuapp.com/maven-central/net.markenwerk/commons-interfaces)

This is a collection of some common interfaces that describe everyday use cases. It is mainly intended for API providers who don't want to redeclare somewhat trivial interfaces all the time.

## Overview

This library is hosted in the [Maven Central Repository](https://maven-badges.herokuapp.com/maven-central/net.markenwerk/commons-interfaces). You can use it with the following coordinates:

```xml
<dependency>
	<groupId>net.markenwerk</groupId>
	<artifactId>commons-interfaces</artifactId>
	<version>2.1.2</version>
</dependency>
```

Consult the [description](#interfaces) and [Javadoc](https://markenwerk.github.io/java-commons-interfaces/index.html) for further information.

## Motivation

Some interfaces, especially [functional interfaces](https://docs.oracle.com/javase/8/docs/api/java/lang/FunctionalInterface.html), are - by their nature - generic enough to describe a very broad field of situation. The Java standard API doesn't provide such interfaces, but some of the standard interfaces are used in a generic way. This is especially true for [`Runnable`][Runnable], which is used in event queues everywhere, although it has very specific semantics in relation to [`Thread`][Thread]. On the other hand, it wouldn't be very useful to create new interfaces with a similar signature, particularly because [`Runnable`][Runnable] is already a very concise and descriptive name. 

A well chosen, concise and descriptive name reduces the necessity for a bulky method documentation, so even in an Java 8 environment, it may be better to use such interfaces, instead of a generic [`Function`][Function] parameters.

Project specific declaration of common interfaces leads to unnecessary duplication and sometimes even the necessity to implement the same basic functionality repeatedly.

Therefore, this library provides a collection of common interfaces that describe everyday situations.

## Interfaces

### Callback

The [`Callback`][Callback] interface should be used by components that perform a costly (time-consuming) operation that will eventually yield a result; most likely, but not necessarily, in a multithreaded scenario.

A [`Callback<Result>`][Callback] needs to implement the following method:

```java
public void onResult(Result result);
```

A [`Callback`][Callback] should not throw any exceptions.

One common use case for a [`Callback`][Callback] is some service, that runs synchronously.

### Predicate

The [`Predicate`][Predicate] interface should be used by components that perform binary tests on some test subjects; most likely, but not necessarily, to filter a collection or stream if incoming or outgoing test subjects.

A [`Predicate<Subject>`][Predicate] needs to implement the following method:

```java
public boolean test(Subject subject) throws EvaluationException;
```

A [`Predicate`][Predicate] should wrap every exception in an [`EvaluationException`][EvaluationException].

One common use case for a [`Predicate`][Predicate] is some data provider, that wants to provide an elaborate API that can automatically filter the provided data.

### Converter and Translator

#### Converter

The [`Converter`][Converter] interface should be used by components that perform conversions on some values; most likely, but not necessarily, to convert a collection or stream if incoming or outgoing values.

A [`Converter<From, To>`][Converter] needs to implement the following method:

```java
public To convert(From from) throws ConversionException
```

A [`Converter`][Converter] should wrap every exception in an [`ConversionException`][ConversionException].

One common use case for a [`Converter`][Converter] is some data provider, that wants to provide an elaborate API that can automatically convert the provided data.

### Translator

The [`Translator`][Translator] interface should be used by components that perform conversions on some values in both directions. It is an extension of [`Converter`][Converter].

A [`Translator<From, To>`][Translator] needs to implement the following methods:

```java
public To convert(From from) throws ConversionException

public To revert(From from) throws ConversionException
```

A [`Translator`][Translator] should wrap every exception in an [`ConversionException`][ConversionException].


### Provider and Producer

#### Provider

#### Simple Provider

The [`Provider`][Provider] interface should be used by components that may need a value that may be costly (time-consuming) to produce and don't wan't to enforce its creation prematurely.

A [`Provider<Product>`][Provider] needs to implement the following method:

```java
public Product provide() throws ProvisioningException
```

A [`Provider`][Provider] should wrap every exception in an [`ProvisioningException`][ProvisioningException]. A [`Provider`][Provider] may return the same instance for multiple invocations. Therefore, a [`Provider`][Provider] schouln't be used to provide stateful or consumable data.

#### Customizing Provider

The [`CustomizingProvider`][CustomizingProvider] interface should be used when a simple [`Provider`][Provider] is not sufficient, because it is necessary to obtain customized (e.g. localized) values.

A [`CustomizingProvider<Customization, Product>`][CustomizingProvider] needs to implement the following method:

```java
public Product provide(Customization customization) throws ProvisioningException
```

#### Producer

#### Simple Producer

The [`Producer`][Producer] interface should be used by components that needs a value (that is not suitable to be provided by a [`Provider`][Provider], i.e. because it is stateful) that may be costly (time-consuming) to produce and don't wan't to enforce its creation prematurely or by components that need multiple fresh instances of some value.

A [`Producer<Product>`][Producer] needs to implement the following method:

```java
public Product produce() throws ProductionException
```

A [`Producer`][Producer] should wrap every exception in an [`ProductionException`][ProductionException]. A [`Producer`][Producer] must return a new instance for every invocation.

#### Customizing Producer

The [`CustomizingProducer`][CustomizingProducer] interface should be used when a simple [`Producer`][Producer] is not sufficient, because it is necessary to obtain customized (e.g. localized) values.


A [`CustomizingProducer<Customization, Product>`][CustomizingProducer] needs to implement the following method:

```java
public Product produce(Customization customization) throws ProductionException
```

[Callback]: https://markenwerk.github.io/java-commons-interfaces/index.html?net/markenwerk/commons/interfaces/Callback.html
[Converter]: https://markenwerk.github.io/java-commons-interfaces/index.html?net/markenwerk/commons/interfaces/Converter.html
[CustomizingProducer]: https://markenwerk.github.io/java-commons-interfaces/index.html?net/markenwerk/commons/interfaces/CustomizingProducer.html
[CustomizingProvider]: https://markenwerk.github.io/java-commons-interfaces/index.html?net/markenwerk/commons/interfaces/CustomizingProvider.html
[Predicate]: https://markenwerk.github.io/java-commons-interfaces/index.html?net/markenwerk/commons/interfaces/Predicate.html
[Producer]: https://markenwerk.github.io/java-commons-interfaces/index.html?net/markenwerk/commons/interfaces/Producer.html
[Provider]: https://markenwerk.github.io/java-commons-interfaces/index.html?net/markenwerk/commons/interfaces/Provider.html
[Translator]: https://markenwerk.github.io/java-commons-interfaces/index.html?net/markenwerk/commons/interfaces/Translator.html

[ConversionException]: https://markenwerk.github.io/java-commons-interfaces/index.html?net/markenwerk/commons/exceptions/ConversionException.html
[EvaluationException]: https://markenwerk.github.io/java-commons-interfaces/index.html?net/markenwerk/commons/exceptions/EvaluationException.html
[ProductionException]: https://markenwerk.github.io/java-commons-interfaces/index.html?net/markenwerk/commons/exceptions/ProductionException.html
[ProvisioningException]: https://markenwerk.github.io/java-commons-interfaces/index.html?net/markenwerk/commons/exceptions/ProvisioningException.html

[Function]: http://docs.oracle.com/javase/8/docs/api/index.html?java/util/function/Function.html
[Runnable]: http://docs.oracle.com/javase/8/docs/api/index.html?java/io/Runnable.html
[Thread]: http://docs.oracle.com/javase/8/docs/api/index.html?java/io/Thread.html
