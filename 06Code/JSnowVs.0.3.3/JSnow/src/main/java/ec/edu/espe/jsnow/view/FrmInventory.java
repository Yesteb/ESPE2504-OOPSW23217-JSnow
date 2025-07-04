
package ec.edu.espe.jsnow.view;

import com.mongodb.MongoException;
import com.mongodb.client.result.DeleteResult;
import ec.edu.espe.jsnow.model.Inventory;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import org.bson.Document;
/**
 *
 * @author Yesteb JSnow
 */
public class FrmInventory extends javax.swing.JFrame {
    
      private final Inventory inventory;
    private JTextField txtId, txtStock, txtSize, txtColor, txtModel, txtPrice;
    private JButton btnAdd, btnSearch, btnDelete;
    private JTextArea txtResult;

    public FrmInventory() {
        inventory = new Inventory();
        setTitle("Gestión de Productos");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
        setupLayout();
    }

    private void initComponents() {

        txtId = new JTextField();
        txtStock = new JTextField();
        txtSize = new JTextField();
        txtColor = new JTextField();
        txtModel = new JTextField();
        txtPrice = new JTextField();

        // Botones
        btnAdd = new JButton("Agregar");
        btnSearch = new JButton("Buscar");
        btnDelete = new JButton("Eliminar");


        txtResult = new JTextArea(10, 40);
        txtResult.setEditable(false);
    }

    private void setupLayout() {
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


        JPanel inputPanel = new JPanel(new GridLayout(6, 2, 5, 5));
        inputPanel.add(new JLabel("ID:"));
        inputPanel.add(txtId);
        inputPanel.add(new JLabel("Stock:"));
        inputPanel.add(txtStock);
        inputPanel.add(new JLabel("Talla:"));
        inputPanel.add(txtSize);
        inputPanel.add(new JLabel("Color:"));
        inputPanel.add(txtColor);
        inputPanel.add(new JLabel("Modelo:"));
        inputPanel.add(txtModel);
        inputPanel.add(new JLabel("Precio:"));
        inputPanel.add(txtPrice);


        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnSearch);
        buttonPanel.add(btnDelete);


        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(new JScrollPane(txtResult), BorderLayout.SOUTH);


        btnAdd.addActionListener(this::addProduct);
        btnSearch.addActionListener(this::searchProduct);
        btnDelete.addActionListener(this::deleteProduct);

        add(mainPanel);
    }

    private void addProduct(ActionEvent e) {
        try {
            Document productDoc = new Document()
                .append("id", Integer.valueOf(txtId.getText()))
                .append("stock", Integer.valueOf(txtStock.getText()))
                .append("size", txtSize.getText())
                .append("color", txtColor.getText())
                .append("model", txtModel.getText())
                .append("price", Double.valueOf(txtPrice.getText()))
                .append("date", java.time.LocalDateTime.now().toString());

            inventory.getProductsCollection().insertOne(productDoc);
            JOptionPane.showMessageDialog(this, "Producto agregado exitosamente");
            clearFields();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error en datos numéricos", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (MongoException ex) {
            JOptionPane.showMessageDialog(this, "Error de base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void searchProduct(ActionEvent e) {
        try {
            Document productDoc = inventory.getProductsCollection()
                .find(new Document("id", Integer.valueOf(txtId.getText())))
                .first();

            if (productDoc != null) {
                txtResult.setText(formatProductInfo(productDoc));
                autoFillFields(productDoc);
            } else {
                JOptionPane.showMessageDialog(this, "Producto no encontrado", "Búsqueda", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "ID debe ser numérico", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String formatProductInfo(Document doc) {
        return String.format(
            "ID: %d\nStock: %d\nTalla: %s\nColor: %s\nModelo: %s\nPrecio: $%.2f\nFecha: %s",
            doc.getInteger("id"),
            doc.getInteger("stock"),
            doc.getString("size"),
            doc.getString("color"),
            doc.getString("model"),
            doc.getDouble("price"),
            doc.getString("date")
        );
    }

    private void autoFillFields(Document doc) {
        txtStock.setText(String.valueOf(doc.getInteger("stock")));
        txtSize.setText(doc.getString("size"));
        txtColor.setText(doc.getString("color"));
        txtModel.setText(doc.getString("model"));
        txtPrice.setText(String.format("%.2f", doc.getDouble("price")));
    }

    private void deleteProduct(ActionEvent e) {
        try {
            DeleteResult result;
            result = inventory.getProductsCollection()
                .deleteOne(new Document("id", Integer.valueOf(txtId.getText())));

            if (result.getDeletedCount() > 0) {
                JOptionPane.showMessageDialog(this, "Producto eliminado");
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, "Producto no encontrado", "Error", JOptionPane.WARNING_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "ID debe ser numérico", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        txtId.setText("");
        txtStock.setText("");
        txtSize.setText("");
        txtColor.setText("");
        txtModel.setText("");
        txtPrice.setText("");
        txtResult.setText("");
    }

     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FrmInventory().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
