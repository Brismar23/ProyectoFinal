/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package registroalumnos;

/**
 * Importación de bibliotecas necesarias para el programa.
 */

import java.io.RandomAccessFile;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase principal Main - que representa un sistema de gestión de registro de alumnos.
 * @author EQUIPO I
 */

public class REGISTROALUMNOS {
    public static void main(String[] args) {
        /**
         * Lista que almacena objetos de tipo Alumno, representando a todos los alumnos en el sistema.
         */
        List<Alumno> alumnos = new ArrayList<Alumno>(); // Guarda todos los alumnos
        /**
         * Variables de control del menú tipo entero
         */
        int opcionMenu;
        int opcionSubmenus;
        int opcionSubmenus2;
        
        /**
         * Objeto Scanner para la entrada de datos desde la consola.
         */
        Scanner scanner = new Scanner(System.in);
        /**
         *Llama a la función que simula limpiar la pantalla.
         */
        limpiaPantalla();
        /**
         * Muestra mensajes indicando la generación y ordenamiento de alumnos.
         */
        System.out.println("Generando alumnos. Espere un momento...");
        System.out.println("Ordenando por numero de inscripcion...");
        System.out.println("Escribiendo a CSV...");
        /**
         * Bucle que genera 1000 alumnos utilizando el método generarAlumno de la clase GenNombres.
         */
        for(int i = 1; i <= 1000; i++){
            alumnos.add(GenNombres.generarAlumno(i));
        }
        ordenarPorNumInscripcion(alumnos);
        /**
         *Desde que inicia el programa, guarda el CSV
         */
        escribirCSV(alumnos);      
   
        /**
         * Bucle principal que gestiona la interacción con el usuario y las opciones del programa.
         */
        do{
            /**
             * Limpia la pantalla para mejorar la presentación en la consola.limpiaPantalla();
             */
            limpiaPantalla();
            /**
             * Muestra el encabezado de bienvenida a la base de datos.
             */
            System.out.println("-----------------------------------------");
            System.out.println("|\tBIENVENIDO A LA BASE DE DATOS\t|");
            System.out.println("-----------------------------------------");
            
            /**
             *Muestra las opciones principales del menú.
             */
            System.out.println("1. Edicion de datos");
            System.out.println("2. Guardar datos");
            System.out.println("3. Salir");
            System.out.print("Escribe la opcion: ");
            /**
             * Lee la opción seleccionada por el usuario.
             */
            opcionMenu = scanner.nextInt();
            /**
             *Evalúa la opción seleccionada por el usuario utilizando una estructura switch.
             */
            switch(opcionMenu){
                /** 
                 * Caso de edicion de datos 
                 */
                case 1: 
                    /**
                     * Bucle que gestiona las opciones de edición de datos para los alumnos.
                     */
                    do{
                        /**
                         *Inicializa la variable para la selección de submenús.
                         */
                        opcionSubmenus = 0;
                        limpiaPantalla();
                        /**
                         *Muestra las opciones del submenú de edición de datos.
                         */
                        System.out.println("-----------------------------------------");
                        System.out.println("1. Alumno");
                        System.out.println("2. Regresar");
                        System.out.println("-----------------------------------------");
                        System.out.print("Selecciona la opcion: ");
                        /**
                         *Lee la opción seleccionada por el usuario.
                         */
                        opcionSubmenus = scanner.nextInt();
                        /**
                         *Verifica si la opción seleccionada es para editar datos de un alumno.
                         */
                        if(opcionSubmenus == 1){
                            /**
                             *Inicializa la variable para la selección de submenús adicionales.
                             */
                            opcionSubmenus2 = 0;
                            limpiaPantalla();
                            /**
                             *Muestra las opciones del submenú de edición de datos de un alumno.
                             */
                            System.out.println("-----------------------------------------");
                            System.out.println("1. Buscar alumno");
                            System.out.println("2. Editar datos del alumno");
                            System.out.println("3. Regresar");
                            System.out.println("-----------------------------------------");
                            System.out.print("Selecciona la opcion: ");
                            /**
                             *Lee la opción seleccionada por el usuario.
                             */
                            opcionSubmenus2 = scanner.nextInt();
                            /**
                             *Verifica la opción seleccionada en el submenú de edición de datos de un alumno.
                             */
                            if(opcionSubmenus2 == 1){
                                /** 
                                 * Buscar alumno 
                                 */
                                String numeroCuentaBuscar;
                                int encontrado = 0;
                                /**
                                 *Limpia el buffer del scanner.
                                 */
                                scanner.nextLine(); // Limpia buffer
                                limpiaPantalla();
                                /**
                                 *Solicita al usuario el número de cuenta del alumno a buscar.
                                 */
                                System.out.print("Escribe el numero de cuenta del alumno a buscar: ");
                                numeroCuentaBuscar = scanner.nextLine();
                                /**
                                 *  Busca al alumno por número de cuenta en la lista de alumnos.
                                 */
                                for(int i = 0; i < alumnos.size(); i++){
                                    if(numeroCuentaBuscar.equals(alumnos.get(i).getNumeroCuenta())){
                                        /**
                                         *Muestra los datos del alumno encontrado.
                                         */
                                        System.out.println(alumnos.get(i));
                                        encontrado = 1;
                                        break;
                                    }
                                }
                                /**
                                 *Informa si no se ha encontrado al alumno.
                                 */
                                if(encontrado == 0) System.out.println("No se ha encontrado.");
                                /**
                                 *Pausa la pantalla para que el usuario pueda revisar la información.
                                 */
                                pausaPantalla();
                            }else if(opcionSubmenus2 == 2){
                                /** 
                                 * Editar datos del alumno 
                                 */
                                String numeroCuentaEditar;
                                int indice_editar = 0;
                                scanner.nextLine(); // Limpia buffer
                                limpiaPantalla();
                                /**
                                 * Solicita al usuario el número de cuenta del alumno a editar.
                                 */
                                System.out.println("-----------------------------------------");
                                System.out.print("Escribe el numero de cuenta del alumno a editar: ");
                                numeroCuentaEditar = scanner.nextLine();
                                System.out.println("-----------------------------------------");
                                /**
                                 *  Busca al alumno por número de cuenta en la lista de alumnos.
                                 */
                                for(int i = 0; i < alumnos.size(); i++){
                                    if(numeroCuentaEditar.equals(alumnos.get(i).getNumeroCuenta())){
                                        /**
                                         * Muestra los datos del alumno encontrado y guarda su índice.
                                         */
                                        System.out.println(alumnos.get(i));
                                        indice_editar = i;
                                        break;
                                    }
                                }
                                /**
                                 *Inicializa la variable para la selección de la opción de edición.
                                 */
                                int opcionEditar;
                                /**
                                 * Muestra las opciones de edición disponibles para el alumno.
                                 */
                                System.out.println("-----------------------------------------");
                                System.out.println("Que quieres editar del alumno?");
                                System.out.println("1. Nombre");
                                System.out.println("2. Edad");
                                System.out.println("3. Direccion");
                                System.out.println("-----------------------------------------");
                                opcionEditar = scanner.nextInt();

                                /**
                                 * Realiza acciones según la opción de edición seleccionada.
                                 * Casos para editar
                                 */
                                if(opcionEditar == 1){
                                    /** 
                                     * Editar nombre 
                                     */
                                    String nuevo_nombre;
                                    scanner.nextLine(); // Limpia Buffer
                                    /**
                                     * Solicita al usuario el nuevo nombre.
                                     */
                                    System.out.print("Escribe el nuevo nombre: ");
                                    nuevo_nombre = scanner.nextLine();
                                    /**
                                     * Asigna el nuevo nombre al alumno.
                                     */
                                    alumnos.get(indice_editar).setNombre(nuevo_nombre); // Se asigna nuevo nombre
                                }else if(opcionEditar == 2){
                                    /** 
                                     * Editar edad 
                                     */
                                    Integer nueva_edad;
                                    System.out.print("Escribe la nueva edad: ");
                                    nueva_edad = scanner.nextInt();
                                    /**
                                     *Asigna la nueva edad al alumno.
                                     */
                                    alumnos.get(indice_editar).setEdad(nueva_edad); // Se asigna nueva edad
                                }else if(opcionEditar==3){
                                    String nueva_direccion;
                                    scanner.nextLine(); // Limpia Buffer
                                    /**
                                     *Solicita al usuario la nueva dirección.
                                     */
                                    System.out.print("Escribe la nueva direccion: ");
                                    nueva_direccion = scanner.nextLine();
                                    /**
                                     *Asigna la nueva dirección al alumno.
                                     */
                                    alumnos.get(indice_editar).setDireccionManual(nueva_direccion);// Se asigna nueva direccion
                                }else{
                                    System.out.println("Opcion no valida.");
                                }
                                limpiaPantalla();
                                /**
                                 *Muestra los nuevos datos del alumno editado.
                                 */
                                System.out.println("\t\tNuevos Datos");
                                System.out.println("-----------------------------------------");
                                System.out.println(alumnos.get(indice_editar));
                                System.out.println("-----------------------------------------");
                                /**
                                 * Pausa la pantalla para que el usuario pueda revisar la información.
                                 */
                                pausaPantalla();

                            }else if(opcionSubmenus2 == 3){} // Regresa
                            else {
                                System.out.println("Opcion invalida.");
                            }

                        }else if(opcionSubmenus == 2){}
                        /**
                         *No realiza ninguna acción y regresa al menú anterior.
                         */
                        else{
                            System.out.println("Opcion invalida.");
                        };
                    /**
                     *epite el bucle mientras la opción seleccionada no sea regresar.
                     */
                    }while(opcionSubmenus != 2);
                    break;
                case 2:
                    do{
                        opcionSubmenus = 0;
                        limpiaPantalla();
                        /**
                         *Muestra las opciones del submenú de operaciones de datos.
                         */
                        System.out.println("-----------------------------------------");
                        System.out.println("1. Guardar datos");
                        System.out.println("2. Eliminar datos (elimina a un alumno)");
                        System.out.println("3. Agregar alumno");
                        System.out.println("4. Regresar");
                        System.out.println("-----------------------------------------");
                        System.out.print("Selecciona la opcion: ");
                        opcionSubmenus = scanner.nextInt();
                        /**
                         *Realiza acciones según la opción seleccionada en el submenú de operaciones de datos.
                         */
                        if(opcionSubmenus == 1){
                            /** 
                             * Guardar datos en CSV 
                             */
                            escribirCSV(alumnos);
                            System.out.println("Se ha exportado correctamente al CSV");

                        }else if(opcionSubmenus == 2){
                            /**
                             * Elimina a un alumno 
                             */
                            String numeroCuentaEliminar;
                            int eliminado = 0;
                            scanner.nextLine(); // Limpia buffer
                            limpiaPantalla();
                            System.out.print("Escribe el numero de cuenta del alumno a eliminar: ");
                            numeroCuentaEliminar = scanner.nextLine();
                            /**
                             *Busca al alumno por número de cuenta en la lista de alumnos.
                             */
                            for(int i = 0; i < alumnos.size(); i++){
                                if(numeroCuentaEliminar.equals(alumnos.get(i).getNumeroCuenta())){
                                    /**
                                     *Elimina al alumno de la lista.
                                     */
                                    alumnos.remove(i);
                                    eliminado = 1;
                                }
                            }
                            /**
                             *Informa si no se ha encontrado al alumno.
                             */
                            if(eliminado != 1){
                                System.out.println("No se ha encontrado el alumno.");
                            }else{
                                /**
                                 *Ordena la lista por número de inscripción después de eliminar al alumno.
                                 */
                                ordenarPorNumInscripcion2(alumnos);
                                System.out.println("Alumno eliminado. Recuerda guardas tus cambios.");
                            }
                            pausaPantalla();
                        }else if(opcionSubmenus == 3){
                            /**
                             * Se agrega alumno 
                             */
                            String nombreNuevo;
                            String apellidoPNuevo;
                            String apellidoMNuevo;
                            Integer edadNueva;
                            Alumno alumnoNuevo;
                            limpiaPantalla();
                            scanner.nextLine();
                            /**
                             *Solicita al usuario los datos del nuevo alumno.
                             */
                            System.out.print("Escribe el nombre del alumno: ");
                            nombreNuevo = scanner.nextLine();
                            System.out.print("Escribe el apellido paterno del alumno: ");
                            apellidoPNuevo = scanner.nextLine();
                            System.out.print("Escribe el apellido materno del alumno: ");
                            apellidoMNuevo = scanner.nextLine();
                            System.out.print("Escribe la edad del alumno: ");
                            edadNueva = scanner.nextInt();
                            scanner.nextLine(); // Limpia buffer
                            /**
                             *Crea un nuevo objeto Alumno con los datos proporcionados.
                             */
                            alumnoNuevo = new Alumno(alumnos.size(), nombreNuevo, apellidoPNuevo, apellidoMNuevo, edadNueva);
                            alumnoNuevo.setSemestre();
                            alumnoNuevo.setNumeroInscripcion(alumnoNuevo.getHistorial().promedio.toString());
                            /**
                             *Agrega al nuevo alumno a la lista y ordena por promedio.
                             */
                            alumnos.add(alumnoNuevo);
                            ordenarPorPromedio(alumnos);
                            /**
                             * Muestra un mensaje indicando que el alumno se ha creado correctamente.
                             */
                            System.out.println("Se ha creado el alumno correctamente.");
                            System.out.println("Imprimiendo datos del alumno...");
                            pausaPantalla();
                            /**
                             *Muestra los datos del nuevo alumno.
                             */
                            System.out.println(alumnoNuevo);
                            scanner.nextLine();
                            /**
                             *Pausa la pantalla para que el usuario pueda revisar la información
                             */
                            pausaPantalla();
                            
                        }
                        else if(opcionSubmenus == 4){} // Regresa
                        /**
                         *No realiza ninguna acción y regresa al menú anterior.
                         */
                        else {                     
                            System.out.println("Opcion invalida.");
                        }
                    /**
                     * Repite el bucle mientras la opción seleccionada no sea regresar.
                     */
                    }while(opcionSubmenus != 4);
                    break;
                case 3:
                        
                    opcionSubmenus = 0;
                    limpiaPantalla();
                    /**
                     *Muestra las opciones del menú de salida.
                     */
                    System.out.println("-----------------------------------------");
                    System.out.println("\t\tSALIR\t\t");
                    System.out.println("-----------------------------------------");
                    System.out.println("Guardo los datos antes de salir?");
                    System.out.println("1. SI");
                    System.out.println("2. NO");
                    System.out.print("Selecciona la opcion: ");
                    opcionSubmenus = scanner.nextInt();
                    /**
                     *Realiza acciones según la opción seleccionada en el menú de salida.
                     */
                    if(opcionSubmenus == 1){
                        /**
                         *Muestra un mensaje indicando que se están guardando los datos y sale del programa.
                         */
                        System.out.println("-----------------------------------------");
                        System.out.println("Saliendo del programa...");
                        System.out.println("-----------------------------------------");
                        break;
                    }else if(opcionSubmenus == 2){
                        /**
                         *Establece la variable de la opción del menú principal a 0 para evitar salir
                         */
                        opcionMenu = 0; // Para evitar salir
                    }
                    else{
                        /**
                         *Si el usuario ingresa una opción no válida, muestra un mensaje de error
                         */
                        System.out.println("Opcion invalida.");
                    };
                    /**
                     *Finaliza el bloque switch y regresa al bucle del menú principal.
                     */
                    break;                   
            }
        }while(opcionMenu!=3);
        scanner.close();
    }

