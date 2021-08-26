import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountTest {
    private BankAccount subject;

    @BeforeEach
    void setup() {
        subject = new BankAccount();
    }

    @Nested
    @DisplayName("New Accounts")
    public class NewAccounts {
        @Test
        @DisplayName("New accounts have zero balance")
        void testNewAccountsHaveZeroBalance() {
            double result = subject.getBalance();
            assertEquals(0, result);
        }
    }

    @Nested
    @DisplayName("Deposits")
    public class Deposits {
        @Test
        @DisplayName("Can make deposit")
        void testCanMakeDeposit() {
            subject.deposit(100);
            double result = subject.getBalance();
            assertEquals(100, result);
        }

        @Test
        @DisplayName("Can make deposit with date")
        void testCanMakeDepositWithDate() {
            subject.deposit(25.10, LocalDate.of(2021, 1, 1));
            double result = subject.getBalance();
            assertEquals(25.10, result);
        }
    }

    @Nested
    @DisplayName("Withdrawals")
    public class Withdrawals {
        @Test
        @DisplayName("Can make withdrawal")
        void testCanMakeWithdrawal() {
            subject.withdraw(50);
            double result = subject.getBalance();
            assertEquals(-50, result);
        }

        @Test
        @DisplayName("Can make withdrawal with date")
        void testCanMakeWithdrawalWithDate() {
            subject.withdraw(9.99, LocalDate.of(1999, 12, 31));
            double result = subject.getBalance();
            assertEquals(-9.99, result);
        }
    }

    @Nested
    @DisplayName("Statements")
    public class Statements {
        @Test
        @DisplayName("Can generate blank statement")
        void testCanGenerateBlankStatement() {
            String result = subject.generateStatement();
            String expected = "date || credit || debit || balance";
            assertEquals(expected, result);
        }
    }
}
