package domain;

public class Product {
    private String name;
    private Double price;
    private String colour;

    public Product(String name, Double price, String colour) {
        this.name = name;
        this.price = price;
        this.colour = colour;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getColour() {
        return colour;
    }
}
