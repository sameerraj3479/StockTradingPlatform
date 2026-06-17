public class Transaction {

    private String type;
    private String symbol;
    private int quantity;

    public Transaction(String type, String symbol, int quantity) {
        this.type = type;
        this.symbol = symbol;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return type + " -> " + symbol + " (" + quantity + " shares)";
    }
}