package proyectoiinterfaz;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 * Frame que se encarga de seleccionar un archivo para ensamblar o solo ver un 
 * archivo en el buscador.
 * @author victor
 */
public class ventanaSeleccionar extends javax.swing.JFrame {
    
        JFileChooser seleccionarArchivoM = new JFileChooser();
        File seleccionado;
        static String ruta;
        
    public ventanaSeleccionar() {
        initComponents();
        
        this.setResizable(false);
        this.setSize(1200, 800);
        this.setTitle("Selecionar Actividad");
        this.setLocationRelativeTo(null);
        
        ImageIcon imagenEditaArchivo =  new ImageIcon(Path.getEstaRuta()+"editarArchivo.png");
        Icon imagenEditar = new ImageIcon (imagenEditaArchivo.getImage().getScaledInstance(lblEditarArchivo.getWidth(), lblEditarArchivo.getHeight(), Image.SCALE_DEFAULT));
        lblEditarArchivo.setIcon(imagenEditar);
        this.repaint();
        
        ImageIcon imagenMacro =  new ImageIcon(Path.getEstaRuta()+"macroensamblar.jpg");
        Icon imagenMac = new ImageIcon (imagenMacro.getImage().getScaledInstance(lblImagenMacro.getWidth(), lblImagenMacro.getHeight(), Image.SCALE_DEFAULT));
        lblImagenMacro.setIcon(imagenMac);
        this.repaint();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblEditarArchivo = new javax.swing.JLabel();
        btnRegVentana = new javax.swing.JButton();
        btnMacroensamblar = new javax.swing.JButton();
        lblImagenMacro = new javax.swing.JLabel();
        btnVerArchivoOriginal = new javax.swing.JButton();

        jButton1.setText("jButton1");

        jButton3.setText("jButton3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(1, 10, 80));

        jLabel1.setFont(new java.awt.Font("Cambria Math", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Seleccione lo que desea hacer");

        btnRegVentana.setFont(new java.awt.Font("Cambria Math", 0, 18)); // NOI18N
        btnRegVentana.setText("Regresar");
        btnRegVentana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegVentanaActionPerformed(evt);
            }
        });

        btnMacroensamblar.setFont(new java.awt.Font("Cambria Math", 0, 18)); // NOI18N
        btnMacroensamblar.setText("Macroensamblar");
        btnMacroensamblar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMacroensamblarActionPerformed(evt);
            }
        });

        btnVerArchivoOriginal.setFont(new java.awt.Font("Cambria Math", 0, 18)); // NOI18N
        btnVerArchivoOriginal.setText("Ver archivo");
        btnVerArchivoOriginal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerArchivoOriginalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(311, 311, 311)
                .addComponent(btnVerArchivoOriginal, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMacroensamblar)
                .addGap(217, 217, 217))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(215, 215, 215)
                        .addComponent(lblEditarArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(33, 33, 33)
                            .addComponent(btnRegVentana, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(69, 69, 69)
                            .addComponent(jLabel1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 257, Short.MAX_VALUE)
                .addComponent(lblImagenMacro, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(165, 165, 165))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(lblEditarArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(lblImagenMacro, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMacroensamblar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVerArchivoOriginal, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(btnRegVentana, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegVentanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegVentanaActionPerformed

      ventana ventana1 = new ventana();
      ventana1.setVisible(true);
      dispose();
        
    }//GEN-LAST:event_btnRegVentanaActionPerformed

    private void btnVerArchivoOriginalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerArchivoOriginalActionPerformed
        
        verArchivoOriginal verArchOriginal = new verArchivoOriginal();
         
    }//GEN-LAST:event_btnVerArchivoOriginalActionPerformed

    private void btnMacroensamblarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMacroensamblarActionPerformed
        
         if (seleccionarArchivoM.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
        
            seleccionado = seleccionarArchivoM.getSelectedFile();
            
            if(seleccionado.canRead()){
            
                if(seleccionado.getName().endsWith("asm") || seleccionado.getName().matches("Tablas")){
                    ruta = seleccionado.getAbsolutePath();
                    
                    ventanaProgreso verProgreso = new ventanaProgreso();
                    verProgreso.setVisible(true);
                    dispose();
       
                }
                else{
                    JOptionPane.showMessageDialog(null,"ERROR\nArchivo no permitido");
                }
            }
        }

    }//GEN-LAST:event_btnMacroensamblarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMacroensamblar;
    private javax.swing.JButton btnRegVentana;
    private javax.swing.JButton btnVerArchivoOriginal;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblEditarArchivo;
    private javax.swing.JLabel lblImagenMacro;
    // End of variables declaration//GEN-END:variables
}
