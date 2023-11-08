package org.llschall.jtrafficlight.model;

/**
 * A {@link LightMode} reflects the current behavior of the LED
 */
public enum LightMode {

    /**
     * The LED is switched off
     */
    OFF(0),
    /**
     * The LED is switched on
     */
    ON(8),

    /**
     * The fastest blinking speed
     */
    BLINK_1(1),
    /**
     * 2 times slower than BLINK_1
     */
    BLINK_2(2),
    /**
     * 2 times slower than BLINK_2
     */
    BLINK_3(3),
    /**
     * 2 times slower than BLINK_3
     */
    BLINK_4(4),
    /**
     * 2 times slower than BLINK_4
     */
    BLINK_5(5);

    final int value;

    LightMode(int value) {
        this.value = value;
    }

    String buildMsg() {
        return Integer.toString(value);
    }
}
