package data;

import model.Pelicula;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PeliculaData {

    private static List<Pelicula> peliculas = new ArrayList<>();
    private static final String ARCHIVO = "peliculas.ser";
    private static int index = 0;

    public void addPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
    }

    public void modificarPelicula(Pelicula pelicula) {
            peliculas.get(index).setNombre(pelicula.getNombre());
            peliculas.get(index).setRuta(pelicula.getRuta());
            peliculas.get(index).setDuracion(pelicula.getDuracion());
            peliculas.get(index).setDirector(pelicula.getDirector());
            peliculas.get(index).setResolucion(pelicula.getResolucion());
            peliculas.get(index).setGenero(pelicula.getGenero());
            peliculas.get(index).setAño(pelicula.getAño());
    }

    public void modificarCampoPelicula(Integer campo, Object object) {
        switch (campo){
            case 1:
                peliculas.get(index).setNombre((String)object);
                break;
            case 2:
                    peliculas.get(index).setRuta((String)object);
            case 3:
                    peliculas.get(index).setDuracion((String)object);
                break;
            case 4:
                    peliculas.get(index).setDirector((String)object);
                break;
            case 5:
                    peliculas.get(index).setResolucion((String)object);
                break;
            case 6:
                    peliculas.get(index).setGenero((String)object);
                break;
            case 7:
                    peliculas.get(index).setAño((String) object);
                break;
            default:
                System.out.println("¡Comando no reconocido, vuelva a intentar!");
        }
    }


    public boolean existePelicula(Long id) {
        for (Pelicula pelicula : peliculas) {
            if(pelicula.getId().equals(id)){
                index = peliculas.indexOf(pelicula);
                return true;
            }
        }
        return false;
    }

    public void eliminarPelicula(Long id) {
        System.out.println("Se ha eliminado la pelicula de id: " + id);
        peliculas.remove(index);
        System.out.println("\n");
    }

    public void verInfo(Long id) {
        System.out.println("La pelicula de id " + id + " es: ");
        System.out.println(peliculas.get(index).toString());
    }

    public void buscarPelicula(String string) {
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getNombre().toUpperCase().contains(string.toUpperCase())) {
                System.out.println("Nombre: " + pelicula.getNombre());
            }
            if (pelicula.getDirector().toUpperCase().contains(string.toUpperCase())) {
                System.out.println("Director: " + pelicula.getDirector());
            }
            if (pelicula.getGenero().toUpperCase().contains(string.toUpperCase())) {
                System.out.println("Genero: " + pelicula.getGenero());
            }
            System.out.println("\n");
        }
        System.out.println("\n");
    }

    public void buscarCampoPelicula(Integer campo, String string){
        for (Pelicula pelicula : peliculas) {
            switch (campo){
                case 1:
                    if (pelicula.getNombre().toUpperCase().contains(string.toUpperCase()))
                        System.out.println("Nombre: " + pelicula.getNombre());
                    break;
                case 2:
                    if (pelicula.getDirector().toUpperCase().contains(string.toUpperCase()))
                        System.out.println("Director: " + pelicula.getDirector());
                    break;
                case 4:
                    if (pelicula.getGenero().toUpperCase().contains(string.toUpperCase()))
                        System.out.println("Genero: " + pelicula.getGenero());
                    break;
            }
        }

    }

    public void lecturaPelicula(){
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARCHIVO))) {
            List<Pelicula> peliculas1 = (List<Pelicula>) in.readObject();
            System.out.println("Se ha cargado el archivo Peliculas.ser");
            peliculas = peliculas1;
        } catch(ClassNotFoundException e){
            System.out.println("El objeto Peliculas no esta en el sistema");
        } catch(IOException e){
            e.printStackTrace();
            System.out.println("Error en la lectura del archivo");
        }
    }



    public void escrituraPelicula(){
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            out.writeObject(peliculas);
        } catch(NotSerializableException e){
            System.out.println("El objeto no se puede serializar porque no implementa la interface Serializable");
        } catch(IOException e){
            e.printStackTrace();
            System.out.println("Error en la escritura del archivo");
        }
    }

    public void listarPelicula(){
        System.out.println("Listado de Peliculas: ");
        for (Pelicula pelicula : peliculas) {
            System.out.println("Nombre: " + pelicula.getNombre() + "\n" +  "Duracion: " + pelicula.getDuracion() + "\n" + "Director: " + pelicula.getDirector() + "\n" + "Resolucion: " + pelicula.getResolucion());
        }
        System.out.println("\n");
    }

    public void listarTodo(){
        for (Pelicula pelicula : peliculas){
            System.out.printf(pelicula.toString());
            System.out.printf("\n");
        }
        System.out.printf("\n");
    }

}