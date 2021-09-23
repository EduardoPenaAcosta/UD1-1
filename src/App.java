import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


public class main {


    public static void main(String[] args){


        // Creamos la ArrayList donde almacenaremos los alumnos del archivo .csv
        ArrayList<String> Alumnos= new ArrayList<String>();

        //Creamos el Buffer
        BufferedReader reader = null;

        try{

            //Pedimos leer el archivo csv
            reader = newBufferedReader( new FileReader("/Users/eduardo/Desktop/2 DAM/PMD/Prácticas/Practica UD 1-1/src/alumnos.csv"));


            //Crearemos una String donde se almacenará provisionalmente lo leído en el archivo.
            String linea;
            //Creamos un bucle donde estaremos leyendo el archivo hasta que la línea esté vacía
            // y a la misma vez los estaremos agregando al ArrayList previamente creado.
            while((linea=br.readLine())!=null) {
                Alumnos.add(linea);
                System.out.println(linea);
            }

        }catch(IOException e){
            //En caso de error, pues nos saltará.
            e.printStackTrace();

        }



    }

}

