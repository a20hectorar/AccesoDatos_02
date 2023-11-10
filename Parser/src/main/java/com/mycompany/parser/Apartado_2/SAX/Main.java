/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parser.Apartado_2.SAX;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author Hector
 */
public class Main {
    public static void main(String[] args){
        
        try {
            
            File archivo = new File("src\\main\\java\\com\\mycompany\\parser\\Apartado_2\\DOM\\libros.xml");
            SAXParser sax = SAXParserFactory.newInstance().newSAXParser();
            LibrosSAX analizador = new LibrosSAX();
            sax.parse(archivo, analizador);
            
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
