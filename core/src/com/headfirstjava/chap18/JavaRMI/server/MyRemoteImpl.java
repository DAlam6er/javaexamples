package com.headfirstjava.chap18.JavaRMI.server;

import com.headfirstjava.chap18.JavaRMI.MyRemote;

import java.rmi.RemoteException;

// 2. Создаём реализацию удалённого интерфейса
public class MyRemoteImpl implements MyRemote
{
    // Реализуем все методы интерфейса MyRemote
    // Необязательно(!) объявлять RemoteException
    @Override
    public String sayHello()
    {
        return "Сервер говорит: \"Привет\"";
    }

    // В объявлении конструктора родительского класса UnicastRemoteObject
    // содержится исключение, поэтому нужно создать свой конструктор,
    // ведь его наличие говорит о вызове опасного кода
    // (конструктора его родительского класса)
    public MyRemoteImpl() throws RemoteException { }
}
