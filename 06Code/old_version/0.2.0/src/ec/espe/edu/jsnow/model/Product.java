
package ec.espe.edu.jsnow.model;

/**
 *
 * @author yesteb
 */
public class Product {
    private int id;
    private String name;
    private double price;
    private int quantityInStock;

    @Override
    public String toString() {
        return "Product{" + "id=" + getId() + ", name=" + getName() + ", price=" + getPrice() + ", quantityInStock=" + getQuantityInStock() + '}';
    }

    
    public Product(int id, String name, double price, int quantityInStock){
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantityInStock = quantityInStock;
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * @return the quantityInStock
     */
    public int getQuantityInStock() {
        return quantityInStock;
    }

    /**
     * @param quantityInStock the quantityInStock to set
     */
    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }
    
    public String[] toCsvRow(){
        return new String [] {
            String.valueOf(id),
            name,
            String.valueOf(price),
            String.valueOf(quantityInStock)
        };
    }
}







