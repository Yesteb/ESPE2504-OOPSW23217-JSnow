
package ec.espe.edu.jsnow.view;
import static ec.espe.edu.jsnow.model.PasswordUserCreate.hashCredential;
import java.util.Scanner;
/**
 *
 * @author yesteb
 */
public class JSnowSystem {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String username;
    String password;
    
        System.out.println("//ENCRYPTED SYSTEM//");
        System.out.println("New Username");
        username = scanner.nextLine();
        System.out.println("New Password");
        password = scanner.nextLine();
        
        hashCredential(username, password);
        
        
        
        
        
    }
    
}
