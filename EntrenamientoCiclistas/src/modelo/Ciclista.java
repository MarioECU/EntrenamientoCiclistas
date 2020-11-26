package modelo;

import java.util.HashMap;

/**
 * Almacena la información requerida de un ciclista.
 */
public class Ciclista extends Persona {
    private int idAtleta;
    private int nivel;
    public static final String[] NIVELES = {"Principiante", "Intermedio", "Avanzado", "Elite"}; //Nombres de los niveles de ciclistas.
    public static final int[] MINIMOS = {176, 131, 106, 60}; //Segundos mínimos paralelos a cada nivel.
    public static final int[] MAXIMOS = {239, 175, 130, 105}; //Segundos máximos paralelos a cada nivel.
    public static HashMap<String, Ciclista> ciclistas; //HashMap que contiene la información de todos los ciclistas registrados hasta el momento.
    
    /**
     * Crea un objeto de tipo ciclista
     * @param id Identificación nacional del ciclista.
     * @param nombre Nombre del ciclista.
     * @param apellido Apellido del ciclista.
     * @param sexo Sexo del ciclista.
     * @param year Año de nacimiento del ciclista.
     * @param month Mes de nacimiento del ciclista.
     * @param day Día de nacimiento del ciclista.
     * @param idAtleta ID del ciclista.
     * @param nivel Nivel en que se encuentra el ciclista, en base a su rango de tiempo en las vueltas.
     */
    public Ciclista(String id, String nombre, String apellido, String sexo, int year, int month, int day, int idAtleta, int nivel) {
        super(id, nombre, apellido, sexo, year, month, day);
        this.idAtleta = idAtleta;
        this.nivel = nivel;
    }

    /**
     * Retorna el número correspondiente al nivel del ciclista.
     * @return Número del nivel del ciclista.
     */
    public int getNivel() {
        return nivel;
    }
    
    /**
     * Retorna el nombre de la categoría a la que pertenece el ciclista.
     * @return Nombre de la categoría a la que pertenece el ciclista.
     */
    public String getNivelDescripcion(){
        return NIVELES[nivel-1];
    }
    
    /**
     * Establece un nuevo nivel al ciclista.
     * @param nivel Nuevo nivel a asignar al ciclista.
     */
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    
}
