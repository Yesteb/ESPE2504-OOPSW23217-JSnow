
package ec.espe.edu.jsnow.view;
//import static ec.espe.edu.jsnow.model.CredentialUserCreate.hashCredential;
import static ec.espe.edu.jsnow.model.Inventory.inventoryMenu;
import static ec.espe.edu.jsnow.model.Login.login;
import static ec.espe.edu.jsnow.model.PrintFiles.printMenu;

import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author yesteb
 */
public class JSnowSystem {
    public static void main(String[] args) throws IOException {
        Scanner scanner;
        byte option;
        
        scanner = new Scanner(System.in);
        //hashCredential();
        login();
        printMenu("src/resources/mainMenu.txt");
        option = scanner.nextByte();
        
        switch(option){
            case 1: 
              inventoryMenu();
                break;
        }
        
        
        
        
    }
    
}
