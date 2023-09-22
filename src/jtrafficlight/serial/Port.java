package jtrafficlight.serial;

import com.fazecast.jSerialComm.SerialPort;

public class PortTest {

    public Port() {
        for (SerialPort port : SerialPort.getCommPorts()) {
            System.out.println(port.getSystemPortName());
        }

    }
}
