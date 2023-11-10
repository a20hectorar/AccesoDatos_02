/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Apartado_1.CrearDAT;

import static Apartado_1.Metodos.escribirStr;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hector
 */
public class EscribirDAT {
    
    public static void main(String[] args){
        
    añadirDat(1, "Alberto", "C/Allariz, 11", 1000.00, 100.00);
    añadirDat(2, "Beatriz", "C/Bonaval,22", 2000.00, 200.00);
    añadirDat(3, "Carlos", "C/Corazones rotos, 33", 3000.00, 300.00);
    añadirDat(4, "Desiderio", "C/Del horreo, 44", 4000.00, 400.00);
    añadirDat(5, "Estefania", "C/Eramos pocos, 55", 5000.00, 500.00);
    
    }
    
    
    
    
    public static void añadirDat(int codigo, String nombre, String direccion, double salario, double comision){
    //Creamos el objeto file con el fichero a crear
    File dat = new File("Empleados.dat");
    
        //Si el dat no existe lo creamos
        if(!dat.exists()){
            try {
                dat.createNewFile();
            } catch (IOException ex) {
                System.out.println("No se ha podido crear el fichero.");
                Logger.getLogger(EscribirDAT.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        
        try {
            //Creamos un acceso aleatorio lectura/escritura al fichero dat
            RandomAccessFile accesoDat = new RandomAccessFile(dat, "rw");
            
            //Guardamos el punto donde acaba el fichero
            long tamañoFichero = dat.length();
            
            //nos posicionamos al final del fichero
            accesoDat.seek(tamañoFichero);
            
            accesoDat.writeInt(codigo);
            escribirStr(accesoDat, nombre, 20);
            escribirStr(accesoDat, direccion, 30);
            accesoDat.writeDouble(salario);
            accesoDat.writeDouble(comision);
            accesoDat.seek(0);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EscribirDAT.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EscribirDAT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
