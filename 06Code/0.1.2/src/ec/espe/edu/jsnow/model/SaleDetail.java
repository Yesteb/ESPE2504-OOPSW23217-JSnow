
package ec.espe.edu.jsnow.model;
/**
 *
 * @author yesteb
 */
public class SaleDetail {
   
    private Product product;
    private int quantity;
    private double subTotal;
    private double calculateSubTotal;
    
    
     @Override
    public String toString() {
        return "SaleDetail{" + "product=" + getProduct() + ", quantity=" + getQuantity() + ", subTotal=" + getSubTotal() + ", calculateSubTotal=" + getCalculateSubTotal() + '}';
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
     * @return the subTotal
     */
    public double getSubTotal() {
        return subTotal;
    }

    /**
     * @param subTotal the subTotal to set
     */
    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    /**
     * @return the calculateSubTotal
     */
    public double getCalculateSubTotal() {
        return calculateSubTotal;
    }

    /**
     * @param calculateSubTotal the calculateSubTotal to set
     */
    public void setCalculateSubTotal(double calculateSubTotal) {
        this.calculateSubTotal = calculateSubTotal;
    }
}



