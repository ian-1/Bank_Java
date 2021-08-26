import java.time.LocalDate;

public class Transaction {
    private LocalDate date;
    private double credit;

    public Transaction(LocalDate date, double amount) {
        this.date = date;
        this.credit = amount;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public double getCredit() {
        return this.credit;
    }
}
