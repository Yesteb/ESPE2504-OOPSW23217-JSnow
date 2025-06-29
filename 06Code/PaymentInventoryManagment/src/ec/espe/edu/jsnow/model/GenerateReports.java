package ec.espe.edu.jsnow.model;

import static ec.espe.edu.jsnow.model.PrintFiles.printMenu;
import static ec.espe.edu.jsnow.model.ProductSale.registerProductSale;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    
    public static void registerProductOutputReport(String id,String name, double price) throws IOException {
        String pathToFileReport;
        Scanner scanner;
        DateTimeFormatter dateTime;
        String description;
        byte option;

        pathToFileReport = "src/resources/productOutputReport.csv";
        scanner = new Scanner(System.in);
        dateTime = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

        System.out.println("La salida del producto del sistema fue consecuencia de una venta?");
        System.out.println("[ 1 ] SI     |     [ 2 ] No  ");
        option = scanner.nextByte();
        switch (option) {
            case 1:
                registerProductSale(price, name, dateTime);
                System.console().readLine();
                break;
            case 2:
                
                System.out.println("Describa la razon de la salida del producto: ");
        description = scanner.nextLine();
        
        try (
                PrintWriter writerReport = new PrintWriter(new FileWriter(pathToFileReport));) {
            writerReport.write(id + "," + name + "," + description + "," + dateTime.format(LocalDateTime.now()) + "\n");
        } catch (IOException e) {
            System.err.println("No se encontro el archivo" + e.getMessage());
        }
        
        break;
        }

        
    }
    
    public static void showProductOutputReport(String directoryPath) throws FileNotFoundException{
        BufferedReader bufferedReader;
        String lineFile;
        
        bufferedReader = new BufferedReader(new FileReader(directoryPath));
        while((lineFile = bufferedReader.readLine()) != null){
              String[] columns;
              columns = lineFile.split(",");
            System.out.println(lineFile);
            
        }
        
    }
    
    public static void productOutputDescription(String column1, String column2, String column3, String column4) {
        System.out.println("--------------------------------------");
        System.out.println("Id: " + column1);
        System.out.println("--------------------------------------");
        System.out.println("Name: " + column3);
        System.out.println("--------------------------------------");
        System.out.println("Precio: " + column2);
        System.out.println("--------------------------------------");
        System.out.println("Fecha y Hora del Registro: " + column4);
        System.out.println("--------------------------------------");

    }
    
}
