import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;

public class StatementPrinterTest {
    private StatementPrinter subject;
    private ArrayList<ITransaction> transactions;

    @BeforeEach
    void setup() {
        subject = new StatementPrinter();
        transactions = new ArrayList<>();
    }

    @Test
    @DisplayName("Prints blank statement")
    void TestPrintsBlankStatement() {
        String result = subject.print(transactions);
        assertEquals("date || credit || debit || balance", result);
    }

    @Test
    @DisplayName("Prints statement for a credit transaction")
    void TestPrintsStatementForACreditTransaction() {
        LocalDate date = LocalDate.of(2000,1,1);
        MockCreditTransaction mockTransaction = new MockCreditTransaction();
        transactions.add(mockTransaction);
        String result = subject.print(transactions);
        String lineOne = "date || credit || debit || balance\n";
        String lineTwo = "01/01/2000 || 100.00 || - || 100.00";
        String expectation = lineOne + lineTwo;
        assertEquals(expectation, result);
    }

    @Test
    @DisplayName("Prints statement twice")
    void TestPrintsStatementTwice() {
        LocalDate date = LocalDate.of(2000,1,1);
        MockCreditTransaction mockTransaction = new MockCreditTransaction();
        transactions.add(mockTransaction);
        String lineOne = "date || credit || debit || balance\n";
        String lineTwo = "01/01/2000 || 100.00 || - || 100.00";
        String expectation = lineOne + lineTwo;
        String result = subject.print(transactions);
        assertEquals(expectation, result);
        String resultTwo = subject.print(transactions);
        assertEquals(expectation, resultTwo);
    }

    @Test
    @DisplayName("Prints statement for two credit transactions")
    void TestPrintsStatementForTwoCreditTransactions() {
        LocalDate date = LocalDate.of(2000,1,1);
        MockCreditTransaction mockTransaction = new MockCreditTransaction();
        transactions.add(mockTransaction);
        LocalDate dateTwo = LocalDate.of(2000,1,2);
        MockCreditTransactionTwo mockTransactionTwo = new MockCreditTransactionTwo();
        transactions.add(mockTransactionTwo);
        String result = subject.print(transactions);
        String lineOne = "date || credit || debit || balance\n";
        String lineTwo = "03/01/2000 || 25.00 || - || 125.00\n";
        String lineThree = "01/01/2000 || 100.00 || - || 100.00";
        String expectation = lineOne + lineTwo + lineThree;
        assertEquals(expectation, result);
    }

    @Test
    @DisplayName("Prints statement for credit and debit transactions")
    void TestPrintsStatementForCreditAndDebitTransactions() {
        MockCreditTransaction mockTransaction = new MockCreditTransaction();
        transactions.add(mockTransaction);
        MockDebitTransaction mockTransactionTwo = new MockDebitTransaction();
        transactions.add(mockTransactionTwo);
        MockCreditTransactionTwo mockTransactionThree = new MockCreditTransactionTwo();
        transactions.add(mockTransactionThree);
        String result = subject.print(transactions);
        String lineOne = "date || credit || debit || balance\n";
        String lineTwo = "03/01/2000 || 25.00 || - || 75.00\n";
        String lineThree = "02/01/2000 || - || 50.00 || 50.00\n";
        String lineFour = "01/01/2000 || 100.00 || - || 100.00";
        String expectation = lineOne + lineTwo + lineThree + lineFour;
        assertEquals(expectation, result);
    }

    private class MockCreditTransaction implements ITransaction {
        @Override
        public LocalDate getDate() {
            return LocalDate.of(2000,1,1);
        }

        @Override
        public double getCredit() {
            return 100;
        }

        @Override
        public double getDebit() {
            return 0;
        }
    }

    private class MockCreditTransactionTwo implements ITransaction {
        @Override
        public LocalDate getDate() {
            return LocalDate.of(2000,1,3);
        }

        @Override
        public double getCredit() {
            return 25;
        }

        @Override
        public double getDebit() {
            return 0;
        }
    }

    private class MockDebitTransaction implements ITransaction {
        @Override
        public LocalDate getDate() {
            return LocalDate.of(2000,1,2);
        }

        @Override
        public double getCredit() {
            return 0;
        }

        @Override
        public double getDebit() {
            return 50;
        }
    }
}
