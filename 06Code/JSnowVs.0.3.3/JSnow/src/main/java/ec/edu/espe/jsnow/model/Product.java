
package ec.edu.espe.jsnow.model;

import java.time.format.DateTimeFormatter;

/**
 *
 * @author Yesteb JSnow
 */
public abstract class Product {
    private DateTimeFormatter dateTime;
    private int id;
    private String name;
    private String size;
    private float price;
    private int stock;
    private String color;
    private int quantity;
    private String model;

    public Product(DateTimeFormatter dateTime, int id, String name, String size, float price, int stock, String color, int quantity, String model) {
        this.dateTime = dateTime;
        this.id = id;
        this.name = name;
        this.size = size;
        this.price = price;
        this.stock = stock;
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
        sb.append(", stock=").append(stock);
        sb.append(", color=").append(color);
        sb.append(", quantity=").append(quantity);
        sb.append(", model=").append(model);
        sb.append('}');
        return sb.toString();
    }
    
    

    
    abstract void updateStock(int quantity);
        
    /**
     * @return the dateTime
     */
    public DateTimeFormatter getDateTime() {
        return dateTime;
    }

    /**
     * @param dateTime the dateTime to set
     */
    public void setDateTime(DateTimeFormatter dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the size
     */
    public String getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    
    
}
