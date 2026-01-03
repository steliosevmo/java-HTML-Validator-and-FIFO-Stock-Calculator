import java.io.File;
import java.util.Scanner;

public class NetProfit {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File(args[0]));
            DoubleQueueImpl<Double> queue = new DoubleQueueImpl<Double>();

            String line;
            double net_profit = 0; // Changed to double for precision with prices
            int stock_quantity = 0;

            while (scanner.hasNextLine()) {
                line = scanner.nextLine();

                if (line.toLowerCase().contains("buy")) {
                    String[] words = line.split(" ");
                    stock_quantity += Integer.parseInt(words[1]);
                    // Store quantity followed by price in the queue
                    queue.put(Double.parseDouble(words[1]));
                    queue.put(Double.parseDouble(words[3]));

                }
                else if (line.toLowerCase().contains("sell")) {
                    String[] words = line.split(" ");
                    double requestedToSell = Double.parseDouble(words[1]);
                    
                    // Check if enough shares are available
                    if (stock_quantity < requestedToSell) { 
                        System.out.println("Error: Not enough shares available to sell.");
                    }
                    else {
                        double sellStocks = requestedToSell;
                        double sellPrice = Double.parseDouble(words[3]);

                        while (sellStocks != 0.0) {
                            double buyQuantity = queue.peek();
                            // Access the price which is the next node
                            double buyPrice = queue.getFirst().next.value;

                            if (buyQuantity > sellStocks) {
                                queue.getFirst().value -= sellStocks;
                                net_profit += sellStocks * (sellPrice - buyPrice);
                                stock_quantity -= sellStocks;
                                break;
                            }
                            else {
                                sellStocks -= buyQuantity;
                                stock_quantity -= buyQuantity;
                                net_profit += queue.get() * (sellPrice - buyPrice);
                                queue.get(); // Remove the price node from queue
                            }
                        }
                    }
                }
            }
            System.out.println("Total Net Profit: " + net_profit);
        } catch (Exception e) {
            System.out.println("Error: File not found or invalid format.");
        }
    }
}