
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

/**
 * GUI Cifrado privado - Fase 1
 * ----------------------------
 * @author Rubén
 */
public class Ventana extends javax.swing.JFrame {

    public Ventana() {
        initComponents();
        this.getContentPane().setBackground(Color.white);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEncriptar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtConsola = new javax.swing.JTextArea();
        lblTitulo = new javax.swing.JLabel();
        lblSubtitulo = new javax.swing.JLabel();
        btnAbrirFichero2 = new javax.swing.JButton();
        lblIcono = new javax.swing.JLabel();
        btnAbrirClave = new javax.swing.JButton();
        btnAbrirFicheroCodificado = new javax.swing.JButton();
        btnAbrirFichero1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cifrado privado - Fase 1");
        setBackground(new java.awt.Color(255, 255, 255));

        btnEncriptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/encrypt-sm1.png"))); // NOI18N
        btnEncriptar.setText("Desencriptar clave fase 2");
        btnEncriptar.setEnabled(false);
        btnEncriptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncriptarActionPerformed(evt);
            }
        });

        txtConsola.setEditable(false);
        txtConsola.setBackground(new java.awt.Color(0, 0, 0));
        txtConsola.setColumns(20);
        txtConsola.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txtConsola.setForeground(new java.awt.Color(51, 204, 0));
        txtConsola.setRows(5);
        txtConsola.setName("txtConsola"); // NOI18N
        txtConsola.setSelectionColor(new java.awt.Color(0, 51, 0));
        jScrollPane1.setViewportView(txtConsola);
        txtConsola.getAccessibleContext().setAccessibleDescription("");

        lblTitulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Descifrado - FASE 3");

        lblSubtitulo.setText("Información del sistema:");

        btnAbrirFichero2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Open_file.png"))); // NOI18N
        btnAbrirFichero2.setText("Abrir clave codificada fase 2");
        btnAbrirFichero2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirFichero2ActionPerformed(evt);
            }
        });

        lblIcono.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrado_peq.png"))); // NOI18N

        btnAbrirClave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/encrypted-icon.png"))); // NOI18N
        btnAbrirClave.setText("Ver clave generada");
        btnAbrirClave.setEnabled(false);
        btnAbrirClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirClaveActionPerformed(evt);
            }
        });

        btnAbrirFicheroCodificado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/steganos-locknote_w24.png"))); // NOI18N
        btnAbrirFicheroCodificado.setText("Ver fichero original decodificado");
        btnAbrirFicheroCodificado.setEnabled(false);
        btnAbrirFicheroCodificado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirFicheroCodificadoActionPerformed(evt);
            }
        });

        btnAbrirFichero1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Open_file_key.png"))); // NOI18N
        btnAbrirFichero1.setText("Abrir clave privada fase 2");
        btnAbrirFichero1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirFichero1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblIcono))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSubtitulo)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnAbrirFichero1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnAbrirFichero2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnEncriptar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnAbrirClave, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnAbrirFicheroCodificado, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addComponent(lblSubtitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIcono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAbrirFichero2)
                    .addComponent(btnAbrirFichero1)
                    .addComponent(btnEncriptar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAbrirClave)
                    .addComponent(btnAbrirFicheroCodificado))
                .addGap(6, 6, 6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAbrirFichero2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirFichero2ActionPerformed
        Main.abrirFicheroClaveCodificada();
    }//GEN-LAST:event_btnAbrirFichero2ActionPerformed

    private void btnEncriptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncriptarActionPerformed
        Main.descifrarClave();
    }//GEN-LAST:event_btnEncriptarActionPerformed

    private void btnAbrirClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirClaveActionPerformed
        Main.abrirFicheroClave();
    }//GEN-LAST:event_btnAbrirClaveActionPerformed

    private void btnAbrirFicheroCodificadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirFicheroCodificadoActionPerformed
        Main.abrirFicheroDescodificado();
    }//GEN-LAST:event_btnAbrirFicheroCodificadoActionPerformed

    private void btnAbrirFichero1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirFichero1ActionPerformed
        Main.abrirFicheroClaveFase2();
    }//GEN-LAST:event_btnAbrirFichero1ActionPerformed

    public void setTextoConsola(String texto){
        txtConsola.append(texto + "\n");
    }
    
    public void setIconoCifrado(boolean estado){
        if(estado){
            lblIcono.setIcon(new ImageIcon("./src/img/abierto_peq.png"));
        }
    }
    
    public void setFicherosSeleccionados(){
        btnEncriptar.setEnabled(true);
    }
    
    public void setProcesoTerminado(){
        btnAbrirClave.setEnabled(true);
        btnAbrirFicheroCodificado.setEnabled(true);
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrirClave;
    private javax.swing.JButton btnAbrirFichero1;
    private javax.swing.JButton btnAbrirFichero2;
    private javax.swing.JButton btnAbrirFicheroCodificado;
    private javax.swing.JButton btnEncriptar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblIcono;
    private javax.swing.JLabel lblSubtitulo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextArea txtConsola;
    // End of variables declaration//GEN-END:variables
}
