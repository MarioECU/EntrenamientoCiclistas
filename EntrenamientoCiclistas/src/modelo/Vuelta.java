package modelo;

import java.time.LocalDate;

/**
 * Almacena los datos correspondientes a una vuelta en el velódromo realizada por un ciclista en un intervalo de tiempo.
 */
public class Vuelta {
    private int idAtleta;
    private LocalDate fechaPractica;
    private int numeroDeVuelta;
    private int minutos;
    private int segundos;

    /**
     * Crea un objeto de tipo Vuelta.
     * @param idAtleta ID del ciclista involucrado.
     * @param fechaPractica Fecha en que se realizó la práctica.
     * @param numeroDeVuelta Número de la vuelta en cuestión.
     * @param minutos Cantidad de minutos en que se completó la vuelta.
     * @param segundos Cantidad de segundos -además de los minutos- en que se completó la vuelta.
     */
    public Vuelta(int idAtleta, LocalDate fechaPractica, int numeroDeVuelta, int minutos, int segundos) {
        this.idAtleta = idAtleta;
        this.fechaPractica = fechaPractica;
        this.numeroDeVuelta = numeroDeVuelta;
        this.minutos = minutos;
        this.segundos = segundos;
    }
    
    /**
     * Retorna la cantidad de segundos del objeto desde donde es llamado.
     * @return Cantidad de segundos en base a los minutos y segundos ya conocidos.
     */
    public int parseSeconds(){
        return minutos*60 + segundos;
    }
    
    /**
     * Retorna la cantidad de segundos a partir de una representación en texto de tiempo.
     * @param time Representación en texto de tiempo.
     * @return Cantidad de segundos en base al tiempo indicado.
     */
    public static int parseSeconds(String time){
        String[] t = time.split(":");
        return Integer.parseInt(t[0])*60 + Integer.parseInt(t[1]);
    }
    
    /**
     * Retorna una representación en texto del tiempo, a partir del tiempo en segundos.
     * @param segundos Cantidad de segundos a convertir.
     * @return Representación en texto del tiempo.
     */
    public static String parseTime(int segundos){
        if (String.valueOf(segundos%60).length() == 1)
            return "0"+segundos/60+":0"+segundos%60;        
        return "0"+segundos/60+":"+segundos%60;
    }

    @Override
    public String toString() {
        return "Vuelta{" + "IdAtleta=" + idAtleta + ", NumeroDeVuelta=" + numeroDeVuelta + ", Tiempo=" + parseSeconds() + '}';
    }
    
}
