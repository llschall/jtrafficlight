package org.llschall.jtrafficlight;

import org.llschall.jtrafficlight.model.LightMode;
import org.llschall.jtrafficlight.model.JTrafficLight;
import org.llschall.jtrafficlight.model.Lights;

/**
 * A class to check the serial connection
 */
public class LightCheck {

    /**
     * @param args No args supported
     */
    public static void main(String[] args) {

        JTrafficLight trafficLight = new JTrafficLight();

        Lights light = Lights.Light_234;

        System.out.println("***      all on       ***");
        trafficLight.switchMode(light, LightMode.ON, LightMode.ON,LightMode.ON);
        delay();

        System.out.println("***     red only      ***");
        trafficLight.switchMode(light, LightMode.ON, LightMode.OFF,LightMode.OFF);
        delay();

        System.out.println("***    yellow only    ***");
        trafficLight.switchMode(light, LightMode.OFF, LightMode.ON,LightMode.OFF);
        delay();

        System.out.println("***    green only     ***");
        trafficLight.switchMode(light, LightMode.OFF, LightMode.OFF,LightMode.ON);
        delay();

        System.out.println("***   all blinking    ***");
        trafficLight.switchMode(light, LightMode.BLINK_1, LightMode.BLINK_2,LightMode.BLINK_3);
        delay();
        delay();
        trafficLight.switchMode(light, LightMode.BLINK_4, LightMode.BLINK_4,LightMode.BLINK_4);
        delay();
        delay();
        delay();

        System.out.println("***      all off      ***");
        trafficLight.switchMode(light, LightMode.OFF, LightMode.OFF,LightMode.OFF);
        delay();

        System.out.println("***  Check Finished   ***");
    }

    static private void delay() {

        try {
            Thread.sleep(2_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
