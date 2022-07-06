package com.headfirstjava.chap18.RMIBrowser.server;

import com.headfirstjava.chap18.RMIBrowser.Service;
import com.headfirstjava.chap18.RMIBrowser.ServiceServer;
import com.headfirstjava.chap18.RMIBrowser.server.services.*;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Set;

public class ServiceServerImpl implements ServiceServer
{
    // ключ - строка, значение - любой объект
    HashMap<String, Service> serviceList;

    public ServiceServerImpl() throws RemoteException
    {
        setUpServices();
    }

    // При вызове конструктора инициализируем универсальные сервисы
    // Создаем сервисы (их настоящие объекты) и помещаем в HashMap
    // вместе со строковым именем (ключом)
    private void setUpServices()
    {
        serviceList = new HashMap<>();
        serviceList.put("Dice Rolling Service", new DiceService());
        serviceList.put("Day of the Week Service", new DayOfTheWeekService());
        serviceList.put("Visual Music Service", new MiniMusicService());
    }

    // Клиент вызывает этот метод, чтобы получить список сервисов
    // и отобразить их в обозревателе. Мы отправляем массив типа Object
    // (хотя внутри строки), который состоит только из ключей,
    // хранящихся внутри HashMap. Мы не будем отправлять сам сервис,
    // пока клиент нас об этом не попросит (вызвав метод getService())
    @Override
    public String[] getServiceList()
    {
        System.out.println("in remote");
        Set<String> mySet = serviceList.keySet();
        return mySet.toArray(new String[0]);
    }

    // Клиент вызывает этот метод после того, как пользователь
    // выберет сервис в раскрывающемся списке. Код использует ключ
    // (изначально отправленный клиенту), чтобы получить из HashMap
    // соответствующий сервис
    @Override
    public Service getService(String serviceKey)
    {
        return serviceList.get(serviceKey);
    }
}
