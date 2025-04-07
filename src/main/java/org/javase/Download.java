package org.javase;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;

public class Download {
    public static void main(String[] args) throws IOException {
        URL url = URI.create("https://diana45.oceansaver.in/pacific/?lT4CE6jpHSeZPUUB9EhXP7X").toURL();
        URLConnection urlConnection = url.openConnection();
        urlConnection.connect();

        InputStream is = urlConnection.getInputStream();
        Path path = Path.of("f://java-nio.mp4");
        Files.copy(is, path);
        System.out.println("Done");
    }
}
