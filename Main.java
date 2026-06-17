import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StockMarket market = new StockMarket();

        User user = new User(10000);

        int choice;

        do {

            System.out.println("\n===== Stock Trading Platform =====");

            System.out.println("1. View Market");

            System.out.println("2. Buy Stock");

            System.out.println("3. Sell Stock");

            System.out.println("4. View Portfolio");

            System.out.println("5. Transaction History");

            System.out.println("6. Exit");

            System.out.print("Enter Choice : ");

            choice=sc.nextInt();

            switch(choice){

                case 1:

                    market.displayStocks();

                    break;

                case 2:

                    market.displayStocks();

                    System.out.print("Enter Symbol : ");

                    String buy=sc.next();

                    Stock buyStock=market.getStock(buy);

                    if(buyStock==null){

                        System.out.println("Invalid Symbol!");

                        break;
                    }

                    System.out.print("Quantity : ");

                    int bqty=sc.nextInt();

                    user.buyStock(buyStock,bqty);

                    break;

                case 3:

                    market.displayStocks();

                    System.out.print("Enter Symbol : ");

                    String sell=sc.next();

                    Stock sellStock=market.getStock(sell);

                    if(sellStock==null){

                        System.out.println("Invalid Symbol!");

                        break;
                    }

                    System.out.print("Quantity : ");

                    int sqty=sc.nextInt();

                    user.sellStock(sellStock,sqty);

                    break;

                case 4:

                    user.showPortfolio(market.getMarket());

                    break;

                case 5:

                    user.showHistory();

                    break;

                case 6:

                    System.out.println("Thank You!");

                    break;

                default:

                    System.out.println("Invalid Choice!");
            }

        }while(choice!=6);

        sc.close();
    }
}