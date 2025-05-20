package ec.espe.edu.jsnow.model;

import java.security.MessageDigest;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.security.NoSuchAlgorithmException;

/**
 * Clase para crear usuarios con credenciales encriptadas y almacenarlas en un archivo.
 * Autor: Yesteb JSnow
 */
public class CredentialUserCreate {

    // Método principal para registrar un nuevo usuario
    public static void registerUser() {
        Scanner scanner = new Scanner(System.in);
        String username;
        String password;
        String encryptUsername;
        String encryptPassword;

        System.out.println("=== Registro de Nuevo Usuario ===");
        System.out.print("Ingrese un nuevo nombre de usuario: ");
        username = scanner.nextLine();
        System.out.print("Ingrese una nueva contraseña: ");
        password = scanner.nextLine();

        encryptUsername = hash(username);
        encryptPassword = hash(password);

        try (PrintWriter writer = new PrintWriter(new FileWriter("src/resources/credentials.txt", true))) {
            writer.println(encryptUsername + "," + encryptPassword);
            System.out.println("✅ Usuario y contraseña guardados exitosamente.");
        } catch (IOException e) {
            System.out.println("❌ Error al guardar las credenciales: " + e.getMessage());
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
