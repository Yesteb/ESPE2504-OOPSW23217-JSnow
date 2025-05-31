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
     
    
    public static void adminLogin() {
        Scanner scanner;
        byte count;
        boolean accessAdmin;
        String username;
        String password;
        String encryptUsername;
        String encryptPassword;
        
        scanner = new Scanner(System.in);
        count = 0;

        while (count < 3) {

            System.out.print("Username: ");
            username = scanner.nextLine();
            System.out.print("Password: ");
            password = scanner.nextLine();

            encryptUsername = hash(username);
            encryptPassword = hash(password);
            

            try (BufferedReader reader = new BufferedReader(new FileReader("src/resources/adminCredentials.csv"))) {
                String lineReader;
                accessAdmin = false;

                while ((lineReader = reader.readLine()) != null) {
                    String[] part = lineReader.split(",");
                    if (part.length < 2) {
                        continue;
                    }
                    String userSave = part[0];
                    String passwordSaveHash = part[1];

                    if (userSave.equals(encryptUsername) && passwordSaveHash.equals(encryptPassword)) {
                        accessAdmin = true;
                        break;
                    }
                }

                if (accessAdmin) {
                    System.out.println("Inicio de sesion correcto!...");
                    
                    return;
                } else {
                    System.out.println("Credenciales incorrectas...");
                    System.out.println("Username o password incorrectos. Intentalo nuevamente");
                    count += 1;
                    System.out.println("Presione cualquier tecla para continuar...");
                    System.console().readLine();
                    
                    
                }

                if (count == 3) {
                    System.out.println("Muchos intentos fallidos. Saliendo...");
                    exit(0);
                }

            } catch (IOException e) {
                System.out.println("Error: el archivo de credenciales no se encontró o no es accesible." + e.getMessage());
            }
            
        }
        
    }
    
    public static void employeLogin(){
        Scanner scanner;
        byte count;
        boolean accessEmploye;
        String username;
        String password;
        String encryptUsername;
        String encryptPassword;
        
        scanner = new Scanner(System.in);
        count = 0;

        while (count < 3) {

            System.out.print("Username: ");
            username = scanner.nextLine();
            System.out.print("Password: ");
            password = scanner.nextLine();

            encryptUsername = hash(username);
            encryptPassword = hash(password);
            

            try (BufferedReader reader = new BufferedReader(new FileReader("src/resources/employeCredentials.csv"))) {
                String lineReader;
                accessEmploye = false;

                while ((lineReader = reader.readLine()) != null) {
                    String[] part = lineReader.split(",");
                    if (part.length < 2) {
                        continue;
                    }
                    String userSave = part[0];
                    String passwordSaveHash = part[1];

                    if (userSave.equals(encryptUsername) && passwordSaveHash.equals(encryptPassword)) {
                        accessEmploye = true;
                        break;
                    }
                }

                if (accessEmploye) {
                    System.out.println("Inicio de sesion correcto!...");
                    
                    return;
                } else {
                    System.out.println("Credenciales incorrectas...");
                    System.out.println("Username o password incorrectos. Intentalo nuevamente");
                    count += 1;
                    System.out.println("Presione cualquier tecla para continuar...");
                    System.console().readLine();
                    
                }

                if (count == 3) {
                    System.out.println("Muchos intentos fallidos. Saliendo...");
                    exit(0);
                }

            } catch (IOException e) {
                System.out.println("Error: el archivo de credenciales no se encontró o no es accesible." + e.getMessage());
            }
            
        }
        
    }
}











