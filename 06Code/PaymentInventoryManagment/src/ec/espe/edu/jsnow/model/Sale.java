
package ec.espe.edu.jsnow.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author yesteb
 */
public class Sale {

    private DateTimeFormatter dateTime;
    private String id;
    private String name;
    private double price;
    
    @Override
    public String toString() {
        return  (dateTime.format(LocalDateTime.now())+ "," + name + "," + price + "\n");
    }

    
    public Sale(DateTimeFormatter dateTime, String name, double price) {
        this.dateTime = dateTime;
        this.name = name;
        this.price = price;
    }
    
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
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
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
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    
    
}
