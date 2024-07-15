package org.javase;

import java.util.concurrent.TimeUnit;

public class IOOperation {
    public static void main(String[] args) {


        int db = fetchDataFromDB();
        int ser1 = fetchDataFromService1();
        int ser2 = fetchDataFromService2();

        System.out.println(db+ser1+ser2);

    }

    private static int fetchDataFromDB() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception ignore) {
        }

        return 10;
    }

    private static int fetchDataFromService1() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception ignore) {
        }

        return 5;
    }

    private static int fetchDataFromService2() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception ignore) {
        }

        return 15;
    }
}
