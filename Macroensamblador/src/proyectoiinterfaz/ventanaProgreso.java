package proyectoiinterfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 * Clase que crea la representación de una tabla con progreso.
 * @author victor
 */
public class ventanaProgreso extends javax.swing.JFrame {
    static String pathMacro;
    static String pathTablas;
    static boolean tablas = false;

    public ventanaProgreso() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public class progreso implements ActionListener{
        public void actionPerformed(ActionEvent avt){
        
            int n = carga.getValue();
            
            if(n < 100){
            
                n++;
                carga.setValue(n);
            }
            else{
                tiempoC.stop();
                JOptionPane.showMessageDialog(null, "El macroensamblado ha finalizado");
                
                dispose();
                if(tablas){
                    ventanaVerTablas abrirVentanaVerTablas = new ventanaVerTablas();
                    abrirVentanaVerTablas.setVisible(true);
                } else{
                    JOptionPane.showMessageDialog(null, "No hay tablas debido a la ausencia de macros");
                    ventanaVerTablas abrirVentanaVerTablas = new ventanaVerTablas();
                    abrirVentanaVerTablas.setVisible(true);
               
                }
               
            }
        }
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        carga = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N
        jLabel1.setText("Progreso");

        jButton1.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        jButton1.setText("Empezar a macroensamblar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(carga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(jButton1)
                .addContainerGap(156, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(carga, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
        tiempoC =  new Timer(1, new progreso());
    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String path = ventanaSeleccionar.ruta;
        Path.setArchivoEsamblar(path);
        Path.crearCarpeta();
        Expansor expansor;
        Control controlP= new Control(path);
        boolean correcto= controlP.metodoPrincipal();
        boolean flag= true;
        if(controlP.hayMacros){
            expansor= new Expansor(controlP.getFarchivo(), controlP.getTablas());
            if(correcto){
                flag = expansor.metodoPrincipal();
                tablas = Expansor.existenTablas();
            }
            if(!flag || !correcto){
            switch(Expansor.error){
                case 1:
                    // mas argumentos de lo necesario
                    JOptionPane.showMessageDialog(null,"Exceso de argumentos en macrollamda:" + Expansor.errorCuerpo);
                    dispose();
                    ventanaSeleccionar seleccionaActividad = new ventanaSeleccionar();
                    seleccionaActividad.setVisible(true);
                    break;
                case 2:
                    // menos argumentos de lo necesario
                    JOptionPane.showMessageDialog(null,"Falta de argumentos en macrollamada:" + Expansor.errorCuerpo);
                    dispose();
                    ventanaSeleccionar seleccionaActividad1 = new ventanaSeleccionar();
                    seleccionaActividad1.setVisible(true);
                    break;
                case 3:
                    // argumento no declarado
                    JOptionPane.showMessageDialog(null,"Argumentos no declarados en macrodefinición" + Expansor.errorCuerpo);
                    dispose();
                    ventanaSeleccionar seleccionaActividad2 = new ventanaSeleccionar();
                    seleccionaActividad2.setVisible(true);
                    break;
                case 4:
                    // etiqueta no especificada
                    JOptionPane.showMessageDialog(null,"Falta de nombre para macrodefinición " + Expansor.errorCuerpo);
                    dispose();
                    ventanaSeleccionar seleccionaActividad3 = new ventanaSeleccionar();
                    seleccionaActividad3.setVisible(true);
                    break;
                    
                case 5:
                    // desequilibrio IF - ENDIF
                    JOptionPane.showMessageDialog(null,Expansor.errorCuerpo );
                    dispose();
                    ventanaSeleccionar seleccionaActividad4= new ventanaSeleccionar();
                    seleccionaActividad4.setVisible(true);
                    break;
                case 6:
                    // error sintaxis en directiva DL
                    JOptionPane.showMessageDialog(null,Expansor.errorCuerpo);
                    dispose();
                    ventanaSeleccionar seleccionaActividad5= new ventanaSeleccionar();
                    seleccionaActividad5.setVisible(true);
                    break;
                case 7:
                    // error sintaxis en directiva DL
                    JOptionPane.showMessageDialog(null,Expansor.errorCuerpo);
                    dispose();
                    ventanaSeleccionar seleccionaActividad6= new ventanaSeleccionar();
                    seleccionaActividad6.setVisible(true);
                    break;
                    
            }
       
        } else{
            pathMacro = expansor.getPathPluma();
            pathTablas = expansor.getArchivoTablas();
            if(pathMacro!=null){
            tiempoC.start();
            } else{
            //ERROR
            }
        }
        
        } else{
            tablas = false;
            JOptionPane.showMessageDialog(null,"El archivo que usted seleccionó no contiene Macros");
            dispose();
            ventanaVerTablas abrirVentanaVerTablas = new ventanaVerTablas();
            abrirVentanaVerTablas.setVisible(true);
        }
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

  
    private Timer tiempoC;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar carga;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
