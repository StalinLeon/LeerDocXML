/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leerdocxml;

import java.io.File;
//import java.io.IOException;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author USUARIO
 */
public class preparacionXML {

    public String direccion;
    public Document document;

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Document preparacion(String s) throws ParserConfigurationException, SAXException {
        try {
            File file = new File(s);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            document = db.parse(file);
            document.getDocumentElement().normalize();
            return document;
        } catch (IOException ex) {
            Logger.getLogger(preparacionXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void presentacion(Document d) {
        String nodoPrincipal;
        nodoPrincipal = d.getDocumentElement().getNodeName();
        System.out.println("Elemento Raiz: " + nodoPrincipal);
        NodeList programas = d.getElementsByTagName("programa");
        System.out.println("Contenido del Documento");
        System.out.println("");
        for (int i = 0; i < programas.getLength(); i++) {
            Node programa = programas.item(i);
            System.out.println("Nombre del elemento actual: " + programa.getNodeName());
            if (programa.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) programa;
                System.out.println("ID: " + element.getAttribute("id"));
                System.out.println("Nombre: " + element.getElementsByTagName("nombre").item(0).getTextContent());
                System.out.println("version: " + element.getElementsByTagName("version").item(0).getTextContent());
                System.out.println("desarrollador: " + element.getElementsByTagName("desarrollador").item(0).getTextContent());

            }
        }
    }
}
