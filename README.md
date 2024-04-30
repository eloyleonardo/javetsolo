# Javet Application Setup Guide

This README provides instructions on how to set up and run this test. 

## Prerequisites

Ensure you have the following prerequisites installed on your system:

- GraalVM (if building a native image)
- wget (or another method to download files from the internet)

## Download Javet

Download the appropriate Javet JAR file for your environment using the following command:

```bash
wget -O javet.jar https://repo1.maven.org/maven2/com/caoccao/javet/javet-macos/3.1.1/javet-macos-3.1.1.jar
```

## Compile the Java File

Compile your Java application with the Javet JAR in the classpath:

```bash
javac -cp javet.jar JavetlabApplication.java
```

## Run the Application

Execute the application with the following command:

```bash
java -cp javet.jar:. JavetlabApplication
```

You should see the following output:

```
init
Hello Javet
finish
```

## Metadata Generation

### Create Metadata Folder

Create a folder to store the metadata files:

```bash
mkdir -p META-INF/native-image
```

### Run the Agent

Run the Java application with the native-image agent to generate the metadata files:

```bash
java -agentlib:native-image-agent=config-output-dir=META-INF/native-image,experimental-class-define-support -cp javet.jar:. JavetlabApplication
```

## Build the Native Image

```bash
native-image --no-fallback -cp javet.jar:. JavetlabApplication
```

## Execute the Native Application

Run the compiled native application binary:

```bash
./javetlabapplication
```

## The error

When i run it I get the follow error

```Java
com.oracle.svm.core.jdk.UnsupportedFeatureError: No classes have been predefined during the image build to load from bytecodes at runtime.
	at org.graalvm.nativeimage.builder/com.oracle.svm.core.util.VMError.unsupportedFeature(VMError.java:121)
	at org.graalvm.nativeimage.builder/com.oracle.svm.core.hub.PredefinedClassesSupport.throwNoBytecodeClasses(PredefinedClassesSupport.java:76)
	at org.graalvm.nativeimage.builder/com.oracle.svm.core.hub.PredefinedClassesSupport.loadClass(PredefinedClassesSupport.java:130)
	at java.base@21.0.2/java.lang.ClassLoader.defineClass(ClassLoader.java:274)
	at com.caoccao.javet.interop.JavetClassLoader.loadClass(JavetClassLoader.java:126)
	at com.caoccao.javet.interop.JavetClassLoader.load(JavetClassLoader.java:99)
	at com.caoccao.javet.interop.V8Host.loadLibrary(V8Host.java:418)
	at com.caoccao.javet.interop.V8Host.<init>(V8Host.java:67)
	at com.caoccao.javet.interop.V8Host.<init>(V8Host.java:43)
	at com.caoccao.javet.interop.V8Host$V8InstanceHolder.<clinit>(V8Host.java:459)
	at com.caoccao.javet.interop.V8Host.getV8Instance(V8Host.java:119)
	at JavetlabApplication.main(JavetlabApplication.java:9)
	at java.base@21.0.2/java.lang.invoke.LambdaForm$DMH/sa346b79c.invokeStaticInit(LambdaForm$DMH)
java.lang.ClassNotFoundException: com.caoccao.javet.interop.loader.JavetLibLoader
	at com.caoccao.javet.interop.JavetClassLoader.loadClass(JavetClassLoader.java:132)
	at com.caoccao.javet.interop.JavetClassLoader.load(JavetClassLoader.java:99)
	at com.caoccao.javet.interop.V8Host.loadLibrary(V8Host.java:418)
	at com.caoccao.javet.interop.V8Host.<init>(V8Host.java:67)
	at com.caoccao.javet.interop.V8Host.<init>(V8Host.java:43)
	at com.caoccao.javet.interop.V8Host$V8InstanceHolder.<clinit>(V8Host.java:459)
	at com.caoccao.javet.interop.V8Host.getV8Instance(V8Host.java:119)
	at JavetlabApplication.main(JavetlabApplication.java:9)
	at java.base@21.0.2/java.lang.invoke.LambdaForm$DMH/sa346b79c.invokeStaticInit(LambdaForm$DMH)
Caused by: com.oracle.svm.core.jdk.UnsupportedFeatureError: No classes have been predefined during the image build to load from bytecodes at runtime.
	at org.graalvm.nativeimage.builder/com.oracle.svm.core.util.VMError.unsupportedFeature(VMError.java:121)
	at org.graalvm.nativeimage.builder/com.oracle.svm.core.hub.PredefinedClassesSupport.throwNoBytecodeClasses(PredefinedClassesSupport.java:76)
	at org.graalvm.nativeimage.builder/com.oracle.svm.core.hub.PredefinedClassesSupport.loadClass(PredefinedClassesSupport.java:130)
	at java.base@21.0.2/java.lang.ClassLoader.defineClass(ClassLoader.java:274)
	at com.caoccao.javet.interop.JavetClassLoader.loadClass(JavetClassLoader.java:126)
```