package com.microsoft.azure.gateway;

import java.io.*;
import mockit.*;
import org.junit.*;

import com.microsoft.azure.gateway.core.*;
import com.microsoft.azure.gateway.messaging.*;

public class TimerModuleUnitTest {
    @Test
    public void shouldSendMessagePerSecond(@Mocked(stubOutClassInitialization = true) final Broker broker) throws IOException, InterruptedException {
        final TimerModule module = new TimerModule(0x1L, broker, null);
        new Expectations() {{
            broker.publishMessage(withNotNull(), 0x1L); times = 3;
        }};
        module.start();
        Thread.sleep(2500);
    }

    @Test
    public void shouldPrintMessageWhenReceived(@Mocked final PrintStream out, @Mocked(stubOutClassInitialization = true) final Broker broker) {
        PrintStream originalOut = System.out;
        final TimerModule module = new TimerModule(0x1L, broker, null);
        Message testMessage = new Message("Test Message".getBytes(), null);
        System.setOut(out);
        module.receive(testMessage);
        new Verifications() {{
            out.println(withEqual(testMessage.toString())); times = 1;
        }};
        System.setOut(originalOut);
    }
}
