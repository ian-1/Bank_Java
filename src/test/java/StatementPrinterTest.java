import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
