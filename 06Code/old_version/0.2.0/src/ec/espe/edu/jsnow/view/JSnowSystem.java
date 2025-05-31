
package ec.espe.edu.jsnow.view;
//import static ec.espe.edu.jsnow.model.CredentialUserCreate.hashCredential;
import static ec.espe.edu.jsnow.model.Inventory.inventoryMenu;
import static ec.espe.edu.jsnow.model.Login.login;
import static ec.espe.edu.jsnow.model.PrintFiles.printMenu;
import static ec.espe.edu.jsnow.view.Register.showRegisterMenu;

import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author yestebasd
 * @author Jahir Sivinta DCCO ESPE
 */
public class JSnowSystem {
    public static void main(String[] args) throws IOException {
        byte option;
       
        Scanner scanner = new Scanner(System.in);
        
        // Mostrar el menú de registro antes del login
        showRegisterMenu();

     
        
        Register.register();
        scanner = new Scanner(System.in);
        printMenu("src/resources/loginMenu.txt");
        
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
