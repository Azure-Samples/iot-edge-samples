package com.microsoft.azure.gateway;

import java.util.*;
import com.microsoft.azure.gateway.core.*;
import com.microsoft.azure.gateway.messaging.*;

public class TimerModule extends GatewayModule {
    public TimerModule(long address, Broker broker, String configuration) {
        super(address, broker, configuration);
        System.out.println("*************************************************");
        System.out.println("** Timer Module Started, Press <Enter> to Exit **");
        System.out.println("*************************************************");
    }

    @Override
    public void start() {
        new Timer(true).schedule(new TimerTask() {
            @Override
            public void run() {
                // This method will be called every second
                Message m = new Message(new Date().toString().getBytes(), null);
                try {
                    TimerModule.this.publish(m);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 0, 1000);
    }

    @Override
    public void receive(Message message) {
        System.out.println(message.toString());
    }

    @Override
    public void destroy() {
        // Since the time in start() is a daemon, the process will automatically
        // cancel it. Therefore we don't need to terminate the timer here.
    }
}
