package org.llschall.jtrafficlight.serial;

import com.fazecast.jSerialComm.SerialPort;

public interface IPort {

    void sendMessage(String message);
}
