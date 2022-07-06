package com.headfirstjava.chap18.RMIBrowser.client;

import com.headfirstjava.chap18.RMIBrowser.Service;
import com.headfirstjava.chap18.RMIBrowser.ServiceServer;

import javax.swing.*;
import java.awt.*;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServiceBrowser
{
    JPanel mainPanel;
    JComboBox<String> serviceList;
    ServiceServer server;
    public static final String UNIQUE_BINDING_NAME = "ServiceServer";

    public void buildGUI()
    {
        JFrame frame = new JFrame("RMI Browser");
        mainPanel = new JPanel();
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);

        // Этот метод выполняет поиск по реестру RMI, получает заглушку
        // и вызывает метод getServiceList() из класса,
        // реализующего интерфейс ServiceServer
        String[] services = getServicesList();

        // Добавляем сервисы (массив элементов Object) в виджет JComboBox
        // Данный виджет знает, как вывести на экран все строки массива
        serviceList = new JComboBox<>(services);

        frame.getContentPane().add(BorderLayout.NORTH, serviceList);

        serviceList.addActionListener(e ->
        {
            String selection = (String) serviceList.getSelectedItem();
            // Если мы дошли до этой строки, значит пользователь выбрал
            // элемент из списка JComboBox. Мы берем этот элемент
            // и загружаем соответствующий сервис.
            loadService(selection);
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /*
    Здесь мы добавляем на панель настоящий сервис,
    после того как пользователь выберет его в списке
    (сам метод вызывается при событии, генерируемом JComboBox).
    Вызываем getService() из удаленного сервера ("заглушки" для ServiceServer)
    и передаем ему строку, отображающуюся в списке.
    Это строка, которую мы получили при вызове метода getServiceList().
    Сервер возвращает сериализованный объект сервиса,
    который благодаря RMI автоматически десериализуется,
    после чего мы просто вызываем из него метод getGUIPanel()
    и добавляем полученный результат (JPanel)
    на главную панель обозревателя (mainPanel).
     */
    void loadService(String serviceSelection)
    {
        try {
            Service svc = server.getService(serviceSelection);
            mainPanel.removeAll();
            mainPanel.add(svc.getGuiPanel());
            mainPanel.validate();
            mainPanel.repaint();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    String[] getServicesList()
    {
        Object obj;
        String[] services = null;

        try {
            Registry registry = LocateRegistry.getRegistry(2732);
            // Выполняем поиск по реестру и получаем заглушку
            obj = registry.lookup(UNIQUE_BINDING_NAME);
            // Приводим тип заглушки к типу удаленного интерфейса
            server = (ServiceServer) obj;
            // Метод возвращает массив с элементами типа String.
            // Мы можем вывести их в JComboBox,
            // с помощью которого пользователь будет делать свой выбор
            services = server.getServiceList();
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
        return services;
    }
}
