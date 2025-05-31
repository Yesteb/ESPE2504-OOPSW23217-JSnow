package ec.espe.edu.jsnow.model;

import static ec.espe.edu.jsnow.model.PrintFiles.printMenu;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author yesteb
 */
public class Inventory {
    public static void inventoryMenu() throws IOException{
        Scanner scanner;
        byte option;
        
        scanner = new Scanner(System.in);
        
        printMenu("src/resources/inventoryMenu.txt");
        option = scanner.nextByte();
        
        switch(option){
            case 1:
                newProductRegister();
                break;
        }
    }
            
            
    public static void newProductRegister() throws IOException {

        PrintWriter writer;
        Scanner scanner;
        byte option;
        
        scanner = new Scanner(System.in);
        
        printMenu("src/resources/inventoryMenuCase1.txt");
        
        
        
        
        writer = new PrintWriter(new FileWriter("src/resources/productList.csv", true));
        
       
       
    }

}
