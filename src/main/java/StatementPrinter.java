import java.time.LocalDate;
import java.util.ArrayList;

public class StatementPrinter {
    private ArrayList<String> lines = new ArrayList<>();

    public String print(ArrayList<Transaction> transactions) {
        lines.add("date || credit || debit || balance");
        if (transactions.size() > 0) {
            ArrayList<Transaction> sortedTransactions = sort(transactions);
            int i = 0;
            for (Transaction transaction : sortedTransactions) {
                double balance = getBalance(i, sortedTransactions);
                lines.add(line(transaction, balance));
                i += 1;
            }
        }
        return combineLines(lines);
    }

    private String line(Transaction transaction, double balance) {
        String line = new String();
        line += "\n";
        line += britDate(transaction);
        line += " || ";
        line += String.format("%.2f", transaction.getCredit());
        line += " || - || ";
        line += String.format("%.2f", balance);
        return line;
    }

    private double getBalance(int index, ArrayList<Transaction> sortedTransactions) {
        double balance = 0;
        for (int i = sortedTransactions.size() - 1; i >= index; i--) {
            balance += sortedTransactions.get(i).getCredit();
        }
        return balance;
    }

    private String britDate(Transaction transaction) {
        LocalDate localDate = transaction.getDate();
        String date = new String();
        String day = Integer.toString(localDate.getDayOfMonth());
        String month = Integer.toString(localDate.getMonthValue());
        String year = Integer.toString(localDate.getYear());
        date += leadZero(day) + "/" + leadZero(month) + "/" + year;
        return date;
    }

    private String leadZero(String number) {
        if (number.length() < 2) {
            return "0" + number;
        } else {
            return number;
        }
    }

    private ArrayList<Transaction> sort(ArrayList<Transaction> transactions) {
        return reverse(transactions);
    }

    private ArrayList<Transaction> reverse(ArrayList<Transaction> transactions) {
        ArrayList<Transaction> reverseTransactions = new ArrayList<>();
        for (int i = transactions.size(); i > 0; i--) {
            reverseTransactions.add(transactions.get(i - 1));
        }
        return reverseTransactions;
    }

    private String combineLines(ArrayList<String> lines) {
        String PrintString = new String();
        for (int i = 0; i < lines.size(); i++) {
            PrintString += lines.get(i);
        }
        return PrintString;
    }
}
