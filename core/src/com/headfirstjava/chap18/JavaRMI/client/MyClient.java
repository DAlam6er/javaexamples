package com.headfirstjava.chap18.JavaRMI.client;


import com.headfirstjava.chap18.JavaRMI.MyRemote;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MyClient
{
    // клиент должен быть в курсе уникального имени объекта,
    // методы которого он будет вызывать удаленно
    public static final String UNIQUE_BINDING_NAME = "server.sayHello";

    public static void main(String[] args)
    {
        try {
            // получаем доступ к регистру удаленных объектов
            Registry registry = LocateRegistry.getRegistry(2732);

            // Получаем из регистра нужный объект.
            // Работа RMI основана на использовании прокси,
            // поэтому удаленный вызов доступен только для методов интерфейсов,
            // а не классов
            // Реестр возвращает значение класса Remote, поэтому делаем приведение к типу MyRemote
            MyRemote service = (MyRemote) registry.lookup(UNIQUE_BINDING_NAME);

            String s = service.sayHello();
            System.out.println(s);
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }
}
