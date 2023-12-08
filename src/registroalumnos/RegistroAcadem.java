/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registroalumnos;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.RandomAccessFile;  
import java.util.Random; 
/**
 * Clase RegistroAcadem
 * @author EQUIPO I
 */

public class RegistroAcadem {
    /**
     * Declaraciuon de variables tipo intger. 
     */
    Integer creditosTotales;
    Integer numAsignaturasCursadas;
    /**
     * Crea una nueva lista llamada asignaturasCursadas que puede contener objetos del tipo Asignatura. 
     */
    List<Asignatura> asignaturasCursadas = new ArrayList<Asignatura>();
    List<Integer> listaCalificaciones = new ArrayList<Integer>();
    Double promedio;

    /**
     * Declaracion de  Constructor.
     * Con variables de instwancia de la clase registroademico.
     * @param semestre Semestre del alumno para asignar aleatoriamente las asignaturas ya cursadas.
    */
    RegistroAcadem(Integer semestre){
        this.creditosTotales = 0;
        this.numAsignaturasCursadas = 0;

        String rutaAsignaturas = "src/asignaturas.txt";
        String linea = "";
        String[] datosAsignaturas;
        Double sumaCalificaciones = 0.0;
        /**
         * Se introduce un bloque de codigo el cual lanza ecepciones a una instancia de una clase. 
         */
        try(RandomAccessFile archivo = new RandomAccessFile(rutaAsignaturas, "rw")){
            for(int i = 1; i < 51; i++){
                
                linea = archivo.readLine(); // Lee la linea actual y la almacena en linea.
                datosAsignaturas = linea.split(","); // Separa cada linea (asignatura. creditos, semestre).

                Integer creditosAsignatura = Integer.parseInt(datosAsignaturas[1]); // Convierte a entero las subcadenas
                Integer semestreAsignatura = Integer.parseInt(datosAsignaturas[2]); // Convierte a entero las subcadenas
                Integer topeSemestre = semestre+1; 
                
                // El ciclo recorre el txt hasta el semestre indicado
                if(semestreAsignatura != topeSemestre){
                    this.creditosTotales += creditosAsignatura; 
                    this.numAsignaturasCursadas++;
                    
                    /* Crea la asignatura */
                    // Crear la asignatura y la agrega a la lista de asignaturas cursadas.
                    // Asignatura asignatura = new Asignatura(datosAsignaturas[0],datosAsignaturas[1].toString(),datosAsignaturas[2].toString());
                    Asignatura asignatura = new Asignatura();
                    asignatura.setNombre(datosAsignaturas[0]);
                    asignatura.setCreditos(creditosAsignatura);
                    asignatura.setSemestre(semestreAsignatura);
                    this.asignaturasCursadas.add(asignatura); // Se agrega a las ya cursadas.
                    
                    // Generar una calificación aleatoria y la agrega a la lista de calificaciones.
                    Random random = new Random();
                    Integer calificacion = random.nextInt(5)+6;
                    this.listaCalificaciones.add(calificacion);
                    sumaCalificaciones += calificacion;
                }else {
                    break;
                }
            }

            this.promedio = sumaCalificaciones/numAsignaturasCursadas;
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }

    /**
     * Método To String para obtener una representación en cadena del registro académico.
     */
    @Override
    public String toString(){
        String cadena = "\n-------------------\n";
        for(int i = 0; i < this.numAsignaturasCursadas; i++){
            cadena += this.asignaturasCursadas.get(i).getNombre() + ": " + this.listaCalificaciones.get(i).toString() + "\n";
        }
        cadena += "-------------------\n";
        cadena += "Promedio: " + String.format("%.3f", this.promedio);
        // for(Asignatura asignatura : this.asignaturasCursadas){
        //     cadena += asignatura.getNombre() + ": " + listaCalificaciones.get(0)
        // }
        cadena += "\n-------------------\n";
        return cadena;
    }

}
