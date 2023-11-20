package org.llschall.jtrafficlight.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.llschall.jtrafficlight.serial.PortProvider;
import org.llschall.jtrafficlight.serial.SerialMock;

public class JTrafficLightTest {

    @BeforeAll
    public static void mock() {
        SerialMock.mock();
    }

    @Test
    public void testVersion() {
        Assertions.assertEquals(JTrafficLight.VERSION, JTrafficLight.getVersion());
    }

    @Test
    public void testAllOn() {

        JTrafficLight.get().switchMode(LightMode.ON, LightMode.ON, LightMode.ON);
        JTrafficLight.get(Lights.Light_567).switchMode(LightMode.ON, LightMode.ON, LightMode.ON);
        Assertions.assertEquals("m888888000", JTrafficLight.encode());
    }

    @Test
    public void testBlinking() {

        JTrafficLight.get().switchMode(LightMode.BLINK_5, LightMode.ON, LightMode.BLINK_4);
        JTrafficLight.get(Lights.Light_567).switchMode(LightMode.ON, LightMode.BLINK_2, LightMode.ON);
        Assertions.assertEquals("m584828000", JTrafficLight.encode());
    }

}
