package proyectoiinterfaz;

import java.io.File;
import java.io.FileInputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * Frame que imprime las tablas generadas y la macroexpansión del archivo seleccionado..
 * @author victor
 */
public class ventanaVerTablas extends javax.swing.JFrame {
    
        JFileChooser seleccionarArchivoTablas = new JFileChooser();
        File archivoTablas;
        FileInputStream entrada;
        private static final int CLICK_TABLAS = 0;
        private static final int CLICK_MACRO = 1;
        private static final int CLICK_SIN_MACRO =2;

    public ventanaVerTablas() {
        initComponents();
        this.setVisible(true);
        this.setTitle("Ver tablas");
        this.setLocationRelativeTo(null);
        
        if(ventanaProgreso.tablas){
            btnElegirArchivoMacro.doClick();
        } else{
            lblVentana.setText("Salida");
            btnVerTablas.setEnabled(false);
            btnElegirArchivoMacro.setEnabled(false);
            escribirArchivo(Path.archivoEsamblar,CLICK_SIN_MACRO);
        }
    }
    
    public String abrirArchivo(File archivoOriginal){
    
        String contenidoT = "";
        try{
            entrada = new FileInputStream(archivoOriginal);
            int leer;
            while((leer = entrada.read()) != -1){
                
                char caracter = (char)leer;
                contenidoT += caracter;
            }
            entrada.close();
        }
        catch (Exception e){
        }
        
        return contenidoT;
    }
    
    public void escribirArchivo(String ruta, int casoAccion){
        
        switch(casoAccion){
            case CLICK_TABLAS:
                archivoTablas = new File(ruta);
                if(archivoTablas.canRead()){
            
                    if(archivoTablas.getName().endsWith("txt")){
                        String contenido = abrirArchivo(archivoTablas);
                        txtTablas.setText(contenido);  
                        btnElegirArchivoMacro.setEnabled(true);
                        btnVerTablas.setEnabled(false);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Archivo no permitido");
                    }
                }
            break;
                
            case CLICK_MACRO:
                archivoTablas = new File(ruta);
                if(archivoTablas.canRead()){
            
                    if(archivoTablas.getName().endsWith("asm")){
                        String contenido = abrirArchivo(archivoTablas);
                        txtTablas.setText(contenido);  
                        btnElegirArchivoMacro.setEnabled(false);
                        btnVerTablas.setEnabled(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Archivo no permitido");
                    }
                }
                break;
                
            case CLICK_SIN_MACRO:
                archivoTablas = new File(ruta);
                if(archivoTablas.canRead()){
            
                    if(archivoTablas.getName().endsWith("asm")){
                        String contenido = abrirArchivo(archivoTablas);
                        txtTablas.setText(contenido);  
                        
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Archivo no permitido");
                    }
                }
                break;
            
        }     
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnElegirArchivoMacro = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtTablas = new javax.swing.JTextArea();
        lblVentana = new javax.swing.JLabel();
        btnInicio = new javax.swing.JButton();
        btnVerTablas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnElegirArchivoMacro.setFont(new java.awt.Font("Cambria Math", 0, 18)); // NOI18N
        btnElegirArchivoMacro.setText("Ver macroensamblado");
        btnElegirArchivoMacro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElegirArchivoMacroActionPerformed(evt);
            }
        });

        txtTablas.setEditable(false);
        txtTablas.setColumns(20);
        txtTablas.setRows(5);
        jScrollPane1.setViewportView(txtTablas);

        lblVentana.setBackground(new java.awt.Color(0, 0, 153));
        lblVentana.setFont(new java.awt.Font("Cambria Math", 1, 48)); // NOI18N
        lblVentana.setForeground(new java.awt.Color(16, 0, 102));
        lblVentana.setText("Salida");

        btnInicio.setFont(new java.awt.Font("Cambria Math", 0, 18)); // NOI18N
        btnInicio.setText("Volver");
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });

        btnVerTablas.setFont(new java.awt.Font("Cambria Math", 0, 18)); // NOI18N
        btnVerTablas.setText("Ver tablas");
        btnVerTablas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerTablasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblVentana)
                .addGap(135, 135, 135)
                .addComponent(btnVerTablas)
                .addGap(45, 45, 45)
                .addComponent(btnElegirArchivoMacro, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblVentana))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnVerTablas)
                            .addComponent(btnElegirArchivoMacro, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnElegirArchivoMacroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElegirArchivoMacroActionPerformed

        escribirArchivo(ventanaProgreso.pathMacro,CLICK_MACRO);
    }//GEN-LAST:event_btnElegirArchivoMacroActionPerformed

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        
        ventanaSeleccionar seleccionaActividad = new ventanaSeleccionar();
        seleccionaActividad.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnInicioActionPerformed

   
    private void btnVerTablasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerTablasActionPerformed
        // TODO add your handling code here:
        escribirArchivo(ventanaProgreso.pathTablas,CLICK_TABLAS);
    }//GEN-LAST:event_btnVerTablasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnElegirArchivoMacro;
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnVerTablas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblVentana;
    private javax.swing.JTextArea txtTablas;
    // End of variables declaration//GEN-END:variables
}
