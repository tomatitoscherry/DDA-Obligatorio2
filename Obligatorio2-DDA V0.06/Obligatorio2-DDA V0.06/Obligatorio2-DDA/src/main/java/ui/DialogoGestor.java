/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package ui;

import Logica.FachadaServicios;
import controlador.DialogoGestorControlador;
import controlador.DialogoMozoControlador;
import dominio.Gestor;
import dominio.ItemServicio;
import dominio.Producto;
import dominio.UnidadProcesadora;
import exceptions.PedidoException;
import ui.DialogoGestorVista;
import java.awt.Frame;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yamil
 */
public class DialogoGestor extends javax.swing.JDialog implements DialogoGestorVista {

    private DialogoGestorControlador controlador;
    DefaultTableModel dtm;

    /**
     * Creates new form DialogoGestor
     */
    public DialogoGestor(java.awt.Frame parent, boolean modal, Gestor gestor, UnidadProcesadora unidadProcesadora) {
        super(parent, modal);
        initComponents();
        this.setTitle("Unidad Procesadora: " + unidadProcesadora.getNombre().toString());
        dtm = (DefaultTableModel) tblPedidosPendientes.getModel();
        this.controlador = new DialogoGestorControlador(this, gestor, unidadProcesadora);
     
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblPedidosPendientes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        bTomarPedido = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lPedidosTomados = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lblGestorNombre = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblPedidosPendientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Cantidad", "Descripción", "Nº Mesa", "Mozo Asignado"
            }
        ));
        jScrollPane1.setViewportView(tblPedidosPendientes);

        jLabel1.setText("Monitor de Pedidos");

        bTomarPedido.setText("Tomar Pedido");
        bTomarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTomarPedidoActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(lPedidosTomados);

        jLabel2.setText("Pedidos Tomados");

        jButton1.setText("Finalizar Pedido");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblGestorNombre.setText("LABEL");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(338, 338, 338)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(bTomarPedido)
                        .addGap(377, 377, 377)
                        .addComponent(jButton1)))
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblGestorNombre)
                .addGap(363, 363, 363))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblGestorNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bTomarPedido)
                    .addComponent(jButton1))
                .addGap(55, 55, 55))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bTomarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTomarPedidoActionPerformed
        tomarPedido();
    }//GEN-LAST:event_bTomarPedidoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bTomarPedido;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList lPedidosTomados;
    private javax.swing.JLabel lblGestorNombre;
    private javax.swing.JTable tblPedidosPendientes;
    // End of variables declaration//GEN-END:variables

    @Override
    public void cargarNombreGestor(String nombreCompleto) {
        lblGestorNombre.setText(nombreCompleto);
    }

    @Override
    public void cargarTabla() {
        int col = dtm.getColumnCount();
        Object[] newRow = new Object[col];
        if (this.controlador != null && !this.controlador.getUnidadProcesadora().getItemServicios().isEmpty()) {
            for (ItemServicio is : this.controlador.getUnidadProcesadora().getItemServicios()) {
                newRow[0] = is.getProducto().getNombre();
                newRow[1] = is.getUnidades();
                newRow[2] = is.getDescripcion();
                newRow[3] = FachadaServicios.getInstance().buscarMesaAsociada(is).getNumero();
                newRow[4] = FachadaServicios.getInstance().buscarMozoAsociado(is).getNombreCompleto();

            }
            dtm.addRow(newRow);
        }

    }

    @Override
    public void vaciarTabla() {
//        dtm.setRowCount(0);
    }

    @Override
    public void tomarPedido() {
        int pos = tblPedidosPendientes.getSelectedRow();
        ItemServicio Pedido = this.controlador.getUnidadProcesadora().getItemServicios().get(pos);

        try {
            this.controlador.tomarPedido(Pedido);
            lPedidosTomados.clearSelection();
            lPedidosTomados.setListData(this.controlador.getGestor().getPedidos().toArray());
        } catch (PedidoException ex) {
            Logger.getLogger(DialogoGestor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void finalizarPedido(ItemServicio pedido) {
        ItemServicio Pedido = (ItemServicio) lPedidosTomados.getSelectedValue();
        try {
            this.controlador.finalizarPedido(Pedido);
            lPedidosTomados.clearSelection();
            lPedidosTomados.setListData(this.controlador.getGestor().getPedidos().toArray());
        } catch (PedidoException ex) {
            Logger.getLogger(DialogoGestor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
