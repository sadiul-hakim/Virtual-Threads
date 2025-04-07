package org.javase;

import com.sun.management.OperatingSystemMXBean;

import java.lang.management.ManagementFactory;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class ResourceMonitorer {
    public static void main(String[] args) {
        var bean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a z");

        while (true) {
            System.out.println(ZonedDateTime.now().format(formatter));
            System.out.println("Name :: "+bean.getName());
            System.out.println("Arch :: "+bean.getArch());
            System.out.println("Version :: "+bean.getVersion());
            System.out.println("Available Processors :: "+bean.getAvailableProcessors());
            System.out.println("System Load Average :: "+bean.getSystemLoadAverage());
            System.out.println("Committed Virtual Memory :: "+bean.getCommittedVirtualMemorySize());
            System.out.println("Cpu Load :: "+bean.getCpuLoad());
            System.out.println("Free Memory Size :: "+bean.getFreeMemorySize());
            System.out.println("Free Swap Space Size :: "+bean.getFreeSwapSpaceSize());
            System.out.println("Process CPU Load :: "+bean.getProcessCpuLoad());
            System.out.println("Process CPU Time :: "+bean.getProcessCpuTime());
            System.out.println("Total Memory Size :: "+bean.getTotalMemorySize());
            System.out.println("Total Swap Memory Size :: "+bean.getTotalSwapSpaceSize());
            System.out.println("+----------------------------+----------------------------+");

            try{
                TimeUnit.SECONDS.sleep(5);
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}
