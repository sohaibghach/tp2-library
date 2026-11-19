package library;


import java.util.Objects;

public class Book {

    private String isbn;
    private String title;
    private int year;

    public Book(String isbn, String title, int year) {
        this.isbn = isbn;
        this.title = title;
        this.year = year;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Book)) return false;

        Book book = (Book) obj;
        return Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
}

