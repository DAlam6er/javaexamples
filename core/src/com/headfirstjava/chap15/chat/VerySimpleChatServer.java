package com.headfirstjava.chap15.chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class VerySimpleChatServer
{
    ArrayList<Writer> clientOutputStreams;

    public class ClientHandler implements Runnable
    {
        BufferedReader reader;

        public ClientHandler(Socket clientSocket)
        {
            try
            {
                // Open communication with client during init
                InputStreamReader isReader = new InputStreamReader(
                    clientSocket.getInputStream());
                reader = new BufferedReader(isReader);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        @Override
        public void run()
        {
            String message;
            try {
                System.out.println("in run() before while{}");
                while ((message = reader.readLine()) != null) {
                    System.out.println("read " + message);
                    tellEveryone(message);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            System.out.println("Thread stopped working.");
        }
    }

    public static void main(String[] args)
    {
        new VerySimpleChatServer().go();
    }

    public void go()
    {
        System.out.println("Server started. Waiting for connection...");
        clientOutputStreams = new ArrayList<>();
        try (ServerSocket serverSocket = new ServerSocket(5000))
        {
            while (true) {
                Socket clientSocket = serverSocket.accept();

                PrintWriter writer = new PrintWriter(
                    clientSocket.getOutputStream());
                clientOutputStreams.add(writer);

                Thread t = new Thread(new ClientHandler(clientSocket));
                t.start();
                System.out.println("got a connection");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void tellEveryone(String message)
    {
        Iterator<Writer> it = clientOutputStreams.iterator();
        while (it.hasNext()) {
            System.out.println("inside tellEveryone()");
            try {
                PrintWriter writer = (PrintWriter) it.next();
                writer.println(message);
                writer.flush();
            } catch (NoSuchElementException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("at the end of tellEveryone()");
    }
}
