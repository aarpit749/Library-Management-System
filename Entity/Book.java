package Entity;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private int publicationYear;
    private boolean isBorrowed;
    private String genre;   // ✅ new field

    public Book(String title, String author, String isbn, int publicationYear, String genre) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.genre = genre;
        this.isBorrowed = false;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public int getPublicationYear() { return publicationYear; }
    public boolean isBorrowed() { return isBorrowed; }
    public String getGenre() { return genre; }   // ✅ getter

    public void setBorrowed(boolean borrowed) { this.isBorrowed = borrowed; }
    public void setGenre(String genre) { this.genre = genre; }   // ✅ setter

    @Override
    public String toString() {
        return String.format("%s by %s (%d) - ISBN: %s, Genre: %s",
                title, author, publicationYear, isbn, genre);
    }
}
