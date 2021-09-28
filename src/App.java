import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;


public class App {


    public static void main(String[] args) {


        // Creamos la ArrayList donde almacenaremos los alumnos del archivo .csv**
        ArrayList<String> Alumnos = new ArrayList<String>();

        // Creo un array bidimensional para almacenar las notas
        double[] notas = new double[5];

        // Introducimos la ruta de donde sacaremos los nombres de los alumnos.
        String ruta = "/Users/eduardo/Desktop/2 DAM/PMD/Prácticas/Practica UD 1-1/src/alumnos.csv";

        // Utilizaremos esta línea donde almacenaremos temporalmente los nombres de los alumnos
        String linea = "";

        // Ahora realizaremos un TryCatch para abrir un buffer,
        // con este lo que hará será leer y almacenar el archivo,
        // con el FileReader buscará el archivo.
        // Luego para almacenarlo, se ha realizado un bucle que mediante el String
        // de almacenamiento temporal que hemos creado y lo agregamos al ArrayList
        try (BufferedReader buffer = new BufferedReader(new FileReader(ruta))) {
            while ((linea = buffer.readLine()) != null) {
                Alumnos.add(linea);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Ahora procederemos a crear el archivo donde meteremos los datos.
        try{
            File newTXT = new File("./notas.txt");
            if(newTXT.createNewFile()){
                System.out.println("El txt ha sido creado correctamente, ahora se procederá a añadir las notas.");

            }else{
                System.out.println("El archivo ya existe, se añadirá al existente...");
            }
        }catch(IOException e){
            e.printStackTrace();
        }

        FileWriter fichero = null;
        PrintWriter pw = null;

        calculoNotas(notas);
        crearArchivo();


        // Creo esta variable donde almacenaré todos los alumnos con sus respectivas notas.
        String alFichero = "";

        for(int i = 0; i < 10 ; i++){

            String alumRandom = Alumnos.get((int) (Math.random() * (Alumnos.size()) + 1));



            // Almacenamos el resultado de las notas del alumno e imprimo en pantalla para verificar.
            String frase = "El alumno " + alumRandom + " tiene las siguientes notas: " +  notas[0] + " " +
                    notas[1] + " " + notas[2] + " " + notas[3] + " y la media es de: " + notas[4] + "\n";

            System.out.println(frase);

            // Aquí es donde almacenaré todas las notas del alumno, una seguida de otra.
            alFichero += frase;

            // Ahora procedemos a escribir el el txt las notas.
            try{
                // Con el FileWriter nos permite escribir en el archivo
                // Con el PrintWriter escribimos en el archivo.
                fichero = new FileWriter("./src/notas.txt");
                pw = new PrintWriter(fichero);

                   // Aquí escribiremos la frase en el txt.
                    fichero.write(alFichero);

            // En caso de errores, pues saltará el error, en case de que
                // no, se cerrará el FileWriter.
            }catch(Exception e){
                e.printStackTrace();
            } finally {
                try {
                    if (null != fichero) {
                        fichero.close();
                    }
                }catch(Exception e2){
                    e2.printStackTrace();
                }
            }
        }
    }

    public static void crearArchivo(){

        // Ahora procederemos a crear el archivo donde meteremos los datos.
        try{
            File newTXT = new File("./notas.txt");
            if(newTXT.createNewFile()){
                System.out.println("El txt ha sido creado correctamente, ahora se procederá a añadir las notas.");

            }else{
                System.out.println("El archivo ya existe, se modificará al existente...");
            }
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    public static void calculoNotas(double[] notas){
        // Elegimos las 4 notas al azar y realizamos la media de las notas.**
        for(int h = 0; h < 4; h++){
            notas[h] = Math.random() * (10 - 1) + 1;
            notas[h] = Math.round(notas[h] * 100d)/100d;

        }

        //Calculamos la media de la nota y redondeamos la nota resultante.
        notas[4] = Math.round( ((notas[0] + notas[1] + notas[2] + notas[3])/4) * 100d)/100d;
    }



}