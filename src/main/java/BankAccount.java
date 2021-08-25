import java.time.LocalDate;

public class BankAccount {
    private double balance;

    public void bankAccount() {
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

    public void withdraw(double amount) {
        this.balance -= amount;
    }
}
