package org.llschall.jtrafficlight;

import org.llschall.jtrafficlight.model.JTrafficLight;
import org.llschall.jtrafficlight.model.LightMode;

/**
 * A class to check the serial connection
 */
public class LightCheck {

    /**
     * @param args No args supported
     */
    public static void main(String[] args) {

        System.out.println(JTrafficLight.getInfo());

        JTrafficLight trafficLight = new JTrafficLight();

        System.out.println("***      all on       ***");
        trafficLight.switchMode(LightMode.ON, LightMode.ON,LightMode.ON);
        delay();

        System.out.println("***     red only      ***");
        trafficLight.switchMode(LightMode.ON, LightMode.OFF,LightMode.OFF);
        delay();

        System.out.println("***    yellow only    ***");
        trafficLight.switchMode(LightMode.OFF, LightMode.ON,LightMode.OFF);
        delay();

        System.out.println("***    green only     ***");
        trafficLight.switchMode(LightMode.OFF, LightMode.OFF,LightMode.ON);
        delay();

        System.out.println("***   all blinking    ***");
        trafficLight.switchMode(LightMode.BLINK_1, LightMode.BLINK_2,LightMode.BLINK_3);
        delay();
        delay();
        trafficLight.switchMode(LightMode.BLINK_4, LightMode.BLINK_4,LightMode.BLINK_4);
        delay();
        delay();
        delay();

        System.out.println("***      all off      ***");
        trafficLight.switchMode(LightMode.OFF, LightMode.OFF,LightMode.OFF);
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
