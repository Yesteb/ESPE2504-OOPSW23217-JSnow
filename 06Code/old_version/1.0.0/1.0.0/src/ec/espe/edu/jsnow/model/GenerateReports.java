
package ec.espe.edu.jsnow.model;

import static ec.espe.edu.jsnow.model.PrintFiles.printMenu;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Yesteb JSnow
 */
public class GenerateReports {
    
    public static void printReports(String pathToFileProductOutputReport, String pathToFileNewProductReport) throws IOException{
        Scanner scanner;
        byte option;
        String pathReportOption;
        boolean access;
        
        access = true;
        pathReportOption = "src/resources/reportOption.txt";
        scanner = new Scanner(System.in);
        
        while(access){
        
        printMenu(pathReportOption);
        option = scanner.nextByte();
        switch(option){
            case 1:
                printMenu(pathToFileNewProductReport);
                break;
            case 2:
                printMenu(pathToFileProductOutputReport);
                break;
            case 3:
                System.out.println("Regresando...");
                return;
        }
    }
        
        
    }
    
}
