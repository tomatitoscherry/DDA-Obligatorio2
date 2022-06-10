/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package ui;

import Logica.FachadaServicios;
import Logica.observer.Observable;
import Logica.observer.Observer;
import controlador.DialogoMozoTransferirMesaControlador;
import dominio.Mesa;
import dominio.Mozo;
import java.util.ArrayList;

/**
 *
 * @author yamil
 */
public class DialogoMozoTransferirMesa extends javax.swing.JDialog implements Observer, DialogoMozoTransferirMesaVista{
    
    private Mozo mozo;
    private Mesa mesa;
    private DialogoMozoTransferirMesaControlador controlador;
    
    /**
     * Creates new form DialogoMozosConectados
     */
    public DialogoMozoTransferirMesa(java.awt.Frame parent, boolean modal, Mozo mozo, Mesa mesa) {
        super(parent, modal);
        initComponents();
        this.mozo= mozo;
        this.mesa=mesa;
        this.controlador= new DialogoMozoTransferirMesaControlador(this);
        FachadaServicios.getInstance().addObserver(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listMozosConectados = new javax.swing.JList();
        lblListMozosConectados = new javax.swing.JLabel();
        lblTransfiriendoMesa = new javax.swing.JLabel();
        btnTransferirMesa = new javax.swing.JButton();
        btnCancelarTransferencia = new javax.swing.JButton();
        txtMozoSeleccionado = new javax.swing.JTextField();
        lblMozoSeleccionado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        listMozosConectados.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listMozosConectadosValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listMozosConectados);

        lblListMozosConectados.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblListMozosConectados.setText("Seleccione un mozo");

        lblTransfiriendoMesa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTransfiriendoMesa.setText("Transfiriendo mesa ");

        btnTransferirMesa.setText("Transferir");
        btnTransferirMesa.setActionCommand("Transferir");
        btnTransferirMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransferirMesaActionPerformed(evt);
            }
        });

        btnCancelarTransferencia.setText("Cancelar");
        btnCancelarTransferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarTransferenciaActionPerformed(evt);
            }
        });

        txtMozoSeleccionado.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        lblMozoSeleccionado.setText("Mozo Seleccionado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTransfiriendoMesa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblListMozosConectados, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnTransferirMesa)
                                .addGap(207, 207, 207)
                                .addComponent(btnCancelarTransferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblMozoSeleccionado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtMozoSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 10, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(lblTransfiriendoMesa)
                .addGap(18, 18, 18)
                .addComponent(lblListMozosConectados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMozoSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMozoSeleccionado))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTransferirMesa)
                    .addComponent(btnCancelarTransferencia))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTransferirMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransferirMesaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTransferirMesaActionPerformed

    private void btnCancelarTransferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarTransferenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarTransferenciaActionPerformed

    private void listMozosConectadosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listMozosConectadosValueChanged
        Mozo mozoSeleccionado= (Mozo) listMozosConectados.getSelectedValuesList();
        txtMozoSeleccionado.setText(mozoSeleccionado.getNombreCompleto());
    }//GEN-LAST:event_listMozosConectadosValueChanged

    @Override
    public void update(Observable source, Object event) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarTransferencia;
    private javax.swing.JButton btnTransferirMesa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblListMozosConectados;
    private javax.swing.JLabel lblMozoSeleccionado;
    private javax.swing.JLabel lblTransfiriendoMesa;
    private javax.swing.JList listMozosConectados;
    private javax.swing.JTextField txtMozoSeleccionado;
    // End of variables declaration//GEN-END:variables

    @Override
    public void cerrarVista() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mostrarError(String mensaje) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void cargarMozosConectados(ArrayList<Mozo> mozosConectados) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}