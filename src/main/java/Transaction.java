import java.time.LocalDate;

public class Transaction {
    private LocalDate date;
    private double credit;
    private double debit;

    public Transaction(LocalDate date, double amount) {
        this.date = date;
        this.credit = amount;
    }

    public Transaction(LocalDate date, double amount, String type) {
        this.date = date;
        this.debit = amount;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public double getCredit() {
        return this.credit;
    }

    public double getDebit() {
        return this.debit;
    }
}
