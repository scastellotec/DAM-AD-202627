package Sesion9_xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class Ejercicio41_xmlinstituto_Escribir {
    /*
        Genera instituto.xml con DOM y vuélcalo con sangría:
        <instituto>
            <nombre>IES Pablo Serrano</nombre>
            <ciudad>Zaragoza</ciudad>
        </instituto>
        Escribe después el programa que lo lea y muestre los dos valores.

     */

    public static void main(String[] args) throws ParserConfigurationException, TransformerException {

        // Inicializar la factoria para crear un documento
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();

        // Creo el documento en blanco
        Document doc = db.newDocument();

        // Empiezo a crear los elementos del archivo

        // Procedimiento: crear -> rellenar -> colgar del progenitor
        Element raiz = doc.createElement("instituto");
        doc.appendChild(raiz);

        // Elemento nombre
        Element nombre = doc.createElement("nombre");
        nombre.setTextContent("IES Pablo Serrano");
        nombre.setAttribute("idioma", "ES");
        raiz.appendChild(nombre);

        //ELemtno ciudad
        Element ciudad = doc.createElement("ciudad");
        ciudad.setTextContent("Zaragoza");
        raiz.appendChild(ciudad);

        // volcar a fichero
        Transformer tr = TransformerFactory.newInstance().newTransformer();
        tr.setOutputProperty(OutputKeys.INDENT, "yes");
        tr.transform(new DOMSource(doc), new StreamResult(new File("ejercicio41.xml")));


    }

}
