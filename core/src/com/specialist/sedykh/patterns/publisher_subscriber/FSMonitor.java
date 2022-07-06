package com.specialist.sedykh.patterns.publisher_subscriber;

public interface FSMonitor
{
    int CREATE = 1; // именованная константа
    int REMOVE = 2;

    void event(String fName, int kind );
}
