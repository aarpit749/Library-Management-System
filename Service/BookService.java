package Service;

import Entity.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookService {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) { books.add(book); }
    public void removeBook(String isbn) { books.removeIf(b -> b.getIsbn().equals(isbn)); }
    public void updateBook(Book updatedBook) {
        removeBook(updatedBook.getIsbn());
        addBook(updatedBook);
    }

    public List<Book> searchByTitle(String title) {
        return books.stream().filter(b -> b.getTitle().equalsIgnoreCase(title)).collect(Collectors.toList());
    }

    public List<Book> searchByAuthor(String author) {
        return books.stream().filter(b -> b.getAuthor().equalsIgnoreCase(author)).collect(Collectors.toList());
    }

    public Book searchByIsbn(String isbn) {
        return books.stream().filter(b -> b.getIsbn().equals(isbn)).findFirst().orElse(null);
    }
}
