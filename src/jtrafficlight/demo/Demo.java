package jtrafficlight.demo;

import jtrafficlight.model.LightMode;
import jtrafficlight.model.TrafficLight;

public class Demo {

    public static void main(String[] args) {

        TrafficLight trafficLight = new TrafficLight();

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
