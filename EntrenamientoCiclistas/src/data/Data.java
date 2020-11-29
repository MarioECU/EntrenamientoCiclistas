package data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import modelo.Ciclista;
import modelo.Rutina;

/**
 * Almacena métodos necesarios para el manejo de la información y la persistencia de los mismos.
 */
public class Data {
    private static Object[] datos;
    
    /**
     * Carga todos los ciclistas previamente registrados.
     */
    public static void cargarCiclistas(){
        try {
            try (ObjectInputStream lectorArchivo = new ObjectInputStream(new FileInputStream("src/data/ciclistas.dat"))) {
                datos = (Object[]) lectorArchivo.readObject();
            }
        }
        catch (IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        Ciclista.idAtletas = (HashMap<String, Integer>) datos[0];
        Ciclista.ciclistas = (HashMap<Integer, Ciclista>) datos[1];
    }
    
    /**
     * Actualiza el archivo serializado que contiene la información de los ciclistas.
     */
    public static void actualizarCiclistas(){
        datos = new Object[2];
        datos[0] = Ciclista.idAtletas;
        datos[1] = Ciclista.ciclistas;
        try {
            try (ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream("src/data/ciclistas.dat"))) {
                escritor.writeObject(datos);
            }            
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Carga el archivo que contiene la información de todas las rutinas realizadas por los ciclistas.
     */
    public static void leerVueltas(){
        try {
            Rutina.rutinas = Files.readAllLines(Paths.get("src/data/ControlEntrenamiento.dat"));
            Rutina.rutinas.remove(0);
        } 
        catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    /**
     * Agrega texto al final del archivo que almacena los datos de las rutinas.
     * @param line Línea que va a ser añadida al archivo que contiene los datos de las rutinas.
     */
    public static void appendVueltas(String line){
        try {
            Files.write(Paths.get("src/data/ControlEntrenamiento.dat"), line.getBytes(), StandardOpenOption.APPEND);
        }       
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Indica la cantidad de registros que se han realizado en una fecha.
     * @param fecha Fecha cuyos registros serán contados.
     * @return Número de registros que han realizado para esa fecha.
     */
    public static int numeroDeRegistrosPorFecha(String fecha){
        int counter = 0;
        for (String linea : Rutina.rutinas){
            String[] data = linea.split(",");
            if (data[0].equals(fecha)){
                counter++;
            }
        }
        return counter;
    }
}
