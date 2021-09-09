/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoiinterfaz;
import java.util.ArrayList;
/**
 * Clase que representa a la tabla "MNT" que ayudará a unir lo que se encontró 
 * en la tabla ALA con lo de la tabla MDT.
 */
public class MNT {
    private ArrayList <MNTUnitario> mnt;
    private int cmnt;

    /**
     * Constructor que inicializa el arreglo de la tabla MNT y el contador iniciado 
     * en cero.
     */
    public MNT(){
        cmnt= 0;
        mnt = new ArrayList <>();
        
    }

    /**
     * Getter que obtiene la tabla MNT.
     * @return la tabla MDT.
     */
    public ArrayList<MNTUnitario> getMNT() {
        return mnt;
    }

    /**
     * Setter que establece la tabla MNT a la variable "mnt".
     * this.mnt = mnt
     * @param mnt 
     */
    public void setMNT(ArrayList<MNTUnitario> mnt) {
        this.mnt = mnt;
    }

    /**
     * Getter que obtiene el contador de la tabla MNT.
     * @return 
     */
    public int getCmnt() {
        return cmnt;
    }

    /**
     * Setter que establece el contador de "cmdt" 
     * @param cmnt contador 
     */
    public void setCmnt(int cmnt) {
        this.cmnt = cmnt;
    }
    
    public void insert(String etiqueta, MDTUnitario nuevo, ALAUnitario ala){
        mnt.add(new MNTUnitario(etiqueta, cmnt, nuevo, ala));
        cmnt++;
    }
    
    /**
     * Método que se encarga de escribir la salida de las tabla.
     */
    public void impimir(){
        System.out.println("CMNT\t| NOMBRE\t AMDT \t AALA");
        System.out.println("-------------------------------------------");
        for(MNTUnitario a:mnt){
            System.out.print(a.getCmnt()+"\t| ");
            System.out.print(a.toString()+"\t| ");
            System.out.print(a.getAmdt().getCmdt()+"\t|");
            try{
                System.out.println(a.getAala().getCala());
            }
            catch(Exception e){
                System.out.println("null");
            }
        }
    }
    
    /**
     * Getter que obtiene la linea siguiente, con respecto a la linea que se 
     * recibe como parámetro.
     * @param aux linea que se tomará como referencia.
     * @return la cadena siguiente de "aux".
     */
    public MNTUnitario getNext(MNTUnitario aux){
        try{
            return mnt.get(aux.getCmnt()+1);
        }
        catch(Exception e){
            return null;
        }
    }
    
    /**
     * Getter que obtiene la linea siguiente, respecto a la linea de que se 
     * recibe como parámeetro.
     * @param aux linea de referencia.
     * @return siguiente tabla
     */
    public ALAUnitario getNextAla(MNTUnitario aux){
        int posicion= mnt.indexOf(aux)+1;
        try{
            return mnt.get(posicion).getAala();
        }catch(IndexOutOfBoundsException e){
            return null;
        }
    }
}
