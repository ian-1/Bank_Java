import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;

public class StatementPrinterTest {
    private StatementPrinter subject;
    private ArrayList<Transaction> transactions;

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
    @DisplayName("Prints statement for one transaction")
    void TestPrintsStatementForOneTransaction() {
        LocalDate date = LocalDate.of(2000,1,1);
        Transaction transaction = new Transaction(1,TransactionType.CREDIT, date);
        transactions.add(transaction);
        String result = subject.print(transactions);
        String lineOne = "date || credit || debit || balance\n";
        String lineTwo = "01/01/2000 || 1.00 || - || 1.00";
        String expectation = lineOne + lineTwo;
        assertEquals(expectation, result);
    }
}
