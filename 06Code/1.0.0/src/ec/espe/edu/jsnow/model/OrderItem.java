
package ec.espe.edu.jsnow.model;

/**
 *
 * @author Yesteb JSnow
 */
public class OrderItem {

    private Product product;
    private int quantity;
    private double subtotal;
    
    @Override
    public String toString() {
        return "OrderItem{" + "product=" + getProduct() + ", quantity=" + getQuantity() + ", subtotal=" + getSubtotal() + '}';
    }

    public OrderItem(Product product, int quantity, double subtotal){
        this.product = product;
        this.quantity = quantity;
        this.subtotal = subtotal;
    }
    
    
    /**
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the subtotal
     */
    public double getSubtotal() {
        return subtotal;
    }

    /**
     * @param subtotal the subtotal to set
     */
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    
    
}
