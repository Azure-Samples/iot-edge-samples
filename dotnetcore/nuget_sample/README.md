.NET Standard v1.3 NuGet Package for Windows 10 Desktop
===============================

Overview
========

This sample showcases how one might build modules for `Azure IoT Edge` in .NET Standard.

The sample contains:

1. A printer module (C#) that interprets telemetry from sensor and prints its content and properties into Console.
2. A sensor module (C#) that publishes random data to the IoT Edge.
3. The .NET Core `Microsoft.Azure.Devices.Gateway` interface assembly.
4. A sample native (C) IoT Edge executable (gw.exe) file.
5. The native (C) binding layer interfaces for .NET, Java, and NodeJs (C). Which includes `aziotsharedutil.dll`, `dotnet.dll`, `dotnetcore.dll`, `gateway.dll`, `gw.exe`, `identity_map.dll`, `iothub.dll`, `iothub_client.dll`, `iothub_service_client.dll`, `java_module_host.dll`, `logger.dll`, `nanomsg.dll`, `node.dll`, `nodejs_binding.dll`, `simulated_device.dll`, and `serializer.dll`.
6. The `Microsoft.Azure.Devices.Gateway.dll` (C#) which contains the Azure IoT Edge module interface definition.
7. A `module_dev_sample.json` file that is used to configure which module the IoT Edge will use.

Prerequisites
=============
1. Microsoft [Visual Studio 2017](https://docs.microsoft.com/en-us/visualstudio/install/install-visual-studio).
2. Make sure you have [.NET Core SDK](https://www.microsoft.com/net/core#windowscmd) installed.
3. The [Microsoft .NET Framework 4.5](https://www.microsoft.com/en-us/download/details.aspx?id=30653).

How does the data flow through the IoT Edge
===========================================
You can find the diagram for Receiving a message and publishing a message on this flow chart:

![](../../images/flow_chart.png)

Running the sample
==================
1. Build the `NetstandardModuleSample` project (`Ctrl` + `Shift` + `B`).
2. Click on the `NetstandardModuleSample` and press `Alt` + `Enter` to open the `NetstandardModuleSample` properties tab.
3. Click on the `Debug` option on the left hand side of the tab.
4. Update the `Executable` text box with the location and name of the executable to run by typing "**$(OutDir)gw.exe**" as seen in the image below.
5. Update the `Application arguments` text box with the arguments to be supplied the the Executable during execution by typing "**module_dev_sample.json**" as seen in the image below.

    ![](../../images/NetStandard_properties.png)

6. Click the `Start` button in the `Visual Studio 2017` IDE or press the `F5` key.

References
==========
[Azure IoT Edge](https://azure.microsoft.com/campaigns/iot-edge/)