    /**  
     * Simula pausar la pantalla 
     */
    public static void pausaPantalla(){
        System.out.println("Presiona Enter para continuar...");
        try {
            /**
             *Lee un carácter desde la entrada estándar (teclado) para simular la pausa.
             */
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /** 
     * Simula limpiar la pantalla 
     */
    public static void limpiaPantalla(){
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
    }
    /**
     * Genera el numero de inscripcion y Ordena los alumnos por numero de inscripcion.
     * @param alumnos Lista de alumnos
     */
    public static void ordenarPorNumInscripcion(List<Alumno> alumnos){
        /**
         * Utiliza una clase externa para ordenar por número de inscripción
         */
        GenNumInscripcion.ordenarPorNumInscripcion(alumnos);
        for(int i = 0; i < alumnos.size(); i++){
            /**
             *Asigna números de inscripción formateados a los alumnos
             */
            alumnos.get(i).setNumeroInscripcion(String.format("%04d", i+1));
        }
    }
    /**
     * Genera el número de inscripción y ordena la lista de alumnos según el número de inscripción.
     * @param alumnos Lista de alumnos a ordenar.
     */
    
    public static void ordenarPorNumInscripcion2(List<Alumno> alumnos){
        /**
         *Utiliza una clase externa para ordenar por número de inscripción
         */
        GenNumInscripcion.ordenarPorNumInscripcion2(alumnos);
        for(int i = 0; i < alumnos.size(); i++){
            /**
             *Asigna números de inscripción formateados a los alumnos
             */
            alumnos.get(i).setNumeroInscripcion(String.format("%04d", i+1));
        }
    }
    /**
     * Genera el número de inscripción y ordena la lista de alumnos según el promedio.
     * @param alumnos Lista de alumnos a ordenar.
     */
    public static void ordenarPorPromedio(List<Alumno> alumnos){
        /**
         *Utiliza una clase externa para ordenar por promedio
         */
        GenNumInscripcion.ordenarPorPromedio(alumnos);
        for(int i = 0; i < alumnos.size(); i++){
            alumnos.get(i).setNumeroInscripcion(String.format("%04d", i+1));
        }
    }

    /** Exporta los datos a CSV
     * @param alumnos Lista de alumnos se escribirán en el archivo CSV
     */
    public static void escribirCSV(List<Alumno> alumnos){
        /**
         * Ruta del archivo CSV
         */
        String ruta = "datos.csv";

        try(RandomAccessFile archivo = new RandomAccessFile(ruta, "rw")){
            /**
             *Borra el contenido existente en el archivo
             */
            archivo.setLength(0);
            /**
             *Encabezados de las columnas en el archivo CSV
             */
            String columnas = "No Inscripcion,NoCuenta,Nombre,Apellido Paterno,Apellido Materno,Edad,Semestre,Promedio,Direccion";
            archivo.writeBytes(columnas + System.lineSeparator());
            
            for(int i = 0; i < alumnos.size(); i++){
                String cadena = "";
                cadena += alumnos.get(i).getNumeroInscripcion();
                cadena += ",";
                cadena += alumnos.get(i).getNumeroCuenta();
                cadena += ",";
                cadena += alumnos.get(i).getNombre();
                cadena += ",";
                cadena += alumnos.get(i).getApellidoP();
                cadena += ",";
                cadena += alumnos.get(i).getApellidoM();
                cadena += ",";
                cadena += alumnos.get(i).getEdad().toString();
                cadena += ",";
                cadena += alumnos.get(i).getSemestre().toString();
                cadena += ",";
                /**
                 *Formatea el promedio con dos decimales
                 */
                DecimalFormat df = new DecimalFormat("#.##");
                String resultado = df.format(alumnos.get(i).getHistorial().promedio);
                cadena += resultado.toString();
                cadena += ",";
                cadena += alumnos.get(i).getDireccion();
                /**
                 *Escribe la cadena en el archivo y agrega un salto de línea
                 */
                archivo.writeBytes(cadena + System.lineSeparator());
            }
            archivo.close();
        }catch(Exception e){
            /**
             * Imprime la traza de la excepción si ocurre algún error
             */
            e.printStackTrace();
        }
    }
}