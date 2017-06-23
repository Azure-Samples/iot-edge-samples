// Copyright (c) Microsoft. All rights reserved.
// Licensed under the MIT license. See LICENSE file in the project root for full license information.
using System;
using System.Text;
using Microsoft.Azure.Devices.Gateway;

namespace NetstandardModuleSample
{
  public class SampleModule : IGatewayModule
  {
    private string configuration;
    public void Create(Broker broker, byte[] configuration)
    {
      this.configuration = Encoding.UTF8.GetString(configuration);
    }

    public void Destroy()
    {
    }

    public void Receive(Message received_message)
    {
      if (received_message.Properties["source"] == "sensor")
      {
        Console.WriteLine("SampleModule received message from Sensor. Content: {0}", Encoding.UTF8.GetString(received_message.Content, 0, received_message.Content.Length));
      }
    }
  }
}
