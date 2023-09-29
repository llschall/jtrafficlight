package jtrafficlight.serial;

import com.fazecast.jSerialComm.SerialPort;

public class Port {

    SerialPort commPort;

    public Port() {
        for (SerialPort port : SerialPort.getCommPorts()) {
            String name = port.getSystemPortPath();
            if (name.startsWith("/dev/ttyUSB")) {
                commPort = port;
                System.out.println("Port [" + name + "] detected");
                boolean b = commPort.openPort();
                if (!b) {
                    System.err.println("Port cannot be opened");
                    System.exit(0);
                }
                Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                  commPort.closePort();
                    System.out.println("Port closed");
                }));
                return;
            }
        }
    }

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
