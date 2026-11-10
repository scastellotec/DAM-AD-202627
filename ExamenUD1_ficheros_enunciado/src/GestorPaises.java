import java.util.ArrayList;
import java.util.List;

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
    public void leerCSV(String nombreArchivoCSV){
        /*
        Lee el contenido del archivo CSV
        Salta la primera linea que indica la descripción de cada campo
        Por cada linea crea un pais y añadelo al ArrayList de paises
        Garantiza el cierre de los recursos
        Captura y/o propaga la excepcion
         */
    }

    // Ejercicio 2: Leer aleatorio
    public void leerAleatorio(String nombreArchivoCSVAleatorio, int idBuscado){
        /*
        Define claramente el tamaño del registro de cada Pais. Ten en cuenta que el nombre del pais siempre será de 5 letras.
        Lee el registro correspondiente al idbuscado, no es necesario contemplar la posibilidad de que el registro no exista
        Inserta el pais buscado en el arraylist
        Garantiza el cierre de los recursos
        Captura y/o propaga la excepcion
         */

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
    public void escribeXML(String nombreArchivoXML){

    }

}
