package org.llschall.jtrafficlight;

import org.llschall.jtrafficlight.model.LightMode;
import org.llschall.jtrafficlight.model.TrafficLight;

public class Demo {

    public static void main(String[] args) {

        TrafficLight trafficLight = new TrafficLight();
        trafficLight.openPort();

        trafficLight.switchMode(LightMode.ON, LightMode.ON,LightMode.ON);
        delay(2);
        trafficLight.switchMode(LightMode.ON, LightMode.OFF,LightMode.OFF);
        delay(1);
        trafficLight.switchMode(LightMode.OFF, LightMode.ON,LightMode.OFF);
        delay(1);
        trafficLight.switchMode(LightMode.OFF, LightMode.OFF,LightMode.ON);
        delay(1);
        trafficLight.switchMode(LightMode.ON, LightMode.ON,LightMode.ON);
    }

    static void delay(long seconds) {

        try {
            Thread.sleep(1000*seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
