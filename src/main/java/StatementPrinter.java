import java.time.LocalDate;
import java.util.ArrayList;

public class StatementPrinter {
    private ArrayList<String> lines;
    private final String HEADER = "date || credit || debit || balance";

    public StatementPrinter() {
        lines = new ArrayList<>();
    }

    public String print(ArrayList<ITransaction> transactions) {
        lines = fillLines(transactions);
        String combinedLines = combineLines(lines);
        lines.clear();
        return combinedLines;
    }

    private ArrayList<String> fillLines(ArrayList<ITransaction> transactions) {
        ArrayList<String> returnLines = new ArrayList<>();
        returnLines.add(HEADER);
        if (!transactions.isEmpty()) {
            ArrayList<ITransaction> sortedTransactions = sort(transactions);
            int i = 0;
            for (ITransaction transaction : sortedTransactions) {
                double balance = getBalance(i, sortedTransactions);
                returnLines.add(line(transaction, balance));
                i += 1;
            }
        }
        return returnLines;
    }

    private String line(ITransaction transaction, double balance) {
        String line = "";
        line += "\n";
        line += britDate(transaction);
        line += " || ";
        line += zeroToDash(transaction.getCredit());
        line += " || ";
        line += zeroToDash(transaction.getDebit());
        line += " || ";
        line += String.format("%.2f", balance);
        return line;
    }

    private double getBalance(int index, ArrayList<ITransaction> sortedTransactions) {
        double balance = 0;
        for (int i = sortedTransactions.size() - 1; i >= index; i--) {
            balance += sortedTransactions.get(i).getCredit();
            balance -= sortedTransactions.get(i).getDebit();
        }
        return balance;
    }

    private String britDate(ITransaction transaction) {
        LocalDate localDate = transaction.getDate();
        String date = "";
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

    private String zeroToDash(double amount) {
        if (amount == 0) {
            return "-";
        } else {
            return String.format("%.2f", amount);
        }
    }

    private ArrayList<ITransaction> sort(ArrayList<ITransaction> transactions) {
        return reverse(transactions);
    }

    private ArrayList<ITransaction> reverse(ArrayList<ITransaction> transactions) {
        ArrayList<ITransaction> reverseTransactions = new ArrayList<>();
        for (int i = transactions.size(); i > 0; i--) {
            reverseTransactions.add(transactions.get(i - 1));
        }
        return reverseTransactions;
    }

    private String combineLines(ArrayList<String> lines) {
        StringBuilder returnString = new StringBuilder();
        for (String line : lines) {
            returnString.append(line);
        }
        return returnString.toString();
    }
}
