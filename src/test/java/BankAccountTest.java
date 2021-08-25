import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountTest {
    @Test
    void testNewAccountsHaveZeroBalance() {
        BankAccount subject = new BankAccount();
        double result = subject.getBalance();
        assertEquals(0, result);
    }
}
