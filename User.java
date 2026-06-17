import java.util.*;

public class User {

    private double balance;
    private HashMap<String, Integer> portfolio;
    private ArrayList<Transaction> history;

    public User(double balance) {
        this.balance = balance;
        portfolio = new HashMap<>();
        history = new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }

    public void buyStock(Stock stock, int qty) {

        double cost = stock.getPrice() * qty;

        if(cost > balance){
            System.out.println("Insufficient Balance!");
            return;
        }

        balance -= cost;

        portfolio.put(stock.getSymbol(),
                portfolio.getOrDefault(stock.getSymbol(),0)+qty);

        history.add(new Transaction("BUY",stock.getSymbol(),qty));

        System.out.println("Stock Purchased Successfully!");
    }

    public void sellStock(Stock stock,int qty){

        int owned = portfolio.getOrDefault(stock.getSymbol(),0);

        if(owned<qty){
            System.out.println("Not enough shares!");
            return;
        }

        balance += stock.getPrice()*qty;

        if(owned==qty)
            portfolio.remove(stock.getSymbol());
        else
            portfolio.put(stock.getSymbol(),owned-qty);

        history.add(new Transaction("SELL",stock.getSymbol(),qty));

        System.out.println("Stock Sold Successfully!");
    }

    public void showPortfolio(HashMap<String,Stock> market){

        System.out.println("\n===== Portfolio =====");

        double total=balance;

        if(portfolio.isEmpty()){
            System.out.println("No Stocks Purchased.");
        }

        for(String symbol:portfolio.keySet()){

            int qty=portfolio.get(symbol);

            Stock s=market.get(symbol);

            double value=s.getPrice()*qty;

            total+=value;

            System.out.println(symbol+" -> "+qty+
                " Shares | Value = Rs. "+value);
        }

        System.out.println("Cash Balance : Rs. "+balance);
        System.out.println("Net Worth : Rs. "+total);
    }

    public void showHistory(){

        System.out.println("\n===== Transactions =====");

        if(history.isEmpty()){
            System.out.println("No Transactions.");
            return;
        }

        for(Transaction t:history){
            System.out.println(t);
        }
    }
}