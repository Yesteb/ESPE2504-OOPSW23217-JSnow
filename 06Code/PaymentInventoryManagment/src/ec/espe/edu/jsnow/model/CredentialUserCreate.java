package ec.espe.edu.jsnow.model;

import static ec.espe.edu.jsnow.model.PrintFiles.printMenu;
import java.security.MessageDigest;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.security.NoSuchAlgorithmException;

/**
 * Class to create user credential to role
 * Author: Yesteb JSnow
 */
public class CredentialUserCreate {
    
    public static void credentialUserCreate() throws IOException{
        Scanner scanner;
        byte option;
        String pathToAdminCredentail = "src/resources/adminCredentials.csv";
        String pathToEmployeCredential = "src/resources/employeCredentials.csv";
        
        scanner = new Scanner(System.in);
        option = 0;
        
        printMenu("src/resources/createCredentialMenu.txt");
        option = scanner.nextByte();
        
        switch(option){
            case 1:
                registerUser(pathToAdminCredentail);
                return;
            case 2:
                registerUser(pathToEmployeCredential);
                return;
            case 3:
                System.out.println("Regresando al menu de inicio...");
                return;
        }
    }
    
    
    
    public static void registerUser(String pathToCredentailUser) {
        Scanner scanner;
        String username;
        String password;
        String encryptUsername;
        String encryptPassword;
        
        scanner = new Scanner(System.in);
        
        System.out.println("=== Registro de Nuevo Usuario ===");
        System.out.print("Ingrese un nuevo nombre de usuario: ");
        username = scanner.nextLine();
        System.out.print("Ingrese una nueva contraseña: ");
        password = scanner.nextLine();

        encryptUsername = hash(username);
        encryptPassword = hash(password);

        try (PrintWriter writer = new PrintWriter(new FileWriter("src/resources/adminCredentials.csv", true))) {
            writer.println(encryptUsername + "," + encryptPassword);
            System.out.println(" Usuario y contrase guardados exitosamente.");
            return;
        } catch (IOException e) {
            System.out.println(" Error al guardar las credenciales: " + e.getMessage());
            return;
        }
    }
    
    
    // Método para encriptar con SHA-256
    public static String hash(String input) {
        try {
            // Algoritmo usado para hash de password es SHA-256
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            
            byte[] hashBytes = messageDigest.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();

            for (byte b : hashBytes) {
                hexString.append(String.format("%02x", b));
            }
            
            return hexString.toString();
        } catch (NoSuchAlgorithmException error) {
            throw new RuntimeException("Error al encriptar: " + error.getMessage());
        }
    }
    
}
