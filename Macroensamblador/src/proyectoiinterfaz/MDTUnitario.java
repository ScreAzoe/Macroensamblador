/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoiinterfaz;

/**
 *
 * Clase que representa a las lineas de la tabla MDT. 
 * Con elllo se realiza la abstracción de cada línea.
 * @author casti
 */
public class MDTUnitario {
    private String cuerpo;
    private int cmdt;
    
    /**
     * Constructor de la clase, donde se inicializa el cuerpo de la linea.
     * @param cuerpo cuerpo de la linea.
     */
    public MDTUnitario(String cuerpo){
        this.cuerpo= cuerpo;
    }

    /**
     * constructor de la clase con parámetros para establecer el contador y 
     * cuerpo de la linea.
     * @param cuerpo cuerpo de la la tabla MDT.
     * @param cmdt contador de las lineas (contador de lineas del MDT)
     */
    public MDTUnitario(String cuerpo, int cmdt) {
        this.cuerpo = cuerpo;
        this.cmdt = cmdt;
    }
    
    /**
     * Getter que obtiene el cupero de la tabla MDT.
     * @return El cuerpo de la tabla.
     */
    public String getCuerpo() {
        return cuerpo;
    }

    /**
     * Método encargado de estableces el cuerpo de la tabla MDT.
     * @param cuerpo 
     */
    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    /**
     * Getter encargado de obtener el contador de la tabla MDT.
     * @return 
     */
    public int getCmdt() {
        return cmdt;
    }

    /**
     * Estable el contador de la linea en un lugar específico.
     * @param cmdt varible que representa el contador de las linea MDT.
     */
    public void setCmdt(int cmdt) {
        this.cmdt = cmdt;
    }
    

    /**
     * Método sobre-escrito que regresa el string de la tabla MDTUnitario.
     * @return 
     */
    @Override
    public String toString(){
        return cuerpo;
    }
    
    
}
