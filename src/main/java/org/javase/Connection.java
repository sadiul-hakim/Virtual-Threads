package org.javase;

public interface Connection {
    static void connect() {
        connectToDB();
        System.out.println("Connecting....");
    }

    private static void connectToDB() {
        System.out.println("Connecting to db....");
    }

    void connectV2();

    default void close() {
        System.out.println("Closing...");
        closeDB();
    }

    private void closeDB() {
        System.out.println("Closing DB");
    }
}