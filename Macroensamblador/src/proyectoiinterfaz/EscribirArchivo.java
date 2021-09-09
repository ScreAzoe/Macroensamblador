/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoiinterfaz;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Writer;

/**
 *
 * Clase que se encarga de crear un archivo en específico, donde se escribirá 
 * con ayuda de la clase PrintWriter su contenido.
 * @author Lenovo
 */
public class EscribirArchivo {
    File file;
    PrintWriter pluma;
    
    /**
     * Constructor que inicializa los objetos para escribir, el archivo y la "pluma".
     * @param path ruta absoluta 
     * @throws FileNotFoundException 
     */
    public EscribirArchivo(String path) throws FileNotFoundException{
        file= new File(path);
        pluma= new PrintWriter(file);
    }
    /**
     * Validación que regresa una bandera de la existencia de un archivo.
     * @return existencia de un archivo.
     */
    public boolean existe(){
        return file.exists();
    }
    
    /**
     * Método para escribir una linea especifica.
     * @param linea línea que se quiere escribir en el archivo.
     */
    public void escribe(String linea){
        pluma.println(linea);
    }
    
    /**
     * Método para poder cerrar el flujo de la pluma.
     */
    public void cerrar(){
        pluma.close();
    }
    
    /**
     * Método que escribe todas las tablas dentro de un archivo.
     * @param tabla tabla que contiene las 3 tablas.
     */
    public void escribirTablas(Tablas tabla){
        imprimirMNT(tabla.mnt);
        pluma.println();
        imprimirMDT(tabla.mdt);
        pluma.println();
        imprimirALA(tabla.ala);
    }
    
    /**
     * Método encargado de darle el formato correpondiente a la escritura de la 
     * tabla MDT.
     * @param mdt tabla MDT.
     */
    public void imprimirMDT(MDT mdt){
        String CMDT= "CMDT"; 
        String cuerpo= "Cuerpo de la macro"; 
        pluma.printf("%5s| %20s",CMDT, cuerpo);
        pluma.println();
        for(int i=0; i<20; i++)
            pluma.print("- ");
        pluma.println();
        for(MDTUnitario aux:mdt.getMDT()){
            pluma.printf("%5d| %20s",aux.getCmdt(),aux.getCuerpo());
            pluma.println();
        }
        pluma.println();
    }
    
    /**
     * Método encargado de darle el formato correpondiente a la escritura de la 
     * tabla MNT.
     * @param mnt tabla MNT.
     */
   
    public void imprimirMNT(MNT mnt){
        String CMNT= "CMNT";
        String nombre= "NOMBRE";
        String AMDT= "AMDT";
        String AALA= "AALA";
        String Void= "-";
        pluma.printf("%5s| %20s| %5s| %5s",CMNT,nombre, AMDT, AALA);
        pluma.println();
        for(int i=0; i<20; i++)
            pluma.print("- ");
        pluma.println();
        try{
            for(MNTUnitario aux:mnt.getMNT()){
                pluma.printf("%5d| %20s| %5d| %5d",aux.getCmnt(), aux.getNombre(), aux.getAmdt().getCmdt(), aux.getAala().getCala() );
                pluma.println();
            }
        }
        catch(Exception e){
            for(MNTUnitario aux:mnt.getMNT()){
                pluma.printf("%5d| %20s| %5d| %5s",aux.getCmnt(), aux.getNombre(), aux.getAmdt().getCmdt(), Void );
                pluma.println();
            }
        }
        pluma.println();
    }
    
    /**
     * Método encargado de darle el formato correpondiente a la escritura de la 
     * tabla ALA.
     * @param ala tabla ALA.
     */
    public void imprimirALA(ALA ala){
        String CALA= "CALA";
        String ArgForm= "Argumento formal";
        String ArgActual= "Argumento actual";
        pluma.printf("%5s| %5s| %5s",CALA,ArgForm, ArgActual);
        pluma.println();
        for(int i=0; i<10; i++)
            pluma.print("- ");
        pluma.println();
        if(ala.getAla().isEmpty())
            return;
        try{
            for(ALAUnitario aux: ala.getAla()){
                pluma.printf("%5s| %5s| %5s",aux.getCala(),aux.getArgForm(), aux.getArgAct());
                pluma.println();
            }
        }catch(NullPointerException e){
            return;
        }
        pluma.println();
    }
}
