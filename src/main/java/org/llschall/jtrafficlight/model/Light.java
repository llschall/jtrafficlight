package org.llschall.jtrafficlight.model;

import org.llschall.jtrafficlight.serial.Port;
import org.llschall.jtrafficlight.serial.PortProvider;

import java.io.StringWriter;

/**
 * A {@link Light} represents a physical light (3 leds) plugged to the Arduino board
 */
public class Light {
    LightMode modeR = LightMode.OFF;
    LightMode modeY = LightMode.OFF;
    LightMode modeG = LightMode.OFF;

    /**
     * @param modeR The desired mode of the Red light
     * @param modeY The desired mode of the Yellow light
     * @param modeG The desired mode of the Green light
     */
    public void switchMode(LightMode modeR, LightMode modeY, LightMode modeG) {

        this.modeR = modeR;
        this.modeY = modeY;
        this.modeG = modeG;

        JTrafficLight.fireUpdate();
    }

}
