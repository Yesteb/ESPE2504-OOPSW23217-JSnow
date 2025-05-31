package ec.espe.edu.jsnow.model;

import java.security.MessageDigest;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author yesteb
 */
public class PasswordUserCreate {

    public static void hashCredential() {
        Scanner scanner = new Scanner(System.in);
        String username;
        String password;
        String hashPassword;

        System.out.println("Hi! this is the tool to creat crendentials");
        System.out.println("You have to enter your new username and password...");
        System.out.println("See you later!...");

        System.out.print("New Username: ");
        username = scanner.nextLine();
        System.out.print("New PassWord: ");
        password = scanner.nextLine();

        hashPassword = hash(password);

        try (PrintWriter writer = new PrintWriter(new FileWriter("src/resources/credentials.txt"))) {
            writer.println(username + "," + hashPassword);
            System.out.println("Password and username saved successfully...");
        } catch (IOException e) {
            System.out.println("Failed proccess: " + e.getMessage());
        }

    }

    public static String hash(String input) {
        try {
            MessageDigest messageDigest;
            byte[] hashBytes;
            StringBuilder hexString;

            messageDigest = MessageDigest.getInstance("SHA-256");
            hashBytes = messageDigest.digest(input.getBytes());
            hexString = new StringBuilder();

            for (byte b : hashBytes) {
                hexString.append(String.format("%02x", b));
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException error) {
            throw new RuntimeException(error);
        }

    }

}
