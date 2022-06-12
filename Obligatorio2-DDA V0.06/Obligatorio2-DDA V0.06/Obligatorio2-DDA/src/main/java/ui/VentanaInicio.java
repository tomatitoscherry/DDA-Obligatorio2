package ui;
/**
 *
 * @author ddauser
 */
public class VentanaInicio extends javax.swing.JFrame {

    /**
     * Creates new form VentanaInicio
     */
    public VentanaInicio() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Bienvenido al sistema de mozos");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mLoginMozo = new javax.swing.JMenuItem();
        mLoginGestor = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bienvenido a Sistema de Agendas");

        jMenu1.setText("Menu");

        mLoginMozo.setText("Login mozo");
        mLoginMozo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mLoginMozoActionPerformed(evt);
            }
        });
        jMenu1.add(mLoginMozo);

        mLoginGestor.setText("Login gestor");
        mLoginGestor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mLoginGestorActionPerformed(evt);
            }
        });
        jMenu1.add(mLoginGestor);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 529, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mLoginMozoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mLoginMozoActionPerformed
        this.loginMozo();
    }//GEN-LAST:event_mLoginMozoActionPerformed

    private void mLoginGestorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mLoginGestorActionPerformed
        this.loginGestor();
    }//GEN-LAST:event_mLoginGestorActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem mLoginGestor;
    private javax.swing.JMenuItem mLoginMozo;
    // End of variables declaration//GEN-END:variables

    private void loginMozo() {
        new DialogoLoginMozo(this, false).setVisible(true);
    }

    private void loginGestor() {
        new DialogoLoginGestor(this, false).setVisible(true);
    }
}
