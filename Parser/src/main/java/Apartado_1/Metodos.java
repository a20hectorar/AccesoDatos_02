/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Apartado_1;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hector
 */
public class Metodos {
    
    private static long ultimaPosicion = 0;
    
    public static long getUltimaPosicion(){
        return ultimaPosicion;
    }
    
    public static void setUltimaPosicion(int desplazamiento){
        ultimaPosicion = ultimaPosicion + desplazamiento;
    }
    
    public static void escribirStr(RandomAccessFile dat, String str, int longitudCadena){
        
        try {
            
            long lonDat = dat.length();
            dat.seek(lonDat);
            StringBuilder sb = new StringBuilder(str);
            sb.setLength(longitudCadena);
            dat.writeChars(sb.toString());
            
        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static String leerStr(RandomAccessFile dat, String dato){
       
        try {
            dat.seek(ultimaPosicion);
        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int longitud = 0;
        if(dato.equals("nombre")){
            longitud = 20;
            setUltimaPosicion(40);
        }
        else if(dato.equals("direccion")){
            longitud = 30;
            setUltimaPosicion(60);
        }
        
        char[] cadena = new char[longitud];
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<longitud;i++){
            try {
                cadena[i] = dat.readChar();
                sb.append(cadena[i]);
                
            } catch (IOException ex) {
                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        String subcadena = sb.toString();
        return subcadena.trim();
    }
    
    public static String datoAStr(RandomAccessFile dat, String datoRequerido){
        
        try {
            dat.seek(ultimaPosicion);
        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String resultado = null;
        if(datoRequerido.equals("codigo")){
            
            try {
                
                int dato = dat.readInt();
                resultado = String.valueOf(dato);
                setUltimaPosicion(4);
                
            } catch (IOException ex) {
                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else if(datoRequerido.equals("salario") | datoRequerido.equals("comision")){
            
            try {
                
                Double dato = dat.readDouble();
                resultado = String.valueOf(dato);
                setUltimaPosicion(8);
                
            } catch (IOException ex) {
                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return resultado;
    }

}
