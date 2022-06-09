/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package ui;

import controlador.DialogoCerrarMesaControlador;
import dominio.Beneficio;
import dominio.Cliente;
import dominio.Mesa;
import dominio.Mozo;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author yamil
 */
public class DialogoCerrarMesa extends javax.swing.JDialog implements DialogoCerrarMesaVista{
    
    private Mesa mesa;
    private Mozo mozo;
    private DialogoCerrarMesaControlador controlador;
    /**
     * Creates new form DialogoAgregarCliente
     */
    public DialogoCerrarMesa(java.awt.Frame parent, boolean modal, Mozo mozo ,Mesa mesa) {
        super(parent, modal);
        initComponents();
        this.mesa= mesa;
        this.mozo= mozo;
        this.controlador= new DialogoCerrarMesaControlador(this);
        this.setTitle("Cerrar mesa");
        btnCerrar.setEnabled(false);
        lblCerrandoMesa.setText("Cerrando mesa "+mesa.getNumero());
        lblCliente.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAgregarCliente = new javax.swing.JLabel();
        btnAgregarCliente = new javax.swing.JButton();
        txtNroCliente = new javax.swing.JTextField();
        lblNroCliente = new javax.swing.JLabel();
        lblCerrandoMesa = new javax.swing.JLabel();
        btnNoAgregarCliente = new javax.swing.JButton();
        lblCliente = new javax.swing.JLabel();
        lblDatosServicio = new javax.swing.JLabel();
        lblMontoServicio = new javax.swing.JLabel();
        lblBeneficiosAplicados = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listBeneficiosAplicados = new javax.swing.JList();
        lblMontoPagar = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblAgregarCliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblAgregarCliente.setText("Puede agregar un cliente a la mesa");

        btnAgregarCliente.setText("Agregar Cliente");
        btnAgregarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarClienteActionPerformed(evt);
            }
        });

        lblNroCliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblNroCliente.setText("Ingrese el Nro. Cliente");

        lblCerrandoMesa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCerrandoMesa.setText("Cerrando mesa");

        btnNoAgregarCliente.setText("No agregar");
        btnNoAgregarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoAgregarClienteActionPerformed(evt);
            }
        });

        lblDatosServicio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDatosServicio.setText("Datos del servicio");

        lblMontoServicio.setText("Monto del servicio : ");

        lblBeneficiosAplicados.setText("Beneficios aplicados :");

        listBeneficiosAplicados.setToolTipText("");
        jScrollPane1.setViewportView(listBeneficiosAplicados);

        lblMontoPagar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblMontoPagar.setText("Monto total a pagar :");

        btnCerrar.setText("CERRAR");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCerrandoMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAgregarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblNroCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAgregarCliente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNoAgregarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txtNroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(126, 126, 126))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblDatosServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(149, 149, 149))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblMontoServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBeneficiosAplicados, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                            .addComponent(lblMontoPagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(btnCerrar)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCerrandoMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAgregarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarCliente)
                    .addComponent(btnNoAgregarCliente))
                .addGap(18, 18, 18)
                .addComponent(lblCliente)
                .addGap(18, 18, 18)
                .addComponent(lblDatosServicio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMontoServicio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBeneficiosAplicados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMontoPagar)
                .addGap(18, 18, 18)
                .addComponent(btnCerrar)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarClienteActionPerformed
        agregarClienteMesa();
    }//GEN-LAST:event_btnAgregarClienteActionPerformed

    private void btnNoAgregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoAgregarClienteActionPerformed
        noAgregarClienteMesa();
    }//GEN-LAST:event_btnNoAgregarClienteActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        cerrarMesa();
        cerrarVista();
    }//GEN-LAST:event_btnCerrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarCliente;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnNoAgregarCliente;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAgregarCliente;
    private javax.swing.JLabel lblBeneficiosAplicados;
    private javax.swing.JLabel lblCerrandoMesa;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblDatosServicio;
    private javax.swing.JLabel lblMontoPagar;
    private javax.swing.JLabel lblMontoServicio;
    private javax.swing.JLabel lblNroCliente;
    private javax.swing.JList listBeneficiosAplicados;
    private javax.swing.JTextField txtNroCliente;
    // End of variables declaration//GEN-END:variables

    @Override
    public void cerrarVista() {
        this.dispose();
    }

    @Override
    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje,"Error", JOptionPane.ERROR_MESSAGE);
    }
    
    @Override
    public void agregarClienteMesa() {
        int nroCliente= Integer.parseInt(txtNroCliente.getText());
        Cliente cliente= controlador.buscarCliente(nroCliente);
        if(cliente!=null){
            desactivarBotones();
            this.mesa.agregarCliente(cliente);
            lblCliente.setText("Cliente: "+cliente.getNombre());
            lblCliente.setVisible(true);
            cargarServicio(cliente);
        }
    }
    
    @Override
    public void noAgregarClienteMesa() {
        desactivarBotones();
        Cliente cli= new Cliente();
        this.mesa.agregarCliente(cli);
        lblCliente.setText("Cliente sin registrar");
        lblCliente.setVisible(true);
        cargarServicio(cli);
    }
    
    public void listarBeneficiosCliente(Cliente cliente){
        ArrayList<Beneficio> beneficios= cliente.getTipoCliente().getBeneficios();
        if(!beneficios.isEmpty()){
            listBeneficiosAplicados.setListData(beneficios.toArray());
        }
    }
    
    public void cargarServicio(Cliente cliente){
        lblMontoServicio.setText("Monto del servicio : $"+mesa.getServicio().montoServicio());
        lblBeneficiosAplicados.setText("Monto descuento por beneficios : $"+mesa.descuentoBeneficios());
        listarBeneficiosCliente(cliente);
        lblMontoPagar.setText("Monto total a pagar : $"+mesa.calcularMontoTotalConBeneficios());
        btnCerrar.setEnabled(true);
    }
    
    public void desactivarBotones(){
        btnAgregarCliente.setEnabled(false);
        btnNoAgregarCliente.setEnabled(false);
    }

    @Override
    public void cerrarMesa() {
        this.mesa.cerrarMesa();
        this.mesa.limpiarMesa();
    }
}
