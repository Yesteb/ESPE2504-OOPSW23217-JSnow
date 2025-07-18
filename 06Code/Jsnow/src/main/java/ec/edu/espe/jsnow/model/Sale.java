
package ec.edu.espe.jsnow.model;

import java.time.format.DateTimeFormatter;

/**
 *
 * @author Yesteb JSnow
 */
public class Sale {
    private int id;
    private DateTimeFormatter dateTime;
    private float total;

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
     * @return the total
     */
    public float getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(float total) {
        this.total = total;
    }
    
    public static void registerSale(){
        
    }
    
}
