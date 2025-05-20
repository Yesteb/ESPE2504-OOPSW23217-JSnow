package ec.espe.edu.jsnow.view;

import ec.espe.edu.jsnow.model.CredentialUserCreate;
import static ec.espe.edu.jsnow.model.Inventory.inventoryMenu;
import static ec.espe.edu.jsnow.model.Login.login;
import static ec.espe.edu.jsnow.model.PrintFiles.printMenu;
import java.util.Scanner;
import java.io.IOException;
import static java.lang.System.exit;

/**
 * Clase que permite registrar usuarios en el sistema JSnow. Autor: Yesteb JSnow
 */
public class Register {

    public static boolean showRegisterMenu() throws IOException {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n=== MENÚ DE REGISTRO ===");
            System.out.println("1. Registrar nuevo usuario");
            System.out.println("2. Iniciar Seseión");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (option) {
                case 1:
                    CredentialUserCreate.registerUser();
                    System.out.println("🎉 Registro exitoso. Ahora puede iniciar sesión.");
                    break;
                case 2:
                    login();
                    printMenu("src/resources/mainMenu.txt");
                    option = scanner.nextByte();

                    switch (option) {
                        case 1:
                            inventoryMenu();
                            break;
                    }
                case 3:
                    exit(0); 
                default:
                    System.out.println("⚠️ Opción inválida.");

            }

        } while (option != 3);
        return false;
    }

    static void register() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
