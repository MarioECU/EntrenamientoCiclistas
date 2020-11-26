package modelo;

import java.time.LocalDate;
import java.util.List;

/**
 * Almacena los datos correspondientes a un conjunto de 3 vueltas realizadas por un determinado ciclista.
 */
public class Rutina {
    private LocalDate fechaPractica;
    private int idAtleta;
    private Vuelta[] vueltas;
    public static List<String> rutinas;
    
    /**
     * Crea un objeto de tipo Rutina.
     * @param fechaPractica Fecha en que se realizó la rutina.
     * @param idAtleta ID del atleta que realizó la rutina.
     * @param v1 Información correspondiente a la primera vuelta.
     * @param v2 Información correspondiente a la primera vuelta.
     * @param v3 Información correspondiente a la primera vuelta.
     */
    public Rutina(LocalDate fechaPractica, int idAtleta, Vuelta v1, Vuelta v2, Vuelta v3) {
        this.fechaPractica = fechaPractica;
        this.idAtleta = idAtleta;
        this.vueltas = new Vuelta[3];
        this.vueltas[0] = v1;
        this.vueltas[1] = v2;
        this.vueltas[2] = v3;
    }
    
    /**
     * Evalúa si el ciclista obtuvo tiempos dentro de los rangos en que su nivel lo ubica.
     * @return Si el ciclista, en todas sus vueltas, cumple con los tiempos establecidos por su nivel se retorna 0, caso contratio se retorna 1
     */
    public int cumpleNivel(){
        int indexNivel = Ciclista.ciclistas.get(String.valueOf(idAtleta)).getNivel()-1;
        for (int i = 0; i < 3; i++){
            if (vueltas[i].parseSeconds()< Ciclista.MINIMOS[indexNivel] || vueltas[i].parseSeconds()> Ciclista.MAXIMOS[indexNivel]){
                return 1;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        String text = fechaPractica+","+idAtleta+",";
        for (int i = 0; i < 3; i++){
            text += Vuelta.parseTime(vueltas[i].parseSeconds());
            text += ",";
        }
        return text + cumpleNivel();
    }
    
}
