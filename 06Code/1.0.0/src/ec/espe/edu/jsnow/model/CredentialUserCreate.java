package ec.espe.edu.jsnow.model;

import static ec.espe.edu.jsnow.model.PrintFiles.printMenu;
import java.security.MessageDigest;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.security.NoSuchAlgorithmException;

/**
 * Clase para crear usuarios con credenciales encriptadas y almacenarlas en un archivo
 * Autor: Yesteb JSnow
 */
public class CredentialUserCreate {
    
    public static void credentialUserCreate() throws IOException{
        Scanner scanner;
        byte option;
        
        scanner = new Scanner(System.in);
        option = 0;
        
        printMenu("src/resources/createCredentialMenu.txt");
        option = scanner.nextByte();
        
        switch(option){
            case 1:
                registerAdmin();
                return;
            case 2:
                registerEmploye();
                return;
            case 3:
                System.out.println("Regresando al menu de inicio...");
                return;
        }
    }
    
    public static void registerAdmin() {
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

        try (PrintWriter writer = new PrintWriter(new FileWriter("src/resources/adminCredentials.txt", true))) {
            writer.println(encryptUsername + "," + encryptPassword);
            System.out.println("✅ Usuario y contraseña guardados exitosamente.");
            return;
        } catch (IOException e) {
            System.out.println("❌ Error al guardar las credenciales: " + e.getMessage());
            return;
        }
    }
    
    public static void registerEmploye(){
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

        try (PrintWriter writer = new PrintWriter(new FileWriter("src/resources/employeCredentials.txt", true))) {
            writer.println(encryptUsername + "," + encryptPassword);
            System.out.println("✅ Usuario y contraseña guardados exitosamente.");
            return;
        } catch (IOException e) {
            System.out.println("❌ Error al guardar las credenciales: " + e.getMessage());
            return;
        }
    }
    
    // Método para encriptar con SHA-256
    public static String hash(String input) {
        try {
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
