package Strategy;

import Entity.Book;
import Entity.Patron;

import java.util.List;
import java.util.stream.Collectors;

public class GenreBasedRecommendation implements RecommendationStrategy {
    @Override
    public List<Book> recommend(Patron patron) {
        if (patron.getBorrowHistory().isEmpty()) return List.of();
        String lastGenre = patron.getBorrowHistory()
                .get(patron.getBorrowHistory().size() - 1)
                .getGenre();   // ✅ now valid
        return patron.getBorrowHistory().stream()
                .filter(b -> b.getGenre().equals(lastGenre))
                .collect(Collectors.toList());
    }
}
