/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registroalumnos;

/**
 * Clase Asignatura
 * @author EQUIPO I
 */
public class Asignatura {
    
    private String nombre; // Nombre de la asignatura
    private Integer creditos; // Creditos de la asignatura
    private Integer semestre; // Semestre al que pertenece la materia

    /**
     * Constructor lleno 
     * @param nombre nombre de la asignatura 
     * @param creditos creditos que le corresponden a cada asignatura 
     * @param semestre semestre en el que se encuentra la asignatura 
     */
    public Asignatura(String nombre, Integer creditos, Integer semestre){
        this.nombre = nombre;
        this.creditos = creditos;
        this.semestre = semestre;
    }
    
    /**
     * Constructor vacio 
     */
    public Asignatura(){
    };
    
    /**
     * Metodo get para el nombre de la materia 
     * @return 
     */
    public String getNombre() {
        return this.nombre;
    }
    
    /**
     * Metodo set para el nombre de la materia
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Metodo get para los creditos de la materia
     * @return 
     */
    public Integer getCreditos() {
        return this.creditos;
    }
    
    /**
     * Metodo set para los creditos de la materia
     * @param creditos 
     */
    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }
    
    /**
     * Metodo get para el semestre en que se encuentra la materia
     * @return 
     */
    public Integer getSemestre() {
        return this.semestre;
    }

    /**
     * Metodo set para el semestre en que se encuentra la materia
     * @param semestre 
     */
    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

}

