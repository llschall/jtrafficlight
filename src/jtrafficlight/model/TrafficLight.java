package jtrafficlight.model;

import jtrafficlight.serial.Port;

import java.io.StringWriter;

public class TrafficLight {


    LightMode modeR = LightMode.ON;
    LightMode modeY = LightMode.ON;
    LightMode modeG = LightMode.ON;


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
