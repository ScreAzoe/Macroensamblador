/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoiinterfaz;

import java.io.File;

/**
 *
 * Clase en cargada de manejar las rutas del archivo que seleccionó el usuario
 * Con estanclase se pretende crear una carpeta y guardar los archivos creados.
 * @author 
 */
public class Path {
    public static String archivoEsamblar;
    public static String carpeta;
    public static String nombre;
    
    /**
     * Método encargado de establecer el nombre del archivo a ensamblar y el 
     * nombre del archivo sin extensión.
     * @param path ruta del archivo seleccionado
     */
    public static void setArchivoEsamblar(String path){
        archivoEsamblar= path;
        nombre=new File(path).getName().replace(".asm", "");
    }
   
    /**
     * Métofo encargado de crear la carpeta donde se alamacenarán los archivos 
     * que se crean a lo largo de la ejecución del programa.
     */
    public static void crearCarpeta(){
        File archivo= new File(archivoEsamblar);
        carpeta=  archivo.getParent()+System.getProperty("file.separator")+nombre;
        File folder= new File(carpeta);
        folder.mkdir();
    }
    
    /**
     * Método encargado de obtener el nombre completo de la carpeta.
     * @return el nombre completo de la carpeta.
     */
    public static String getCarpeta(){
        return carpeta;
    }
    
    /**
     * 
     * Método encargado de crear un "path" absoluto para un archivo en específico, 
     * que abarca la ruta de la carpeta.
     * @param archivo nombre del archivo que se concatenará con la ruta de la carpeta  
     * @return 
     */
    public static String addPath(String archivo){
        return carpeta+System.getProperty("file.separator")+archivo;
    }
    
    /**
     * Método que nos ayudará al cargar las imagenes del programa.
     * @return cadena con el nombre la ruta del proyecto en donde se guardan las imágenes.
     */
    public static String getEstaRuta(){
        return new File(System.getProperty("user.dir"))+System.getProperty("file.separator")+"icono"+System.getProperty("file.separator");
    }
}
