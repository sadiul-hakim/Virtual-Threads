package org.javase;

import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.zone.ZoneOffsetTransition;

public class Main {

    public static void main(String[] args) throws UnknownHostException {

        var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a");

        LocalDateTime localDateTime = LocalDateTime.of(2024, 1, 1, 0, 0);

        ZoneOffsetTransition zoneOffsetTransition = ZoneOffsetTransition.of(localDateTime,ZoneOffset.of("+6"), ZoneOffset.of("+5"));
        LocalDateTime before = zoneOffsetTransition.getDateTimeBefore();
        LocalDateTime after = zoneOffsetTransition.getDateTimeAfter();

        System.out.println(formatter.format(before));
        System.out.println(formatter.format(after));

        System.out.println(ZoneOffset.of("+6"));
    }
}

 