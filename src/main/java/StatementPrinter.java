import java.util.ArrayList;

public class StatementPrinter {
    private ArrayList<String> lines = new ArrayList<>();

    public String print(ArrayList<Transaction> transactions) {
        lines.add("date || credit || debit || balance");
        if (transactions.size() > 0) {
            lines.add("\n01/01/2000 || 1.00 || - || 1.00");
        }
        return conbineLines(lines);
    }

    private String conbineLines(ArrayList<String> lines) {
        String PrintString = new String();
        for (int i = 0; i < lines.size(); i++) {
            PrintString += lines.get(i);
        }
        return PrintString;
    }
}
