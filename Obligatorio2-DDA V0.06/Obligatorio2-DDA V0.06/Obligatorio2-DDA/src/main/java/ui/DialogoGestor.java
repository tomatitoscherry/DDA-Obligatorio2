/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package ui;

import controlador.DialogoGestorControlador;
import controlador.DialogoMozoControlador;
import dominio.Gestor;
import dominio.ItemServicio;
import dominio.UnidadProcesadora;
import ui.DialogoGestorVista;
import java.awt.Frame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yamil
 */
public class DialogoGestor extends javax.swing.JDialog {

    private UnidadProcesadora unidadProcesadora;
    private DialogoGestorControlador controlador;
    DefaultTableModel dtm;
    
    /**
     * Creates new form DialogoGestor
     */
    
    public DialogoGestor(java.awt.Frame parent, boolean modal, Gestor gestor, UnidadProcesadora unidadProcesadora) {
        super(parent, modal);
        initComponents();
        dtm = (DefaultTableModel) tblPedidosPendientes.getModel();
        this.setTitle("Unidad Procesadora: " + unidadProcesadora.getNombre());
        this.controlador = new DialogoGestorControlador((DialogoGestorVista) this, gestor, unidadProcesadora, dtm);
        this.unidadProcesadora = unidadProcesadora;
        
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(211, 211, 211)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(143, 143, 143)
                                .addComponent(jLabel2))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(bTomarPedido)))
                .addContainerGap(370, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(232, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(bTomarPedido)
                        .addGap(55, 55, 55))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bTomarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTomarPedidoActionPerformed
        tomarPedido();
    }//GEN-LAST:event_bTomarPedidoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bTomarPedido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList lPedidosTomados;
    private javax.swing.JTable tblPedidosPendientes;
    // End of variables declaration//GEN-END:variables

    private void tomarPedido() {
        int pos = tblPedidosPendientes.getSelectedRow();
        ItemServicio Pedido = unidadProcesadora.getItemServicios().get(pos);
        lPedidosTomados.clearSelection();
        lPedidosTomados.setListData(this.controlador.getGestor().getPedidos().toArray());
        this.controlador.tomarPedido(Pedido);
    }

    

}
