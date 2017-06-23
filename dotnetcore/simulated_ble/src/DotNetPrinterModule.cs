using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Microsoft.Azure.Devices.Gateway;
using Newtonsoft.Json;

namespace PrinterModule
{
    public class DotNetPrinterModule : IGatewayModule
    {
        private string configuration;
        public void Create(Broker broker, byte[] configuration)
        {
            this.configuration = System.Text.Encoding.UTF8.GetString(configuration);
        }

        public void Destroy()
        {
        }

        public void Receive(Message received_message)
        {
            string recMsg = System.Text.Encoding.UTF8.GetString(received_message.Content, 0, received_message.Content.Length);
            Dictionary<string, string> receivedProperties = received_message.Properties;
            
            BleConverterData receivedData = JsonConvert.DeserializeObject<BleConverterData>(recMsg);

            Console.WriteLine();
            Console.WriteLine("Module           : [DotNetPrinterModule]");
            Console.WriteLine("received_message : {0}", recMsg);

            if(received_message.Properties["source"] == "bleTelemetry")
            {
                Console.WriteLine("Source           : {0}", receivedProperties["source"]);
                Console.WriteLine("MAC address      : {0}", receivedProperties["macAddress"]);
                Console.WriteLine("Temperature Alert: {0}", receivedProperties["temperatureAlert"]);
                Console.WriteLine("Deserialized Obj : [BleConverterData]");
                Console.WriteLine("  DeviceId       : {0}", receivedData.DeviceId);
                Console.WriteLine("  MessageId      : {0}", receivedData.MessageId);
                Console.WriteLine("  Temperature    : {0}", receivedData.Temperature);
            }

            Console.WriteLine();
        }
    }
}