import java.time.LocalDate;

public class Transaction {
    private LocalDate date;
    private double credit;
    private double debit;

    public Transaction(LocalDate date, double amount, TransactionType type) {
        this.date = date;
        if (type == TransactionType.CREDIT) {
            this.credit = amount;
            this.debit = 0;
        } else if (type == TransactionType.DEBIT) {
            this.credit = 0;
            this.debit = amount;
        }
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
