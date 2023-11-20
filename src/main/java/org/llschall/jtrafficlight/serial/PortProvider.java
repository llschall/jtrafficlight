package org.llschall.jtrafficlight.serial;

/**
 * A {@link PortProvider} provides the {@link Port} for the serial communication
 * with the Arduino board.
 */
public class PortProvider {

    private static boolean mock;

    static PortProvider INSTANCE = new PortProvider();

    Port port;

    // For testing purpose only
    static void mock() {
        mock = true;
    }

    /**
     * @return the {@link PortProvider} of the runtime
     */
    public static PortProvider get() {
        if (mock) {
            return new PortProviderMock();
        }
        return INSTANCE;
    }

    /**
     * @return the {@link Port} of the runtime
     */
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
        return message -> {
            // do nothing
        };
    }
}
