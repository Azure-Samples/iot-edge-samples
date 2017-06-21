using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using Microsoft.Azure.Devices.Gateway;
using Newtonsoft.Json;

namespace IoTEdgeConverterModule
{
    public class BleConverterModule : IGatewayModule, IGatewayModuleStart
    {
        private Broker broker;
        private string configuration;
        private int messageCount;

        public void Create(Broker broker, byte[] configuration)
        {
            this.broker = broker;
            this.configuration = System.Text.Encoding.UTF8.GetString(configuration);
        }

        public void Start()
        {
        }

        public void Destroy()
        {
        }

        public void Receive(Message received_message)
        {
            string recMsg = Encoding.UTF8.GetString(received_message.Content, 0, received_message.Content.Length);
            BleData receivedData = JsonConvert.DeserializeObject<BleData>(recMsg);

            float temperature = float.Parse(receivedData.Temperature, CultureInfo.InvariantCulture.NumberFormat); 
            Dictionary<string, string> receivedProperties = received_message.Properties;
            
            Dictionary<string, string> properties = new Dictionary<string, string>();
            properties.Add("source", receivedProperties["source"]);
            properties.Add("macAddress", receivedProperties["macAddress"]);
            properties.Add("temperatureAlert", temperature > 30 ? "true" : "false");

            String content = String.Format("{0} \"deviceId\": \"Intel NUC Gateway\", \"messageId\": {1}, \"temperature\": {2} {3}", "{", ++this.messageCount, temperature, "}");
            Message messageToPublish = new Message(content, properties);

            this.broker.Publish(messageToPublish);
        }
    }
}