package com.eduprof.tikhomirov.interfaces;

import java.util.Calendar;
import java.util.Date;

public class Book
{
    private final long id;
    private String title;
    private String author;

    public Book(String title, String author)
    {
        this.id = ++Library.booksTotal;
        this.title = title;
        this.author = author;
    }

    public long getId()
    {
        return id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public class Rent
    {
        public static final int RENTAL_DURATION = 30;
        private final Date rentalStart;
        private final Date rentalEnd;

        public Rent()
        {
            this.rentalStart = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(getRentalStart());
            calendar.add(Calendar.DATE, RENTAL_DURATION);
            this.rentalEnd = calendar.getTime();
        }
        public Date getRentalStart()
        {
            return rentalStart;
        }

        public Date getRentalEnd()
        {
            return this.rentalEnd;
        }

        public boolean isExpired()
        {
            return rentalEnd.before(new Date());
        }
    }
}
