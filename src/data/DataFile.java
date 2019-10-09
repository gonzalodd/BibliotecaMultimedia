package data;

import model.Musica;
import model.Pelicula;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.Field;
import java.util.List;

public class DataFile {
    private static Long idM;
    private static Long idP;
    private static List<Musica> musicas;
    private static List<Pelicula> peliculas;


    public static void cargar(){
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("musica.ser"))) {
            List<Musica> musicas1 = (List<Musica>) in.readObject();
            musicas = musicas1;
        } catch(ClassNotFoundException e){
            System.out.println("El objeto Musicas no esta en el sistema");
        } catch(IOException e){
            e.printStackTrace();
            System.out.println("Error en la lectura del archivo");
        }

        for (Musica musica : musicas) {
            idM = Math.max(musica.getId(),musica.getNextId());
        }

        Field field = null;
        try {
            field = Musica.class.getDeclaredField("nextId");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        field.setAccessible(true);
        try {
            field.set(null,idM);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("peliculas.ser"))) {
            List<Pelicula> peliculas1 = (List<Pelicula>) in.readObject();
            peliculas = peliculas1;
        } catch(ClassNotFoundException e){
            System.out.println("El objeto Peliculas no esta en el sistema");
        } catch(IOException e){
            e.printStackTrace();
            System.out.println("Error en la lectura del archivo");
        }

        for (Pelicula pelicula : peliculas) {
            idP = Math.max(pelicula.getId(),pelicula.getNextId());
            System.out.println(idP);
        }

        Field field2 = null;
        try {
            field2 = Pelicula.class.getDeclaredField("nextId");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        field2.setAccessible(true);
        try {
            field2.set(null,idP);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        // leer archivo
        // cargar listas Data
        // setear ids Data
    }
}



/*
    Esto me va a servir para poder guardar los datos tanto de las listas como de los ultimos id's cargados.

 */