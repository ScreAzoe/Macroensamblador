/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoiinterfaz;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.regex.Pattern;

/**
 *
 * Clase que se encargará de la expansión (segunda pasada), del archivo a macroensamblar,
 * basado en el algoritmo para el manejo de macros.
 * @author Alberto, Luis, Noelia, Victor
 */
public class Expansor {
    
    public static int error;
    public static String errorCuerpo;
    
    
    File archivo;
    static Tablas tablas;
    LeerArchivo fuente;
    EscribirArchivo pluma, archivoT;
    MNTUnitario macrollamada;
    
    /**
     * En este constuctor se inicializa las tablas que fueron creadas en la 
     * primera pasada.
     * @param path ruta del archivo a macroensamblar.
     * @param tablas tablas creadas en la primera pasada (ALA,MDT,MNT).
     */
    public Expansor(String path, Tablas tablas){
        this.tablas= tablas;
        archivo= new File(path);
    }
    
    /**
     * Método principal que se encargará de todo el manejo de las macro llamadas,
     * creando el archivo de tablas y un archivo donde se muestra la expansión.
     * 
     * @return booleano que especifica si ocurrió un error al macro-ensamblar.
     */
    public boolean metodoPrincipal(){
        System.out.println("Expansor");
        try{
            setLector();
        }catch(FileNotFoundException e){
            
        }
        try{
            setPluma();
        }catch(FileNotFoundException e){
            
        }
        if(tablas==null){
            codigoSinMacros();
        }
        while(fuente.hayLineas()){
            fuente.leeLinea();
            if(esMacroLlamada()){
                String []args= getArgs(fuente.getLinea());
                if(!iterador(args)){
                    return false;
                }
                
                MDTUnitario lim;
                ALAUnitario auxALA= macrollamada.getAala();
                MDTUnitario auxMDT= macrollamada.getAmdt();
                auxMDT= tablas.mdt.getNext(auxMDT.getCmdt());        
                try{
                    lim= tablas.mnt.getNext(macrollamada).getAmdt();
                }catch(Exception e){
                    lim=null;
                }
                String linea;
                while(paro(auxMDT, lim)){
                    linea=auxMDT.getCuerpo();
                    if(!Condicional.defineVariable(auxMDT.getCuerpo()))
                        return false;
                    try{
                        for(int i=0; i<args.length; i=i+1){
                            linea= linea.replaceAll("&"+auxALA.getArgForm(), auxALA.getArgAct());
                            auxALA= tablas.ala.getIndex(auxALA.getCala()+1);
                        }
                    }catch(Exception e){

                    }
                    if(linea.contains("&")){
                        Expansor.error= 3;
                        Expansor.errorCuerpo= " "+macrollamada.getNombre();
                        pluma.escribe("ERROR: Faltan argumentos por declarar en la macrodefincion "+macrollamada.getNombre()+"\n");
                        pluma.escribe(linea);
                        pluma.cerrar();
                        return false;
                    }
                    
                    if(Condicional.esCondicional(linea)){
                        auxMDT= Condicional.analizaCondicional(auxMDT, pluma.pluma);
                    }else
                        pluma.escribe(linea);
                    auxMDT= tablas.mdt.getNext(auxMDT.getCmdt());
                    auxALA=macrollamada.getAala();
                }
            }
            else
               pluma.escribe(fuente.getLinea());
        }
        fuente.cerrar();
        pluma.cerrar();
        if(tablas != null){
            try{
                archivoT= new EscribirArchivo(Path.addPath(Path.nombre+"Tablas.txt"));
                
                archivoT.escribirTablas(tablas);
                
                archivoT.cerrar();
                
            }catch(Exception e){
                

            }     
        }
        return true;
    }
    
    /**
     * Método encargado de validar si se llegó al límite de la expansión.
     * @param aux linea de la tabla MDT.
     * @param lim linea limite de la tabla MDT.
     * @return una variable booleana, depende del valor de "lim".
     */
    private boolean paro(MDTUnitario aux, MDTUnitario lim){
        if(lim==null){
            return aux!=null;
        }
        return !aux.equals(lim);
        
    }
    
    
    /**
     * Método para establecer el objeto que se encargará de leer los archivos.
     * @throws FileNotFoundException archivo no encrontrado
     */
    public void setLector() throws FileNotFoundException{
        fuente= new LeerArchivo(archivo.getAbsolutePath());
    }
    
    /**
     * Mñetodo encargado de crear el objeto que escribirá en los archivos creados.
     * @throws FileNotFoundException archivo no encrontrado
     */
    public void setPluma() throws FileNotFoundException{
        pluma= new EscribirArchivo(Path.addPath(Path.nombre+"OUT.asm"));
    }
    
