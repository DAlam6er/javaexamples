package com.specialist.sedykh.patterns.publisher_subscriber.server;

import com.specialist.sedykh.patterns.publisher_subscriber.FSMonitor;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;

public class FSServer implements Runnable
{
    private final String dir;
    private final ArrayList<FSMonitor> clients;
    private volatile boolean canWork;
    private final Thread self;

    public FSServer(String dir)
    {
        this.dir = dir;
        self = new Thread(this, "FSServer");
        clients = new ArrayList<>();
    }

    public void addClient(FSMonitor client)
    {
        clients.add(client);
    }

    public void removeClient(FSMonitor client)
    {
        clients.remove(client);
    }

    public void start()
    {
        canWork = true;
        self.start();
    }

    public void stop()
    {
        canWork = false;
        System.out.println(self.getName() + " stopped.");
    }

    public void join()
    {
        try {
            self.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public Thread getSelf()
    {
        return self;
    }

    @Override
    public void run()
    {
        System.out.println(self.getName() + " started.");
        try {
            // nio отслеживание изменений в файловой системе - наблюдатель
            WatchService watch = FileSystems.getDefault().newWatchService();
            // ассоциируем наблюдателя с конкретной директорией
            Paths.get(dir).register(
                watch,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_DELETE);
            while (canWork) {
                // take() - блокирующий вызов, выйти не получится, пока не произойдёт событие
                // здесь возможно зависание программы
                WatchKey key = watch.take(); // дескриптор произошедшего события
                for (WatchEvent<?> event : key.pollEvents()) {
                    String fName = event.context().toString();
                    int kind;
                    if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
                        kind = FSMonitor.CREATE;
                    } else {
                        kind = FSMonitor.REMOVE;
                    }
                    // оповещаем всех клиентов
                    for (FSMonitor client : clients) {
                        client.event(fName, kind);
                    }
                }
                key.reset(); // закрытие дескриптера
            }
            watch.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (InterruptedException e) {
            // InterruptedException here
        }
    }
}
