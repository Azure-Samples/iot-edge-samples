# Azure IoT Edge Module Samples
This tutorial shows how to setup your IoT Edge module development environment (Windows/Ubuntu Linux), write a module, customize and initialize the IoT Edge instance. It includes samples for JavaScript, Java, and .NET modules.

If you encounter an issue related to these samples please [submit a new issue](https://github.com/Azure-Samples/iot-edge-samples/issues/new). For issues related to the IoT Edge or the packages please go to the [IoT Edge repo](https://github.com/Azure/iot-edge) and submit an issue.

<br>

## How to run JavaScript modules (Windows 10/Ubuntu Linux 14+)
### Prerequisites
1. Install latest [Git Client](https://git-scm.com/downloads).
2. Install latest [Node LTS](https://nodejs.org).
### Quick Start
1. `git clone https://github.com/Azure-Samples/iot-edge-samples.git`
2. `cd iot-edge-samples/js/simple`
3. `npm install` to install pre-built core runtime of IoT Edge.
4. `npm run local` to start the IoT Edge with pre-defined modules (sensor and printer).

<br>

## How to run Java modules (Windows 10/Ubuntu Linux 14+)
### Prerequisites
1. Install latest [Git Client](https://git-scm.com/downloads).
2. Install latest x64 version of [JRE](http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html).
3. Install latest [Maven](https://maven.apache.org/install.html).
### Quick Start
1. `git clone https://github.com/Azure-Samples/iot-edge-samples.git`
2. `cd iot-edge-samples/java`
3. `mvn package` to build your module with all dependencies.
4. `mvn exec:exec` to start the IoT Edge with pre-defined module.

<br>

## How to run .NET modules (Windows 10)
### Prerequisites
1. Install latest [Git Client](https://https://git-scm.com/downloads).
2. Install Visual Studio 2015 with Update 3.
### Quick Start
1. `git clone https://github.com/Azure-Samples/iot-edge-samples.git`
2. `cd iot-edge-samples/dotnet`
3. Open `\DotnetModuleSample\DotnetModuleSample.sln` with and build the solution.
4. Build the DotnetModuleSample project (Ctrl + Shift + B).
5. Click the `Start` button in the Visual Studio 2015 IDE or press the F5 key.
