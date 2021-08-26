import java.time.LocalDate;

public class BankAccount {
    private double balance;

    public BankAccount() {
        balance = 0;
    }

    public double getBalance() {
        return this.balance;
    }

    public void deposit(double amount, LocalDate date) {
        this.balance += amount;
    }

    public void deposit(double amount) {
        deposit(amount, LocalDate.now());
    }

    public void withdraw(double amount, LocalDate date) {
        this.balance -= amount;
    }

    public void withdraw(double amount) {
        withdraw(amount, LocalDate.now());
    }

    public String generateStatement() {
        return "date || credit || debit || balance";
    }
}
