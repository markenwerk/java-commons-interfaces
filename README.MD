# Some common interfaces for Java

[![Build Status](https://travis-ci.org/markenwerk/java-commons-interfaces.svg?branch=master)](https://travis-ci.org/markenwerk/java-commons-interfaces)
[![Dependency Status](https://www.versioneye.com/user/projects/56323f1636d0ab0016001bc4/badge.svg)](https://www.versioneye.com/user/projects/56323f1636d0ab0016001bc4)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/net.markenwerk/commons-interfaces/badge.svg)](https://maven-badges.herokuapp.com/maven-central/net.markenwerk/commons-interfaces)
[![Java SE 6](https://img.shields.io/badge/java-SE_6-brightgreen.svg)](http://docs.oracle.com/javase/6/docs/api/)
[![MIT License](https://img.shields.io/badge/license-MIT-brightgreen.svg)](https://github.com/markenwerk/java-commons-interfaces/blob/master/LICENSE)

This is a collection of some common interfaces that describe everyday use cases. It is mainly intended for API providers who don't want to redeclare somewhat trivial interfaces all the time.

## Overview

This library is hosted in the [Maven Central Repository](https://maven-badges.herokuapp.com/maven-central/net.markenwerk/commons-interfaces). You can use it with the following coordinates:

```xml
<dependency>
	<groupId>net.markenwerk</groupId>
	<artifactId>commons-interfaces</artifactId>
	<version>4.0.1</version>
</dependency>
```

Consult the [description](#interfaces) and [Javadoc](https://markenwerk.github.io/java-commons-interfaces/index.html) for further information.

## Motivation

Some interfaces, especially [functional interfaces](https://docs.oracle.com/javase/8/docs/api/java/lang/FunctionalInterface.html), are - by their nature - generic enough to describe a very broad field of situation. The Java standard API doesn't provide such interfaces, but some of the standard interfaces are used in a generic way. This is especially true for [`Runnable`][Runnable], which is used in event queues everywhere, although it has very specific semantics in relation to [`Thread`][Thread]. On the other hand, it wouldn't be very useful to create new interfaces with a similar signature, particularly because [`Runnable`][Runnable] is already a very concise and descriptive name. 

A well chosen, concise and descriptive name reduces the necessity for a bulky method documentation, so even in an Java 8 environment, it may be better to use such interfaces, instead of a generic [`Function`][Function] parameters.

Project specific declaration of common interfaces leads to unnecessary duplication and sometimes even the necessity to implement the same basic functionality repeatedly.

Therefore, this library provides a collection of common interfaces that describe everyday situations.

## Interfaces

### Check

The [`Check`][Check] interface should be used by components that perform tests.

A [`Check`][Check] must implement the following method:

```java
public boolean test();
```

A [`Check`][Check] should not throw any exceptions.

### Predicate

The [`Predicate`][Predicate] interface should be used by components that perform tests on test subjects.

A [`Predicate`][Predicate] must implement the following method:

```java
public boolean test(Subject subject);
```

A [`Predicate`][Predicate] should not throw any exceptions.

### Callback

The [`Callback`][Callback] interface should be used by components that perform an operation that will eventually yield a result.

A [`Callback`][Callback] needs to implement the following method:

```java
public void onResult(Callee callee, Result result);
```

A [`Callback`][Callback] should not throw any exceptions.

### Handler

The [`Handler`][Handler] interface should be used by components that perform an operation that may encounter some condition and needs to delegate the handling.

A [`Handler`][Handler] needs to implement the following method:

```java
public void handle(Handler result) throws HandlingException;
```

A [`Handler`][Handler] should wrap every exception in an [`HandlingException`][HandlingException].

### Processor

The [`Processor`][Processor] interface should be used by components that perform modifications on some values.

A [`Processor`][Processor] needs to implement the following method:

```java
public value process(Value value) throws ProcessingException;
```

A [`Processor`][Processor] should wrap every exception in an [`ProcessingException`][ProcessingException].

### Converter

The [`Converter`][Converter] interface should be used by components that perform conversions on some values.

A [`Converter`][Converter] needs to implement the following method:

```java
public To convert(From from) throws ConversionException;
```

A [`Converter`][Converter] should wrap every exception in an [`ConversionException`][ConversionException].

### Translator

The [`Translator`][Translator] interface should be used by components that perform conversions on some values in both directions. It is an extension of [`Converter`][Converter].

A [`Translator`][Translator] needs to implement the following methods:

```java
public To convert(From from) throws ConversionException;

public To revert(From from) throws ConversionException;
```

A [`Translator`][Translator] should wrap every exception in an [`ConversionException`][ConversionException].

### Provider

The [`Provider`][Provider] interface should be used by components that may need a value that may be costly (time-consuming) to produce and don't wan't to enforce its creation prematurely.

A [`Provider`][Provider] needs to implement the following method:

```java
public Product provide() throws ProvisioningException;
```

A [`Provider`][Provider] should wrap every exception in an [`ProvisioningException`][ProvisioningException].

### Producer

The [`Producer`][Producer] interface should be used when a simple [`Provider`][Provider] is not sufficient, because it is necessary to obtain contextual (e.g. location-, date-, or language-dependent) values. It acts like a [`Provider`][Provider] that takes orders and produces corresponding values.

A [`Producer`][Producer] needs to implement the following method:

```java
public Product produce(Order order) throws ProductionException;
```

A [`Producer`][Producer] should wrap every exception in an [`ProductionException`][ProductionException].

[Callback]: https://markenwerk.github.io/java-commons-interfaces/index.html?net/markenwerk/commons/interfaces/Callback.html
[Check]: https://markenwerk.github.io/java-commons-interfaces/index.html?net/markenwerk/commons/interfaces/Check.html
[Converter]: https://markenwerk.github.io/java-commons-interfaces/index.html?net/markenwerk/commons/interfaces/Converter.html
[Handler]: https://markenwerk.github.io/java-commons-interfaces/index.html?net/markenwerk/commons/interfaces/Handler.html
[Predicate]: https://markenwerk.github.io/java-commons-interfaces/index.html?net/markenwerk/commons/interfaces/Predicate.html
[Processor]: https://markenwerk.github.io/java-commons-interfaces/index.html?net/markenwerk/commons/interfaces/Processor.html
[Producer]: https://markenwerk.github.io/java-commons-interfaces/index.html?net/markenwerk/commons/interfaces/Producer.html
[Provider]: https://markenwerk.github.io/java-commons-interfaces/index.html?net/markenwerk/commons/interfaces/Provider.html
[Translator]: https://markenwerk.github.io/java-commons-interfaces/index.html?net/markenwerk/commons/interfaces/Translator.html

[ConversionException]: https://markenwerk.github.io/java-commons-interfaces/index.html?net/markenwerk/commons/exceptions/ConversionException.html
[HandlingException]: https://markenwerk.github.io/java-commons-interfaces/index.html?net/markenwerk/commons/exceptions/HandlingException.html
[ProcessingException]: https://markenwerk.github.io/java-commons-interfaces/index.html?net/markenwerk/commons/exceptions/ProcessingException.html
[ProductionException]: https://markenwerk.github.io/java-commons-interfaces/index.html?net/markenwerk/commons/exceptions/ProductionException.html
[ProvisioningException]: https://markenwerk.github.io/java-commons-interfaces/index.html?net/markenwerk/commons/exceptions/ProvisioningException.html

[Function]: http://docs.oracle.com/javase/8/docs/api/index.html?java/util/function/Function.html
[Runnable]: http://docs.oracle.com/javase/8/docs/api/index.html?java/io/Runnable.html
[Thread]: http://docs.oracle.com/javase/8/docs/api/index.html?java/io/Thread.html