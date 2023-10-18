package org.llschall.jtrafficlight.model;

import org.llschall.jtrafficlight.serial.Port;

import java.io.StringWriter;

/**
 * A {@link TrafficLight} wraps the state of a Light plugged to Arduino
 */
public class TrafficLight {

    LightMode modeR;
    LightMode modeY;
    LightMode modeG;

    Port port = null;

    /**
     * Searches and opens the port for the serial communication
     */
    public void openPort() {
        port = new Port();
    }

    /**
     * @param modeR The desired mode on the red LED
     * @param modeY The desired mode on the yellow LED
     * @param modeG The desired mode on the green LED
     */
    public void switchMode(LightMode modeR, LightMode modeY, LightMode modeG) {
        this.modeR = modeR;
        this.modeY = modeY;
        this.modeG = modeG;
        port.sendMessage(encode());
    }

    String encode() {
        StringWriter writer = new StringWriter();
        writer.append("m");
        writer.append(modeR.buildMessage());
        writer.append(modeY.buildMessage());
        writer.append(modeG.buildMessage());

        return writer.toString();
    }
}
