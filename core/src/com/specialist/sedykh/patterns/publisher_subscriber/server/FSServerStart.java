package com.specialist.sedykh.patterns.publisher_subscriber.server;

import com.specialist.sedykh.patterns.publisher_subscriber.FSMonitor;

public class FSServerStart
{
    public static void main(String[] args) throws InterruptedException
    {
        FSServer server = new FSServer(".");
        server.addClient(new FSMonitor()
        {
            @Override
            public void event(String fName, int kind)
            {
                switch (kind) {
                    case FSMonitor.CREATE ->
                        System.out.println("File created: " + fName);
                    case FSMonitor.REMOVE ->
                        System.out.println("File removed: " + fName);
                    default ->
                        System.out.println("Unknown event!");
                }
            }
        });
        server.start();
    }
}
