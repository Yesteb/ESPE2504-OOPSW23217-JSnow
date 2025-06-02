package ec.espe.edu.jsnow.model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Yesteb JSnow
 */
public class WriteToFile {

    public static void insertProductData(Product product, String pathToFile) throws IOException {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(pathToFile, true));
            writer.write(product.toString());
            System.out.println("El producto se ingreso exitosamente");
        } catch (IOException e) {
            System.out.println("Error al guardar el producto");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    

    public static void insertSaleData(Sale sale, String pathToFile) throws IOException {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(pathToFile, true));
            writer.write(sale.toString());
            System.out.println("La venta se registro exitosamente!...");
        } catch (IOException e) {
            System.out.println("Error al guardar el producto");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

}
