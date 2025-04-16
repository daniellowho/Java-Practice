import java.util.Scanner;

public class case3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int categoryChoice, itemChoice, quantity;
        double totalBill = 0;
        boolean shopping = true;

        while (shopping) {
            // Display Categories
            System.out.println("\n📢 Welcome to Online Shopping! Choose a category:");
            System.out.println("1. Electronics");
            System.out.println("2. Clothing");
            System.out.println("3. Groceries");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            categoryChoice = sc.nextInt();

            // Category Switch-Case
            switch (categoryChoice) {
                case 1:
                    // Electronics Items
                    String[] electronics = {"Laptop", "Smartphone", "Headphones"};
                    double[] electronicsPrices = {800.00, 500.00, 50.00};
                    totalBill += selectItems(sc, electronics, electronicsPrices);
                    break;

                case 2:
                    // Clothing Items
                    String[] clothing = {"T-Shirt", "Jeans", "Jacket"};
                    double[] clothingPrices = {20.00, 40.00, 60.00};
                    totalBill += selectItems(sc, clothing, clothingPrices);
                    break;

                case 3:
                    // Groceries Items
                    String[] groceries = {"Milk", "Rice", "Bread"};
                    double[] groceriesPrices = {2.00, 10.00, 3.00};
                    totalBill += selectItems(sc, groceries, groceriesPrices);
                    break;

                case 4:
                    // Exit
                    shopping = false;
                    System.out.println("\n🛒 Thank you for shopping with us!");
                    break;

                default:
                    System.out.println("Invalid choice! Please select a valid category.");
            }
        }

        // Display Final Bill
        System.out.println("\n💰 Total Bill: $" + totalBill);
        sc.close();
    }

    // Method to Display Items & Calculate Price
    public static double selectItems(Scanner sc, String[] items, double[] prices) {
        System.out.println("\nSelect an item to purchase:");
        for (int i = 0; i < items.length; i++) {
            System.out.println((i + 1) + ". " + items[i] + " - $" + prices[i]);
        }
        System.out.print("Enter item number: ");
        int itemChoice = sc.nextInt();

        if (itemChoice < 1 || itemChoice > items.length) {
            System.out.println("❌ Invalid item choice!");
            return 0;
        }

        System.out.print("Enter quantity: ");
        int quantity = sc.nextInt();
        double cost = prices[itemChoice - 1] * quantity;

        System.out.println("\n✅ Added to cart: " + items[itemChoice - 1] + " x " + quantity);
        System.out.println("Subtotal: $" + cost);
        return cost;
    }
}
