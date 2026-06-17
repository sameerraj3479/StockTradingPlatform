import java.util.*;

public class StockMarket {

    private HashMap<String,Stock> market;

    public StockMarket(){

        market=new HashMap<>();

        market.put("AAPL",
                new Stock("AAPL","Apple",180));

        market.put("TSLA",
                new Stock("TSLA","Tesla",250));

        market.put("GOOG",
                new Stock("GOOG","Google",150));

        market.put("MSFT",
                new Stock("MSFT","Microsoft",320));
    }

    public void displayStocks(){

        System.out.println("\n===== Stock Market =====");

        for(Stock s:market.values()){

            System.out.println(
                s.getSymbol()+" | "+
                s.getName()+" | Rs. "+
                s.getPrice()
            );
        }
    }

    public Stock getStock(String symbol){

        return market.get(symbol.toUpperCase());

    }

    public HashMap<String,Stock> getMarket(){

        return market;

    }
}