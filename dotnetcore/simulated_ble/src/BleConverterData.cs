using System;
using Newtonsoft.Json;

namespace PrinterModule
{
    public class BleConverterData
    {
        [JsonProperty(PropertyName = "deviceId")]
        public string DeviceId { get; set; }

        [JsonProperty(PropertyName = "messageId")]
        public string MessageId { get; set; }

        [JsonProperty(PropertyName = "temperature")]
        public string Temperature { get; set; }
    }
}