/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leerdocxml;

import java.io.File;
import java.io.IOException;
import java.nio.file.attribute.AclEntry;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.DoubleStream;
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
public class LeerDocXML {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParserConfigurationException, SAXException {

        String direccionArchivo = "\\Users\\USUARIO\\Documents\\NetBeansProjects\\LeerDocXML\\datos\\programa.xml";
        preparacionXML pxml = new preparacionXML();
        Document documentXML = null;

        documentXML = pxml.preparacion(direccionArchivo);
        pxml.presentacion(documentXML);

    }
}
