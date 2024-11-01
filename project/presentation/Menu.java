package presentation;

import java.util.Scanner;
import domain.Catalog;
import domain.Product;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Catalog catalog = new Catalog();

        while (true) {
            System.out.println("\n!Welcome to the Catalog! (to navigate the system, use numbers 1-4)");
            System.out.println("1 = Add a new product to the catalog");
            System.out.println("2 = Display products");
            System.out.println("3 = Load products from the file");
            System.out.println("4 = Save products to the file");
            System.out.println("5 = Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Please enter the name of the new product: ");
                    String name = scanner.nextLine();
                    System.out.print("Please enter the price of the new product: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine(); 
                    System.out.print("Please enter the color of the new product: ");
                    String colour = scanner.nextLine();
                    catalog.addProduct(new Product(name, price, colour));
                    System.out.println("Product added successfully.");
                    break;

                case 2:
                    System.out.println("Displaying products...");
                    catalog.displayCatalog();
                    break;

                case 3:
                    System.out.println("Loading products from the file...");
                    catalog.loadProducts();
                    break;

                case 4:
                    System.out.println("Saving products to the file...");
                    catalog.dumpProducts();
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 5.");
                    break;
            }
        }
    }
}
