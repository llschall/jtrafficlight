package org.llschall.jtrafficlight.model;

import org.llschall.jtrafficlight.serial.IPort;
import org.llschall.jtrafficlight.serial.PortProvider;

import java.io.StringWriter;

/**
 * A {@link JTrafficSystem} wraps the state of a Light plugged to Arduino
 * <a href="https://github.com/llschall/jtrafficlight/releases/tag/v1.0.2">
 *     Make sure jtrafficlight_ino.zip is deployed on the Arduino Board
 * </a>
 */
public class JTrafficSystem {
    /**
     * The version of the JTrafficLight library
     */
    public final static String VERSION = "1.0.2";
    final IPort port;
    static final JTrafficSystem INSTANCE = new JTrafficSystem();
    private JTrafficSystem() {
        port = PortProvider.get().provide();
    }

    /**
     * @return The JTrafficSystem instance in read only access
     */
    public static JTrafficSystem get() {
        return INSTANCE;
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
     * Switches all leds of all lights to the given mode
     *
     * @param mode The mode to apply to all leds
     */
    public void switchAll(LightMode mode) {
        for (JTrafficLight light : JTrafficLight.values()) {
            light.switchMode(mode, mode, mode);
        }
    }

    String encode() {
        StringWriter writer = new StringWriter();
        writer.append("m");
        for (JTrafficLight light : JTrafficLight.values()) {
            writer.append(light.modeR.buildMsg());
            writer.append(light.modeY.buildMsg());
            writer.append(light.modeG.buildMsg());
        }
        return writer.toString();
    }

    void fireUpdate() {
        port.sendMessage(encode());
    }

}

