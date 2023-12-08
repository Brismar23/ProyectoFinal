/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registroalumnos;

import java.io.RandomAccessFile;
import java.util.Random;

/**
 * Clase Alumno
 * @author EQUIPO I
 */

public class Alumno {
    
    /**
     * Atributos
     */
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private Integer edad;
    private String direccion;
    private Integer semestre;
    private String numeroCuenta;
    private String numeroInscripcion;
    private RegistroAcadem historial;
    private Double promedio;

    
    /**
     * Constructor con parametros
     * @param nombre Nombre del Alumno
     * @param apelldioP Apellido Paterno del alumno
     * @param apellidoM Apellido Materno del alumno
     * @param edad Edad del alumno
     * @param direccion Direccion del alumno
     */
    public Alumno(Integer id,String nombre, String apellidoP, String apellidoM, Integer edad){
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.edad = edad;
        this.setDireccion(id);
        // this.numeroCuenta = generarNumeroDeCuenta();
    }
    
    /**
     * Constructor vacio
     * @param id 
     */
    public Alumno(Integer id){
        this.setDireccion(id);
    };

    
    /**
     * Metodo get para el nombre 
     * @return regresa ek nombre
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Metodo set para el nombre
     * @param nombre nombre del alumno 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo get para el apellido 
     * @return regresa el apellido 
     */
    public String getApellidoP() {
        return this.apellidoP;
    }

    /**
     * Metodo set para el apellido paterno 
     * @param apellidoP apellido del alumno paterno
     */
    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    /**
     * Metodo get para el apellido materno
     * @return regresa el apellido materno
     */
    public String getApellidoM() {
        return this.apellidoM;
    }

    /**
     * Metodo set para el apellido materno
     * @param apellidoM 
     */
    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    /**
     * Metodo get para la edad del alumno
     * @return 
     */
    public Integer getEdad() {
        return this.edad;
    }

    /**
     * Metodo set para la edad del alumno
     * @param edad 
     */
    public void setEdad(int edad) {
        this.edad = edad;
        // this.semestre = calcularSemestre();
        // System.out.println("Edad: "+ this.edad+ " Semestre: " + this.semestre);
    }

    /**
     * Metodo get para la direccion delalumno 
     * @return 
     */
    public String getDireccion() {
        return this.direccion;
    }

    /**
     * Metodo set para la direccion del alumno(caso en el que se agrega un alumno)
     * @param direccion 
     */
    public void setDireccionManual(String direccion){
        this.direccion = direccion;
    }

    /**
     * Metodo para poner la direccion del alumno 
     * @param id numero de cuenta del alumno
     */
    public void setDireccion(Integer id) {
        String nombreArchivo = "direcciones.txt"; // Ruta

        try(RandomAccessFile archivo = new RandomAccessFile(nombreArchivo, "rw")){
            // archivo.seek(0);
            for(int i = 1; i < id; i++){
                archivo.readLine();
            }
            this.direccion = archivo.readLine();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Metodo get para el numero de inscripcion 
     * @return 
     */
    public String getNumeroInscripcion(){
        return this.numeroInscripcion;
    }

    /**
     * Metodo set para el numero de incripcion 
     * @param numeroInscripcion 
     */
    public void setNumeroInscripcion(String numeroInscripcion) {
        this.numeroInscripcion = numeroInscripcion;
    }

    /**
     * Metodo get para el semestre del alumno 
     * @return 
     */
    public Integer getSemestre(){
        return this.semestre;
    }

    /**
     * Metodo set para el semestre del alumno 
     */
    public void setSemestre() {
        this.semestre = this.calcularSemestre();
    }

    /**
     * Metodo get para el numero de cuenta 
     * @return 
     */
    public String getNumeroCuenta() {
        return this.numeroCuenta;
    }

    /**
     * Metodo set para el numero de cuenta 
     */
    public void setNumeroCuenta(){
        this.numeroCuenta = generarNumeroDeCuenta();
    }

    /**
     * Metodo get para el historial academico del alumno 
     * @return 
     */
    public RegistroAcadem getHistorial(){
        return this.historial;
    }

    /**
     * Metodo get para el promedio del alumno
     * @return 
     */
    public Double getPromedio() {
        return promedio;
    }
    
    /**
     * Metodo set para el promedio del alumno 
     */
    public void setPromedio() {
        this.promedio = this.historial.promedio;
    }

    /**
     * Metodo para calcular el semestre a partir de la edad.
     * Ademas se crea el registro de cada alumno a partir del semestre.
     * Genera numero de cuenta
     * Genera NoInscripcion
     * @return Retorna el semestre aleatorio
     */
    public Integer calcularSemestre(){
        Random random = new Random();
        Integer semestre = 1;
        if(this.edad == 18){
            semestre = random.nextInt(2)+1; // Genera numero [1,2]
        }else if(this.edad == 19){
            semestre = random.nextInt(4)+1; // Genera numero [1,4]
        }else if(this.edad == 20){
            semestre = random.nextInt(4)+3; // Genera numero [3,6]
        }else if(this.edad == 21){
            semestre = random.nextInt(4)+5; // Genera numero [5,8]
        }else{
            semestre = random.nextInt(4)+7; // Genera numero [6,10]
        }

        // Asinga el historial academico al alumno
        this.historial = new RegistroAcadem(semestre);
        // Asigna el numero de cuenta generado
        this.numeroCuenta = generarNumeroDeCuenta();
        // Asigna el promedio a la clase Alumno, ademas del historial
        setPromedio();
        GenNumInscripcion generadorIndicador = new GenNumInscripcion();
        this.numeroInscripcion = generadorIndicador.generarIndicador(this.historial.promedio);
        // System.out.println("Numero de inscripcion es: "+this.numeroInscripcion);
        return semestre;
    }

    /**
     * Funcion para generar un número de cuenta aleatorio
     * @return
     */ 
    private static String generarNumeroDeCuenta() {
        Random random = new Random();
        Integer numero = random.nextInt(1000000);
        String cadena = String.format("314%06d", numero);
        return cadena;
    }

    /**
     * Metodo toString
     * @return 
     */
    @Override
    public String toString() {
        String cadena = "------------------------------\n";
        cadena += this.nombre + " " + this.apellidoP + " " +  this.apellidoM;
        cadena += "\n------------------------------\n";
        cadena += "No. Cuenta: " + this.numeroCuenta + "\tEdad: " + this.edad;
        cadena += "\n------------------------------\n";
        cadena += "No. Semestre: " + this.semestre + "\tNo. Inscripcion: " + this.numeroInscripcion;
        cadena += "\n------------------------------\n";
        cadena += "Direccion: " + this.direccion;
        cadena += "\n------------------------------\n";
        cadena += this.historial;

        return cadena;
    }
}
