
package ec.espe.edu.jsnow.model;

import static ec.espe.edu.jsnow.model.AdminSession.adminSession;
import static ec.espe.edu.jsnow.model.EmployeSession.employeSession;
import static ec.espe.edu.jsnow.model.Login.adminLogin;
import static ec.espe.edu.jsnow.model.Login.employeLogin;
import static ec.espe.edu.jsnow.model.PrintFiles.printMenu;
import java.io.IOException;
import static java.lang.System.exit;
import java.util.Scanner;

/**
 *
 * @author Yesteb JSnow
 */
public class Session {
    public static void sessionUser() throws IOException{
       Scanner scanner;
       byte option;
       
       scanner = new Scanner(System.in);
       option = 0;
       
       printMenu("src/resources/loginMenu.txt");
       option = scanner.nextByte();
       
       switch(option){
           case 1:
               adminLogin();
               adminSession();
               break;
           case 2:
               employeLogin();
               employeSession();
               break;
           case 3:
               exit(0);
               break;
       }
       
    }
}
