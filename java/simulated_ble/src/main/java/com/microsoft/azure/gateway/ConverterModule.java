package com.microsoft.azure.gateway;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import com.microsoft.azure.gateway.core.Broker;
import com.microsoft.azure.gateway.core.GatewayModule;
import com.microsoft.azure.gateway.messaging.Message;

public class ConverterModule extends GatewayModule {
    private int messageCount = 0;

    public ConverterModule(long address, Broker broker, String configuration) {
        super(address, broker, configuration);
    }

    @Override
    public void receive(Message message) {
        try {
            JSONObject messageFromBle = new JSONObject(new String(message.getContent()));
            double temperature = messageFromBle.getDouble("temperature");
            Map<String, String> inputProperties = message.getProperties();

            HashMap<String, String> properties = new HashMap<>();
            properties.put("source", inputProperties.get("source"));
            properties.put("macAddress", inputProperties.get("macAddress"));
            properties.put("temperatureAlert", temperature > 30 ? "true" : "false");

            String content = String.format(
                "{ \"deviceId\": \"Intel NUC Gateway\", \"messageId\": %d, \"temperature\": %f }",
                ++this.messageCount, temperature);

            this.publish(new Message(content.getBytes(), properties));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void destroy() { /* Nop. */ }
}
