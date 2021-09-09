
package proyectoiinterfaz;

import java.io.FileNotFoundException;
import java.util.regex.Pattern;

/**
 *
 * Clase encargada de leer el archivo y de controlar las tablas MDT,MNT,ALA; 
 * se realiza la busqueda de las Macros, y el llenado de las tablas.
 * @author Alberto, Luis, Noelia, Victor
 */
public class Control {
    private String path;
    private EscribirArchivo hoja;
    private LeerArchivo archivo;
    private Tablas tablas;
    public boolean hayMacros = false;

    /**
     * Constructor que recibe una ruta.
     * @param path ruta absoluta del archivo.
     */
    public Control(String path) {
        this.path= path;
        tablas = null;
    }
    
    /**
     * Método que se encargará de iniciar el proceso de encontrar macros.
     * 
     * @return Proceso hecho correctamente
     */
    public boolean metodoPrincipal(){
        Condicional.getInstance();
        try{
            archivo= new LeerArchivo(path);
        }catch(FileNotFoundException e){
        }
        if(!archivo.existe()){
            System.exit(0);
            //ERROR
        }
        try{
            hoja= new EscribirArchivo(Path.addPath("f"+Path.nombre+".asm"));
        }catch(FileNotFoundException e){
            System.exit(0);
        }
        while(archivo.hayLineas()){
            
            String etiqueta, args[];
            archivo.leeLinea();
            if(!Condicional.defineVariable(archivo.getLinea()))
                return false;
            if(esMacro(archivo.getLinea())){
                hayMacros = true;
                if(tablas==null)
                    tablas= new Tablas();
                MDTUnitario aux;
                etiqueta= getEtiqueta(archivo.getLinea());
                if(etiqueta==null){
                    Expansor.error= 4;
                    Expansor.errorCuerpo= archivo.getLinea();
                    return false;
                }
                archivo.setLinea(eliminaEtiqueta(archivo.getLinea()));
                
                args= getArgumentos(archivo.getLinea());
                tablas.mdt.insertInicio();
                while(archivo.hayLineas() && !esFinMacro(archivo.getLinea())){
                    aux= new MDTUnitario(archivo.getLinea());
                    tablas.mdt.insert(aux);
                    if(Condicional.esCondicional(archivo.getLinea())){
                        Condicional.agregarIF(archivo.getLinea());
                    }
                    if(Condicional.esEndIF(archivo.getLinea())){
                        String error= Condicional.quitarIF(archivo.getLinea());
                        if(error==null){
                            Expansor.error= 5;
                            Expansor.errorCuerpo= "ERROR en equilibrio de IF - ENDIF: Hay un ENDIF de más"+etiqueta;
                            return false;
                        }
                    }
                    archivo.leeLinea();
                }
                tablas.ala.insert(args);
                tablas.mnt.insert(etiqueta, tablas.mdt.getUltimaMacro(), tablas.ala.getPrimerArg());
                if(!Condicional.pila.empty()){
                    Expansor.error= 7;
                    Expansor.errorCuerpo= "ERROR en equilibrio de IF - ENDIF: Falta un ENDIF en "+etiqueta;
                    return false;
                }
            }
            else{
                hoja.escribe(archivo.getLinea());
            }
        }
        archivo.cerrar();
        hoja.cerrar();
        return true;
    }
    
    /** 
     * Validación con expresión regular para encontrar el inicio de la MACRO.
     * 
     * @param linea Linea de texto a analizar.
     * @return Se regresa un "true" si la linea contiene la palabra "MACRO".
     */
    private boolean esMacro(String linea){
        Pattern p= Pattern.compile("MACRO");
        return p.matcher(linea).find();
    }
    
    /**
     * Validación con expresión regular para encontrar el fin de una MACRO.
     * 
     * @param linea Linea de texto a analizar.
     * @return Se regresa un boolean en true si la linea contiene la palabra 
     * "MEND", asegurando el fin de una macro.
     */
    private boolean esFinMacro(String linea){
        Pattern p= Pattern.compile("MEND");
        return p.matcher(linea).find();   
    }
    
    /**
     * Método encargado de eliminar la etiqueta que antecede a la MACRO.
     * 
     * @param linea Linea de texto a analizar. 
     * @return Se regresa la linea de texto, pero sin la etiqueta.
     */
    private String eliminaEtiqueta(String etiqueta){
        String aux[]= etiqueta.split(":[ ]*");
        try{
            return aux[1];
        }catch(Exception e){
                return null;
        }
    }
    /**
     * Getter que obtiene laa etiqueta de la macro.
     * @param linea linea a analizar.
     * @return regresa el nombre de la etiqueta.
     */
    private String getEtiqueta(String linea){
        String aux[]= linea.split(":[ ]*");
        if(aux.length!=1)
            return aux[0];
        return null;
    }
    
    /**
     * Getter que obtiene un arreglo de strings.
     * @param linea linea a analizar.
     * @return arreglo de argumetnos.
     */
    private String [] getArgumentos(String linea){
        String args[];
        try{
            args= linea.replace("&","").split("MACRO[ ]*")[1].split(",[ ]*");
        }catch(ArrayIndexOutOfBoundsException e){
            return null;
        }
        return args;
    }
    
    /**
     * Getter que obtiene las tablas creadas.
     * @return tablas 
     */
    public Tablas getTablas(){
        return tablas;
    }
    
    /**
     * Getter que obtiene la ruta absoluta.
     * @return ruta absoluta.
     */
    public String getFarchivo(){
        return hoja.file.getAbsolutePath();
    }
    
    
}
