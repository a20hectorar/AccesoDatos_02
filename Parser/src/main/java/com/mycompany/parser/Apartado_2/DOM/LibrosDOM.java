/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parser.Apartado_2.DOM;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Clase principal para el DOM
 * @author Hector
 */
public class LibrosDOM {
       public static void main(String[] args){
    
    Document doc = null;
           try {
               //instancia del documento
               doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("src\\main\\java\\com\\mycompany\\parser\\Apartado_2\\DOM\\libros.xml");
               
               //normalizar
               doc.getDocumentElement().normalize();
               Node nodoRaiz = doc.getFirstChild();
               
               //mostrar elemento raiz
               System.out.println("\nEtiqueta raíz: " + nodoRaiz.getNodeName());
               System.out.println("-----------------------------------------------");
               
               //queremos saber cuantas etiquetas "libro" hay para sacarlas todas
               NodeList listaNodosLibro = doc.getElementsByTagName("libro");
               int longitudLibros = listaNodosLibro.getLength();
               System.out.println("\nNúmero de libros: " + longitudLibros);
               System.out.println("-----------------------------------------------");
               
               //recorremos listaNodos
               for(int i = 0; i < longitudLibros; i++){
                   int indice = i + 1;
                   Node nodo = listaNodosLibro.item(i);
                   System.out.print("\n" + nodo.getNodeName() + " " + indice + ". ");
                   //comprobamos que el nodo sea de tipo element
                   if(nodo.getNodeType() == Node.ELEMENT_NODE){
                       
                       Element elemento = (Element) nodo;
                       //Mostramos la información del atributo año y las etiquetas hijas
                       System.out.print("Año: " + elemento.getAttribute("año") + ".\n");
                       System.out.println("-----------------------------------------------");
                       System.out.println(elemento.getElementsByTagName("titulo").item(0).getNodeName() + ": " + elemento.getElementsByTagName("titulo").item(0).getTextContent());
                       System.out.println("-----------------------------------------------");
                       //Como puede haber varios autores, haremos una lista que recorreremos y mostraremos todos los autores si los hay
                       NodeList hermanosAutor = elemento.getElementsByTagName("autor");
                       for(int j=0; j<hermanosAutor.getLength();j++){
                           
                           Node nodoAutor = hermanosAutor.item(j);
                           
                           System.out.println(nodoAutor.getNodeName());
                           
                           if(nodoAutor.getNodeType() == Node.ELEMENT_NODE){
                               
                               Element elementoAutor = (Element) nodoAutor;
                               //Mostramos nombre de etiqueta y contenido
                               System.out.println("\t" + elementoAutor.getElementsByTagName("apellido").item(0).getNodeName() + ": " + elementoAutor.getElementsByTagName("apellido").item(0).getTextContent());
                               System.out.println("\t" + elementoAutor.getElementsByTagName("nombre").item(0).getNodeName() + ": " + elementoAutor.getElementsByTagName("nombre").item(0).getTextContent() + "\n");
                               
                           }
                           System.out.println("-----------------------------------------------");
                       }
                       
                       System.out.print(elemento.getElementsByTagName("editorial").item(0).getNodeName() + ": " + elemento.getElementsByTagName("editorial").item(0).getTextContent()+ "\n");
                       System.out.println("-----------------------------------------------");
                       System.out.println(elemento.getElementsByTagName("precio").item(0).getNodeName()+ ": " + elemento.getElementsByTagName("precio").item(0).getTextContent());
                       System.out.println("-----------------------------------------------");
                       System.out.println("-----------------------------------------------");

                   }

               }
           //Excepciones
           } catch (ParserConfigurationException | SAXException | IOException ex) {
               Logger.getLogger(LibrosDOM.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
}
