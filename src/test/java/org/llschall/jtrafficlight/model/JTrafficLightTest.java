package org.llschall.jtrafficlight.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.llschall.jtrafficlight.serial.SerialMock;

public class JTrafficLightTest {

    @BeforeAll
    public static void mock() {
        SerialMock.mock();
    }

    @BeforeEach
    public void beforeEach() {
        JTrafficSystem.get().switchAll(LightMode.OFF);
    }

    @Test
    public void testAllOn() {
        JTrafficLight.Light_234.switchMode(LightMode.ON, LightMode.ON, LightMode.ON);
        Assertions.assertEquals("m888000000", JTrafficSystem.get().encode());
        JTrafficLight.Light_567.switchMode(LightMode.ON, LightMode.ON, LightMode.ON);
        Assertions.assertEquals("m888888000", JTrafficSystem.get().encode());
        JTrafficSystem.get().switchAll(LightMode.ON);
        Assertions.assertEquals("m888888888", JTrafficSystem.get().encode());
    }

    @Test
    public void testBlinking() {

        JTrafficLight.Light_234.switchMode(LightMode.BLINK_5, LightMode.ON, LightMode.BLINK_4);
        Assertions.assertEquals("m584000000", JTrafficSystem.get().encode());
        JTrafficLight.Light_567.switchMode(LightMode.ON, LightMode.BLINK_2, LightMode.ON);
        Assertions.assertEquals("m584828000", JTrafficSystem.get().encode());
    }

}
