import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class BankAccount {
    private ArrayList<Transaction> transactions = new ArrayList<>();

    public ArrayList getTransactions() {
        return this.transactions;
    }

    public void deposit(LocalDate date, double amount) {
        Transaction transaction = new Transaction(date, amount, TransactionType.CREDIT);
        this.transactions.add(transaction);
    }

    public void deposit(double amount) {
        deposit(LocalDate.now(), amount);
    }

    public void withdraw(LocalDate date, double amount) {
        Transaction transaction = new Transaction(date, amount, TransactionType.DEBIT);
        this.transactions.add(transaction);
    }

    public void withdraw(double amount) {
        withdraw(LocalDate.now(), amount);
    }

    public String generateStatement() {
        return "date || credit || debit || balance";
    }
}
