package com.llschall.jtrafficlight;

import com.llschall.jtrafficlight.model.LightMode;
import com.llschall.jtrafficlight.model.TrafficLight;

public class Demo {

    public static void main(String[] args) {

        TrafficLight trafficLight = new TrafficLight();
        trafficLight.openPort();

        trafficLight.switchMode(LightMode.ON, LightMode.ON,LightMode.ON);
        trafficLight.sendToPort();
        delay(2);
        trafficLight.switchMode(LightMode.ON, LightMode.OFF,LightMode.OFF);
        trafficLight.sendToPort();
        delay(1);
        trafficLight.switchMode(LightMode.OFF, LightMode.ON,LightMode.OFF);
        trafficLight.sendToPort();
        delay(1);
        trafficLight.switchMode(LightMode.OFF, LightMode.OFF,LightMode.ON);
        trafficLight.sendToPort();
        delay(1);
        trafficLight.switchMode(LightMode.ON, LightMode.ON,LightMode.ON);
        trafficLight.sendToPort();

    }

    static void delay(long seconds) {

        try {
            Thread.sleep(1000*seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
