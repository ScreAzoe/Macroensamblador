/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoiinterfaz;


import java.io.PrintWriter;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * Clase que se encargará de validar las macros condicionnales
 * @author Alberto, Luis, Noelia, Victor
 */
public class Condicional {
    public static HashMap <String, Boolean> variables=null;
    public static Stack <String>  pila= null;
    
    public Condicional(){
        pila= new Stack<>();
        variables= new HashMap<>();
        
    }
    
    public static boolean defineVariable(String linea){
        Pattern p= Pattern.compile("DL");
        
        if(p.matcher(linea).find()){
           String nombre= getNombre(linea);
           p= Pattern.compile("DL[ ]+TRUE");
           if(p.matcher(linea).find()){
               variables.put(nombre, true);
           }else{
               p= Pattern.compile("DL[ ]+FALSE");
               if(p.matcher(linea).find()){
                   variables.put(nombre, false);
               }
               else{
                   Expansor.error= 6;
                   Expansor.errorCuerpo="ERROR con directiva DL";
                   return false;
               }
           }
        }

        return true;
    }
    
    public static String getNombre(String linea){
        String []aux= linea.split("[ ]*:");
        return aux[0].replaceAll(" ","");
    }
    
    public static void setVariable(String variable, String valor){
        if(valor.equals("FALSE"))
            variables.put(variable, false);
        else
            variables.put(variable, true);
    }
    
    public static boolean existeCondicional(){
        return  variables!=null;
    }
    
    public static void getInstance(){
        variables= new HashMap<>();
        pila= new Stack<>();
    }
    
    public static void agregarIF(String linea){

        pila.push(linea);
    }
    
    public static String quitarIF(String linea){
        try{
            return pila.pop();
        }catch(EmptyStackException e){
            return null;
        }
    }
    
    public static MDTUnitario analizaCondicional(MDTUnitario aux, PrintWriter pluma){
        if(!Condicional.defineVariable(aux.getCuerpo())){
            
        }
        boolean flag= !condicionalFalsa(aux.getCuerpo());
        String variable= getVariable(aux.getCuerpo());
        boolean valorVariable= variables.get(variable);
        if(valorVariable==flag){
            aux= Expansor.tablas.mdt.getNext(aux.getCmdt());
            while(!esEndIF(aux.getCuerpo())){
                if(!Condicional.defineVariable(aux.getCuerpo())){
                }
                pluma.println(aux.getCuerpo());
                aux=Expansor.tablas.mdt.getNext(aux.getCmdt());
            }
        }
        while(!esEndIF(aux.getCuerpo())){
            aux= Expansor.tablas.mdt.getNext(aux.getCmdt());
        }
        return aux;
    }
    
    
    public static boolean esCondicional(String linea){
        if(linea.contains("IF"))
            return !linea.contains("END");
        return false;
    }
    
    public static boolean condicionalFalsa(String linea){
        return linea.contains("IF NOT");
    }
    
    public static boolean esEndIF(String linea){
        return linea.contains("END IF");
    }
    
    public static String getVariable(String linea){
        
        Pattern p= Pattern.compile("[ ]*(IF )(NOT )?[ ]*");
        Matcher encaja= p.matcher(linea);
        String aux= encaja.replaceAll("");
        return aux;

    }
}
