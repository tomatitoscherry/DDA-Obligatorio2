/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package ui;

import Logica.observer.Observable;
import controlador.DialogoMozoControlador;
import dominio.Mesa;
import dominio.Mozo;
import dominio.Producto;
import dominio.Sesion;
import dominio.Usuario;
import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.ListCellRenderer;

/**
 *
 * @author yamil
 */
public class DialogoMozo extends javax.swing.JDialog implements DialogoMozoVista{
    
    private Mozo mozo;
    private DialogoMozoControlador controlador;
    private Sesion sesion;

    /**
     * Creates new form DialogoMozo
     */
    public DialogoMozo(java.awt.Frame parent, boolean modal, Mozo mozo) {
        super(parent, modal);
        initComponents();
        this.mozo= mozo;
        this.controlador= new DialogoMozoControlador(this);
        sesion = new Sesion(mozo, new Date());
        controlador.iniciarSesion(sesion);
        this.setTitle("Ventana mozo");
        ejecutarCu1();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        btnAbrir = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        btnTransferir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listProductos = new javax.swing.JList();
        lblMesasMozo = new javax.swing.JLabel();
        lblMesaSeleccionada = new javax.swing.JLabel();
        txtCantidadProducto = new javax.swing.JTextField();
        lblCantidadProducto = new javax.swing.JLabel();
        lblDescripcionProducto = new javax.swing.JLabel();
        txtDescripcionProducto = new javax.swing.JTextField();
        btnAgregarProducto = new javax.swing.JButton();
        lblProductosDisponilbes = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblServicio = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        listMesas = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Servicio de la mesa:");

        btnAbrir.setText("Abrir");
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        btnTransferir.setText("Transferir");
        btnTransferir.setToolTipText("");
        btnTransferir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransferirActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(listProductos);

        lblMesasMozo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblMesasMozo.setText("Mesas del mozo: ");

        lblMesaSeleccionada.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblMesaSeleccionada.setText("Mesa:");

        lblCantidadProducto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCantidadProducto.setText("Ingrese la cantidad");

        lblDescripcionProducto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblDescripcionProducto.setText("Ingrese una descripcion");

        btnAgregarProducto.setText("Agregar producto");
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });

        lblProductosDisponilbes.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblProductosDisponilbes.setText("Productos disponibles:");

        tblServicio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Cant.", "Producto", "Descripcion", "P. Unit.", "Subtotal", "Estado"
            }
        ));
        tblServicio.setName(""); // NOI18N
        tblServicio.setOpaque(false);
        jScrollPane2.setViewportView(tblServicio);

        listMesas.setBackground(new java.awt.Color(204, 204, 204));
        listMesas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        listMesas.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        listMesas.setToolTipText("");
        listMesas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        listMesas.setMaximumSize(new java.awt.Dimension(45, 100));
        listMesas.setMinimumSize(new java.awt.Dimension(45, 100));
        listMesas.setSelectionBackground(new java.awt.Color(204, 204, 204));
        listMesas.setVisibleRowCount(5);
        jScrollPane3.setViewportView(listMesas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblMesasMozo, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblProductosDisponilbes))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnAbrir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnTransferir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(lblMesaSeleccionada, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblCantidadProducto)
                                    .addComponent(btnAgregarProducto)
                                    .addComponent(txtCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDescripcionProducto)
                                    .addComponent(lblDescripcionProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProductosDisponilbes)
                    .addComponent(lblMesasMozo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCantidadProducto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblDescripcionProducto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDescripcionProducto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregarProducto))
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblMesaSeleccionada)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAbrir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCerrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTransferir)))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        abrirMesa();
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        cerrarMesa();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnTransferirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransferirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTransferirActionPerformed

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed
        agregarProductoAlServicio();
    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnTransferir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblCantidadProducto;
    private javax.swing.JLabel lblDescripcionProducto;
    private javax.swing.JLabel lblMesaSeleccionada;
    private javax.swing.JLabel lblMesasMozo;
    private javax.swing.JLabel lblProductosDisponilbes;
    private javax.swing.JList listMesas;
    private javax.swing.JList listProductos;
    private javax.swing.JTable tblServicio;
    private javax.swing.JTextField txtCantidadProducto;
    private javax.swing.JTextField txtDescripcionProducto;
    // End of variables declaration//GEN-END:variables

    @Override
    public void cerrarVista() {
        this.dispose();
    }

    @Override
    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje,"Error", JOptionPane.ERROR_MESSAGE);
    }
    //Caso Uso 1
    private void ejecutarCu1() {
        cargarNombreMozo();
        cargarMesasMozo();
    }
    
    public void cargarNombreMozo(){
        lblMesasMozo.setText("Mesas del mozo: "+mozo.getNombreCompleto());
    }
    
    public void cargarMesasMozo(){
        if(mozo!=null){
            if(!mozo.getMesas().isEmpty()){
                listMesas.setCellRenderer(new MesasRenderer());
                listMesas.setListData(mozo.getMesas().toArray());
            }
        }
    }

    public void abrirMesa() {
        Mesa mesaSeleccionada= (Mesa) listMesas.getSelectedValue();
        controlador.abrirMesa(mesaSeleccionada);
    }
    
    public void cargarProductosDisponibles(ArrayList<Producto> productosDisponibles){
       listProductos.setListData(productosDisponibles.toArray());
    }

    private void agregarProductoAlServicio() {
        Mesa mesa= (Mesa) listMesas.getSelectedValue();
        Producto producto= (Producto) listProductos.getSelectedValue();
        String descripcion= txtDescripcionProducto.getText();
        String cantidad= txtCantidadProducto.getText();
        int cantidadP=Integer.parseInt(cantidad);
        
        controlador.agregarProductoAlServicio(mesa, producto, descripcion, cantidadP);
    }
    
    private void cerrarMesa() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private class MesasRenderer extends JLabel implements ListCellRenderer<Mesa> {

        @Override
        public Component getListCellRendererComponent(JList<? extends Mesa> list, Mesa m, int index, boolean isSelected, boolean cellHasFocus) {
            if(m.isAbierta()) {
                setOpaque(true);
                setBackground(Color.red);
            } else {
                setOpaque(true);
                setBackground(Color.white);
            }
            return this;
        }
    }

}
