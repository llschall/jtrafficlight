package org.llschall.jtrafficlight.model;

import java.io.StringWriter;

class Light {

    LightMode modeR = LightMode.OFF;
    LightMode modeY = LightMode.OFF;
    LightMode modeG = LightMode.OFF;

    String buildMsg() {
        StringWriter writer = new StringWriter();
        writer.append(modeR.buildMsg());
        writer.append(modeY.buildMsg());
        writer.append(modeG.buildMsg());
        return writer.toString();
    }
}
