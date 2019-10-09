package model;

import data.MusicaData;
import java.io.Serializable;
import java.util.Scanner;

public class Musica implements BibliotecaMultimedia, Serializable {

    private Long id;
    private static Long nextId = 0L;
    private String nombre;
    private String ruta;
    private String duracion;
    private String artista;
    private String album;
    private String nroCancion;
    private String genero;
    private String[] generos = {"Electronica", "Pop", "Rap", "Rock", "Tango"};

    public static MusicaData musicaData = new MusicaData();
    public static Scanner scanner = new Scanner(System.in);
    public static Validation val = new Validation();

    public Musica() {
        this.setId();
        this.nombre = "";
        this.ruta = "";
        this.duracion = "";
        this.artista = "";
        this.album = "";
        this.nroCancion = "";
        this.genero = "";
    }

    public Musica(Long id, String nombre, String ruta, String duracion, String artista, String album, String nroCancion, String genero) {
        this.setId();
        this.nombre = nombre;
        this.ruta = ruta;
        this.duracion = duracion;
        this.artista = artista;
        this.album = album;
        this.nroCancion = nroCancion;
        this.genero = genero;
    }

    public static Long getNextId()  {
        return nextId;
    }

    public static void setNextId(Long nextId) {
        Musica.nextId = nextId++;
    }

    private void setId(){
        this.id = nextId;
        nextId++;
    }

