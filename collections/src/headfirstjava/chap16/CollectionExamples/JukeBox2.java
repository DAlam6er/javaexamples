package headfirstjava.chap16.CollectionExamples;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class JukeBox2
{
    ArrayList<Song> songList = new ArrayList<>();

    public static void main(String[] args)
    {
        new JukeBox2().go();
    }

    public void go()
    {
        getSongs();
        System.out.println("В порядке добавления:\n" + songList);

        Collections.sort(songList);
        System.out.println("По названию:\n" + songList);
        // лямбда-выражение (since Java8)
        /*
        Collections.sort(songList,
            (s1, s2) -> s1.getArtist().compareTo(s2.getArtist()));
        */

        // квадроточие (since Java8) позволяет получить ссылку на метод,
        // указанный в правой части класса, указанного в левой части
        // Компилятор выводит тип ссылки из контекста
        // и приводит её к соответствующему функциональному интерфейсу.
        Collections.sort(songList, Comparator.comparing(Song::getArtist));
        System.out.println("По исполнителю:\n" + songList);
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
