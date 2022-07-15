package com.stepik.javabasecourse.files.io;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

public class SerializationDemo
{
    public static void main(String[] args)
    {
        Client originalClient = new Client();
        originalClient.setId(1);
        originalClient.setName("Chuck Norris");
        originalClient.setBirthDate(LocalDate.of(1940, 3, 10));

        Path path = Paths.get("objects.bin");
        try (ObjectOutputStream oos =
                 new ObjectOutputStream(Files.newOutputStream(path)))
        {
            oos.writeObject(originalClient);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        Client deserializedClient = null;
        try (ObjectInputStream ois =
                 new ObjectInputStream(Files.newInputStream(path)))
        {
            deserializedClient = (Client) ois.readObject();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Класс не найден!");
        }

        System.out.println(deserializedClient.getId());
        System.out.println(deserializedClient.getName());
        System.out.println(deserializedClient.getBirthDate());
        System.out.println(deserializedClient.getAgeInYears());
    }

    // Serializable - маркерный интерфейс
    public static class Client implements Serializable
    {
        private long id;
        private String name;
        private LocalDate birthDate;
        // поля, которые не нужно сохранять
        private transient int ageInYears;

        public long getId()
        {
            return id;
        }

        public void setId(long id)
        {
            this.id = id;
        }

        public String getName()
        {
            return name;
        }

        public void setName(String name)
        {
            this.name = name;
        }

        public LocalDate getBirthDate()
        {
            return birthDate;
        }

        public void setBirthDate(LocalDate birthDate)
        {
            this.birthDate = birthDate;
        }

        public int getAgeInYears()
        {
            if (ageInYears == 0) {
                ageInYears = birthDate.until(LocalDate.now()).getYears();
            }
            return ageInYears;
        }
    }
}
