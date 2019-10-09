package model;

import data.PeliculaData;

import java.io.Serializable;
import java.util.Scanner;

public class Pelicula implements BibliotecaMultimedia, Serializable {



    private static Long nextId = 0L;
    private Long id;
    private String nombre;
    private String ruta;
    private String duracion;
    private String director;
    private String resolucion;
    private String genero;
    private String año;
    private String[] generos = {"Comedia", "Ciencia Ficcion","Drama", "Romatica", "Terror"};
    private String[] resoluciones = {"480", "720", "1080"};

    public static PeliculaData peliculaData = new PeliculaData();
    public static Scanner scanner = new Scanner(System.in);
    public static Validation val = new Validation();

    public Pelicula() {
        this.setId();
        this.nombre = "";
        this.ruta = "";
        this.duracion = "";
        this.director = "";
        this.resolucion = "";
        this.genero = "";
        this.año = "";
    }

    public Pelicula(Long id, String nombre, String ruta, String duracion, String director, String resolucion, String genero, String año) {
        this.setId();
        this.nombre = nombre;
        this.ruta = ruta;
        this.duracion = duracion;
        this.director = director;
        this.resolucion = resolucion;
        this.genero = genero;
        this.año = año;
    }

    public static Long getNextId()  {
        return nextId;
    }

    public static void setNextId(Long nextId) {
        Pelicula.nextId = nextId;
    }

