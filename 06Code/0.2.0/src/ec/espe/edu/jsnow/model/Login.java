package ec.espe.edu.jsnow.model;

import static ec.espe.edu.jsnow.model.CredentialUserCreate.hash;
import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import static java.lang.System.exit;

/**
 *
 * @author yesteb
 */
public class Login {

    public static void login() {
        Scanner scanner = new Scanner(System.in);
        byte count;
        boolean access;
        String username;
        String password;
        String encryptUsername;
        String encryptPassword;
        
        
        count = 0;

        while (count < 3) {

            System.out.print("Username: ");
            username = scanner.nextLine();
            System.out.print("Password: ");
            password = scanner.nextLine();

            encryptUsername = hash(username);
            encryptPassword = hash(password);
            

            try (BufferedReader reader = new BufferedReader(new FileReader("src/resources/credentials.txt"))) {
                String lineReader;
                access = false;

                while ((lineReader = reader.readLine()) != null) {
                    String[] part = lineReader.split(",");
                    if (part.length < 2) {
                        continue;
                    }
                    String userSave = part[0];
                    String passwordSaveHash = part[1];

                    if (userSave.equals(encryptUsername) && passwordSaveHash.equals(encryptPassword)) {
                        access = true;
                        break;
                    }
                }

                if (access) {
                    System.out.println("Inicio de sesion correcto!...");
                    return;
                } else {
                    System.out.println("Credenciales incorrectas...");
                    System.out.println("Contraseña o usuario invalidos...");
                    count += 1;
                }

                if (count == 3) {
                    System.out.println("Muchos intentos fallidos. Saliendo...");
                    exit(0);
                }

            } catch (IOException e) {
                System.out.println("Error, no se encontro el archivo: " + e.getMessage());
            }

        }
    }
}
