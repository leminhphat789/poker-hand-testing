package poker;

import java.lang.reflect.Method;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static poker.Rank.*;
import static poker.Suit.*;

public class TestPokerHand {
    // Tạo lá bài để viết các ca kiểm thử gọn hơn
    private static Card card(Rank rank, Suit suit) {
        return new Card(rank, suit);
    }

    // dùng reflection để gọi hàm private mà không cần sửa lớp pokerHand
    private static boolean isStraightFlush(Card... cards) throws Exception {
        PokerHand hand = new PokerHand(cards);
        Method method = PokerHand.class.getDeclaredMethod("isStraightFlush");
        method.setAccessible(true);
        return (boolean) method.invoke(hand);
    }

    // 5,8 thùng phá sảnh phải trả về true. Hai bài sau dùng lại ca này.
    @Test @Tag("ex58") @Tag("ex59") @Tag("ex510")
    void straightFlushReturnsTrue() throws Exception {
        // Truyền các lá không theo thứ tự để kiểm tra việc sắp xếp.
        assertTrue(isStraightFlush(card(FIVE, HEARTS), card(ACE, HEARTS),
                card(THREE, HEARTS), card(TWO, HEARTS), card(FOUR, HEARTS)));
    }

    // 5,9 thêm lá khác chất để chạy được lệnh return false.
    @Test @Tag("ex59") @Tag("ex510")
    void differentSuitReturnsFalse() throws Exception {
        assertFalse(isStraightFlush(card(ACE, HEARTS), card(TWO, CLUBS),
                card(THREE, HEARTS), card(FOUR, HEARTS), card(FIVE, HEARTS)));
    }

    // 5,10 các lá cùng chất nhưng thiếu lá Hai, nên không liên tiếp.
    // kiểm tra trường hợp vế trái của || sai, vế phải đúng.
    @Test @Tag("ex510")
    void rankGapReturnsFalse() throws Exception {
        assertFalse(isStraightFlush(card(ACE, HEARTS), card(THREE, HEARTS),
                card(FOUR, HEARTS), card(FIVE, HEARTS), card(SIX, HEARTS)));
    }
}
