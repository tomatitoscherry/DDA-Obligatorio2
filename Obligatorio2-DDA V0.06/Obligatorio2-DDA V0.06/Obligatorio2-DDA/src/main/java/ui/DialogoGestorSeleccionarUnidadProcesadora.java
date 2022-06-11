/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package ui;

import Logica.FachadaServicios;
import Logica.observer.Observable;
import Logica.observer.Observer;
import controlador.DialogoGestorSeleccionarUnidadProcesadoraControlador;
import dominio.Gestor;
import dominio.UnidadProcesadora;
import java.awt.Frame;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author yamil
 */
public class DialogoGestorSeleccionarUnidadProcesadora extends javax.swing.JDialog implements DialogoGestorSeleccionarUnidadProcesadoraVista{
    
    
    private DialogoGestorSeleccionarUnidadProcesadoraControlador controlador;
    
    /////////////////////////////////////////////////////////////////
    //  OJO: por MVC la vista no puede contener entidades del modelo//
    //  quien tiene que tener la entidad de modelo es el controlador//
    //////////////////////////////////////////////////////////////////
    
    
    /**
     * Creates new form DialogoMozosConectados
     */
    public DialogoGestorSeleccionarUnidadProcesadora(java.awt.Frame parent, boolean modal, Gestor gestor) {
        super(parent, modal);
        initComponents();
        this.controlador= new DialogoGestorSeleccionarUnidadProcesadoraControlador(this, gestor);
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
        listUnidadesProcesadoras = new javax.swing.JList();
        lblListUnidadesProcesadoras = new javax.swing.JLabel();
        btnContinuarPedidos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.setViewportView(listUnidadesProcesadoras);

        lblListUnidadesProcesadoras.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblListUnidadesProcesadoras.setText("Seleccione una Unidad Procesadora");

        btnContinuarPedidos.setText("Continuar");
        btnContinuarPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarPedidosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnContinuarPedidos)
                .addGap(25, 25, 25))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblListUnidadesProcesadoras, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(lblListUnidadesProcesadoras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnContinuarPedidos)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnContinuarPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarPedidosActionPerformed
        continuarUnidadProcesadora();
    }//GEN-LAST:event_btnContinuarPedidosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnContinuarPedidos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblListUnidadesProcesadoras;
    private javax.swing.JList listUnidadesProcesadoras;
    // End of variables declaration//GEN-END:variables

    @Override
    public void cerrarVista() {
       this.dispose();
    }

    @Override
    public void mostrarError(String mensaje)  {
        JOptionPane.showMessageDialog(this, mensaje,"Error", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void setLabelInicio(String string) {
        lblListUnidadesProcesadoras.setText(string);
    }

    @Override
    public void cargarListadoUnidadesProcesadoras(ArrayList<UnidadProcesadora> unidadesProcesadoras) {
       listUnidadesProcesadoras.setListData(unidadesProcesadoras.toArray());
    }
    //////////////////////////////////////////////////////////////////
    //   *CU: Ingresar a la aplicación                              //               
    //////////////////////////////////////////////////////////////////
    
    private void continuarUnidadProcesadora() {
        UnidadProcesadora unidadProcesadora = (UnidadProcesadora) listUnidadesProcesadoras.getSelectedValue();
        controlador.continuarUnidadProcesadora(unidadProcesadora);
    }

    public void callDialogoGestor(UnidadProcesadora unidadProcesadora, Gestor gestor) {
         new DialogoGestor((java.awt.Frame) this.getParent(), false, gestor, unidadProcesadora).setVisible(true);       }
    
}
