import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionTest {
    private Transaction subject;
    private LocalDate date;

    @Nested
    @DisplayName("Credit")
    public class WhenCredit {
        @BeforeEach
        public void setup() {
            date = LocalDate.of(1990, 1, 1);
            subject = new Transaction(30.15, TransactionType.CREDIT, date);
        }

        @Test
        @DisplayName("Can make credit transaction")
        void testCanMakeCreditTransaction() {
            assertEquals(30.15, subject.getCredit());
        }

        @Test
        @DisplayName("Credit transaction holds date")
        void testCreditTransactionHoldsDate() {
            assertEquals(date, subject.getDate());
        }

        @Test
        @DisplayName("Credit transaction has zero debit")
        void testCreditTransactionHasZeroDebit() {
            assertEquals(0, subject.getDebit());
        }
    }

    @Nested
    @DisplayName("Debit")
    public class WhenDebit {
        @BeforeEach
        public void setup() {
            date = LocalDate.of(1995, 6, 15);
            subject = new Transaction(6452.78, TransactionType.DEBIT, date);
        }

        @Test
        @DisplayName("Can make debit transaction")
        void testCanMakeDebitTransaction() {
            assertEquals(6452.78, subject.getDebit());
        }

        @Test
        @DisplayName("Debit transaction holds date")
        void testDebitTransactionHoldsDate() {
            assertEquals(date, subject.getDate());
        }

        @Test
        @DisplayName("Debit transaction has zero credit")
        void testdebitTransactionHasZeroCredit() {
            assertEquals(6452.78, subject.getDebit());
        }
    }
}
