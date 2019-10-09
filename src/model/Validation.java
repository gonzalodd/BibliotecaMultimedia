package model;

import java.util.Scanner;

public class Validation {



    Scanner scanner = new Scanner(System.in);
    private String[] generos = {"Cumbia", "Electronica", "Pop", "Rap", "Rock"};
    private String[] generos2 = {"Comedia", "Ciencia Ficcion","Drama", "Romatica", "Terror"};
    private String[] resoluciones = {"480", "720", "1080"};

    public String validarCampoVacio(String string){
        String otroString;
        do {
            System.out.println(string);
            otroString = scanner.nextLine();
        }while(otroString.isEmpty());
        return otroString;
    }

    public String validarRutaMusica(String string) {
        while(!string.endsWith(".mp3") && !string.endsWith(".wma") && !string.endsWith(".wav")){
            System.out.println("La ruta especificada es invalida, vuelva a ingresar: ");
            string = scanner.nextLine();
        }
        return string;
    }

    public String validarRutaPelicula(String string) {
        while(!string.endsWith(".mp4") && !string.endsWith(".avi") && !string.endsWith(".mkv")){
            System.out.println("La ruta especificada es invalida, vuelva a ingresar: ");
            string = scanner.nextLine();
        }
        return string;
    }

    public String validarDuracion(String string){
        while(!isNumeric(string)){
            System.out.println("Solo debe ingresar numeros, vuelva a ingresar");
            string = scanner.nextLine();
        }
        return  string;
    }

    public String validarNroCancion(String string){
        while(!isNumeric(string)){
            System.out.println("Solo debe ingresar numeros, vuelva a ingresar");
            string = scanner.nextLine();
        }
        return  string;
    }

    private static boolean isNumeric(String cadena){
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }

    public String validarGeneroCanciones(String string){
        while (!((generos[0].toUpperCase()).equals(string.toUpperCase())) && !((generos[1].toUpperCase()).equals(string.toUpperCase())) && !((generos[2].toUpperCase()).equals(string.toUpperCase())) && !((generos[3].toUpperCase()).equals(string.toUpperCase())) && !((generos[4].toUpperCase()).equals(string.toUpperCase()))){
            System.out.println("El genero es invalido, vuelva a intentar");
            string = scanner.nextLine();
        }
        return string;
    }

    public String validarResolucion(String string) {
        while(!isNumeric(string) || (!resoluciones[0].equals(string) && !resoluciones[1].equals(string) && !resoluciones[2].equals(string))){
            System.out.println("Solo debe ingresar numeros o la resolucion es invalida, vuelva a intentar");
            string = scanner.nextLine();
        }
        return  string;
    }

    public String validarGeneroPeliculas(String string) {
        while (!((generos2[0].toUpperCase()).equals(string.toUpperCase())) && !((generos2[1].toUpperCase()).equals(string.toUpperCase())) && !((generos2[2].toUpperCase()).equals(string.toUpperCase())) && !((generos2[3].toUpperCase()).equals(string.toUpperCase())) && !((generos2[4].toUpperCase()).equals(string.toUpperCase()))){
            System.out.println("El genero es invalido, vuelva a intentar");
            string = scanner.nextLine();
        }
        return string;
    }

    public String validarAño(String string) {
        while(!isNumeric(string) || (Integer.parseInt(string)<0 || Integer.parseInt(string)>2018)){
            System.out.println("Solo debe ingresar numeros, vuelva a ingresar");
            string = scanner.nextLine();
        }
        return  string;
    }

    public String validarPalabra(String string){
        while (isNumeric(string)){
            System.out.println("Debe ingresar una palabra, vuelva a ingresar");
            string = scanner.nextLine();
        }
        return string;
    }

}
