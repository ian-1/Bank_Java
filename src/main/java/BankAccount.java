import java.time.LocalDate;
import java.util.ArrayList;

public class BankAccount {
    private ArrayList<ITransaction> transactions;
    private StatementPrinter printer;

    public BankAccount() {
        transactions = new ArrayList<>();
        printer = new StatementPrinter();
    }

    public ArrayList<ITransaction> getTransactions() {
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
        return printer.print(transactions);
    }
}
