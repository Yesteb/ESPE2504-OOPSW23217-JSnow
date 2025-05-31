package ec.espe.edu.jsnow.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author yesteb
 */
public class Inventory {

    public static void registerProductOutput(String id, String pathToFile, String pathToFileReport) throws FileNotFoundException, IOException {
        DateTimeFormatter dateTime;
        Scanner scanner;
        String temporalFile;
        String line;
        String nullLine;
        String description;
        
        dateTime = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        scanner = new Scanner(System.in);
        nullLine = "0,0,0,0";
        temporalFile = "src/resources/productListTemp.csv";

        try (
                BufferedReader reader = new BufferedReader(new FileReader(pathToFile)); 
                PrintWriter writer = new PrintWriter(new FileWriter(temporalFile));) {
            while ((line = reader.readLine()) != null) {
                String[] columns;

                columns = line.split(",");

                if (columns[0].equalsIgnoreCase(id)) {
                    writer.write(nullLine);
                } else {
                    writer.write(line);
                }

            } 

        }   catch(IOException e){
            System.err.println("No se encontraron los archivos" + e.getMessage());
        }
        
        File originalFileCSV;
        File temporalFileCSV;
        
        originalFileCSV = new File(pathToFile);
        temporalFileCSV = new File(temporalFile);
        
        if(originalFileCSV.delete()){
            temporalFileCSV.renameTo(originalFileCSV);
            System.out.println("Producto Eliminado...");
        }
        
        System.out.println("Describa la razon de la salida del producto: ");
        description = scanner.nextLine();
        
        try (
            PrintWriter writerReport = new PrintWriter(new FileWriter(pathToFileReport));
                ){
            writerReport.write(description +" Registrado: " + dateTime.format(LocalDateTime.now())+ "\n");
            writerReport.write("-------------------------------------------------");
            } catch (IOException e){
                System.err.println("No se encontro el archivo" + e.getMessage());
            }
    }

    public static void searchProductCSV(String id, String pathToFile) throws FileNotFoundException, IOException {
        String line;
        boolean findId;

        try (BufferedReader readerLine = new BufferedReader(new FileReader(pathToFile))) {

            findId = false;

            while ((line = readerLine.readLine()) != null) {
                String[] columns;
                columns = line.split(",");

                if (columns.length > 0 && columns[0].trim().equalsIgnoreCase(id)) {
                    System.out.println("Producto encontrado!! >^..^<");
                    System.out.println("--------------------------------------");
                    System.out.println("Id: " + columns[0]);
                    System.out.println("--------------------------------------");
                    System.out.println("Precio: " + columns[1]);
                    System.out.println("--------------------------------------");
                    System.out.println("Name: " + columns[2]);
                    System.out.println("--------------------------------------");
                    System.out.println("Fecha y Hora del Registro: " + columns[3]);
                    findId = true;
                    System.console().readLine();

                }

            }

            if (!findId) {
                System.out.println("Producto no encontrado, intente de nuevo...");
                System.console().readLine();

            }

        } catch (IOException e) {
            System.err.println("No se pudo encontrar el archivo, intente de nuevo..." + e.getMessage());
        }

    }

    public static void newProductRegister() throws IOException {
        DateTimeFormatter dateTime;
        Scanner scanner;
        Product product;
        int id;
        double price;
        String name;
        String fileName;
        String toStringId;
        String toStringPrice;
        String nextLine;
        String pathToFileNewProductReport;
        
        pathToFileNewProductReport = "src/resources/newProductReport.txt";
        fileName = "src/resources/productList.csv";
        id = 0;
        price = 0;
        name = null;
        scanner = new Scanner(System.in);
        dateTime = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

        System.out.println("Ingrese el id del Producto (10000 5 cifras)");
        id = scanner.nextInt();
        if (id > 99999 || id < 10000) {
            throw new ArithmeticException("El Id debe tener 5 cifras...");
            
        }

        toStringId = String.valueOf(id);
        System.out.println("Ingrese el precio del producto");
        price = scanner.nextDouble();
        toStringPrice = String.valueOf(price);
        
        nextLine = scanner.nextLine();
        
        System.out.println("Ingrese el nombre del producto");
        name = scanner.nextLine();

        System.out.println("Fecha y hora de registro: " + dateTime.format(LocalDateTime.now()));

        product = new Product(id, price, name, dateTime);

        WriteToFile.insertData(product, fileName);
        System.out.println("Producto Registrado! >^..^<");
        System.console().readLine();
        
        try(
                PrintWriter writerNewProductRegister = new PrintWriter(new FileWriter(pathToFileNewProductReport));
                ){
            writerNewProductRegister.write("Registrado: " + dateTime.format(LocalDateTime.now()) + "\n");
            writerNewProductRegister.write("-------------------------------------------------");
            
            
        } catch(IOException e){
            System.err.println("No se encontro el archivo" + e.getMessage());
        }
        
    }

}
