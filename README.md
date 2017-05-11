# Azure IoT Gateway SDK Module Samples
This tutorial shows how to setup your Azure IoT Gateway SDK module development environment (Windows/Ubuntu Linux), write a module, customize and initialize the gateway instance. It includes samples for JavaScript, Java, and .NET modules.

<br>

## How to run JavaScript modules (Windows 10/Ubuntu Linux 14+)
### Prerequisites
1. Install latest [Git Client](https://https://git-scm.com/downloads).
2. Install latest [Node LTS](https://nodejs.org).
### Quick Start
1. `git clone https://github.com/Azure-Samples/azure-iot-gateway-samples.git`
2. `cd azure-iot-gateway-samples/js`
3. `npm install` to install pre-built core runtime of gateway.
4. `npm run local` to start the gateway with pre-defined modules (sensor and printer).

<br>

## How to run Java modules (Windows 10/Ubuntu Linux 14+)
### Prerequisites
1. Install latest [Git Client](https://https://git-scm.com/downloads).
2. Install latest x64 version of [JRE](http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html).
3. Install latest [Maven](https://maven.apache.org/install.html).
### Quick Start
1. `git clone https://github.com/Azure-Samples/azure-iot-gateway-samples.git`
2. `cd java`
3. `mvn package` to build your module with all dependencies.
4. `mvn exec:exec` to start the gateway with pre-defined module.

<br>

## How to run .NET modules(Windows 10)
### Prerequisites
1. Install latest [Git Client](https://https://git-scm.com/downloads).
2. Install Visual Studio 2015 with Update 3.
### Quick Start
1. `git clone https://github.com/Azure-Samples/azure-iot-gateway-samples.git`
2. `cd dotnet`
3. Open `\DotnetModuleSample\DotnetModuleSample.sln` with and build the solution.
4. Build the DotnetModuleSample project (Ctrl + Shift + B).
5. Click the `Start` button in the Visual Studio 2015 IDE or press the F5 key.
