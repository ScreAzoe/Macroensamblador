/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoiinterfaz;

/**
 *
 * Clase que representa a las lineas de la tabla MNT. 
 * Con elllo se realiza la abstracción de cada línea.
 * @author casti
 */
public class MNTUnitario {
    private String nombre;
    private int cmnt;
    private MDTUnitario amdt;
    private ALAUnitario aala;
    
    /**
     * Constructor que inicialice las propiedades de la linea MNTUnitario.
     * 
     */
    public MNTUnitario(String nombre, int cmnt, MDTUnitario amdt, ALAUnitario aala){
        this.amdt= amdt;
        this.cmnt= cmnt;
        this.nombre= nombre;
        this.aala= aala;
    }

    /**
     * Getter que regresa el nombre.
     * @return nombre 
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter que establece el nombre.
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Getter que regresa el contador "cmnt".
     * @return contador cmnt
     */
    public int getCmnt() {
        return cmnt;
    }

    /**
     * Setter que da un valor al contador cmnt.
     * @param cmnt 
     */
    public void setCmnt(int cmnt) {
        this.cmnt = cmnt;
    }

    /**
     * Getter que obtienen el amdt.
     * @return 
     */
    public MDTUnitario getAmdt() {
        try{
            return amdt;
        }
        catch(Exception e){
            return null;
        }
    }

    /**
     * Setter que da un valor a la variable Amdt.
     * @param amdt 
     */
    public void setAmdt(MDTUnitario amdt) {
        this.amdt = amdt;
    }

    /**
     * Getter que obtiene la linea aala.
     * @return 
     */
    public ALAUnitario getAala() {
        return aala;
    }

    /**
     * Setter que establece el valor de aala, con ayuda del parámetro aala.
     * @param aala 
     */
    public void setAala(ALAUnitario aala) {
        this.aala = aala;
    }
    
    /**
     * Método que regresa la cadena de nombre.
     * @return 
     */
    public String toString(){
        return nombre;
    }
}
