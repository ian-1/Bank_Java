import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountTest {
    @Test
    void testNewAccountsHaveZeroBalance() {
        BankAccount subject = new BankAccount();
        double result = subject.getBalance();
        assertEquals(0, result);
    }

    @Test
    void testCanMakeDeposit() {
        BankAccount subject = new BankAccount();
        subject.deposit(100);
        double result = subject.getBalance();
        assertEquals(100, result);
    }

    @Test
    void testCanMakeWithdrawal() {
        BankAccount subject = new BankAccount();
        subject.withdraw(50);
        double result = subject.getBalance();
        assertEquals(-50, result);
    }
}
