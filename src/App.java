import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;


public class App {


    public static void main(String[] args) {


        /** Creamos la ArrayList donde almacenaremos los alumnos del archivo .csv**/

        ArrayList<String> Alumnos = new ArrayList<String>();


        /** Introducimos la ruta **/

        String ruta = "/Users/eduardo/Desktop/2 DAM/PMD/Prácticas/Practica UD 1-1/src/alumnos.csv";

        /**Utilizaremos esta String como almacenamiento temporal del la línea del archivo.**/
        String linea = "";


        /** Ahora realizaremos un trycatch para abrir un buffer,
         * con este lo que hará será leer y almacenar el archivo,
         * con el FileReader buscará el archivo.
         * Luego para almacenarlo, se ha realizado un bucle que mediante el String
         * de almacenamiento temporal que hemos creado y lo agregamos al ArrayList**/
        try (BufferedReader buffer = new BufferedReader(new FileReader(ruta))) {
            while ((linea = buffer.readLine()) != null) {
                Alumnos.add(linea);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        /** Ahora procederemos a crear el archivo donde meteremos los datos. **/

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

        /** Creo esta variable donde almacenaré todos los alumnos con sus respectivas notas.**/
        String alFichero = "";

        for(int i = 0; i < 4 ; i++){

            double numRandom = Math.random() * (Alumnos.size() + 0) + 1;
            String alumRandom = Alumnos.get((int)numRandom);

            /**Redondeamos las notas a dos decimales.**/

            DecimalFormat df = new DecimalFormat("#.00");

            /** Elegimos las 4 notas al azar y realizamos la media de las notas.**/

            double nota1 = Math.random() * (10 - 1) + 1;
            double nota2 = Math.random() * (10 - 1) + 1;
            double nota3 = Math.random() * (10 - 1) + 1;
            double nota4 = Math.random() * (10 - 1) + 1;

            double media = (nota1 + nota2 + nota3 + nota4)/4;

            /**Redondeamos los números**/
            nota1 = ((double)(Math.round(nota1 * 100d)/100d));
            nota2 = ((double)(Math.round(nota2 * 100d)/100d));
            nota3 = ((double)(Math.round(nota3 * 100d)/100d));
            nota4 = ((double)(Math.round(nota4 * 100d)/100d));
            media = ((double)(Math.round(media * 100d)/100d));
            
            /** Imprimimos en pantalla el resultado **/
            String frase = "El alumno " + alumRandom + " tiene las siguientes notas: " +  nota1 + " " +
                    nota2 + " " + nota3 + " " + nota4 + " y la media es de: " + media + "\n";

            System.out.println(frase);

            /** Aquí es donde almacenaré todas las notas del alumno, una seguida de otra.**/
            alFichero += frase;

            /** Ahora procedemos a escribir el el txt las notas. **/
            try{
                /** Con el FileWriter nos permite escribir en el archivo **/
                /** Con el PrintWriter escribimos en el archivo.**/
                fichero = new FileWriter("./src/notas.txt");
                pw = new PrintWriter(fichero);

                    /** Aquí escribiremos la frase en el txt.**/

                    fichero.write(alFichero);

            /** En caso de errores, pues saltará el error, en case de que
             * no, se cerrará el FileWriter.**/
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


}

