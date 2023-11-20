package org.llschall.jtrafficlight.model;

import org.llschall.jtrafficlight.serial.IPort;
import org.llschall.jtrafficlight.serial.Port;
import org.llschall.jtrafficlight.serial.PortProvider;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * A {@link JTrafficLight} wraps the state of a Light plugged to Arduino
 * <a href="https://github.com/llschall/jtrafficlight/releases/tag/v1.0.1">
 *     Make sure jtrafficlight_ino.zip is deployed on the Arduino Board
 * </a>
 */
public class JTrafficLight {
    final static String VERSION = "1.0.1";
    final static Map<Lights, Light> map;
    static final IPort port;

    static {
        map = new HashMap<>();
        for (Lights value : Lights.values()) {
            map.put(value, new Light());
        }

        port = PortProvider.get().provide();
    }

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

    public static Light get() {
        return get(Lights.Light_234);
    }

    public static Light get(Lights light) {
        return map.get(light);
    }

    static String encode() {
        StringWriter writer = new StringWriter();
        writer.append("m");
        for (Lights light : Lights.values()) {
            Light light1 = get(light);
            writer.append(light1.modeR.buildMsg());
            writer.append(light1.modeY.buildMsg());
            writer.append(light1.modeG.buildMsg());
        }
        return writer.toString();
    }

    static void fireUpdate() {
        port.sendMessage(encode());
    }

}

