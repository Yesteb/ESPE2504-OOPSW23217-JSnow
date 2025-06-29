package ec.espe.edu.jsnow.model;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Yesteb JSnow
 */
public class ProductSale {
    
    public static void registerProductSale(float price, String name, DateTimeFormatter dateTime) throws IOException{
        Sale sale;
        String pathToSaleRegister;
                
        pathToSaleRegister = "src/resources/productSalesRegister.csv";
        dateTime = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        sale = new Sale(dateTime, name, price);

        WriteToFile.insertSaleData(sale, pathToSaleRegister);
        
    }
    
}
