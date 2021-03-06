import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        @DisplayName("New accounts have no transactions")
        void testNewAccountsHaveNoTransactions() {
            ArrayList<ITransaction> transactions = subject.getTransactions();
            assertEquals(0, transactions.size());
        }

        @Test
        @DisplayName("Can generate blank statement")
        // Needs to be stubbed to test calling Transaction without actually calling
        void testCanGenerateBlankStatement() {
            String result = subject.generateStatement();
            String expected = "date || credit || debit || balance";
            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("Deposits")
    public class Deposits {
        @Test
        @DisplayName("Can make deposit")
        // Needs to be stubbed to test calling Transaction with correct arguments
        void testCanMakeDeposit() {
            subject.deposit(100);
            ArrayList<ITransaction> transactions = subject.getTransactions();
            Transaction transaction = (Transaction) transactions.get(transactions.size() - 1);
            double credit = transaction.getCredit();
            assertEquals(100, credit);
        }

        @Test
        @DisplayName("Can make deposit with date")
        // Needs to be stubbed to test calling Transaction with correct arguments
        void testCanMakeDepositWithDate() {
            LocalDate date = LocalDate.of(2021, 1, 1);
            subject.deposit(25.10, date);
            ArrayList<ITransaction> transactions = subject.getTransactions();
            Transaction transaction = (Transaction) transactions.get(transactions.size() - 1);
            LocalDate recordedDate = transaction.getDate();
            assertEquals(date, recordedDate);
        }
    }

    @Nested
    @DisplayName("Withdrawals")
    public class Withdrawals {
        @Test
        @DisplayName("Can make withdrawal")
        // Needs to be stubbed to test calling Transaction with correct arguments
        void testCanMakeWithdrawal() {
            subject.withdraw(50);
            ArrayList<ITransaction> transactions = subject.getTransactions();
            Transaction transaction = (Transaction) transactions.get(transactions.size() - 1);
            double debit = transaction.getDebit();
            assertEquals(50, debit);
        }

        @Test
        @DisplayName("Can make withdrawal with date")
        // Needs to be stubbed to test calling Transaction with correct arguments
        void testCanMakeWithdrawalWithDate() {
            LocalDate date = LocalDate.of(1999, 12, 31);
            subject.withdraw(9.99, date);
            ArrayList<ITransaction> transactions = subject.getTransactions();
            Transaction transaction = (Transaction) transactions.get(transactions.size() - 1);
            LocalDate recordedDate = transaction.getDate();
            assertEquals(date, recordedDate);
        }
    }
}