    /**
     * Validación para ver si la linea de la tala MNT es una macro-llamada.
     * @return regresa un booleano, su valor depende si la linea analizada es una macro-llamada.
     */
    public boolean esMacroLlamada(){
        for(MNTUnitario aux:tablas.mnt.getMNT()){
            Pattern p= Pattern.compile(aux.getNombre());
            if(p.matcher(fuente.getLinea()).find()){
                macrollamada= aux;
                //System.out.println(macrollamada.getNombre());

                return true;
            }
        }
        return false;
    }
    
    /**
     * Obtiene un arreglo de strings con todos los argumentos de una linea con macro.
     * @param linea
     * @return 
     */
    public String[] getArgs(String linea){
        String aux[]= linea.split("[ ]*"+macrollamada.getNombre()+"[ ]*");
        String [] args;
        try{
            args= aux[1].split("[ ]*,[ ]*");
        }catch(Exception e){
            args=null;
        }
        return args;
    }
    
    /**
     * Método encargado de hacer la iteración entre los argumentos encontrados 
     * de las lineas que contenían macros.
     * 
     * @param args arreglo de argumentos a analizar.
     * @return se la macro llamada tiene los argumentos correctos.
     */
    public boolean iterador(String[] args){
        
        int index,i=0;
        ALAUnitario indice= macrollamada.getAala();
        try{
            index= indice.getCala();
        }catch(Exception e){
            if(args!=null){
                Expansor.error= 1;
                Expansor.errorCuerpo= fuente.getLinea();
                pluma.escribe("ERROR: Exceso de argumentos en macrollamada: ");
                pluma.escribe(">> "+errorCuerpo+" <<");
                pluma.cerrar();
            }
            else{
            }
            return args==null ;
        }
        ALAUnitario lim= tablas.mnt.getNextAla(macrollamada);
        if(lim!=null){
            while(!indice.equals(lim)){
                try{
                    indice.setArgAct(args[i]);
                }catch(Exception e){
                    Expansor.error= 2;
                    Expansor.errorCuerpo= fuente.getLinea();
                    pluma.escribe("ERROR: Falta de argumentos en macrollamada: ");
                    pluma.escribe(">> "+errorCuerpo+" <<");
                    pluma.cerrar();
                    return false;      
                }   
                i++;
                index++;
                indice= tablas.ala.getIndex(index);
            }
        }
        else{
            while(null!=indice){
                try{
                    indice.setArgAct(args[i]);
                }catch(Exception e){
                    Expansor.error= 2;
                    Expansor.errorCuerpo= fuente.getLinea();
                    pluma.escribe("ERROR: Falta de argumentos en macrollamada: ");
                    pluma.escribe(">> "+errorCuerpo+" <<");
                    pluma.cerrar();
                    return false;      
                }                    
                i++;
                index++;
                indice= tablas.ala.getIndex(index);
            }
        }
        if(i<args.length){
            Expansor.error= 1;
            Expansor.errorCuerpo= fuente.getLinea();
            pluma.escribe("ERROR: Exceso de argumentos en la macrollamada: ");
            pluma.escribe(">> "+errorCuerpo+" <<");
            pluma.cerrar();
            return false;
        }
        if(i>args.length){
            Expansor.error= 1;
            Expansor.errorCuerpo= fuente.getLinea();
            pluma.escribe("ERROR: Falta de argumentos en macrollamada: ");
            pluma.escribe(">> "+errorCuerpo+" <<");
            pluma.cerrar();
            return false;
        }
        return true;
    }
    
    /**
     * Método encargado de obtener la ruta del archivo de salida de la expansión. 
     * @return ruta del archivo en donde se expandión la macro.
     */
    public String getPathPluma(){
        return pluma.file.getAbsolutePath();
    }
    
    /**
     * Método encargado de validar si las tablas no s encuentran vacías.
     * @return booleano con la existencias de las tablas.
     */
    public static boolean existenTablas(){
        return tablas!=null;
    }

    /**
     * Validación para ver si el archivo seleccionado contiene macros.
     */
    private void codigoSinMacros() {
        while(fuente.hayLineas()){
            fuente.leeLinea();
            pluma.escribe(fuente.getLinea());
        }
    }
    
    /**
     * Método encargado de obtener la ruta absoluta en donde se creó el archivo 
     * con las tablas creadas.
     * @return ruta absoluta.
     */
    public String getArchivoTablas(){
        return archivoT.file.getAbsolutePath();
    }
    

}

