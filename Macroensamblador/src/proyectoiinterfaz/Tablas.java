/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoiinterfaz;
import java.io.*;
/**
 *
 * Clase que se encarga de encapsular y manejar a las tablas creadas (MDT,MNT,ALA)
 * 
 * @author casti
 */
public class Tablas {
    public MNT mnt;
    public ALA ala;
    public MDT mdt;
        
    /**
     * Constructor que inicaliza las tablas.
     */
    public Tablas() {
        mnt= new MNT();
        ala= new ALA();
        mdt= new MDT();
    }
    
    /**
     * Método que actualiza las tablas para que todas queden con una integración 
     * uniforme.
     * @param mnt tabla mnt.
     * @param ala tabla ala.
     * @param mdtU tabla mdtU.
     * @param indice contador del índice.
     */
    public void actualizaTablas(MNT mnt, ALA ala,MDTUnitario mdtU, int indice){
        String aux[]= mdtU.getCuerpo().replaceAll(" #", "&").split(":");
        String etiqueta= aux[0];
        String args[]= aux[1].split(",");
        args[0]=args[0].substring(6);
        for(String argumentos: args)
            System.out.println(argumentos);
        for(String argumentos: args){
            System.out.println(argumentos.substring(1));
        }
    }
    
    private static void actualizaALA(){
        
    }
    
    private static void actualizaMNT(){

    }
    
    public static void actualizaMDT(){
        
    }
}
