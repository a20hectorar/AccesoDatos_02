/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parser.Apartado_2.SAX;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Clase que contiene el manejo de eventos
 * @author Hector
 */
public class LibrosSAX extends DefaultHandler {
    
    private final StringBuilder valor;
    
    public LibrosSAX(){
        this.valor = new StringBuilder();
    }
    
    /**
     *
     * @param uri
     * @param localname
     * @param qName nombre de la etiqueta
     * @param attributes atributos que puede tener la etiqueta
     */
    @Override
    public void startElement(String uri, String localname,String qName, Attributes attributes){
        valor.setLength(0);
        if(qName.equals("libro")){
            String anho = attributes.getValue("año");
            System.out.println("Año: " + anho);
        }
    }
    
    /**
     *
     * @param c caracteres del texto
     * @param start donde empieza en el array
     * @param length longitud de los datos
     */
    @Override
    public void characters(char c[], int start, int length){
        this.valor.append(c, start, length);
    }
    
    /**
     *
     * @param uri
     * @param localName
     * @param qName
     */
    @Override
    public void endElement(String uri, String localName, String qName){
        
        switch(qName){
            
            case "titulo" -> System.out.println("Título: " + valor.toString());
            case "apellido" -> System.out.println("Autor:\n\tApellidos: " + valor.toString());
            case "nombre" -> System.out.println("\tNombre: " + valor.toString());
            case "editorial" -> System.out.println("Editorial: " + valor.toString());
            case "precio" -> System.out.println("Precio: " + valor.toString());
            default -> System.out.println("");
        }
        
        
    }
    
    
}
