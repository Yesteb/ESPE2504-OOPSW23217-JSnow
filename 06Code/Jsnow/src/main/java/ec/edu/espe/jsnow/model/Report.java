
package ec.edu.espe.jsnow.model;

import java.time.format.DateTimeFormatter;

/**
 *
 * @author Yesteb JSnow
 */
public class Report {
    private String type;
    private DateTimeFormatter dateTime;

    public Report(String type, DateTimeFormatter dateTime) {
        this.type = type;
        this.dateTime = dateTime;
    }
    
    
    
    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
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
