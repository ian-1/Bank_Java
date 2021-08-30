import java.time.LocalDate;

public class Transaction implements ITransaction {
    private LocalDate date;
    private double credit;
    private double debit;

    public Transaction(double amount, TransactionType type, LocalDate date) {
        this.date = date;
        if (type == TransactionType.CREDIT) {
            this.credit = amount;
            this.debit = 0;
        } else if (type == TransactionType.DEBIT) {
            this.credit = 0;
            this.debit = amount;
        }
    }

    @Override
    public LocalDate getDate() {
        return this.date;
    }

    @Override
    public double getCredit() {
        return this.credit;
    }

    @Override
    public double getDebit() {
        return this.debit;
    }
}
