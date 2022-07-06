package com.headfirstjava.chap18.JavaRMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

// 1. Создаем удаленный интерфейс.
// Должен быть унаследован от Remote - интерфейса-маркера
public interface MyRemote extends Remote
{
    // все удаленные методы должны содержать объявление RemoteException
    String sayHello() throws RemoteException;
}
