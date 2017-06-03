package com.microsoft.azure.gateway;

import java.util.HashMap;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import org.json.JSONObject;

import com.microsoft.azure.gateway.core.Broker;
import com.microsoft.azure.gateway.core.GatewayModule;
import com.microsoft.azure.gateway.messaging.Message;

public class SimulatedBleModule extends GatewayModule {
    private String macAddress;
    private int messagePeriod = 1000;

    public SimulatedBleModule(long address, Broker broker, String configuration) {
        super(address, broker, configuration);
        JSONObject bleConfig = new JSONObject(configuration);
        this.macAddress = bleConfig.getString("macAddress");
        this.messagePeriod = bleConfig.getInt("messagePeriod");

        System.out.println("*********************************************************");
        System.out.println("** Simulated BLE Module Started, Press <Enter> to Exit **");
        System.out.println("*********************************************************");
    }

    @Override
    public void start() {
        new Timer(true).schedule(new TimerTask() {
            private Random rand = new Random();

            @Override
            public void run() {
                try {
                    HashMap<String, String> properties = new HashMap<>();
                    properties.put("source", "bleTelemetry");
                    properties.put("macAddress", SimulatedBleModule.this.macAddress);

                    float temperature = this.rand.nextFloat() * 20 + 20;
                    byte[] content = Float.toString(temperature).getBytes();

                    SimulatedBleModule.this.publish(new Message(content, properties));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 0, this.messagePeriod);
    }

    @Override
    public void receive(Message message) { /* Noop */ }

    @Override
    public void destroy() { /* Noop */ }
}
