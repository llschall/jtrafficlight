package org.llschall.jtrafficlight.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JTrafficLightTest {

    @Test
    public void testVersion() {
        Assertions.assertEquals(JTrafficLight.VERSION, JTrafficLight.getVersion());
    }

    @Test
    public void testAllOn() {

        JTrafficLight light = new JTrafficLight(null);

        light.switchMode(LightMode.ON, LightMode.ON, LightMode.ON);
        Assertions.assertEquals("m888000000", light.encode());

        light.switchMode(Lights.Light_567, LightMode.ON, LightMode.ON, LightMode.ON);
        Assertions.assertEquals("m888888000", light.encode());
    }

    @Test
    public void testBlinking() {

        JTrafficLight light = new JTrafficLight(null);

        light.switchMode(LightMode.BLINK_5, LightMode.ON, LightMode.BLINK_4);
        Assertions.assertEquals("m584000000", light.encode());

        light.switchMode(Lights.Light_567, LightMode.ON, LightMode.BLINK_2, LightMode.ON);
        Assertions.assertEquals("m584828000", light.encode());
    }

}
