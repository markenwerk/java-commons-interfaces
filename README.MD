# Some common interfaces for Java

This is a collection of some common interfaces that describe everyday use cases. It is intended for those, who provide some API and don't want to redeclare somewhat trivial interfaces all the time.

## Overview

This library is hosted in the [Maven Central Repositoy](http://search.maven.org/#artifactdetails|net.markenwerk|commons-interfaces|1.0.0|jar). You can use it with the following coordinates:

```xml
<dependency>
	<groupId>net.markenwerk</groupId>
	<artifactId>commons-interfaces</artifactId>
	<version>1.0.0</version>
</dependency>
```

Consult the [description](#interfaces) and [Javadoc](http://markenwerk.github.io/java-commons-interfaces/javadoc/1.0.0/index.html) for further information.

## Motivation

Some interfaces, especially [functional interfaces](https://docs.oracle.com/javase/8/docs/api/java/lang/FunctionalInterface.html), are - by there nature - generic enough to describe a very broad field of situation. The Java standard API doesn't provide such interfaces, but some of the standard interfaces are used in a generic way. This is especially true for [`Runnable`][Runnable], which is used in event queues everywhere, although it has very specific semantics in relation to [`Thread`][Thread]. On the other hand, it wouldn't be very useful to create new interfaces with a similar signature, particularly because `Runnable` is already a very concise and descriptive name. 

A well chosen, concise and descriptive name reduces the necessity for a bulky method documentation, so even in an Java 8 environment, it is better to use such generic functional interfaces, instead of [`Function`][Function] parameters.

Although there are situation where it is useful and appropriate to use specialised interfaces, usually named with project depended prefixes, this is not always the case. This leads to unnecessary duplications of simple interfaces and sometimes, the necessity, to implement the same basic functionality repeatedly.

This library provides a collection of interfaces that describe such common situations.

## Interfaces

### Callback

The [`Callback`][Callback] interface should be used by components that perform a costly (time-consuming) operation that will eventually yield a result; most likely, but not necessarily, in a multithreaded scenario.

A [`Callback<Result>`][Callback] needs to implement the following method:

```java
public void onResult(Result result);
```

One common use case for a [`Callback`][Callback] is som service, that runs synchronously.

### Predicate

The [`Predicate`][Predicate] interface should be used by components that perform binary tests on some test subjects; most likely, but not necessarily, to filter a collection or stream if oncoming or outgoing test subjects.

A [`Predicate<Subject>`][Predicate] needs to implement the following method:

```java
public boolean test(Subject subject) throws PredicateException;
```

One common use case for a [`Predicate`][Predicate] is some data provider, that wants to provide an elaborate API that can automatically filter the provided data.

### Converter and Translator

#### Converter

The [`Converter`][Converter] interface should be used by components that perform conversions on some values; most likely, but not necessarily, to convert a collection or stream if oncoming or outgoing values.

A [`Converter<From, To>`][Converter] needs to implement the following method:

```java
public To convert(From from) throws ConverterException
```

One common use case for a [`Converter`][Converter] is some data provider, that wants to provide an elaborate API that can automatically convert the provided data.

### Translator

The [`Translator`][Translator] interface should be used by components that perform conversions on some values in both directions. It is an extension of [`Converter`][Converter].

A [`Translator<From, To>`][Translator] needs to implement the following methods:

```java
public To convert(From from) throws ConverterException

public To revert(From from) throws ConverterException
```

### Provider, Producer and Factory

#### Provider

The [`Provider`][Provider] interface should be used by components that may need a value that may be costly (time-consuming) to produce and don't wan't to enforce its creation prematurely.

A [`Provider<Product>`][Provider] needs to implement the following method:

```java
public Product provide() throws ProviderException
```

A [`Provider`][Provider] may return the same instance for multiple invocations. Therefore, a [`Provider`][Provider] schouln't be used to provide stateful or consumable data.

#### Producer

The [`Producer`][Producer] interface should be used by components that needs a value (that is not suitable to be provided by a [`Provider`][Provider], i.e. because it is stateful) that may be costly (time-consuming) to produce and don't wan't to enforce its creation prematurely or by components that need multiple fresh instances of some value.

A [`Producer<Product>`][Producer] needs to implement the following method:

```java
public Product produce() throws ProducerException
```

A [`Producer`][Producer] must return a new instance for every invocation.

#### Factory

The [`Factory`][Factory] interface should be used by components that need multiple fresh instances of some value and needs to specify some parameters of the produced values.

A [`Factory<ProductSpecification, Product>`][Factory] needs to implement the following method:

```java
public Product produce(ProductSpecification specification) throws FactoryException
```
A [`Factory`][Factory] must return a new instance for every invocation.



[Callback]: http://markenwerk.github.io/java-commons-interfaces/javadoc/1.1.1/index.html?net/markenwerk/commoins/interfaces/Callback.html
[Converter]: http://markenwerk.github.io/java-commons-interfaces/javadoc/1.1.1/index.html?net/markenwerk/commoins/interfaces/Converter.html
[Factory]: http://markenwerk.github.io/java-commons-interfaces/javadoc/1.1.1/index.html?net/markenwerk/commoins/interfaces/Factory.html
[Predicate]: http://markenwerk.github.io/java-commons-interfaces/javadoc/1.1.1/index.html?net/markenwerk/commoins/interfaces/Predicate.html
[Producer]: http://markenwerk.github.io/java-commons-interfaces/javadoc/1.1.1/index.html?net/markenwerk/commoins/interfaces/Producer.html
[Provider]: http://markenwerk.github.io/java-commons-interfaces/javadoc/1.1.1/index.html?net/markenwerk/commoins/interfaces/Provider.html
[Translator]: http://markenwerk.github.io/java-commons-interfaces/javadoc/1.1.1/index.html?net/markenwerk/commoins/interfaces/Translator.html

[Function]: http://docs.oracle.com/javase/8/docs/api/index.html?java/util/function/Function.html
[Runnable]: http://docs.oracle.com/javase/6/docs/api/index.html?java/io/Runnable.html
[Thread]: http://docs.oracle.com/javase/6/docs/api/index.html?java/io/Thread.html
