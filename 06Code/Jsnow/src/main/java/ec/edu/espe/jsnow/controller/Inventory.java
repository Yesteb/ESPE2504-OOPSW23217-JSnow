
package ec.edu.espe.jsnow.controller;

import com.mongodb.client.MongoCollection;
import ec.edu.espe.jsnow.model.Product;
import java.util.ArrayList;
import org.bson.Document;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Yesteb JSnow
 */
public class Inventory {
    private final MongoCollection<Document> productsCollection;
    public Inventory(DBController dbController) {
        this.productsCollection = DBController.getCollection("Products");
    }
    
    public void addProduct(Product product){
        Document document = new Document("id", product.getId())
            .append("name", product.getName())
            .append("size", product.getSize())
            .append("price", product.getPrice())
            .append("quantity", product.getQuantity())
            .append("color", product.getColor())
            .append("model", product.getModel())
            .append("dateTime", product.getDateTime().toString());
        productsCollection.insertOne(document);
    }
    
    public Document findProduct(String id){
        return productsCollection.find(new Document("id", new ObjectId(id))).first();
    }
    
    public void updateProduct(String id, Product product){
        Document updateProduct;
        
          updateProduct = new Document
                ("id", product.getId())
                .append("name", product.getName())
                .append("size", product.getSize())
                .append("price", product.getPrice())
                .append("quantity", product.getQuantity())
                .append("color", product.getColor())
                .append("model", product.getModel());
        Document oldProduct = findProduct(id);
          
        
        productsCollection.updateOne(oldProduct, updateProduct);
    }
    
    public void deleteProduct(String id){
        Document product= findProduct(id);
        
        productsCollection.deleteOne(product);
    }
    
    public List<Document> getAllProducts(){
        List<Document> products = new ArrayList<>();
        productsCollection.find().into(products);
        return products;
    }
}
