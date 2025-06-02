package ec.espe.edu.jsnow.model;

import static ec.espe.edu.jsnow.model.Inventory.newProductRegister;
import static ec.espe.edu.jsnow.model.Inventory.searchProductCSV;
import static ec.espe.edu.jsnow.model.Inventory.productOutput;
import static ec.espe.edu.jsnow.model.PrintFiles.printMenu;
import java.io.IOException;
import static java.lang.System.exit;
import java.util.Scanner;

/**
 *
 * @author Yesteb JSnow
 */
public class EmployeSession {

    public static void employeSession() throws IOException {
        Scanner scanner;
        byte option;
        int id;
        String toStringId;
        String pathToEmployeMenu;
        String pathToFileCSV;
        String pathtoFileProductOutputReport;
        
        pathtoFileProductOutputReport = "src/resources/productOutputReport.txt";
        pathToEmployeMenu = "src/resources/employeMenu.txt";
        pathToFileCSV = "src/resources/productList.csv";
        scanner = new Scanner(System.in);
        option = 0;

        while (true) {
            printMenu(pathToEmployeMenu);
            option = scanner.nextByte();

            switch (option) {
                case 1:
                    newProductRegister();
                    break;
                case 2:
                    System.out.print("Ingrese el Id del producto (5 cifras): ");
                    id = scanner.nextInt();
                    if(id > 99999 || id <10000){
                        throw new ArithmeticException("Debe de ingresar 5 cifras");
                    }
                    toStringId = String.valueOf(id);
                    
                    searchProductCSV(toStringId, pathToFileCSV);
                    
                    break;
                case 3:
                    
                    System.out.print("Ingrese el Id del producto (5 cifras): ");
                    id = scanner.nextInt();
                    if(id > 99999 || id <10000){
                        throw new ArithmeticException("Debe de ingresar 5 cifras");
                    }
                    toStringId = String.valueOf(id);
     
                    productOutput(toStringId,pathToFileCSV);
                    
                    break;
                case 4:
                    System.out.println("Cerrando el Sistema...");
                    System.out.println("Nos vemos luego! >^..^<");
                    exit(0);
                    break;
            }
        }

    }
}
