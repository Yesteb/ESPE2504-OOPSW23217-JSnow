
package ec.edu.espe.jsnow.model;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import ec.edu.espe.jsnow.controller.DBController;
import javax.swing.JOptionPane;
import org.bson.Document;


/**
 *
 * @author Yesteb JSnow
 */
public class Inventory {
    private final MongoCollection<Document> productsCollection;

    public Inventory() {
        MongoDatabase database = DBController.getDatabase();
        this.productsCollection = database.getCollection("Products");
    }
    
    public boolean searchProduct(int id){
            Document filter;
            
            filter = new Document("id", id);
            
            
            productsCollection.find(filter);
            
            
        
    }
    
    public void addProduct(Product product){
        Document newProduct;
        try{
           newProduct = new Document("id", product.getId())
                .append("stock", product.getStock())
                .append("size", product.getSize())
                .append("color", product.getColor())
                .append("model", product.getModel())
                .append("price", product.getPrice())
                .append("date", product.getDateTime());
        
        productsCollection.insertOne(newProduct); 
        } catch (MongoException e){
            JOptionPane.showMessageDialog(parentComponent, "Error al registrar un producto", "Registro de productos invalido", JOptionPane.ERROR_MESSAGE);
        }
        
        
    } 
    
    public boolean removeProduct(int id){
        try {
            DeleteResult result;
            Document filter;
            filter = new Document("id", id);
            
            result = productsCollection.deleteOne(filter);
            
            return result.getDeletedCount() > 0;
            
        } catch (MongoException e) {
            JOptionPane.showMessageDialog(parentComponent, "Error al eliminar el producto", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }
    public static void getLowStock(){
        
    }
    public static void generateInventoryReport (){
        
        
        
        
    }
    
}
