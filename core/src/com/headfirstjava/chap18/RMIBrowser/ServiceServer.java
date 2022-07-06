package com.headfirstjava.chap18.RMIBrowser;

import java.rmi.Remote;
import java.rmi.RemoteException;

// Удаленный RMI-интерфейс.
// Описывает два метода, которым должен обладать удаленный сервис.
// Сервис передается по сети от сервера в виде результата вызова клиентом
// метода getService()
public interface ServiceServer extends Remote
{
    String[] getServiceList() throws RemoteException;
    Service getService(String serviceKey) throws RemoteException;
}
