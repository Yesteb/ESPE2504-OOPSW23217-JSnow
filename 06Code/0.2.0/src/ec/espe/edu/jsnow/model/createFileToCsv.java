
package ec.espe.edu.jsnow.model;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Yesteb JSnow
 */
public class createFileToCsv {
    public static void productToCsv(Product product) throws IOException{
        
        FileWriter writer;
        String fileName;
        String[] row;
        
        fileName = "src/resources/productList.csv";
        
        writer = new FileWriter(fileName, true);
        row = product.toCsvRow();
        
        
        writer.write("Category,ProductId,Name,Price,QuantityInStock,Size\n");
        
        writer.write(String.join(",", row));
        
        writer.write("\n");
        
        
    }
}
