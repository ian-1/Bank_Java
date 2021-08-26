import java.time.LocalDate;

public class Transaction {
    private LocalDate date;
    private double debit;

    public Transaction(LocalDate date, double amount) {
        this.date = date;
        this.debit = amount;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public double getDebit() {
        return this.debit;
    }
}
