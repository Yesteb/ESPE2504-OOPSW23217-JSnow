
package ec.edu.espe.jsnow.model;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.mongodb.client.model.Filters;
import ec.edu.espe.jsnow.controller.DBController;
import java.awt.Component;
import javax.swing.JOptionPane;
import org.mindrot.jbcrypt.BCrypt;

public class AuthSystem {

    private final MongoCollection<Document> credentialCollection;

    public AuthSystem() {
        MongoDatabase database = DBController.getDatabase();
        this.credentialCollection = database.getCollection("Credential");
    }

    // Method to user register
    public boolean register(String username, String password, String role, Component parentComponent) {
        String hashedPassword;
        Document newUser;
        if (userExists(username)) {
            JOptionPane.showMessageDialog(parentComponent, "El usuario ya esta registrado!...", "Registro invalido", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        hashedPassword = hashPassword(password);

        newUser = new Document("username", username)
                .append("password", hashedPassword)
                .append("role", role);

        credentialCollection.insertOne(newUser);
        JOptionPane.showMessageDialog(parentComponent, "Se registro el usuario con exito!...");
        return true;
    }

    // Método para login
    public User login(String username, String password) {
        Document user = credentialCollection.find(
                Filters.eq("username", username)
        ).first();

        if (user != null) {
            String storedHashedPassword = user.getString("password");
            if (checkPassword(password, storedHashedPassword)) {
                String role = user.getString("role");
                
            if ( role.equalsIgnoreCase("admin")){
                return new Admin(username);
            } else if (role.equalsIgnoreCase("employee")){
                return new Employee(username);
            }
                
            }
        }

        JOptionPane.showMessageDialog(null, "Intente de nuevo...", "Credenciales incorrectas", JOptionPane.INFORMATION_MESSAGE);
        return null;
    }

    // Verifica si el usuario ya existe
    private boolean userExists(String username) {
        return credentialCollection.find(Filters.eq("username", username)).first() != null;
    }

    // Hash de contraseña con bcrypt
    private String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    // Verificación de contraseña con bcrypt
    private boolean checkPassword(String password, String hashed) {
        return BCrypt.checkpw(password, hashed);
    }
}
