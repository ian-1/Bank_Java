import org.junit.jupiter.api.Test;

import java.time.LocalDate;

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
    void testCanMakeDepositWithDate() {
        BankAccount subject = new BankAccount();
        subject.deposit(25.10, LocalDate.of(2021, 1, 1));
        double result = subject.getBalance();
        assertEquals(25.10, result);
    }

    @Test
    void testCanMakeWithdrawal() {
        BankAccount subject = new BankAccount();
        subject.withdraw(50);
        double result = subject.getBalance();
        assertEquals(-50, result);
    }

    @Test
    void testCanMakeWithdrawalWithDate() {
        BankAccount subject = new BankAccount();
        subject.withdraw(9.99, LocalDate.of(1999, 12, 31));
        double result = subject.getBalance();
        assertEquals(-9.99, result);
    }

    @Test
    void testCanGenerateBlankStatement() {
        BankAccount subject = new BankAccount();
        String result = subject.generateStatement();
        String expected = "date || credit || debit || balance";
        assertEquals(expected, result);
    }
}
