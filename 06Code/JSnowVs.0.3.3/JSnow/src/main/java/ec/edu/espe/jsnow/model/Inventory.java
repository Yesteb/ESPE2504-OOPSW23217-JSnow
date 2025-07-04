
package ec.edu.espe.jsnow.model;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import ec.edu.espe.jsnow.controller.DBController;
import javax.swing.JOptionPane;
import org.bson.Document;
import java.awt.Component;

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
    
    public Document searchProduct(int id){
            try {
            Document filter;
            Document findProduct;
            
            filter = new Document("id", id);
            findProduct = getProductsCollection().find(filter).first();
                if (findProduct != null) {
                    return findProduct;
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontro el producto", "Busqueda", JOptionPane.INFORMATION_MESSAGE);
                    return null;
                }
            
        } catch (MongoException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar el producto", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
            
            
            
            
        
    }
    
    public void addProduct(Product product, Component parentComponent){
        Document newProduct;
        try{
           newProduct = new Document("id", product.getId())
                .append("stock", product.getStock())
                .append("size", product.getSize())
                .append("color", product.getColor())
                .append("model", product.getModel())
                .append("price", product.getPrice())
                .append("date", product.getDateTime());
        
            getProductsCollection().insertOne(newProduct); 
        } catch (MongoException e){
            JOptionPane.showMessageDialog(parentComponent, "Error al registrar un producto", "Registro de productos invalido", JOptionPane.ERROR_MESSAGE);
        }
        
        
    } 
    
    public boolean removeProduct(int id){
        try {
            DeleteResult result;
            Document filter;
            filter = new Document("id", id);
            
            result = getProductsCollection().deleteOne(filter);
            
            return result.getDeletedCount() > 0;
            
        } catch (MongoException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el producto", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        
    }
    public static void getLowStock(){
        
    }
    public static void generateInventoryReport (){
        
        
        
        
    }

    /**
     * @return the productsCollection
     */
    public MongoCollection<Document> getProductsCollection() {
        return productsCollection;
    }
    
}
