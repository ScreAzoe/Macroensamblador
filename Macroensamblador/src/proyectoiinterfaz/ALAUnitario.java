/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoiinterfaz;

/**
 * Clase que representa a la linea de la tabla ALA.
 * @author casti
 */
public class ALAUnitario {
    private int cala;
    private String argForm;
    private String argAct;

    /**
     * Contructor que inicaliza el contador de ala (cala), los argumentos 
     * formales y actuals.
     * @param cala contador de la linea que está dentro de ALA.
     * @param argForm arguemento formal.
     * @param argAct argumento actual.
     */
    public ALAUnitario(int cala, String argForm, String argAct) {
        this.cala = cala;
        this.argForm = argForm;
        this.argAct = argAct;
    }
    
    /**
     * Contructor pero con menos parámetros.
     * @param cala indice cala.
     * @param argForm argumento formal.
     */
    public ALAUnitario(int cala, String argForm) {
        this.cala = cala;
        this.argForm = argForm;
        this.argAct = null;
    }
    
    /**
     * Getter que obtiene el contador de la tabla ALA.
     * @return cala indice de la tabla ALA.
     */
    public int getCala() {
        return cala;
    }

    /**
     * Setter que asigna el valor a "cala"
     * @param cala  valor del cala.
     */
    public void setCala(int cala) {
        this.cala = cala;
    }

    /**
     * Getter que regresa el argumeto formal.
     * @return argumento formal.
     */
    public String getArgForm() {
        return argForm;
    }

    /**
     * Setter que establece el valor formal al argumento formal.
     * @param argForm  argumento formal.
     */
    public void setArgForm(String argForm) {
        this.argForm = argForm;
    }

    /**
     * Getter que regresa un argumento actual.
     * @return argumento actual.
     */
    public String getArgAct() {
        return argAct;
    }
    /**
     * Setter que estabkece el valor del argumento actual.
     * @param argAct  argumento actual.
     */
    public void setArgAct(String argAct) {
        this.argAct = argAct;
    }
    
    
}
