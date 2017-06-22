package com.microsoft.azure.gateway;

import com.microsoft.azure.gateway.core.Broker;
import com.microsoft.azure.gateway.core.GatewayModule;
import com.microsoft.azure.gateway.messaging.Message;

public class PrinterModule extends GatewayModule {
    public PrinterModule(long address, Broker broker, String configuration) {
        super(address, broker, configuration);
    }

    @Override
    public void receive(Message message) {
        System.out.println(message.toString());
        System.out.println();
    }

    @Override
    public void destroy() { /* Noop */ }
}
