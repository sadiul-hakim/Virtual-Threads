package org.javase;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openjdk.jmh.runner.RunnerException;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws RunnerException, JsonProcessingException {

        Map<String, String> errorMessage = new HashMap<String, String>() {{
            put("error", "Failed to parse request body. " );
            put("details", "");
        }};

        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(errorMessage);
        System.out.println(s.contains("error"));
    }
}

