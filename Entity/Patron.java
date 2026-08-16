package Entity;

import java.util.ArrayList;
import java.util.List;

public class Patron extends User {
    private List<Book> borrowHistory;

    public Patron(String id, String name, String email) {
        super(id, name, email);   // inherit id, name, email from User
        this.borrowHistory = new ArrayList<>();
    }

    public void addBorrowedBook(Book book) {
        borrowHistory.add(book);
    }

    public List<Book> getBorrowHistory() {
        return borrowHistory;
    }

    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public String toString() {
        return String.format("Patron: %s (%s)", name, email);
    }
}
