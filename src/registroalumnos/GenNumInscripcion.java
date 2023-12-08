/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registroalumnos;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Clase GenNumInscripcion
 * @author EQUIPO I
 */

public class GenNumInscripcion {
    /**
     * Metodo que genera el numero de inscripcion de los alumnos
     * @param promedio Toma como parametro el promedio de cada alumno para poder generar el numero de inscripcion
     * @return regresa el numero de inscripcion del alumno
     */
    public String generarIndicador(Double promedio){
        /**
         * Variables utilizadas para calcular el indicador escolar.
         */
        Double escolaridad;
        Double velocidad;
        Double indicador;
        /**
         *Variable que almacenará la representación del indicador escolar como String.
         */
        String indicadorEscolar = "";
        /**
         * Asigna valores predeterminados para escolaridad y velocidad.
         */
        escolaridad = Double.valueOf(100);
        // System.out.println("Escolareidad: "+escolaridad);
        velocidad = Double.valueOf(100);
        // System.out.println("Velocidad: "+velocidad);
        /**
         *Calcula el indicador multiplicando el promedio, escolaridad y velocidad.
         */
        indicador = Double.valueOf(promedio*escolaridad*velocidad);
        /**
         *Convierte el indicador a una cadena de texto.
         */

        indicadorEscolar = indicador.toString();
        // System.out.println("Indicador escolar: "+indicador);
        /**
         *Devuelve la representación del indicador escolar.
         */
        return indicadorEscolar;
    }

    /**
     * Se aplica la primera vez que ordena los numero de inscripcion
     * @param alumnos Lista de alumnos a ordenar
     */
    public static void ordenarPorNumInscripcion(List<Alumno> alumnos){
        Comparator<Alumno> comparadorPorIndicador = Comparator.comparing(Alumno::getNumeroInscripcion).reversed();
        Collections.sort(alumnos, comparadorPorIndicador);
    }
    
    /**
     * Se aplica cuando ya han sido ordenados los numeros de inscripcion al menos una vez
     * @param alumnos Lista de alumnos a ordenar
     */
    public static void ordenarPorNumInscripcion2(List<Alumno> alumnos){
        Comparator<Alumno> comparadorPorIndicador = Comparator.comparing(Alumno::getNumeroInscripcion);
        Collections.sort(alumnos, comparadorPorIndicador);
    }
    /**
     * Ordena una lista de objetos Alumno por el valor del campo promedio.
     * @param alumnos Lista de alumnos a ordenar
     */
    public static void ordenarPorPromedio(List<Alumno> alumnos){
        /**
         *Se crea un comparador utilizando la expresión lambda y el método comparing de la interfaz Comparator
         */
        Comparator<Alumno> comparadorPorPromedio = Comparator.comparing(Alumno::getPromedio);
        /**
         * Se utiliza el método sort de la clase Collections para ordenar la lista de alumnos.
         * La lista se ordena según el comparador creado anteriormente, que compara los objetos Alumno por su promedio
         */
        Collections.sort(alumnos, comparadorPorPromedio);
    }   
}
