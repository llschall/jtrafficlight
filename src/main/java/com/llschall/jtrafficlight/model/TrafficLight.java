package com.llschall.jtrafficlight.model;

import main.java.com.llschall.jtrafficlight.serial.Port;

import java.io.StringWriter;

public class TrafficLight {

    LightMode modeR;
    LightMode modeY;
    LightMode modeG;

    Port port = null;

    public void openPort() {
        port = new Port();
    }

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
