package org.llschall.jtrafficlight.model;

import org.llschall.jtrafficlight.JTrafficLightException;
import org.llschall.jtrafficlight.serial.Port;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;


/**
 * A {@link JTrafficLight} wraps the state of a Light plugged to Arduino
 *
 * <a href="https://github.com/llschall/jtrafficlight/releases/tag/v0.0.1">
 *     Make sure jtrafficlight_ino.zip is deployed on the Arduino Board
 * </a>
 */
public class JTrafficLight {

    final static String VERSION = "0.0.2-SNAPSHOT";

    final Map<Lights, Light> map;

    Port port;

    public static String getVersion() {
        return VERSION;
    }

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

    public void deactivate(Lights light) {
        map.get(light).active = false;
    }

    public void switchMode(LightMode modeR, LightMode modeY, LightMode modeG) {
        switchMode(Lights.Light_234, modeR, modeY, modeG);
    }

    /**
     * @param modeR The desired mode on the red LED
     * @param modeY The desired mode on the yellow LED
     * @param modeG The desired mode on the green LED
     */
    public void switchMode(Lights light, LightMode modeR, LightMode modeY, LightMode modeG) {

        Light light1 = map.get(light);

        if (!light1.active) {
            throw new JTrafficLightException("Cannot switch "+light+" because it has been deactivated");
        }

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

