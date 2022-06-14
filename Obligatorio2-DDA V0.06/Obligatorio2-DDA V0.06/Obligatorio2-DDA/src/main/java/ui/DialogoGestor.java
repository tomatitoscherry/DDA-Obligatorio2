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
import dominio.Pedido;
import dominio.Producto;
import dominio.UnidadProcesadora;
import exceptions.PedidoException;
import ui.DialogoGestorVista;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
        bFinalizarPedido = new javax.swing.JButton();
        lblGestorNombre = new javax.swing.JLabel();
        bSalir = new javax.swing.JButton();

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

        bFinalizarPedido.setText("Finalizar Pedido");
        bFinalizarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bFinalizarPedidoActionPerformed(evt);
            }
        });

        lblGestorNombre.setText("LABEL");

        bSalir.setText("Salir");
        bSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(338, 338, 338)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(bTomarPedido)
                        .addGap(377, 377, 377)
                        .addComponent(bFinalizarPedido)))
                .addContainerGap(138, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(bSalir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblGestorNombre)
                .addGap(466, 466, 466))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGestorNombre)
                    .addComponent(bSalir))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bTomarPedido)
                    .addComponent(bFinalizarPedido))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bTomarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTomarPedidoActionPerformed
        tomarPedido();
    }//GEN-LAST:event_bTomarPedidoActionPerformed

    private void bFinalizarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFinalizarPedidoActionPerformed
        finalizarPedido();
    }//GEN-LAST:event_bFinalizarPedidoActionPerformed

    private void bSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalirActionPerformed
       salir();
    }//GEN-LAST:event_bSalirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bFinalizarPedido;
    private javax.swing.JButton bSalir;
    private javax.swing.JButton bTomarPedido;
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
    public void cargarTabla(ArrayList<Pedido> pedido) {
        int col = dtm.getColumnCount();

        for (Pedido p : pedido) {
            Object[] newRow = new Object[col];
            newRow[0] = p.getItem().getProducto().getNombre();
            newRow[1] = p.getItem().getUnidades();
            newRow[2] = p.getItem().getDescripcion();
            newRow[3] = p.getMesa();
            newRow[4] = p.getMozo();
            dtm.addRow(newRow);
        }

    }

    @Override
    public void tomarPedido() {
        int pos = tblPedidosPendientes.getSelectedRow();
        try {
            this.controlador.tomarPedido(pos);
        } catch (PedidoException ex) {
            Logger.getLogger(DialogoGestor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void finalizarPedido() {
        Pedido pedido = (Pedido) lPedidosTomados.getSelectedValue();
         try {
            this.controlador.finalizarPedido(pedido);
        } catch (PedidoException ex) {
            Logger.getLogger(DialogoGestor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



    public void vaciarTabla() {
       dtm.setRowCount(0);
    }
    
    
    public void cargarPedidosGestor(ArrayList<Pedido> pedidosGestor) {
        lPedidosTomados.clearSelection();
        lPedidosTomados.setListData(pedidosGestor.toArray());

    }


    public void cerrarVista() {
        this.dispose();
    }

        
    @Override
    public void mostrarError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void salir() {
        controlador.salirDelSistema();
    }

}
