package poker;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class PokerHand {
    private final List<Card> aCards;

    public PokerHand(Card... pCards) {
        assert pCards.length == 5;
        aCards = Arrays.asList(pCards);
        // Sắp xếp các lá theo hạng từ thấp đến cao
        aCards.sort(new Comparator<Card>() {
            public int compare(Card pCard1, Card pCard2) {
                return pCard1.getRank().compareTo(pCard2.getRank());
            }
        });
    }

    private boolean isStraightFlush() {
        // Lấy chất và hạng của lá đầu để so sánh với các lá sau.
        Suit suit = aCards.get(0).getSuit();
        Rank rank = aCards.get(0).getRank();
        Iterator<Card> iterator = aCards.iterator();
        // Bỏ qua lá đầu 
        iterator.next();
        while (iterator.hasNext()) {
            Card card = iterator.next();
            // Khác chất hoặc không hơn lá trước đúng một hạng thì bỏ
            if (card.getSuit() != suit || card.getRank().ordinal() - rank.ordinal() != 1) {
                return false;
            }
            // Dùng hạng của lá hiện tại để so sánh ở lần lặp tiếp theo
            rank = card.getRank();
        }
        return true;
    }
}
