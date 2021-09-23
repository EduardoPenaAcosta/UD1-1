import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


public class App {


    public static void main(String[] args) {


        /** Creamos la ArrayList donde almacenaremos los alumnos del archivo .csv**/

        ArrayList<String> Alumnos = new ArrayList<String>();

        /**Creamos el Buffer**/


        /** Introducimos la ruta **/

        String ruta = "/Users/eduardo/Desktop/2 DAM/PMD/Prácticas/Practica UD 1-1/src/alumnos.csv";

        String linea = "";

        try (BufferedReader buffer = new BufferedReader(new FileReader(ruta))) {
            while ((linea = buffer.readLine()) != null) {
                Alumnos.add(linea);
            }
        } catch (Exception e) {
            e.printStackTrace();


        }

    }
}

