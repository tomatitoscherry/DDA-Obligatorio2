/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package ui;

import Logica.FachadaServicios;
import controlador.DialogoMozoControlador;
import dominio.Cliente;
import dominio.ItemServicio;
import dominio.Mesa;
import dominio.Mozo;
import dominio.Producto;
import dominio.Servicio;
import dominio.TransferenciaMesa;
import dominio.Usuario;
import exceptions.ServicioException;
import exceptions.MesaException;
import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.ListCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yamil
 */
public class DialogoMozo extends javax.swing.JDialog implements DialogoMozoVista{
    
    private DialogoMozoControlador controlador;
    DefaultTableModel dtm;

    /**
     * Creates new form DialogoMozo
     */
    public DialogoMozo(java.awt.Frame parent, boolean modal, Mozo mozo) {
        super(parent, modal);
        initComponents();
        this.setTitle("Ventana mozo");
        this.controlador= new DialogoMozoControlador(this, mozo);
        dtm = (DefaultTableModel) tblServicio.getModel();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblServicioMesa = new javax.swing.JLabel();
        btnAbrir = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        btnTransferir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listProductos = new javax.swing.JList();
        lblMesasMozo = new javax.swing.JLabel();
        txtCantidadProducto = new javax.swing.JTextField();
        lblCantidadProducto = new javax.swing.JLabel();
        lblDescripcionProducto = new javax.swing.JLabel();
        txtDescripcionProducto = new javax.swing.JTextField();
        btnAgregarItemServicio = new javax.swing.JButton();
        lblProductosDisponilbes = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblServicio = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        listMesas = new javax.swing.JList();
        btnSalir = new javax.swing.JButton();
        btnAgregarProducto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblServicioMesa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblServicioMesa.setText("Servicio de la mesa:");

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

        lblCantidadProducto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCantidadProducto.setText("Ingrese la cantidad");

        lblDescripcionProducto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblDescripcionProducto.setText("Ingrese una descripcion");

        btnAgregarItemServicio.setText("Agregar");
        btnAgregarItemServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarItemServicioActionPerformed(evt);
            }
        });

        lblProductosDisponilbes.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblProductosDisponilbes.setText("Productos disponibles:");

        tblServicio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cant.", "Producto", "Descripcion", "P. Unit.", "Subtotal", "Estado", "Gestor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
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
        listMesas.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listMesasValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(listMesas);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnAgregarProducto.setText("Agregar Producto");
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnCerrar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAgregarProducto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnTransferir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btnAbrir, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblCantidadProducto)
                            .addComponent(btnAgregarItemServicio)
                            .addComponent(txtCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDescripcionProducto)
                            .addComponent(lblDescripcionProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblMesasMozo, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblProductosDisponilbes))
                    .addComponent(btnSalir)
                    .addComponent(lblServicioMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSalir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                        .addComponent(btnAgregarItemServicio))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(btnAbrir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregarProducto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCerrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTransferir)))
                .addGap(41, 41, 41)
                .addComponent(lblServicioMesa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
        try {
            abrirMesa();
        } catch (MesaException ex) {
            Logger.getLogger(DialogoMozo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAbrirActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        try {
            cerrarMesa();
        } catch (MesaException ex) {
            Logger.getLogger(DialogoMozo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnTransferirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransferirActionPerformed
        transferirMesa();
    }//GEN-LAST:event_btnTransferirActionPerformed

    private void btnAgregarItemServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarItemServicioActionPerformed
        try {
            agregarProductoAlServicio();
        } catch (ServicioException ex) {
            Logger.getLogger(DialogoMozo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAgregarItemServicioActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        salir();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed
        try {
            agregarProductoAlServicio();
        } catch (ServicioException ex) {
            Logger.getLogger(DialogoMozo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    private void listMesasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listMesasValueChanged
        cargarServicioDeLaMesa();
    }//GEN-LAST:event_listMesasValueChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnAgregarItemServicio;
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnTransferir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblCantidadProducto;
    private javax.swing.JLabel lblDescripcionProducto;
    private javax.swing.JLabel lblMesasMozo;
    private javax.swing.JLabel lblProductosDisponilbes;
    private javax.swing.JLabel lblServicioMesa;
    private javax.swing.JList listMesas;
    private javax.swing.JList listProductos;
    private javax.swing.JTable tblServicio;
    private javax.swing.JTextField txtCantidadProducto;
    private javax.swing.JTextField txtDescripcionProducto;
    // End of variables declaration//GEN-END:variables

    public void cerrarVista() {
        this.dispose();
    }

    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje,"Error", JOptionPane.ERROR_MESSAGE);
    }

    //////////////////////////////////////////////////////////////////
    //   //*CU:  Ingresar a la aplicación                           //               
    ////////////////////////////////////////////////////////////////// 
    
    public void cargarNombreMozo(String nombreMozo){
        lblMesasMozo.setText("Mesas del mozo: "+nombreMozo);
    }
    
    public void cargarMesasMozo(ArrayList<Mesa> mesasMozo){
        listMesas.setCellRenderer(new MesasRenderer());
        listMesas.setListData(mesasMozo.toArray());
    }
    
    //////////////////////////////////////////////////////////////////
    //   //*CU: Abrir una mesa                                      //               
    ////////////////////////////////////////////////////////////////// 
    
    public void abrirMesa() throws MesaException {
        Mesa mesaSeleccionada= (Mesa) listMesas.getSelectedValue();
        controlador.abrirMesa(mesaSeleccionada);
    }
    
    //////////////////////////////////////////////////////////////////
    //   //CU: Agregar un producto al servicio                      //               
    ////////////////////////////////////////////////////////////////// 

    private void cargarServicioDeLaMesa(){
        dtm.setNumRows(0);
        Mesa mesa= (Mesa) listMesas.getSelectedValue();
        controlador.cargarServicioMesa(mesa);
    }
    
    public void setLblServicioMesa(String texto){
        lblServicioMesa.setText(texto);
    }

    private void productosDisponibles() {  
        controlador.listaProductosDisponibles();
    }
    
    public void setListProductos(ArrayList<Producto> productos){
        listProductos.clearSelection();
        listProductos.setListData(productos.toArray());
    }
    
    private void agregarProductoAlServicio() throws ServicioException {
        Mesa mesa= (Mesa) listMesas.getSelectedValue();
        Producto producto= (Producto) listProductos.getSelectedValue();
        String descripcion= txtDescripcionProducto.getText();
        String cantidad= txtCantidadProducto.getText();
        int cantidadP=Integer.parseInt(cantidad);
        
        controlador.agregarProductoAlServicio(mesa, producto, descripcion, cantidadP);
    }
    
    public void cargarServicioCompleto(Servicio servicio){
        for(int i=0; i < servicio.getItems().size(); i++){
            ItemServicio item= servicio.getItems().get(i);
            agregarItemTablaServicio(item);
        }
    }
    
    public void agregarItemTablaServicio(ItemServicio item){
        int col = dtm.getColumnCount();
        Object[] newRow = new Object[col];
        newRow[0]= item.getUnidades();
        newRow[1]= item.getProducto();
        newRow[2]= item.getDescripcion();
        newRow[3]= item.getProducto().getPrecioUnidad();
        newRow[4]= item.getSubTotal();
        newRow[5]= item.getEstado();
        newRow[6]= item.getGestorActual().getNombreCompleto();
        dtm.addRow(newRow);
    }
    
    //////////////////////////////////////////////////////////////////
    //   //CU: Cerrar una mesa                                      //               
    //////////////////////////////////////////////////////////////////
    
    private void cerrarMesa() throws MesaException {
        Mesa mesa= (Mesa) listMesas.getSelectedValue();
        controlador.cerrarMesa(mesa);
    }
    
    public void callDialogoCerrarMesa(Mozo mozo, Mesa mesa){
        new DialogoCerrarMesa((java.awt.Frame) this.getParent(), false, mozo, mesa).setVisible(true);    
    }
    
    //////////////////////////////////////////////////////////////////
    //   //CU: Transferir una mesa                                  //               
    //////////////////////////////////////////////////////////////////
    
    private void transferirMesa(){
        Mesa mesa= (Mesa) listMesas.getSelectedValue();
        controlador.transferirMesa(mesa);
    }
    
    public void callDialogoMozoTransferirMesa(Mozo mozo, Mesa mesa){
        new DialogoMozoTransferirMesa((java.awt.Frame) this.getParent(), false, mozo, mesa).setVisible(true);   
    }
    
    public void notificarNuevaTransferenciaMesa(TransferenciaMesa transferencia){
        int numeroMesa= transferencia.getMesa().getNumero();
        String estadoMesa="cerrada";
        if(transferencia.getMesa().isAbierta()){
            estadoMesa= "abierta";
        }
        String nombreMozo= transferencia.getMozoEmisor().getNombreCompleto();
        
        String[] options = {"Aceptar", "Rechazar"};
        int opcionSeleccionada = JOptionPane.showOptionDialog(this, "Mesa "+numeroMesa+ ", estado: "+estadoMesa+" mozo: "+nombreMozo,
                "Nueva transferencia de mesa", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        controlador.cambioEstadoTransferenciaMesa(opcionSeleccionada, transferencia);
    }
    
    public void notificarEstadoTransferenciaEmitida(String estado){
        JOptionPane.showMessageDialog(this, estado,"Estado transferencia", JOptionPane.PLAIN_MESSAGE);
    }
    
    //////////////////////////////////////////////////////////////////
    //   //CU: Salir del sistema                                    //               
    //////////////////////////////////////////////////////////////////
    
    private void salir(){
        controlador.salirDelSistema();
    }

    private class MesasRenderer extends JLabel implements ListCellRenderer<Mesa> {

        @Override
        public Component getListCellRendererComponent(JList<? extends Mesa> list, Mesa m, int index, boolean isSelected, boolean cellHasFocus) {
            if(m.isAbierta()) {
                setBackground(Color.red);
            } else {
                setBackground(Color.white);
            }
            return this;
        }
    }
    
}
