package com.llschall.jtrafficlight.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TrafficLightTest {

    @Test
    public void testTrue() {

        TrafficLight light = new TrafficLight();
        light.switchMode(LightMode.ON, LightMode.ON, LightMode.ON);
        String message = light.encode();
        Assertions.assertEquals("m999", message);
    }

}
