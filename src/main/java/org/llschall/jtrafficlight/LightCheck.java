package org.llschall.jtrafficlight;

import org.llschall.jtrafficlight.model.JTrafficLight;
import org.llschall.jtrafficlight.model.JTrafficSystem;
import org.llschall.jtrafficlight.model.LightMode;

/**
 * A class to check the serial connection
 */
public class LightCheck {

    /**
     * @param args No args supported
     */
    public static void main(String[] args) {

        System.out.println(JTrafficSystem.getInfo());

        JTrafficLight light = JTrafficLight.get();

        System.out.println("***      all on       ***");
        light.switchMode(LightMode.ON, LightMode.ON,LightMode.ON);
        delay();

        System.out.println("***     red only      ***");
        light.switchMode(LightMode.ON, LightMode.OFF,LightMode.OFF);
        delay();

        System.out.println("***    yellow only    ***");
        light.switchMode(LightMode.OFF, LightMode.ON,LightMode.OFF);
        delay();

        System.out.println("***    green only     ***");
        light.switchMode(LightMode.OFF, LightMode.OFF,LightMode.ON);
        delay();

        System.out.println("***   all blinking    ***");
        light.switchMode(LightMode.BLINK_2, LightMode.BLINK_3,LightMode.BLINK_4);
        delay();
        delay();
        delay();
        delay();
        delay();

        System.out.println("***      all off      ***");
        light.switchMode(LightMode.OFF, LightMode.OFF,LightMode.OFF);
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
