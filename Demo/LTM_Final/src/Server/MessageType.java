package Server;

import Client.*;

public enum MessageType {
    TEXT(1), FILE(2);

    private final int value;

    public int getValue() {
        return value;
    }

    private MessageType(int value) {
        this.value = value;
    }

    public static MessageType toMessageType(int value) {
        if (value == 1) {
            return TEXT;
        } else {
            return FILE;
        }
    }
}
