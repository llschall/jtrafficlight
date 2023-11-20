package org.llschall.jtrafficlight.serial;

import com.fazecast.jSerialComm.SerialPort;

/**
 * A {@link Port} takes care of the serial connection and communication
 */
public class Port implements IPort {

    // The port of the jSerialComm framework
    final SerialPort commPort;

    /**
     * Searches and opens the port for the serial communication
     * Also installs a shutdown hook to ensure the port is closed when the JVM exits
     */
    public Port() {

        System.out.println("*** Check Serial Port ***");
        commPort = scanPort(SerialPort.getCommPorts());

        if (commPort == null) {
            System.err.println("No port was found.");
            System.exit(0);
        }

        String name = commPort.getSystemPortName();
        System.out.println("Port [" + name + "] detected");
        boolean b = commPort.openPort();
        if (!b) {
            System.err.println("Port "+commPort.getSystemPortPath()+" cannot be opened");
            System.exit(-1);
        }

        try {
            Thread.sleep(2_000); // The card might reboot after the new connection
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Port [" + name + "] ready");

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            commPort.closePort();
            System.out.println("Port closed");
        }));
    }

    private SerialPort scanPort(SerialPort[] ports) {
        for (SerialPort port : ports) {
            String desc = port.getDescriptivePortName();
            if (desc.contains("CH340") || desc.contains("USB")) {
                return port;
            }

            String name = port.getSystemPortPath();
            if (name.startsWith("/dev/ttyUSB")) {
                return port;
            }
        }
        return null;
    }

    /**
     * @param message The message to be sent to the Arduino board
     */
    public void sendMessage(String message) {
        char[] chars = message.toCharArray();
        byte[] bytes = new byte[chars.length+1];
        for (int i = 0; i < chars.length; i++) {
            bytes[i] = (byte) chars[i];
        }
        commPort.writeBytes(bytes, bytes.length);
        commPort.flushIOBuffers();
    }

}
