package com.headfirstjava.chap16.CollectionExamples;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

// Задача 1. Сортировать песни в алфавитном порядке
// ArrayList не содержит методов для сортировки
public class Jukebox1
{
    ArrayList<String> songList = new ArrayList<>();

    public static void main(String[] args)
    {
        new Jukebox1().go();
    }

    public void go()
    {
        getSongs();
        System.out.println(songList);
        // Сортировка с использованием Collections
        Collections.sort(songList);
        System.out.println(songList);
    }

    void getSongs()
    {
        try {
            File file = new File("SongList.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                addSong(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void addSong(String lineToParse)
    {
        // Строка содержит название песни и имя исполнителя, разделенные "/"
        String[] tokens = lineToParse.split("/");
        songList.add(tokens[0]);
    }
}
