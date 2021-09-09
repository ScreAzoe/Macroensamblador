package proyectoiinterfaz;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * Clase que se encarga de poder ver el archivo original 
 * @author victor
 */
public class verArchivoOriginal extends javax.swing.JFrame {

        JFileChooser seleccionarArchivoOriginal = new JFileChooser();
        File archivoOriginal;
        FileInputStream entrada;
         
    public verArchivoOriginal() {
      initComponents();
      this.setVisible(true);
      this.setTitle("Ver archivo original");
      this.setLocationRelativeTo(null);
    }

    
    public String AbrirArchivoOriginal(File archivoOriginal){
    
        String contenido = "";
        try{
            entrada = new FileInputStream(archivoOriginal);
            int leer;
            while((leer = entrada.read()) != -1){
                
                char caracter = (char)leer;
                contenido += caracter;
            }
        }
        catch (Exception e){
        }
        
        return contenido;
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtMostrarOriginal = new javax.swing.JTextArea();
        btnEligeArchivo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Seleccionar Archivo");

        txtMostrarOriginal.setEditable(false);
        txtMostrarOriginal.setColumns(20);
        txtMostrarOriginal.setRows(5);
        jScrollPane1.setViewportView(txtMostrarOriginal);

        btnEligeArchivo.setFont(new java.awt.Font("Cambria Math", 0, 18)); // NOI18N
        btnEligeArchivo.setText("Elegir Archivo");
        btnEligeArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEligeArchivoActionPerformed(evt);
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
                        .addComponent(btnEligeArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(631, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnEligeArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEligeArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEligeArchivoActionPerformed
       
        if (seleccionarArchivoOriginal.showDialog(null, "Abrir") == JFileChooser.APPROVE_OPTION){
        
            archivoOriginal = seleccionarArchivoOriginal.getSelectedFile();
            if(archivoOriginal.canRead()){
            
                if(archivoOriginal.getName().endsWith("asm")){
                
                    String contenido = AbrirArchivoOriginal(archivoOriginal);
                    txtMostrarOriginal.setText(contenido);    
                }
                else{
                    JOptionPane.showMessageDialog(null,"Archivo no permitido");
                }
            }
        }
    }//GEN-LAST:event_btnEligeArchivoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEligeArchivo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtMostrarOriginal;
    // End of variables declaration//GEN-END:variables
}
