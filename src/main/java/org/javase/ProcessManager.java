package org.javase;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ProcessManager {
    public static void main(String[] args) {
        try {
            // Execute tasklist command to get process details
            Process process = Runtime.getRuntime().exec("tasklist /FO CSV /NH");  // /FO CSV outputs as CSV format
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            // Read each line of the output
            String line;
            while ((line = reader.readLine()) != null) {
                // Each line contains process details (PID, image name, memory usage)
                String[] processDetails = line.split("\",\""); // Split CSV columns

                // Example columns in tasklist CSV: ImageName, PID, SessionName, Session#, MemUsage
                String processName = processDetails[0].replace("\"", ""); // Process name
                String pid = processDetails[1].replace("\"", ""); // PID
                String memoryUsage = processDetails[4].replace("\"", ""); // Memory usage

                // Print out process info
                System.out.printf("PID: %s, Name: %s, Memory: %s%n", pid, processName, memoryUsage);
            }

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
