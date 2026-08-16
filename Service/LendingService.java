package Service;

import Entity.Book;
import Entity.Patron;

public class LendingService {
    public boolean checkoutBook(Book book, Patron patron) {
        if (!book.isBorrowed()) {
            book.setBorrowed(true);
            patron.addBorrowedBook(book);
            return true;
        }
        return false;
    }

    public boolean returnBook(Book book) {
        if (book.isBorrowed()) {
            book.setBorrowed(false);
            return true;
        }
        return false;
    }
}
