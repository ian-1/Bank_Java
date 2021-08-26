import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionTest {

    @Test
    void testCanMakeCreditTransaction() {
        LocalDate date = LocalDate.of(1990, 1, 1);
        Transaction subject = new Transaction(date, 30.15);
        assertEquals(date, subject.getDate());
        assertEquals(30.15, subject.getCredit());
    }
}
