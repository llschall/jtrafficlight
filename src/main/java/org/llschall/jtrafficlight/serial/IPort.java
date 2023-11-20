package org.llschall.jtrafficlight.serial;

import com.fazecast.jSerialComm.SerialPort;

/**
 * An interface to enable to create Mocks
 */
public interface IPort {

    /**
     * @param message The message to send to the Arduino board
     */
    void sendMessage(String message);
}
