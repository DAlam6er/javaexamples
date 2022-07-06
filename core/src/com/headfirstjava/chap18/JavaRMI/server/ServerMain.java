package com.headfirstjava.chap18.JavaRMI.server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

// Сервер настраивает и запускает серверный класс MyRemoteImpl
public class ServerMain
{
    // уникальное имя удаленного объекта
    // По этому имени программа-клиент сможет найти наш сервер
    public static final String UNIQUE_BINDING_NAME = "server.sayHello";

    public static void main(String[] args)
    {
        try {
            MyRemoteImpl service = new MyRemoteImpl();
            // Реестр удаленных объектов - место,
            // куда пользователь обращается, чтобы получить прокси
            // (клиентскую заглушку/вспомогательный объект)
            // 2732 - номер порта
            Registry registry = LocateRegistry.createRegistry(2732);
            // Создаём заглушку.
            // Заглушка инкапсулирует внутри себя весь процесс удаленного вызова
            // Передаем в метод UnicastRemoteObject.exportObject()
            // наш объект-калькулятор service.
            // Таким образом мы делаем возможным удаленный вызов его методов.
            // 0 — выбор любого свободного порта
            Remote stub = UnicastRemoteObject.exportObject(service, 0);
            // «регистрируем» нашу заглушку в реестре удаленных объектов
            // под тем именем, которое придумали в самом начале.
            // Теперь клиент сможет ее найти!
            registry.rebind(UNIQUE_BINDING_NAME, stub);
            // Заставляем главный поток программы заснуть,
            // чтобы сервер работал долгое время
            // и программа-сервер не вырубилась, пока мы будем запускать клиент.
            Thread.sleep(Integer.MAX_VALUE);
        } catch (RemoteException | InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
