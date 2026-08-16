import Entity.Book;
import Entity.Patron;
import Service.BookService;
import Service.LendingService;
import Service.PatronService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookService bookService = new BookService();
        PatronService patronService = new PatronService();
        LendingService lendingService = new LendingService();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("📚 Welcome to the Library Management System!");

        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Book");
            System.out.println("2. Search Book");
            System.out.println("3. Add Patron");
            System.out.println("4. Checkout Book");
            System.out.println("5. Return Book");
            System.out.println("6. View Patron History");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Author: ");
                    String author = scanner.nextLine();
                    System.out.print("ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Year: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Genre: ");
                    String genre = scanner.nextLine();

                    Book book = new Book(title, author, isbn, year, genre);
                    bookService.addBook(book);
                    System.out.println("✅ Book added!");
                }
                case 2 -> {
                    System.out.print("Search by (title/author/isbn): ");
                    String type = scanner.nextLine();
                    System.out.print("Enter search value: ");
                    String value = scanner.nextLine();

                    switch (type.toLowerCase()) {
                        case "title" -> System.out.println(bookService.searchByTitle(value));
                        case "author" -> System.out.println(bookService.searchByAuthor(value));
                        case "isbn" -> System.out.println(bookService.searchByIsbn(value));
                        default -> System.out.println("❌ Invalid search type.");
                    }
                }
                case 3 -> {
                    System.out.print("Patron ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    Patron patron = new Patron(id, name, email);
                    patronService.addPatron(patron);
                    System.out.println("✅ Patron added!");
                }
                case 4 -> {
                    System.out.print("Enter ISBN of book to checkout: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Enter Patron ID: ");
                    String patronId = scanner.nextLine();

                    Book book = bookService.searchByIsbn(isbn);
                    Patron patron = patronService.findPatronById(patronId);

                    if (book != null && patron != null) {
                        if (lendingService.checkoutBook(book, patron)) {
                            System.out.println("✅ Book checked out!");
                        } else {
                            System.out.println("❌ Book already borrowed.");
                        }
                    } else {
                        System.out.println("❌ Book or Patron not found.");
                    }
                }
                case 5 -> {
                    System.out.print("Enter ISBN of book to return: ");
                    String isbn = scanner.nextLine();
                    Book book = bookService.searchByIsbn(isbn);

                    if (book != null) {
                        if (lendingService.returnBook(book)) {
                            System.out.println("✅ Book returned!");
                        } else {
                            System.out.println("❌ Book was not borrowed.");
                        }
                    } else {
                        System.out.println("❌ Book not found.");
                    }
                }
                case 6 -> {
                    System.out.print("Enter Patron ID: ");
                    String patronId = scanner.nextLine();
                    Patron patron = patronService.findPatronById(patronId);

                    if (patron != null) {
                        System.out.println("📖 Borrow history: " + patron.getBorrowHistory());
                    } else {
                        System.out.println("❌ Patron not found.");
                    }
                }
                case 0 -> {
                    running = false;
                    System.out.println("👋 Goodbye!");
                }
                default -> System.out.println("❌ Invalid choice.");
            }
        }

        scanner.close();
    }
}
