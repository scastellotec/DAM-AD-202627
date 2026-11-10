import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestorPaises {

    // Colección que contiene todos los paises
    private List<Pais> paises = new ArrayList<Pais>();

    // Mostrar todos los países
    public void mostrarPaises() {
        for (Pais p : paises) {
            System.out.println(p);
        }
    }

    // Ejercicio 1: leer CSV
    public void leerCSV(String nombreArchivoCSV) throws FileNotFoundException {

        //1. Abrir el fichero
        Scanner sc = new Scanner(new File(nombreArchivoCSV));

        //2. Recorrer con un bucle todas las lineas del fichero
        sc.nextLine(); // Salto la primera linea

        while(sc.hasNextLine()) {
            String linea = sc.nextLine();
            String[] datosLinea = linea.split(";");
            paises.add(new Pais(Integer.parseInt(datosLinea[0]),
                                    datosLinea[1],
                                        Double.parseDouble(datosLinea[2])));
        }

        //3. Cerrar el fichero
        sc.close();
    }

    // Ejercicio 2: Leer aleatorio
    public void leerAleatorio(String nombreArchivoCSVAleatorio, int idBuscado) throws IOException {

        // 1. Defino el tamaño del registro
        final int ID_SIZE = 4;
        final int NOMBRE_SIZE = 5;
        final int INDICEDESARROLLO_SIZE = 8;
        final int TOTAL_SIZE = ID_SIZE + NOMBRE_SIZE*2 + INDICEDESARROLLO_SIZE;

        //2. Abro el fichero
        RandomAccessFile ra = new RandomAccessFile(nombreArchivoCSVAleatorio, "r");

        //3. Me posiciono en el registro
        ra.seek(idBuscado * TOTAL_SIZE);

        //4. Leo el registro y lo añado
        int id = ra.readInt();

        String nombre = "";
        for (int i = 0; i < NOMBRE_SIZE; i++) {
            nombre += ra.readChar();
        }

        double indiceDesarrollo = ra.readDouble();

        paises.add(new Pais(id, nombre, indiceDesarrollo));

        //5. Libero o cierro recursos
        ra.close();
    }

    // Ejercicio 3: Escribir XML
    /*
    <paises>
        <pais>
            <id>6</id>
            <nombre>Yemen</nombre>
            <indiceDesarrollo>0.480</indiceDesarrollo>
        </pais>
        ...
    </paises>

    Crea un archivo XML recibido y con la estructura de ejemplo
    Crear el nodo raíz <paises> y, dentro, un nodo <pais> por cada elemento del ArrayList.
    Crea el XML correctamente indentado (legible).
    Garantiza el cierre de los recursos
    Captura y/o propaga la excepcion
     */
    public void escribeXML(String nombreArchivoXML) throws ParserConfigurationException, TransformerException {

        //1. Abro el fichero (o la factory para crearlo)
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.newDocument();

        // 2. Grabo los datos con un bucle (o creo la estructura)
        // Genero el nodo raiz
        Element raiz = doc.createElement("paises");
        // Lo añado al arbol DOM
        doc.appendChild(raiz);

        // Recorrer con un bucle el ArryList de Paises e ir guardando
        for (Pais p: paises) {
            // <pais>
            Element pais = doc.createElement("pais");

            //<id>
            Element id = doc.createElement("id");
            id.setTextContent(String.valueOf(p.getId()));

            //<nombre>
            Element nombre = doc.createElement("nombre");
            nombre.setTextContent(p.getNombre());

            //<indicedesarrollo>
            Element indicedesarrollo = doc.createElement("indicedesarrollo");
            indicedesarrollo.setTextContent(String.valueOf(p.getIndiceDesarrollo()));

            //Añado al arbol DOM
            pais.appendChild(id);
            pais.appendChild(nombre);
            pais.appendChild(indicedesarrollo);
            raiz.appendChild(pais);
        }

        //3. Solo en XML: Genero el fichero
        Transformer tr = TransformerFactory.newInstance().newTransformer();
        tr.setOutputProperty(OutputKeys.INDENT, "yes");
        tr.transform(new DOMSource(doc), new StreamResult(new File(nombreArchivoXML)));

    }

}
