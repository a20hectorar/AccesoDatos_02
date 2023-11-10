/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.parser.Apartado_1;

import java.io.File;
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
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Clase para parser
 * @author Hector
 */
public class Parser {

    public static void main(String[] args) {
        
        try {
            //Documento
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document documento = db.newDocument();
            
            //Elemento raíz
            Element elementoRaiz = documento.createElement("Empleados");
            documento.appendChild(elementoRaiz);
            
            //Empleado 1
            Element elementoEmpleado1 = documento.createElement("Empleado");
            elementoRaiz.appendChild(elementoEmpleado1);
            
            Attr atributoCodigo = documento.createAttribute("Codigo");
            atributoCodigo.setValue("1");
            elementoEmpleado1.setAttributeNode(atributoCodigo);
            
            Element elementoNombre = documento.createElement("Nombre");
            elementoNombre.appendChild(documento.createTextNode("Alberto"));
            elementoEmpleado1.appendChild(elementoNombre);
            
            Element elementoDireccion = documento.createElement("Direccion");
            elementoDireccion.appendChild(documento.createTextNode("C/Allariz, 11"));
            elementoEmpleado1.appendChild(elementoDireccion);
            
            Element elementoSalario = documento.createElement("Salario");
            elementoSalario.appendChild(documento.createTextNode("1000"));
            elementoEmpleado1.appendChild(elementoSalario);
            
            Element elementoComision = documento.createElement("Comision");
            elementoComision.appendChild(documento.createTextNode("100"));
            elementoEmpleado1.appendChild(elementoComision);

            //Empleado 2
            Element elementoEmpleado2 = documento.createElement("Empleado");
            elementoRaiz.appendChild(elementoEmpleado2);
            
            Attr atributoCodigo2 = documento.createAttribute("Codigo");
            atributoCodigo2.setValue("2");
            elementoEmpleado2.setAttributeNode(atributoCodigo2);
            
            Element elementoNombre2 = documento.createElement("Nombre");
            elementoNombre2.appendChild(documento.createTextNode("Beatriz"));
            elementoEmpleado2.appendChild(elementoNombre2);
            
            Element elementoDireccion2 = documento.createElement("Direccion");
            elementoDireccion2.appendChild(documento.createTextNode("C/Bonaval, 22"));
            elementoEmpleado2.appendChild(elementoDireccion2);
            
            Element elementoSalario2 = documento.createElement("Salario");
            elementoSalario2.appendChild(documento.createTextNode("2000"));
            elementoEmpleado2.appendChild(elementoSalario2);
            
            Element elementoComision2 = documento.createElement("Comision");
            elementoComision2.appendChild(documento.createTextNode("200"));
            elementoEmpleado2.appendChild(elementoComision2);
            
            //Empleado 3
            Element elementoEmpleado3 = documento.createElement("Empleado");
            elementoRaiz.appendChild(elementoEmpleado3);
            
            Attr atributoCodigo3 = documento.createAttribute("Codigo");
            atributoCodigo3.setValue("3");
            elementoEmpleado3.setAttributeNode(atributoCodigo3);
            
            Element elementoNombre3 = documento.createElement("Nombre");
            elementoNombre3.appendChild(documento.createTextNode("Carlos"));
            elementoEmpleado3.appendChild(elementoNombre3);
            
            Element elementoDireccion3 = documento.createElement("Direccion");
            elementoDireccion3.appendChild(documento.createTextNode("C/Corazones rotos, 33"));
            elementoEmpleado3.appendChild(elementoDireccion3);
            
            Element elementoSalario3 = documento.createElement("Salario");
            elementoSalario3.appendChild(documento.createTextNode("3000"));
            elementoEmpleado3.appendChild(elementoSalario3);
            
            Element elementoComision3 = documento.createElement("Comision");
            elementoComision3.appendChild(documento.createTextNode("300"));
            elementoEmpleado3.appendChild(elementoComision3);
            
            //Empleado 4
            Element elementoEmpleado4 = documento.createElement("Empleado");
            elementoRaiz.appendChild(elementoEmpleado4);
            
            Attr atributoCodigo4 = documento.createAttribute("Codigo");
            atributoCodigo4.setValue("4");
            elementoEmpleado4.setAttributeNode(atributoCodigo4);
            
            Element elementoNombre4 = documento.createElement("Nombre");
            elementoNombre4.appendChild(documento.createTextNode("Desiderio"));
            elementoEmpleado4.appendChild(elementoNombre4);
            
            Element elementoDireccion4 = documento.createElement("Direccion");
            elementoDireccion4.appendChild(documento.createTextNode("C/Del horreo, 44"));
            elementoEmpleado4.appendChild(elementoDireccion4);
            
            Element elementoSalario4 = documento.createElement("Salario");
            elementoSalario4.appendChild(documento.createTextNode("4000"));
            elementoEmpleado4.appendChild(elementoSalario4);
            
            Element elementoComision4 = documento.createElement("Comision");
            elementoComision4.appendChild(documento.createTextNode("400"));
            elementoEmpleado4.appendChild(elementoComision4);
            
            //Empleado 5
            Element elementoEmpleado5 = documento.createElement("Empleado");
            elementoRaiz.appendChild(elementoEmpleado5);
            
            Attr atributoCodigo5 = documento.createAttribute("Codigo");
            atributoCodigo5.setValue("5");
            elementoEmpleado5.setAttributeNode(atributoCodigo5);
            
            Element elementoNombre5 = documento.createElement("Nombre");
            elementoNombre5.appendChild(documento.createTextNode("Estefania"));
            elementoEmpleado5.appendChild(elementoNombre5);
            
            Element elementoDireccion5 = documento.createElement("Direccion");
            elementoDireccion5.appendChild(documento.createTextNode("C/Eramos pocos, 55"));
            elementoEmpleado5.appendChild(elementoDireccion5);
            
            Element elementoSalario5 = documento.createElement("Salario");
            elementoSalario5.appendChild(documento.createTextNode("5000"));
            elementoEmpleado5.appendChild(elementoSalario5);
            
            Element elementoComision5 = documento.createElement("Comision");
            elementoComision5.appendChild(documento.createTextNode("500"));
            elementoEmpleado5.appendChild(elementoComision5);
            
            
            
            //Transformer
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();
            DOMSource source = new DOMSource(documento);
            StreamResult sr = new StreamResult(new File("EMPLEADOS2.xml"));
            
            t.transform(source, sr);
            
            //Excepciones
        } catch (ParserConfigurationException | TransformerException ex) {
            Logger.getLogger(Parser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}