    private void setId(Long id){
        this.id = id;
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

    public void setRuta(String ruta){
        this.ruta = ruta;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getNroCancion() {
        return nroCancion;
    }

    public void setNroCancion(String nroCancion) {
        this.nroCancion = nroCancion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public void nuevo() {

        String nombre;
        String ruta;
        String duracion;
        String artista;
        String album;
        String nroCancion;
        String genero;

        nombre = val.validarCampoVacio("Ingrese el nombre de la cancion: ");
        ruta = val.validarCampoVacio("Ingrese la ruta: ");
        ruta = val.validarRutaMusica(ruta);
        duracion = val.validarCampoVacio("Ingrese la duracion de la cancion en segundos: ");
        duracion = val.validarDuracion(duracion);
        duracion = convertirDuracion(duracion);
        artista = val.validarCampoVacio("Ingrese el nombre del artista: ");
        album = val.validarCampoVacio("Ingrese el nombre del album: ");
        nroCancion = val.validarCampoVacio("Ingrese el numero de la cancion: ");
        nroCancion = val.validarNroCancion(nroCancion);
        genero = val.validarCampoVacio("Ingrese el genero de la cancion: ");
        genero = val.validarGeneroCanciones(genero);

        Musica musica = new Musica();

        musica.setNombre(nombre);
        musica.setRuta(ruta);
        musica.setDuracion(duracion);
        musica.setArtista(artista);
        musica.setAlbum(album);
        musica.setNroCancion(nroCancion);
        musica.setGenero(genero);

        musicaData.addMusica(musica);

        System.out.println("Se ha ingresado la siguiente cancion: ");
        System.out.println(musica.toString());
        System.out.println("\n");
    }

    private String convertirDuracion(String duracion) {
        String duracionConvertida, minutos, segundos;
        Integer dur, min, seg;
        dur = Integer.parseInt(duracion);
        min = dur/60;
        seg = dur%60;
        minutos = min.toString();
        segundos = seg.toString();
        duracionConvertida = minutos + "m:" +segundos + "s";
        return duracionConvertida;
    }

    @Override
    public String toString() {
        return "Id: " + getId() + "\n" +
                "Nombre: " + getNombre() + "\n" +
                "Ruta: " + getRuta() + "\n" +
                "Duracion: " + getDuracion() + "\n" +
                "Nombre Artista: " + getArtista() + "\n" +
                "Nombre Album: " + getAlbum() + "\n" +
                "Numero cancion: " + getNroCancion() + "\n" +
                "Genero: " + getGenero() + " ";

    }

    @Override
    public void editar() {
        Long id;
        String nombre;
        String ruta;
        String duracion;
        String artista;
        String album;
        String nroCancion;
        String genero;
        System.out.println("Ingrese el id de la cancion a editar: ");
        id = scanner.nextLong();
        scanner.nextLine();
        if(musicaData.existeMusica(id)) {

            nombre = val.validarCampoVacio("Ingrese el nombre de la cancion: ");
            ruta = val.validarCampoVacio("Ingrese la ruta: ");
            ruta = val.validarRutaMusica(ruta);
            duracion = val.validarCampoVacio("Ingrese la duracion de la cancion en segundos: ");
            duracion = val.validarDuracion(duracion);
            duracion = convertirDuracion(duracion);
            artista = val.validarCampoVacio("Ingrese el nombre del artista: ");
            album = val.validarCampoVacio("Ingrese el nombre del album: ");
            nroCancion = val.validarCampoVacio("Ingrese el numero de la cancion: ");
            nroCancion = val.validarNroCancion(nroCancion);
            genero = val.validarCampoVacio("Ingrese el genero de la cancion: ");
            genero = val.validarGeneroCanciones(genero);

            Musica musica = new Musica();

            musica.setId(id);
            musica.setNombre(nombre);
            musica.setRuta(ruta);
            musica.setDuracion(duracion);
            musica.setArtista(artista);
            musica.setAlbum(album);
            musica.setNroCancion(nroCancion);
            musica.setGenero(genero);

            musicaData.modificarMusica(musica);

            System.out.println("Se ha ingresado la siguiente cancion: ");
            System.out.println(musica.toString());
            System.out.println("\n");
        }else
            System.out.println("El id ingresado no existe, vuelva a intentar");
    }

    @Override
    public void editarCampo() {
        String nombre;
        String ruta;
        String duracion;
        String artista;
        String album;
        String nroCancion;
        String genero;

        Long id;
        Integer campo;
        System.out.println("Ingrese el id de la cancion a editar: ");
        id = scanner.nextLong();
        if(musicaData.existeMusica(id)){
            campo = menuCampoAEditar();
            switch (campo){
                case 1:
                    nombre = val.validarCampoVacio("Ingrese el nombre de la cancion: ");
                    musicaData.modificarCampoMusica(1, nombre);
                    break;
                case 2:
                    ruta = val.validarCampoVacio("Ingrese la ruta: ");
                    ruta = val.validarRutaMusica(ruta);
                    musicaData.modificarCampoMusica(2,ruta);
                    break;
                case 3:
                    duracion = val.validarCampoVacio("Ingrese la duracion de la cancion en segundos: ");
                    duracion = val.validarDuracion(duracion);
                    duracion = convertirDuracion(duracion);
                    musicaData.modificarCampoMusica(3,duracion);
                    break;
                case 4:
                    System.out.println("Ingrese el nombre dle artista: ");
                    artista = scanner.nextLine();
                    musicaData.modificarCampoMusica(4,artista);
                    break;
                case 5:
                    album = val.validarCampoVacio("Ingrese el nombre del album: ");
                    musicaData.modificarCampoMusica(5,album);
                    break;
                case 6:
                    nroCancion = val.validarCampoVacio("Ingrese el numero de la cancion: ");
                    nroCancion = val.validarNroCancion(nroCancion);
                    musicaData.modificarCampoMusica(6,nroCancion);
                    break;
                case 7:
                    genero = val.validarCampoVacio("Ingrese el genero de la cancion: ");
                    genero = val.validarGeneroCanciones(genero);
                    musicaData.modificarCampoMusica(7,genero);
                    break;
                default:
                    System.out.println("¡Comando no reconocido, vuelva a intentar!");
            }
        }
        else
            System.out.println("El id ingresado no existe, vuelva a intentar");
    }

    private Integer menuCampoAEditar() {
        int opcion;
        System.out.println("Seleccione el campo que desea editar: ");
        System.out.println("1. Nombre");
        System.out.println("2. Ruta");
        System.out.println("3. Duracion");
        System.out.println("4. Artista");
        System.out.println("5. Album");
        System.out.println("6. Numero de cancion");
        System.out.println("7. Genero");
        opcion = scanner.nextInt();
        scanner.nextLine();
        return opcion;
    }

    @Override
    public void eliminar() {
        Long id;
        System.out.println("Ingrese el id de la cancion a elminar: ");
        id = scanner.nextLong();
        if(musicaData.existeMusica(id))
            musicaData.eliminarMusica(id);
        else
            System.out.println("El id ingresado no existe, vuelva a intentar");
    }

    @Override
    public void verInfo() {
        Long id;
        System.out.println("Ingrese el id de una cancion, para ver su informacion: ");
        id = scanner.nextLong();
        scanner.nextLine();
        if(musicaData.existeMusica(id))
            musicaData.verInfo(id);
        else
            System.out.println("El id ingresado no existe, vuelva a intentar");
    }

    @Override
    public void listar() {
        musicaData.listarMusica();
    }

    @Override
    public void buscar() {
        String palabra;
        palabra = val.validarCampoVacio("Ingrese la palabra que desea buscar: ");
        palabra = val.validarPalabra(palabra);
        musicaData.buscarMusica(palabra);
    }

    @Override
    public void buscarCampo() {
        Integer campo;
        String palabra;
        campo = menuCampoABuscar();
        palabra = val.validarCampoVacio("Ingrese la palabra que desea buscar");
        palabra = val.validarPalabra(palabra);
        musicaData.buscarCampoMusica(campo, palabra);

    }

    private Integer menuCampoABuscar() {
        int opcion;
        do {
            System.out.println("Seleccione el campo que desea buscar: ");
            System.out.println("1. Nombre");
            System.out.println("2. Artista");
            System.out.println("3. Album");
            System.out.println("4. Genero");
            opcion = scanner.nextInt();
            scanner.nextLine();
        }while(opcion<0 || opcion>4);

        return opcion;
    }
}
