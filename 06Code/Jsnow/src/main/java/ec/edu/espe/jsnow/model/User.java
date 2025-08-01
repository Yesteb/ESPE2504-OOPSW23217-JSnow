
package ec.edu.espe.jsnow.model;

/**
 *
 * @author Yesteb JSnow
 */
public abstract class User {
    
    protected String username;
    protected String password;
   
    protected String role;

    public User(String username, String role) {
        this.username = username;
        this.role = role;
    }
    

    
    
    public abstract void showDashboard();
    

    public String getUsername() {
        return username;
    }
    
     public String getRole() {
        return role;
    }


    
    
}
