/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Apartado_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Hector
 */
public class ParserDOM {
    
    public static void main(String[] args){

            
            //Creamos un RandomAccessFile para acceder a los datos de empleados.dat
        try {
            File ficheroOrigen = new File("Empleados.dat");
            
            RandomAccessFile raf = new RandomAccessFile(ficheroOrigen, "rw");
            
        
            
            
            
            
            //Creamos la estructura del xml
            
            try {
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                Document documento = db.newDocument();
                
                Element elementoRaiz = documento.createElement("Empleados");
                documento.appendChild(elementoRaiz);
                
            while(raf.getFilePointer()<raf.length()){
                Element elementoEmpleado = documento.createElement("Empleado");
                elementoRaiz.appendChild(elementoEmpleado);
                
                               
                Element elementoCodigo = documento.createElement("Codigo");
                elementoEmpleado.appendChild(elementoCodigo);
                String code = Metodos.datoAStr(raf, "codigo");
                elementoCodigo.appendChild(documento.createTextNode(code));
                
                
                Element elementoNombre = documento.createElement("Nombre");
                String nombre = Metodos.leerStr(raf, "nombre");
                elementoNombre.appendChild(documento.createTextNode(nombre));
                elementoEmpleado.appendChild(elementoNombre);

                String direccion = Metodos.leerStr(raf, "direccion");
                Element elementoDireccion = documento.createElement("Direccion");
                elementoDireccion.appendChild(documento.createTextNode(direccion));
                elementoEmpleado.appendChild(elementoDireccion);
                
                String salario = Metodos.datoAStr(raf, "salario");
                Element elementoSalario = documento.createElement("Salario");
                elementoSalario.appendChild(documento.createTextNode(salario));
                elementoEmpleado.appendChild(elementoSalario);
                
                String comision = Metodos.datoAStr(raf, "comision");
                Element elementoComision = documento.createElement("Comision");
                elementoComision.appendChild(documento.createTextNode(comision));
                elementoEmpleado.appendChild(elementoComision);
                
                System.out.println(code);
                System.out.println(nombre);
                System.out.println(direccion);
                System.out.println(salario);
                System.out.println(comision);
            }
                
    TransformerFactory tf = TransformerFactory.newInstance();
    Transformer t = tf.newTransformer();
    DOMSource origen = new DOMSource(documento);
    StreamResult destino = new StreamResult("Empleados.xml");
    
    t.transform(origen, destino);
                
                
            } catch (ParserConfigurationException | IOException | TransformerException ex) {
                Logger.getLogger(ParserDOM.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
    } catch (FileNotFoundException ex) {
            Logger.getLogger(ParserDOM.class.getName()).log(Level.SEVERE, null, ex);
        }           

        
        
        
    }
}
