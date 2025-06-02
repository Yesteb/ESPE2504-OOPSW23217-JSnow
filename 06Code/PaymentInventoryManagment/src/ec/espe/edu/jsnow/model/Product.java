
package ec.espe.edu.jsnow.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author yesteb
 */
public class Product {
    private int id;
    private double price;
    private String name;
    private DateTimeFormatter dateTime;
    
    @Override
    public String toString() {
        return (id + "," + price + "," + name + "," + dateTime.format(LocalDateTime.now()) + "\n");
    }

    
    public Product(int id, double price, String name, DateTimeFormatter dateTime){
        this.id = id;
        this.dateTime = dateTime;
        this.price = price;
        this.name = name;
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
     * @return the price
     */
    public double getPrice() {
        return price;
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
     * @param price the price to set
     */
    public void setPrice(float price) {
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


    
    }








