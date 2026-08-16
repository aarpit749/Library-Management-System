package Service;

import Entity.Book;

import java.util.List;
import java.util.stream.Collectors;

public class InventoryService {
    private List<Book> books;

    public InventoryService(List<Book> books) {
        this.books = books;
    }

    public List<Book> getAvailableBooks() {
        return books.stream().filter(b -> !b.isBorrowed()).collect(Collectors.toList());
    }

    public List<Book> getBorrowedBooks() {
        return books.stream().filter(Book::isBorrowed).collect(Collectors.toList());
    }
}
