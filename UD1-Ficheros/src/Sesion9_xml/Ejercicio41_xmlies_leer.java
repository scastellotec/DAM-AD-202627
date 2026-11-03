package Sesion9_xml;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Ejercicio41_xmlies_leer {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        // Declaro objetos y factoria para leer un XML
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();

        // Instancio el archivo que quiero leer
        Document doc = db.parse(new File("ejercicio41.xml"));

        // Vamos a leer el documento
        NodeList listaNodos = doc.getElementsByTagName("nombre");

        // Como el XML solo tiene un nombre, no hace falta un bucle
        // Puedo acceder directamente a la primera posicion
        String nombre = listaNodos.item(0).getTextContent();
        System.out.println("Nombre: "+nombre);

        // Intentamos coger el atributo
        String idioma = listaNodos.item(0).getAttributes().getNamedItem("idioma").getNodeValue();
        System.out.println("Atributo idioma: "+idioma);


        // Vamos a leer el documento
        listaNodos = doc.getElementsByTagName("ciudad");

        // Recojo el atributo de ciudad
        String ciudad = listaNodos.item(0).getTextContent();
        System.out.println("Ciudad: "+ciudad);

    }
}
