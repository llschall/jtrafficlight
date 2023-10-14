package org.llschall.jtrafficlight.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TrafficLightTest {

    @Test
    public void testAllOn() {

        TrafficLight light = new TrafficLight();
        light.modeR = LightMode.ON;
        light.modeG = LightMode.ON;
        light.modeY = LightMode.ON;
        String message = light.encode();
        Assertions.assertEquals("m999", message);
    }

}
