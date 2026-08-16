package Strategy;

import Entity.Book;
import Entity.Patron;

import java.util.List;
import java.util.stream.Collectors;

public class AuthorBasedRecommendation implements RecommendationStrategy {
    @Override
    public List<Book> recommend(Patron patron) {
        if (patron.getBorrowHistory().isEmpty()) return List.of();
        String lastAuthor = patron.getBorrowHistory()
                .get(patron.getBorrowHistory().size() - 1)
                .getAuthor();
        return patron.getBorrowHistory().stream()
                .filter(b -> b.getAuthor().equals(lastAuthor))
                .collect(Collectors.toList());
    }
}
