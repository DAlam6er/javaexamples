package com.specialist.sedykh.homework.lab2_3_4_5;

import java.io.*;
import java.util.*;

public class WordCount
{
    private final String inFile;
    private final String outFile;
    private final static String testString =
        "To be, or not to be, that is the question:\n" +
        "Whether 'tis nobler in the mind to suffer\n" +
        "The slings and arrows of outrageous fortune,\n" +
        "Or to take arms against a sea of troubles\n" +
        "And by opposing end them. To die—to sleep,\n" +
        "No more; and by a sleep to say we end\n" +
        "The heart-ache and the thousand natural shocks\n" +
        "That flesh is heir to: 'tis a consummation\n" +
        "Devoutly to be wish'd. To die, to sleep;\n" +
        "To sleep, perchance to dream—ay, there's the rub:\n" +
        "For in that sleep of death what dreams may come,\n" +
        "When we have shuffled off this mortal coil,\n" +
        "Must give us pause—there's the respect\n" +
        "That makes calamity of so long life.";
    // более старая коллекция, медленная за счет потокобезопасности
//    private final Hashtable<String, Integer> words = new Hashtable<>();
    // более быстрая коллекция, выше скорость за счет отсутствия потокобезопасности
    private final HashMap<String, Integer> words;
    private final Vector<IWordCounter> listeners;

    public WordCount(String inFile, String outFile)
    {
        this.inFile = inFile;
        this.outFile = outFile;
        words = new HashMap<>();
        listeners = new Vector<>();
    }

//    public Hashtable<String, Integer> getWords()
//    {
//        return words;
//    }

    public HashMap<String, Integer> getWords()
    {
        return words;
    }

    public void countWords() throws IOException
    {
        int num=0;
        Reader reader;
        if (inFile != null) {
            reader = new FileReader(inFile);
        } else {
            reader = new StringReader(testString);
        }
        BufferedReader br = new BufferedReader(reader);

        for (String line = br.readLine();
             line != null; line = br.readLine())
        {
            StringTokenizer st =
                new StringTokenizer(line," \t\n\r\f.,;“”!()?:—\"");
            while (st.hasMoreTokens()) {
                String token = st.nextToken().toLowerCase(Locale.ROOT);
                if (words.containsKey(token)) {
                    words.put(token, words.get(token) + 1);
                } else {
                    words.put(token, 1);
                    num++;
                }
            }
        }

        // output using Hashtable
//        Enumeration<String> keys = getWords().keys();
//        int n;
//        StringBuilder sb = new StringBuilder();
//        while (keys.hasMoreElements()) {
//            String w = keys.nextElement();
//            n = getWords().get(w);
//            sb.append(w).append("     ").append(n).append("\n");
//        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : words.entrySet()) {
            sb.append(entry).append("\n");
        }

        if(outFile != null) {
            try (FileWriter writer = new FileWriter(outFile)) {
                writer.write(sb.toString());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println(sb);
        }

        br.close();
        reader.close();
        // рассылка события всем подписчикам
        fireCounter(num);
    }

    public void addListener(IWordCounter listener)
    {
        listeners.add(listener);
    }

    public void delListener(IWordCounter listener)
    {
        listeners.remove(listener);
    }

    // метод для рассылки события IWordCounter.counted()
    protected void fireCounter(int size)
    {
        for (IWordCounter listener : listeners) {
            listener.counted(this, size);
        }
    }

    public static void main(String[] args)
    {
        SimpleParser sp = new SimpleParser();
        sp.parse(args);

        WordCount wc = new WordCount(sp.getInFile(), sp.getOutFile());

        // подписка на событие
        wc.addListener(
            (sender, size) -> System.out.println("client get result " + size)
        );

        try {
            wc.countWords();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
