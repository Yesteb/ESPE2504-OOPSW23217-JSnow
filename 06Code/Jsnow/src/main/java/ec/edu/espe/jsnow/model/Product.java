package ec.edu.espe.jsnow.model;

import java.time.LocalDateTime;

public class Product {
    private LocalDateTime dateTime;
    private int id;
    private String name;
    private String size;
    private float price;
    private String color;
    private int quantity;
    private String model;

    public Product(LocalDateTime dateTime, int id, String name, String size, float price, String color, int quantity, String model) {
        this.dateTime = dateTime;
        this.id = id;
        this.name = name;
        this.size = size;
        this.price = price;
        this.color = color;
        this.quantity = quantity;
        this.model = model;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Product{");
        sb.append("dateTime=").append(dateTime);
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", size=").append(size);
        sb.append(", price=").append(price);
        sb.append(", color=").append(color);
        sb.append(", quantity=").append(quantity);
        sb.append(", model=").append(model);
        sb.append('}');
        return sb.toString();
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
}