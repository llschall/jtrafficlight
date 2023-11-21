package org.llschall.jtrafficlight.model;

/**
 * An instance of this enum represents a traffic light connected to the Arduino board
 */
public enum JTrafficLight {

    /**
     * The traffic light connected to the pins 2,3,4
     */
    Light_234, // pins 2,3,4

    /**
     * The traffic light connected to the pins 5,6,7
     */
    Light_567, // pins 5,6,7
    /**
     * The traffic light connected to the pins 8,9,10
     */
    Light_89X; // pins 8,9,10

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
        JTrafficSystem.get().fireUpdate();
    }

    /**
     * @return The default light, that might be enough for basic projects
     */
    public static JTrafficLight get() {
        return Light_234;
    }

}
