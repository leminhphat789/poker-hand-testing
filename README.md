# Poker Hand Testing

| File | Vai trò |
| --- | --- |
| `Card.java` | Biểu diễn một lá bài gồm hạng và chất. |
| `Rank.java` | Khai báo các hạng bài từ Át đến Già. |
| `Suit.java` | Khai báo bốn chất: tép, rô, cơ và bích. |
| `PokerHand.java` | Lưu 5 lá bài, sắp xếp theo hạng và kiểm tra thùng phá sảnh. |
| `TestPokerHand.java` | Chứa các hàm hỗ trợ và ca kiểm thử cho ba bài. |
| `pom.xml` | Cấu hình Maven, JUnit 5 và JaCoCo. |

## Các trường hợp được kiểm tra

- Năm lá cùng chất và có hạng liên tiếp.
- Bộ bài có một lá khác chất.
- Năm lá cùng chất nhưng hạng không liên tiếp.

## Kiến thức sử dụng

- **JUnit 5:** viết các ca kiểm thử và kiểm tra bằng assertion.
- **Reflection:** truy cập phương thức private mà không đổi phạm vi truy cập của phương thức.
- **Bao phủ câu lệnh:** xác định những câu lệnh đã được thực thi.
- **Bao phủ nhánh:** xem xét các hướng đi của vòng lặp và điều kiện.
- **Toán tử OR ngắn mạch:** vế phải chỉ được xét khi vế trái sai.

Project sử dụng quy ước Át thấp của bài tập: Át đứng trước Hai trong thứ tự hạng bài.
