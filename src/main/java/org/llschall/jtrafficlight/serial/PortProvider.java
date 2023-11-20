package org.llschall.jtrafficlight.serial;

public class PortProvider {

    private static boolean mock;

    static PortProvider INSTANCE = new PortProvider();

    Port port;

    // For testing purpose only
    static void mock() {
        mock = true;
    }

    public static PortProvider get() {
        if (mock) {
            return new PortProviderMock();
        }
        return INSTANCE;
    }

    public IPort provide() {
        if (port == null) {
            port = new Port();
        }
        return port;
    }
}

// For testing purpose only
class PortProviderMock extends PortProvider {
    @Override
    public IPort provide() {
        return new IPort() {
            @Override
            public void sendMessage(String message) {
                // do nothing
            }
        };
    }
}
