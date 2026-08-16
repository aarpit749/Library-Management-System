package Service;

import Entity.Book;
import Entity.Patron;
import Strategy.RecommendationStrategy;

import java.util.List;

public class RecommendationService {
    private RecommendationStrategy strategy;

    public void setStrategy(RecommendationStrategy strategy) {
        this.strategy = strategy;
    }

    public List<Book> recommendBooks(Patron patron) {
        return strategy.recommend(patron);
    }
}
