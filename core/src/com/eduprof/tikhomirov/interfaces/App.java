package com.eduprof.tikhomirov.interfaces;

import java.util.ArrayList;

public class App
{
    public static void main(String[] args)
    {
        ArrayList<Book> booksAvailable = new ArrayList<>();
        booksAvailable.add(
            new Book(
                "The Adventures of Tom Sawyer", "Mark Twain"));
        booksAvailable.add(
            new Book(
                "The Night in Lisbon", "Erich Maria Remarque"));
        booksAvailable.add(
            new Book("Nineteen Eighty-Four", "George Orwell"));
        booksAvailable.add(
            new Book("The Martian Chronicles", "Ray Bradbury"));
        booksAvailable.add(
            new Book("The Green Mile", "Stephen King"));
        booksAvailable.add(
            new Book("Atlas Shrugged", "Ayn Rand"));
        booksAvailable.add(
            new Book(
                "The Tragedy of Hamlet, Prince of Denmark",
                "William Shakespeare"));
        booksAvailable.add(
            new Book("Ulysses", "James Joyce"));
        booksAvailable.add(
            new Book("Irish Avatar", "Lord Byron"));
        booksAvailable.add(
            new Book("The Three Musketeers", "Alexandre Dumas"));

        // Implementation of the interface Administrator
        Administrator defAdmin = new Administrator()
        {
            @Override
            public Book findBookByTitle(
                ArrayList<Book> books, String bookTitle)
            {
                for (Book book : books) {
                    if (book.getTitle().equals(bookTitle)) return book;
                }
                return null;
            }

            @Override
            public Book findBookByAuthor(
                ArrayList<Book> books, String bookAuthor)
            {
                for (Book book : books) {
                    if (book.getAuthor().equals(bookAuthor)) return book;
                }
                return null;
            }

            @Override
            public void lendBooks(ArrayList<Book> books, Reader reader)
            {
                StringBuilder lendBooks = new StringBuilder(reader +
                    ", you are receiving the following books:\n");
                for (Book book : books) {
                    lendBooks.append(
                        String.format(
                            "%s — %s\n", book.getAuthor(), book.getTitle()));
                }
                System.out.println(lendBooks);
            }

            @Override
            public void overdueNotify(ArrayList<Book> books, Reader reader)
            {
                StringBuilder overdueNotify = new StringBuilder(reader +
                    ", you are late with the following books:\n");
                for (Book book : books) {
                    overdueNotify.append(
                        String.format(
                            "\t%s — %s\n", book.getAuthor(), book.getTitle()));
                }
                System.out.println(overdueNotify);
            }
        };

        // Implementation of the interface Librarian
        Librarian defLibrarian = (books, supplier) ->
        {
            StringBuilder order = new StringBuilder("I ask " + supplier +
                " to supply our library with the following books:\n");
            for (Book book : books) {
                order.append(
                    String.format(
                        "\t%s — %s\n", book.getAuthor(), book.getTitle()));
            }
            System.out.println(order);
        };

        // Implementation of the interface Reader
        Reader defReader = new Reader()
        {
            @Override
            public boolean takeBooks(ArrayList<Book> books, Administrator admin)
            {
                StringBuilder takeBooks = new StringBuilder(admin +
                    ", I'd like to take the following books:\n");
                for (Book book : books) {
                    takeBooks.append(
                        String.format(
                            "\t%s — %s\n", book.getAuthor(), book.getTitle()));
                }
                System.out.println(takeBooks);
                return true; // желаемые книги всегда есть в наличии
            }

            @Override
            public boolean returnBook(ArrayList<Book> books, Administrator admin)
            {
                StringBuilder returnBook = new StringBuilder(admin +
                    ", I'd like to return the following books:\n");
                for (Book book : books) {
                    returnBook.append(
                        String.format(
                            "\t%s — %s\n", book.getAuthor(), book.getTitle()));
                }
                System.out.println(returnBook);
                return true; // всегда есть возможность вернуть книги
            }
        };

        // Implementation of the interface Supplier
        Supplier defSupplier = (books, librarian) ->
        {
            StringBuilder supply = new StringBuilder("I supply " + librarian +
                " with the following books:\n");
            for (Book book : books) {
                supply.append(
                    String.format(
                        "\t%s — %s\n", book.getAuthor(), book.getTitle()));
            }
            System.out.println(supply);
        };

        // The librarian forms an order to the supplier
        ArrayList<Book> booksToOrder = new ArrayList<>();
        booksToOrder.add(
            new Book("The Count of Monte Cristo","Alexandre Dumas"));
        booksToOrder.add(
            new Book("The World Crisis", "Winston Churchill"));
        defLibrarian.order(booksToOrder, defSupplier);

        // The supplier notifies that he was able to supply part of the books
        ArrayList<Book> booksToSupply = new ArrayList<>(booksToOrder);
        booksToSupply.remove(1);
        defSupplier.supply(booksToSupply, defLibrarian);

        // The reader takes part of the books
        ArrayList<Book> booksForReader = new ArrayList<>(booksAvailable);
        booksForReader.remove(
            (int)(Math.random() * booksAvailable.size()));
        booksForReader.remove(
            (int)(Math.random() * booksAvailable.size()));
        defReader.takeBooks(booksForReader, defAdmin);

        // The reader returns a random part of the books
        ArrayList<Book> returnBooks = new ArrayList<>(booksForReader);
        returnBooks.remove(
            (int)(Math.random() * returnBooks.size()));
        returnBooks.remove(
            (int)(Math.random() * returnBooks.size()));
        defReader.returnBook(returnBooks, defAdmin);

        // The administrator notifies about delays in the return time
        // for the rest of the books
        booksForReader.removeAll(returnBooks);
        defAdmin.overdueNotify(booksForReader,defReader);
    }
}
