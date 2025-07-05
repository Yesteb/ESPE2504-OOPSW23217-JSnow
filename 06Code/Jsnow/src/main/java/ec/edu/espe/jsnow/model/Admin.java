
package ec.edu.espe.jsnow.model;

/**
 *
 * @author Yesteb JSnow
 */
public class Admin extends User{

    public Admin(String username) {
        super(username, "admin");
    }
    
    
    @Override
    public void showDashboard() {
        
    }
    
}