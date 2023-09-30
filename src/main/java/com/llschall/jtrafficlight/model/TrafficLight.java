package com.llschall.jtrafficlight.model;

import main.java.com.llschall.jtrafficlight.serial.Port;

import java.io.StringWriter;

public class TrafficLight {

    Port port = new Port();

    public void switchMode(LightMode modeR, LightMode modeY, LightMode modeG) {
        StringWriter writer = new StringWriter();
        writer.append("m");
        writer.append(modeR.buildMessage());
        writer.append(modeY.buildMessage());
        writer.append(modeG.buildMessage());
        port.sendMessage(writer.toString());
    }
}