    private void setId(){
        this.id = nextId;
        nextId++;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion){
        this.duracion = duracion;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director)  {
        this.director = director;
    }

    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }


    @Override
    public String toString() {
        return "Id: " + getId() + "\n" +
                "Nombre: " + getNombre() + "\n" +
                "Ruta: " + getRuta() + "\n" +
                "Duracion: " + getDuracion() + "\n" +
                "Nombre Director: " + getDirector() + "\n" +
                "Resolucion; " + getResolucion() + "\n" +
                "Genero: " + getGenero() + " " +
                "Año: " + getAño() + " ";

    }

    @Override
    public void nuevo() {
        String nombre;
        String ruta;
        String duracion;
        String director;
        String resolucion;
        String genero;
        String año;

        nombre = val.validarCampoVacio("Ingrese el nombre de la pelicula: ");
        ruta = val.validarCampoVacio("Ingrese la ruta: ");
        ruta = val.validarRutaPelicula(ruta);
        duracion = val.validarCampoVacio("Ingrese la duracion de la pelicula en minutos: ");
        duracion = val.validarDuracion(duracion);
        duracion = convertirDuracion(duracion);
        director = val.validarCampoVacio("Ingrese el nombre de director: ");
        resolucion = val.validarCampoVacio("Ingrese la resolucion dela pelicula: ");
        resolucion = val.validarResolucion(resolucion);
        genero = val.validarCampoVacio("Ingrese el genero de la pelicula: ");
        genero = val.validarGeneroPeliculas(genero);
        año = val.validarCampoVacio("Ingrese el año de la pelicula: ");
        año = val.validarAño(año);

        Pelicula pelicula = new Pelicula();

        pelicula.setNombre(nombre);
        pelicula.setRuta(ruta);
        pelicula.setDuracion(duracion);
        pelicula.setDirector(director);
        pelicula.setResolucion(resolucion);
        pelicula.setGenero(genero);
        pelicula.setAño(año);

        peliculaData.addPelicula(pelicula);
        System.out.println("Se ha ingresado la siguiente cancion: ");
        System.out.println(pelicula.toString());
        System.out.println("\n");

    }

    private String convertirDuracion(String duracion) {
        String duracionConvertida, horas, minutos;
        Integer dur, hs, min;
        dur = Integer.parseInt(duracion);
        hs = dur/60;
        min = dur%60;
        horas = hs.toString();
        minutos = min.toString();
        duracionConvertida = horas + "h:" + minutos + "m";
        return duracionConvertida;
    }

    @Override
    public void editar() {
        Long id;
        String nombre;
        String ruta;
        String duracion;
        String director;
        String resolucion;
        String genero;
        String año;
        System.out.println("Ingrese el id de la cancion a editar: ");
        id = scanner.nextLong();
        if(peliculaData.existePelicula(id)){
            nombre = val.validarCampoVacio("Ingrese el nombre de la pelicula: ");
            ruta = val.validarCampoVacio("Ingrese la ruta: ");
            ruta = val.validarRutaPelicula(ruta);
            duracion = val.validarCampoVacio("Ingrese la duracion de la pelicula: ");
            duracion = val.validarDuracion(duracion);
            director = val.validarCampoVacio("Ingrese el nombre de director: ");
            resolucion = val.validarCampoVacio("Ingrese la resolucion dela pelicula: ");
            resolucion = val.validarResolucion(resolucion);
            genero = val.validarCampoVacio("Ingrese el genero de la pelicula: ");
            genero = val.validarGeneroPeliculas(genero);
            año = val.validarCampoVacio("Ingrese el año de la pelicula: ");
            año = val.validarAño(año);

            Pelicula pelicula = new Pelicula();;
            pelicula.setNombre(nombre);
            pelicula.setRuta(ruta);
            pelicula.setDuracion(duracion);
            pelicula.setDirector(director);
            pelicula.setResolucion(resolucion);
            pelicula.setGenero(genero);
            pelicula.setAño(año);
            peliculaData.modificarPelicula(pelicula);
            System.out.println("Se ha ingresado la siguiente pelicula: ");
            System.out.println(pelicula.toString());
            System.out.println("\n");
        }
        else
            System.out.println("El id ingresado no existe, vuelva a intentar");
    }

    @Override
    public void editarCampo() {
        String nombre;
        String ruta;
        String duracion;
        String director;
        String resolucion;
        String genero;
        String año;

        Long id;
        Integer campo;
        System.out.println("Ingrese el id de la cancion a editar: ");
        id = scanner.nextLong();
        if(peliculaData.existePelicula(id)){
            campo = menuCampoAEditar();
            switch (campo){
                case 1:
                    nombre = val.validarCampoVacio("Ingrese el nombre de la pelicula: ");
                    peliculaData.modificarCampoPelicula(1, nombre);
                    break;
                case 2:
                    ruta = val.validarCampoVacio("Ingrese la ruta: ");
                    ruta = val.validarRutaPelicula(ruta);
                    peliculaData.modificarCampoPelicula(2,ruta);
                    break;
                case 3:
                    duracion = val.validarCampoVacio("Ingrese la duracion de la pelicula: ");
                    duracion = val.validarDuracion(duracion);
                    peliculaData.modificarCampoPelicula(3,duracion);
                    break;
                case 4:
                    director = val.validarCampoVacio("Ingrese el nombre de director: ");
                    peliculaData.modificarCampoPelicula(4,director);
                    break;
                case 5:
                    resolucion = val.validarCampoVacio("Ingrese la resolucion dela pelicula: ");
                    resolucion = val.validarResolucion(resolucion);
                    peliculaData.modificarCampoPelicula(5,resolucion);
                    break;
                case 6:
                    genero = val.validarCampoVacio("Ingrese el genero de la pelicula: ");
                    genero = val.validarGeneroPeliculas(genero);
                    peliculaData.modificarCampoPelicula(7,genero);
                    break;
                case 7:
                    año = val.validarCampoVacio("Ingrese el año de la pelicula: ");
                    año = val.validarAño(año);
                    peliculaData.modificarCampoPelicula(5,año);
                    break;
                default:
                    System.out.println("¡Comando no reconocido, vuelva a intentar!");
            }
        }
        else
            System.out.println("El id ingresado no existe, vuelva a intentar");
    }

    private Integer menuCampoAEditar() {
        int opcion = 0;
        System.out.println("Seleccione el campo que desea editar: ");
        System.out.println("1. Nombre");
        System.out.println("2. Ruta");
        System.out.println("3. Duracion");
        System.out.println("4. Director");
        System.out.println("5. Resolucion");
        System.out.println("6. Genero");
        System.out.println("7. Año");
        opcion = Integer.parseInt(scanner.nextLine());
        return opcion;
    }

    @Override
    public void eliminar() {
        Long id;
        System.out.println("Ingrese el id de la pelicula a elminar: ");
        id = scanner.nextLong();
        if(peliculaData.existePelicula(id))
            peliculaData.eliminarPelicula(id);
        else
            System.out.println("El id ingresado no existe, vuelva a intentar");
    }

    @Override
    public void verInfo() {
        Long id;
        System.out.println("Ingrese el id de una pelicula, para ver su informacion: ");
        id = scanner.nextLong();
        scanner.nextLine();
        if(peliculaData.existePelicula(id))
            peliculaData.verInfo(id);
        else
            System.out.println("El id ingresado no existe, vuelva a intentar");
    }

    @Override
    public void listar() {
        peliculaData.listarPelicula();
    }

    @Override
    public void buscar() {
        String palabra;
        palabra = val.validarCampoVacio("Ingrese lo que desea buscar: ");
        palabra = val.validarPalabra(palabra);
        peliculaData.buscarPelicula(palabra);
    }

    @Override
    public void buscarCampo() {
        Integer campo;
        String palabra;
        campo = menuCampoABuscar();
        palabra = val.validarCampoVacio("Ingrese la palabra que desea buscar");
        palabra = val.validarPalabra(palabra);
        peliculaData.buscarCampoPelicula(campo, palabra);
    }

    private Integer menuCampoABuscar() {
        int opcion;
        do {
            System.out.println("Seleccione el campo que desea buscar: ");
            System.out.println("1. Nombre");
            System.out.println("2. Director");
            System.out.println("4. Genero");
            opcion = scanner.nextInt();
            scanner.nextLine();
        }while(opcion<0 || opcion>3);

        return opcion;
    }
}

