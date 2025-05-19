
package ec.espe.edu.jsnow.model;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 *
 * @author Yesteb JSnow
 */
public class PrintFiles {
    
    public static void printMenu(String directoryPath) throws FileNotFoundException, IOException{
        BufferedReader bufferedReader;
        String lineFile;
        
        bufferedReader = new BufferedReader(new FileReader(directoryPath));
        while((lineFile = bufferedReader.readLine()) != null){
            System.out.println(lineFile);
        }
        bufferedReader.close();
    }
}
