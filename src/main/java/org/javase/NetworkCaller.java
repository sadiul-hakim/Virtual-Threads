package org.javase;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

public class NetworkCaller {
    private final String callName;

    public NetworkCaller(String callName) {
        this.callName = callName;
    }

    public String makeCall(int sec) throws URISyntaxException {
        System.out.println(callName + " : BEG call : " + Thread.currentThread());

        URI uri = new URI("https://httpbin.org/delay/" + sec);
        try (InputStream is = uri.toURL().openStream()) {
            return new String(is.readAllBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println(callName + " : END call : " + Thread.currentThread());
        }
    }

}
