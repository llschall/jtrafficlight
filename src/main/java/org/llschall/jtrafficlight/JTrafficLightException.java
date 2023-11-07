package org.llschall.jtrafficlight;

/**
 * The specific {@link Exception} of the JTrafficLight library.
 * Can be thrown for various reasons.
 */
public class JTrafficLightException extends RuntimeException {

    /**
     * @param message The exception message
     */
    public JTrafficLightException(String message) {
        super(message);
    }
}
