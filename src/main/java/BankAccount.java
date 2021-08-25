public class BankAccount {
    private double balance;

    public void bankAccount() {
        balance = 0;
    }

    public double getBalance() {
        return this.balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }
}
