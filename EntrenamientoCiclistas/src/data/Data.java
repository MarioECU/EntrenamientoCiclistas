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
    /**
     * Carga todos los ciclistas previamente registrados.
     * @return HashMap cuyo clave es el ID del ciclista y el valor es el objeto de tipo Ciclista.
     */
    public static HashMap<String, Ciclista> cargarCiclistas(){
        HashMap<String, Ciclista> ciclistas = null;
        try {
            try (ObjectInputStream lectorArchivo = new ObjectInputStream(new FileInputStream("src/data/ciclistas.dat"))) {
                ciclistas = (HashMap<String, Ciclista>) lectorArchivo.readObject();
            }
        }
        catch (IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        return ciclistas;
    }
    
    /**
     * Actualiza el archivo serializado que contiene la información de los ciclistas.
     * @param c HashMap actualizado de los ciclistas.
     */
    public static void actualizarCiclistas(HashMap<String, Ciclista> c){
        try {
            try (ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream("src/data/ciclistas.dat"))) {
                escritor.writeObject(c);
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
}
