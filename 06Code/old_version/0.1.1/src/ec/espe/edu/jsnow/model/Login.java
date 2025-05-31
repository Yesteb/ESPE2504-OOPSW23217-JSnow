package ec.espe.edu.jsnow.model;

import static ec.espe.edu.jsnow.model.PasswordUserCreate.hash;
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
        String username;
        String password;
        String hashPassword;
        int count;
        boolean access;

        count = 0;

        while (count < 3) {

            System.out.print("Username: ");
            username = scanner.nextLine();
            System.out.print("Password: ");
            password = scanner.nextLine();

            hashPassword = hash(password);

            access = false;

            try (BufferedReader reader = new BufferedReader(new FileReader("credentials.txt"))) {
                String lineReader;
                access = false;

                while ((lineReader = reader.readLine()) != null) {
                    String[] part = lineReader.split(",");
                    if (part.length < 2) {
                        continue;
                    }
                    String userSave = part[0];
                    String passwordSaveHash = part[1];

                    if (userSave.equals(username) && passwordSaveHash.equals(hashPassword)) {
                        access = true;
                        break;
                    }
                }

                if (access) {
                    System.out.println("Login successful!");
                    return;
                } else {
                    System.out.println("Wrong credentials...");
                    System.out.println("Invalid Password or Username...");
                    count += 1;
                }

                if (count == 3) {
                    System.out.println("Too many failed attempts. Exiting...");
                    exit(0);
                }

            } catch (IOException e) {
                System.out.println("Error, couldn't find the file: " + e.getMessage());
            }

        }
    }
}
