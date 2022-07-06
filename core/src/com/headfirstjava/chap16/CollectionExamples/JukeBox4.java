package com.headfirstjava.chap16.CollectionExamples;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class JukeBox4
{
    ArrayList<Song> songList = new ArrayList<>();

    public static void main(String[] args)
    {
        new JukeBox4().go();
    }

    public void go()
    {
        getSongs();
        System.out.println("В порядке добавления:\n" + songList);
        Collections.sort(songList);
        System.out.println("По названию:\n" + songList);

        // Вызов конструктора без аргументов означает, что для сортировки
        // будут использоваться методы compareTo() (интерфейса Comparable)
        // из каждого элемента. Но мы можем передать Comparator
        TreeSet<Song> songSet = new TreeSet<>();
        songSet.addAll(songList);
        System.out.println("Множество после добавления:\n" + songSet);
    }

    void getSongs()
    {
        try {
            File file = new File("SongListMore.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                addSong(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void addSong(String lineToParse)
    {
        String[] tokens = lineToParse.split("/");

        Song nextSong = new Song(tokens[0], tokens[1], tokens[2], tokens[3]);
        songList.add(nextSong);
    }
}
