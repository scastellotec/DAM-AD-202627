package Sesion9_xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

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
import java.io.IOException;
import java.util.ArrayList;

public class Ejercicio42_contactos {

    public static void main(String[] args) throws ParserConfigurationException, TransformerException, IOException, SAXException {

        // Creo el arrayList
        ArrayList<Contacto> contactos = new ArrayList<>();

        // Añado unos cuantos contactos
        contactos.add(new Contacto(1, "Julian"));
        contactos.add(new Contacto(2, "Maria"));
        contactos.add(new Contacto(3, "John"));
        contactos.add(new Contacto(4, "Amanda"));
        contactos.add(new Contacto(5, "Jose"));

        //Generar un archivo XML con estos contactos
        /* <agenda>
                <contacto id="xxx">
                    <nombre>xxxxx</nombre>
                </contacto>
        * */
        // Inicializo un DOC nuevo
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.newDocument();

        // Creo el elemento raiz
        Element raiz = doc.createElement("contactos");
        doc.appendChild(raiz);

        // Empiezo a rellenarlo para todos los contactos
        for (Contacto c: contactos) {
            // Creo elemento contacto
            Element contacto = doc.createElement("contacto");
            contacto.setAttribute("id", String.valueOf(c.getId()));

            // Creo elemento nombre => contacto
            Element nombre = doc.createElement("nombre");
            nombre.setTextContent(c.getNombre());
            contacto.appendChild(nombre);
            raiz.appendChild(contacto);
        }

        // Genero el archivo XML
        Transformer tr = TransformerFactory.newInstance().newTransformer();
        tr.setOutputProperty(OutputKeys.INDENT, "yes");
        tr.transform(new DOMSource(doc), new StreamResult(new File("ejercicio42.xml")));







        // Leer el mismo archivo XML e imprimir por pantalla toda la informacion
        db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        doc = db.parse(new File("ejercicio42.xml"));

        // Recojo todos los contactos
        NodeList contactosLeidos = doc.getElementsByTagName("contacto");

        for(int i=0; i < contactosLeidos.getLength(); i++){

            // Recojo el elemento de la posición que recorro
            Element e = (Element) contactosLeidos.item(i);

            // Recupero su atributo
            int id = Integer.parseInt(e.getAttribute("id"));

            // Recupero su nombre
            String nombre = e.getElementsByTagName("nombre").item(0).getTextContent();

            // Imprimo el contacto
            System.out.println("Contacto leido: "+id+" - "+nombre);
        }



    }
}

