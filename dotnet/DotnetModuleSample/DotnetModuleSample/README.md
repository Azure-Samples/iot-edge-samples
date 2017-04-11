.NET NuGet Package for Windows Desktop
===============================

Overview
--------

This sample showcases how one might build modules for IoT Gateway in .NET.

The sample contains:

1. A printer module (C#) that interprets telemetry from sensor and prints its content and properties into Console.
2. A sensor module (C#) that publishes random data to the gateway.
3. The .NET Microsoft.Azure.IoT.Gateway interface assembly.
4. A sample native (C++) gateway executable (gw.exe) file.
5. The native (C++) binding layer interfaces for .NET, Java, and NodeJs (C++). Which includes `gateway.dll`, `aziotsharedutil.dll`, `nanomsg.dll`, `dotnet.dll`, `java_module_host.dll`, `node.dll`, `nodejs_binding.dll`.
6. The `Microsoft.Azure.IoT.Gateway.dll` (C#) which contains the Azure IoT Gateway module interface definition.
7. A `module_dev_sample.json` file that is used to configure which module the gateway will use.

Prerequisites
--------------
1. Microsoft Visual Studio 2015.
2. Make sure you have .NET Framework installed. Our current version of the binding was tested and loads modules written in .NET version v4.6.01586.
3. The [Microsoft .NET Framework 4.5](https://www.microsoft.com/en-us/download/details.aspx?id=30653).

How does the data flow through the Gateway
------------------------------------------
You can find the diagram for Receiving a message and publishing a message on this flow chart:

![](./images/flow_chart.png)

Running the sample
------------------
1. Build the DotnetModuleSample project (Ctrl + Shift + B).
2. Open a command prompt (cmd.exe) and navigate to the projects bin folder.
3. Enter the following command:
	- gw.exe module&#95;dev&#95;sample.json