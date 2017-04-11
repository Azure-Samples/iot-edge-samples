# Java Maven Package for Windows and Linux

## Overview

This sample showcases how one might build a simple module for Microsoft Azure IoT Gateway SDK in Java.

The sample contains:
1. A `TimerModule.java` which will generate one message per second. It will also receive and print that message into the Console as well.
2. A `TimerModuleUnitTest.java` which will test the basic behavior of `TimerModule.java`.
3. A `gw-config.json` which is the runtime configuration file for the Microsoft Azure IoT Gateway.
4. A `pom.xml` which is used to declare all the dependencies, compiler version and execution stage for Maven.

## Prerequisites

* The latest [JRE](http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html) (x86 on Windows; apt-get "default-jre" on Ubuntu)
* [Maven](https://maven.apache.org/install.html) command line
* **[Windows]** Add parent folder path of jvm.dll (might be "C:\Program Files (x86)\Java\jre1.8.0_121\bin\client") to the PATH environment variable

## The Data Flow

There is only one module in this sample called `TimerModule`. Every second, it will publish to the Gateway a message containing the string representation of the current timestamp (i.e. `"Mon Mar 20 00:00:00 PDT 2017"`). This module also contains a `receive` method which will read the message from the Gateway, and print that message (both the content and the properties) to the Console. The configuration file `gw-config.json` specifies the only data flow of the Gateway: **ALL messages come from `TimerModule` will be received by `TimerModule` itself**.

So in this case, a typical end-to-end dataflow is illustrated below:

> ⟲ [*TimerModule*] Timer task kicks in every second <br />
  → [*TimerModule*] Send current timestamp message to Gateway <br />
  → [*Gateway*] Forward message according to `gw-config.json` <br />
  → [*TimerModule*] Receive the message from Gateway <br />
  → [*TimerModule*] Print out the message

## Running the sample

To compile and run the sample, firstly you need to enter the `./azure-iot-gw-sample/java` folder use any command line tool you like on any platform. But please make sure that `mvn --version` works in that command line tool.

Use "`mvn package`" to compile and pack the `TimerModule` into the `./target` folder. "`mvn clean package`" is recommended for a clean build.

Use "`mvn exec:exec`" to run the gateway and you should observe that every second a message will be printed out in the command line window. Please press `<Enter>` key to terminate the gateway gracefully.

> ⚠ **DO NOT** use Ctrl+C to terminate the gateway, it might cause some side-effects.

## Testing the sample

Actually the test phase should already been invoked when you call the `mvn package` command. But still you could use "`mvn test`" or "`mvn clean test`" to run all the unit test cases.

Basically the unit test of a module should test for the bahaviors of its input (`void receive(Message message)`) as well as its output (`void start()`); and this is what `TimerModuleUnitTest.java` does. It expects that each second a message will be generated and published to the Gateway; it also verifies that when a message is received by this module, that specific message will be printed out.

## Modifying the Code

You could just change the code in `./src/main/java/com/microsoft/gateway/TimerModule.java`. But the `super(address, broker, configuration)` statement in the constructor should be preserved in order to let the gateway successfully constructed. You can update the message to be sent in `void start()` method, and deal with the message you received in `void receive(Message message)` method. And remember to do the cleanup jobs in the `void destroy()` method if you create your own resources like new threads.

> ⚠ Forgot to clean up the threads in `void destroy()` will not cause many problems if you are just need to terminate the gateway, but it is not a good practice to do so.
