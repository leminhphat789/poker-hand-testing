package poker;
import java.util.Objects;
// Mỗi lá bài có một hạng và một chất, không đổi sau khi tạo.
public final class Card {
    private final Rank rank;
    private final Suit suit;
    public Card(Rank rank, Suit suit) {
        this.rank = Objects.requireNonNull(rank);
        this.suit = Objects.requireNonNull(suit);
    }
    public Rank getRank() { return rank; }
    public Suit getSuit() { return suit; }
}
