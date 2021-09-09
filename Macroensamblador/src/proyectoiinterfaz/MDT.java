/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoiinterfaz;
import java.util.ArrayList;
/**
 * Clase encargada de rellenar la Tabla "MDT", en esta se ingresarán las lineas 
 * que encapsulen a las MACROS que se encontraron en el archivo ".asm".
 * 
 * @author Alberto, Luis, Noelia, Victor.
 */
public class MDT {
    private ArrayList <MDTUnitario> mdt  = null;
    private int iMacro;   
    private int indice;
    
    /**
     * Constructor en donde se inicaliza un arreglo en donde se almacenaran las 
     * lineas de la tabla MDT y se inicia un contador para los indices.
     */
    public MDT(){
        mdt= new ArrayList<>();
        iMacro= 0;
    }
    
    /**
     * Constructor encargado de incluir a la linea "mdtU".
     * @param mdtU abstracción de una linea de la tabla MDT.
     */
    public MDT(MDTUnitario mdtU){
        mdt= new ArrayList<>();
        iMacro=0;
        mdt.add(mdtU);
    }
    
    /**
     * Getter que regresa una de las lineas a la tabla MDT.
     * @return 
     */
    public ArrayList<MDTUnitario> getMDT(){
        return mdt;
    }
    
    /**
     * Método encargado de ingresar una linea a la tabla MDT.
     * @param mdtU 
     */
    public void insert(MDTUnitario mdtU){
        mdtU.setCmdt(indice);
        mdt.add(mdtU);
        indice++;
    }
    
    /**
     * Método encargado de establecer el valor inicial de una macro definición.
     */
    public void insertInicio(){
        iMacro= indice;
    }
    
    /**
     * Método encargado de imprimir en pantalla, las tablas de MDT.
     */
    public void impimir(){
        System.out.println("CMDT\t| CUERPO DE LA MACRO");
        System.out.println("--------+-----------------------------------");
        for(MDTUnitario a:mdt){
            System.out.print(a.getCmdt()+"\t| ");
            System.out.println(a.toString());
        }
    }
    
    /**
     * Método encargado de obtener el indice en donde se encuentra el contador.
     * @return 
     */
    public int getiMacro() {
        return iMacro;
    }
    
    /**
     * Método encargado de obtener la última macro.
     * @return indice de la macro (contador).
     */
    public MDTUnitario getUltimaMacro(){
        return mdt.get(iMacro);
    }
    
    /**
     * Método encargado de obtener la siguiente linea de la tabla MDT.
     * @param cmdt clave en donde se encuantra la linea de la tabla MDT. 
     * @return linea siguiente de la tabla MDT.
     */
    public MDTUnitario getNext(int cmdt){
        try{
            return mdt.get(cmdt+1);
        }
        catch(Exception e){
            return null;
        }
    }
}


