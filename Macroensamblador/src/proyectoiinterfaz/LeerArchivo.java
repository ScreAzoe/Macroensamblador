/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoiinterfaz;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Clase que se encarga específicamente en leer los archivos, que fueron seleccionados por el usario.
 * @author casti
 */
public class LeerArchivo {
    private Scanner archivo;
    private String nombre;
    private String linea;
    private File file;

    /**
     * Constructor que a través de una ruta, genera un archivo con el nombre del 
     * PATH.
     * @param nombre nombre del archivo a leer.
     * @throws FileNotFoundException 
     */
    public LeerArchivo(String nombre) throws FileNotFoundException{
        this.nombre= nombre;
        file= new File(nombre);
        setScanner();
    }
   
    /**
     * validación para ver si el archivo exite.
     * @return 
     */
    public boolean existe(){
        return file.exists();
    }
    
    /**
     * Método que se encargan leerlineas
     */
    public void leeLinea(){
        linea= formatoLinea(archivo.nextLine());
    }
    
    /**
     * Getter que obtiene la linea de donde se encuantra.
     * @return 
     */
    public String getLinea(){
        return linea;
    }
    
    /**
     * Método encargado de validar si el archivo tiene otra linea en la siguiente. 
     * @return bandera para validar si hay más lineas.
     */
    public boolean hayLineas(){
        return archivo.hasNextLine();
    }
    
    private boolean buscar(){
        file= new File(nombre);
        return file.exists();
    }
    
    /**
     * Getter que ayuda a crear el scanner que se encargará de leer el archivo.
     * @throws FileNotFoundException 
     */
    private void setScanner() throws FileNotFoundException{
        archivo= new Scanner(new File(nombre));
    }
    
    public void cerrar(){
        archivo.close();
 
    }
    
    public void setLinea(String linea){
        this.linea= linea;
    }
    
    /**
     * Método que reemplaza los "#" por "&", para dar formato a la escritura.
     * @param linea
     * @return 
     */
    private String formatoLinea(String linea){
        return linea.replaceAll("#", "&");
    }
}
