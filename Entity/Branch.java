package Entity;

import java.util.ArrayList;
import java.util.List;

public class Branch {
    private String name;
    private List<Book> inventory;

    public Branch(String name) {
        this.name = name;
        this.inventory = new ArrayList<>();
    }

    public void addBook(Book book) { inventory.add(book); }
    public void removeBook(Book book) { inventory.remove(book); }
    public List<Book> getInventory() { return inventory; }

    @Override
    public String toString() {
        return "Branch: " + name + " with " + inventory.size() + " books.";
    }
}
