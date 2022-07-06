package com.headfirstjava.chap18.RMIBrowser.server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServerMain
{
    public static final String UNIQUE_BINDING_NAME = "ServiceServer";

    public static void main(String[] args)
    {
        try {
            Registry registry = LocateRegistry.createRegistry(2732);
            Remote stub = UnicastRemoteObject.exportObject(
                new ServiceServerImpl(), 0);
            registry.rebind(UNIQUE_BINDING_NAME, stub);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Remote service is running");
    }
}
