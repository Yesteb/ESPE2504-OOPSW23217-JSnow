package ec.espe.edu.jsnow.model;

import static ec.espe.edu.jsnow.model.CredentialUserCreate.credentialUserCreate;
import static ec.espe.edu.jsnow.model.GenerateReports.printReports;
import static ec.espe.edu.jsnow.model.PrintFiles.printMenu;
import java.io.IOException;
import static java.lang.System.exit;
import java.util.Scanner;

/**
 *
 * @author Yesteb JSnow
 */
public class AdminSession {

    public static void adminSession() throws IOException {
        Scanner scanner;
        byte option;
        String filePath;
        String pathToFileNewProductReport;
        String pathToFileProductOutputReport;
        
        filePath = "src/resources/adminMenu.txt";
        scanner = new Scanner(System.in);
        option = 0;
        pathToFileProductOutputReport = "src/resources/productOutputReport.txt";
        pathToFileNewProductReport = "src/resources/newProductReport.txt";
        
        while (true) {
            printMenu(filePath);
            option = scanner.nextByte();

            switch (option) {
                case 1:
                    credentialUserCreate();
                    
                    break;
                case 2:
                    printReports( pathToFileProductOutputReport, pathToFileNewProductReport);
                    
                    break;
                case 3:
                    System.out.println("Cerrando Sistema...");
                    System.out.println("Hasta luego >^..^<");
                    exit(0);
                    break;

            }
        }

    }
}
