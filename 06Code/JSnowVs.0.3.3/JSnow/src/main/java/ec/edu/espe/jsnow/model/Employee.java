
package ec.edu.espe.jsnow.model;

/**
 *
 * @author Yesteb JSnow
 */
public class Employee extends User{

    public Employee(String username) {
        super(username, "employee");
    }

    @Override
    public void showDashboard() {
        
    }
    
}
