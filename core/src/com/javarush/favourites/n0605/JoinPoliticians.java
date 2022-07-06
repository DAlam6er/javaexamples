package com.javarush.favourites.n0605;

/* 
Продвижение на политических дебатах
Особенность программы в том, что каждый политик в любом случае скажет 200 речей.
Программа не завершается пока не выполнятся все потоки.
Проще всего добавить вывод в метод run, тогда будет видно что все говорят по двести речей.

Пустой цикл в мейне ждет пока все в сумме наговорят 200 речей,
выводит инфу на экран и основной Thread на этом заканчивается.
Остальные потоки продолжают работать. Программа завершится после завершения всех потоков.

Почему больше 200. Когда join() сразу после Иванова,
то меин ждет пока он выговорится до лимита и начинает создавать Петрова и Сидорова.
То что они успевают сказать до вывода на экран,
это и есть промежуток времени между их созданием
и проверкой условия в пустом цикле main'a.
*/

public class JoinPoliticians
{
    // Общее число речей
    public static int totalSpeechCount = 200;
    // число высказываний в речи
    public static int utterancesPerSpeech = 1_000_000;

    public static void main(String[] args) throws InterruptedException {
        Politician ivanov = new Politician("Иванов");
        ivanov.join();
        Politician petrov = new Politician("Петров");
        Politician sidorov = new Politician("Сидоров");

        while (ivanov.getSpeechCount() + petrov.getSpeechCount()
            + sidorov.getSpeechCount() < totalSpeechCount)
        { }

        System.out.println(ivanov);
        System.out.println(petrov);
        System.out.println(sidorov);
    }

    public static class Politician extends Thread {
        private volatile int utteranceCount;

        public Politician(String name) {
            super(name);
            start();
        }

        @Override
        public void run() {
            // totalSpeechCount * utterancesPerSpeech = 200 * 1_000_000
            while (utteranceCount < totalSpeechCount * utterancesPerSpeech)
            {
                utteranceCount++;
            }
            System.out.printf("%s закончил. Сказал речь %d раз\n",
                getName(), getSpeechCount());
        }

        public int getSpeechCount() {
            return utteranceCount / utterancesPerSpeech;
        }

        @Override
        public String toString() {
            return String.format(
                "%s сказал речь %d раз", getName(), getSpeechCount());
        }
    }
}

