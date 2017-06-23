using System;
using Newtonsoft.Json;

namespace IoTEdgeConverterModule
{
    public class BleData
    {
        [JsonProperty(PropertyName = "temperature")]
        public string Temperature { get; set; }
    }
}