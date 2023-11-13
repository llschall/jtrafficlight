package org.llschall.jtrafficlight.model;

import org.llschall.jtrafficlight.serial.Port;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;


/**
 * A {@link JTrafficLight} wraps the state of a Light plugged to Arduino
 * <a href="https://github.com/llschall/jtrafficlight/releases/tag/v0.0.6">
 *     Make sure jtrafficlight_ino.zip is deployed on the Arduino Board
 * </a>
 */
public class JTrafficLight {

    final static String VERSION = "0.0.6";

    final Map<Lights, Light> map;

    final Port port;

    /**
     * @return The jtrafficlight library version
     */
    public static String getVersion() {
        return VERSION;
    }

    /**
     * @return Information related to the deployment and perhaps more in the future.
     */
    public static String getInfo() {
        return "The files to upload to the Arduino board are available in the jtrafficlight_ino.zip file.\n" +
                "The jtrafficlight_ino.zip is available here:\n" +
                "https://github.com/llschall/jtrafficlight/releases/tag/v"+VERSION;
    }

    /**
     * Main entry point of the JTrafficLight API
     */
    public JTrafficLight() {
        this(new Port());
    }

    JTrafficLight(Port port) {
        map = new HashMap<>();
        for (Lights value : Lights.values()) {
            map.put(value, new Light());
        }

        this.port = port;
    }

    /**
     * @param modeR The desired mode of the Red light
     * @param modeY The desired mode of the Yellow light
     * @param modeG The desired mode of the Green light
     */
    public void switchMode(LightMode modeR, LightMode modeY, LightMode modeG) {
        switchMode(Lights.Light_234, modeR, modeY, modeG);
    }

    /**
     * @param light The light to switch
     * @param modeR The desired mode on the red LED
     * @param modeY The desired mode on the yellow LED
     * @param modeG The desired mode on the green LED
     */
    public void switchMode(Lights light, LightMode modeR, LightMode modeY, LightMode modeG) {

        Light light1 = map.get(light);

        light1.modeR = modeR;
        light1.modeY = modeY;
        light1.modeG = modeG;

        if (port != null) {
            port.sendMessage(encode());
        }
    }

    String encode() {
        StringWriter writer = new StringWriter();
        writer.append("m");
        for (Lights light : Lights.values()) {
            Light light1 = map.get(light);
            writer.append(light1.buildMsg());
        }
        return writer.toString();
    }
}

