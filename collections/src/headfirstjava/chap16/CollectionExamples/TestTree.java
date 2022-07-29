package headfirstjava.chap16.CollectionExamples;

import java.util.Comparator;
import java.util.TreeSet;

public class TestTree
{
    public static void main(String[] args)
    {
        new TestTree().go();
    }

    public void go()
    {
        Book b1 = new Book("Как устроены кошки");
        Book b2 = new Book("Постройте заново своё тело");
        Book b3 = new Book("В поисках Эмо");

        TreeSet<Book> tree = new TreeSet<>();
        tree.add(b1);
        tree.add(b2);
        tree.add(b3);
        System.out.println("tree1:\n" + tree);

        TreeSet<Book2> tree2 = new TreeSet<>(new Comparator<Book2>()
        {
            @Override
            public int compare(Book2 b1, Book2 b2)
            {
                return b1.getTitle().compareTo(b2.getTitle());
            }
        });
        Book2 b4 = new Book2("Холодный дом");
        Book2 b5 = new Book2("Гордость и предубеждение");
        Book2 b6 = new Book2("Приключения Тома Сойера");
        tree2.add(b4);
        tree2.add(b5);
        tree2.add(b6);
        System.out.println("tree2:\n" + tree2);
    }
}

// Обязательное условие работы TreeSet:
//     1. Book должен реализовывать Comparable
//     2. Использование перегруженного конструктора, принимающего Comparator,
//     при создании TreeSet.
class Book implements Comparable<Book>
{
    private final String title;

    public Book(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }

    @Override
    public int compareTo(Book b)
    {
        return title.compareTo(b.getTitle());
    }

    @Override
    public String toString()
    {
        return title;
    }
}

class Book2
{
    private String title;

    public Book2(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }

    @Override
    public String toString()
    {
        return title;
    }
}
