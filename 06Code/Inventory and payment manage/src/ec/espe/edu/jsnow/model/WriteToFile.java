
package ec.espe.edu.jsnow.model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Yesteb JSnow
 */
public class WriteToFile {
    
    public static void insertData(Product product, String pathToFile) throws IOException{
        
        
       try (PrintWriter writer = new PrintWriter(new FileWriter(pathToFile, true))){
            writer.write(product.toString());
           System.out.println("El producto se ingreso exitosamente");
           
        } catch(IOException e){
            System.out.println("Error al guardar el producto");
        }
        
        
        
        
    }
    
    public static void insertDataFile(String anything, String pathToFile) throws IOException{
        
        
       try (PrintWriter writer = new PrintWriter(new FileWriter(pathToFile, true))){
            writer.write(anything);
           System.out.println("El producto se ingreso exitosamente");
           
        } catch(IOException e){
            System.out.println("Error al guardar el producto");
        }
        
        
        
        
    }
    
}
