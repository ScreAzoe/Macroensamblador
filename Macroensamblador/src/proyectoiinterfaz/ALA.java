/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoiinterfaz;
import java.util.ArrayList;/**
 *
 * Clase que hace a la tabla Ala, esta tabla se genera con el algoritmo utlizado 
 * para macro-ensamblar.
 */
public class ALA {
    private ArrayList <ALAUnitario> ala;
    private int cala;
    private int iArgs;
    
    /**
     * Contructor qu einicializa el arreglo para la tabla ALA e inicaliza su 
     * contador en cero.
     */
    public ALA(){
        ala= new ArrayList<>();
        cala = 0;
    }
    
    /**
     * Getter que regresa el arreglo ala.
     * 
     * @return arreglo ala
     */
    public ArrayList<ALAUnitario> getAla() {
        return ala;
    }

    /**
     * Setter que ayuda a establecer la tabla ala.
     * @param ala tabla ala
     */
    public void setAla(ArrayList<ALAUnitario> ala) {
        this.ala = ala;
    }
    
    /**
     * Método encargado de insertar los argumentos de la tabla Ala.
     * @param args argumentos a ingresar.
     */
    public void insert(String args[]){
        iArgs= cala;
        if(args==null){
            ala.add(null);
            cala++;
            return;
        }
        ALAUnitario alaU;
        for(String aux:args){
            alaU= new ALAUnitario(cala, aux);
            ala.add(alaU);
            cala++;
        }
    }
    
    /**
     * Método que insert el incio
     */
    public void insertInicio(){
        iArgs = cala;
    }
    
    public ALAUnitario getPrimerArg(){
        return ala.get(iArgs);
    }
    
    /**
     * Método encargado de imprimir las tablas con un formato en la sección de 
     * salida del IDE.
     */
    public void imprimir(){
        System.out.println("CALA|\t Argumento formal|\t Argumento Actual");
        for(ALAUnitario aux: ala){
            try{
                System.out.println(aux.getCala()+"|\t"+aux.getArgForm()+"|\t"+aux.getArgAct());
            }catch(Exception e){
                //System.out.println(null+"|\t"+null+"|\t"+null);
            }
        }
        System.out.println("");
    }
    
    /**
     * Getter que obtiene la "linea" de la tabla ALA, dependiendo del indice.
     * @param i índice de la linea 
     * @return regresa la "linea" encontrada con el índice especificado.
     */
    public ALAUnitario getIndex(int i){
        if(ala.size()<=i){
            return null;
        }
        return ala.get(i);
    }
    
    
}
