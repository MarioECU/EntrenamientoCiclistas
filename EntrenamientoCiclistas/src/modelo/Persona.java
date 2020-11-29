package modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

/**
 * Almacena la información requerida de una persona.
 */
public class Persona implements Serializable {
    private String id;
    private String nombre;
    private String apellido;
    private String sexo;
    private int edad;
    private LocalDate nacimiento;

    protected static final long serialVersionUID = 1L;
    
    /**
     * Crea un objeto de tipo Persona
     * @param id Identificación nacional del ciclista.
     * @param nombre Nombre del ciclista.
     * @param apellido Apellido del ciclista.
     * @param sexo Sexo del ciclista.
     * @param year Año de nacimiento del ciclista.
     * @param month Mes de nacimiento del ciclista.
     * @param day Día de nacimiento del ciclista.
     */
    public Persona(String id, String nombre, String apellido, String sexo, int year, int month, int day) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        nacimiento = LocalDate.of(year, month, day);
        getEdad();
    }

    /**
     * Retorna la edad actual en base al cálculo con la fecha de nacimiento.
     * @return Edad actual de la persona.
     */
    public int getEdad() {
        edad = Period.between(nacimiento, LocalDate.now()).getYears();
        return edad;
    }

    @Override
    public String toString() {
        return id + "," + nombre + "," + apellido + "," + sexo + "," + edad + "," + nacimiento;
    }
    
}
