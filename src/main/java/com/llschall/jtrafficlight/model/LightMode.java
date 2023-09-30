package main.java.com.llschall.jtrafficlight.model;

public enum LightMode {

    OFF(0),
    ON(9);

    final int value;

    LightMode(int value) {
        this.value = value;
    }

    String buildMessage() {
        return Integer.toString(value);
    }
}
