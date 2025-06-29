package ec.espe.edu.jsnow.model;

import static ec.espe.edu.jsnow.model.GenerateReports.registerProductOutputReport;
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

    public static void productOutput(String id, String pathToFile) throws FileNotFoundException, IOException {
        DateTimeFormatter dateTime;
        Scanner scanner;
        String temporalFile;
        String line;
        String nullLine;
        double price;
        String name;

        dateTime = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        scanner = new Scanner(System.in);
        nullLine = "0,0,0,0";
        temporalFile = "src/resources/productListTemp.csv";
        
//In this case, I don't use the method searchProduct, because I need save some information before finish the process of the method 
        try (
                BufferedReader reader = new BufferedReader(new FileReader(pathToFile)); PrintWriter writer = new PrintWriter(new FileWriter(temporalFile));) {
            while ((line = reader.readLine()) != null) {
                String[] columns;

                columns = line.split(",");
                if (columns[0].equalsIgnoreCase(id)) {
                    name = columns[3];
                    price = columns[1];
                    registerProductOutputReport(id, name, price);
                    
                    writer.write(nullLine);
                } else {
                    writer.write(line);
                }

            }

        } catch (IOException e) {
            System.err.println("No se encontraron los archivos" + e.getMessage());
        }

        File originalFileCSV;
        File temporalFileCSV;

        originalFileCSV = new File(pathToFile);
        temporalFileCSV = new File(temporalFile);

        if (originalFileCSV.delete()) {
            temporalFileCSV.renameTo(originalFileCSV);
            System.out.println("Producto Eliminado de la Base de Datos...");
        }

    }

    public static void productDescription(String column1, String column2, String column3, String column4) {
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
                    productDescription(columns[0], columns[1], columns[2], columns[3]);
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
    
        System.out.println("Ingrese el precio del producto");
        price = scanner.nextDouble();

        scanner.nextLine();

        System.out.println("Ingrese el nombre del producto");
        name = scanner.nextLine();

        System.out.println("Fecha y hora de registro: " + dateTime.format(LocalDateTime.now()));

        product = new Product(id, price, name, dateTime);

        WriteToFile.insertProductData(product, fileName);
        System.out.println("Producto Registrado! >^..^<");
        System.console().readLine();

    }

}
