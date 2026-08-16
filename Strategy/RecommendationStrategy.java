package Strategy;

import Entity.Book;
import Entity.Patron;

import java.util.List;

public interface RecommendationStrategy {
    List<Book> recommend(Patron patron);
}
