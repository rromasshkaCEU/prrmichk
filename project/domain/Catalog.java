package domain;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Catalog {
    private ArrayList<Product> catalog;
      
    public Catalog() {
        this.catalog = new ArrayList<>();
    }

    public void addProduct(Product product) {
        this.catalog.add(product);
    }

    public void displayCatalog() {
      if (catalog.isEmpty()) {
          System.out.println("The catalog is empty.");
      } else {
          System.out.println("Loading...");
          for (Product product : catalog) {
              System.out.println("Name: " + product.getName() + ", Price: " + product.getPrice() + ", Colour: " + product.getColour());
          }
      }
}

    public void loadProducts() {
        try {
            File file = new File("ProductFile.csv");
            if (file.createNewFile()) {
                System.out.println("New file created: ProductFile.csv");
            }
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter(",|\n");

            while (scanner.hasNext()) {
                String name = scanner.next();
                double price = Double.parseDouble(scanner.next());
                String colour = scanner.next();
                Product product = new Product(name, price, colour);
                this.catalog.add(product);
            }

            scanner.close();
            System.out.println("Products loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error loading products from file.");
    }

    public void dumpProducts() {
        try {
            FileWriter writer = new FileWriter("ProductFile.csv");
            for (Product product : catalog) {
                writer.write(product.getName() + "," + product.getPrice() + "," + product.getColour());
            }
            writer.close();
            System.out.println("Products saved successfully.");
        } catch (IOException e) {
            System.out.println("Error.");
        }
    }


    public String toString() {
        StringBuilder catalogString = new StringBuilder();
        for (Product product : catalog) {
            catalogString.append(product.getName() + "," + product.getPrice() + "," + product.getColour());
        }
        return catalogString.toString().trim();
    }
}
