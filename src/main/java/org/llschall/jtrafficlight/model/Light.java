package org.llschall.jtrafficlight.model;

import java.io.StringWriter;

class Light {

    boolean active = true;

    LightMode modeR = LightMode.OFF;
    LightMode modeY = LightMode.OFF;
    LightMode modeG = LightMode.OFF;

    String buildMsg() {
        if (!active) {
            return "999";
        }
        StringWriter writer = new StringWriter();
        writer.append(modeR.buildMsg());
        writer.append(modeY.buildMsg());
        writer.append(modeG.buildMsg());
        return writer.toString();
    }
}
