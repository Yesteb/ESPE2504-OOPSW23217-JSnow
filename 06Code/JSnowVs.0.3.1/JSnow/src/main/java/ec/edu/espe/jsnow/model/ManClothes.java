
package ec.edu.espe.jsnow.model;

import java.time.format.DateTimeFormatter;

/**
 *
 * @author Yesteb JSnow
 */
public class ManClothes extends Product {


    public ManClothes(DateTimeFormatter dateTime, int id, String name, String size, float price, int stock, String color, int quantity, String model) {
        super(dateTime, id, name, size, price, stock, color, quantity, model);
    }
    
      @Override
    void updateStock(int quantity) {
        quantity+=1;
    }

  
    
}
