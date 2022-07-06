package com.eduprof.tikhomirov.interfaces;

import java.util.ArrayList;

public interface Administrator
{
    Book findBookByTitle(ArrayList<Book> books, String bookTitle);
    Book findBookByAuthor(ArrayList<Book> books, String bookAuthor);
    void lendBooks(ArrayList<Book> books, Reader reader);
    void overdueNotify(ArrayList<Book> books,Reader reader);
}
