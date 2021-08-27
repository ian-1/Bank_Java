import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class BankAccount {
    private ArrayList<Transaction> transactions = new ArrayList<>();

    public ArrayList getTransactions() {
        return this.transactions;
    }

    public void deposit(double amount, LocalDate date) {
        Transaction transaction = new Transaction(amount, TransactionType.CREDIT, date);
        this.transactions.add(transaction);
    }

    public void deposit(double amount) {
        deposit(amount, LocalDate.now());
    }

    public void withdraw(double amount, LocalDate date) {
        Transaction transaction = new Transaction(amount, TransactionType.DEBIT, date);
        this.transactions.add(transaction);
    }

    public void withdraw(double amount) {
        withdraw(amount, LocalDate.now());
    }

    public String generateStatement() {
        StatementPrinter printer = new StatementPrinter();
        return printer.print(transactions);
    }
}
