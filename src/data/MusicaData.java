package data;

import model.Musica;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MusicaData {

    private static List<Musica> musicas = new ArrayList<>();
    private static final String ARCHIVO = "musica.ser";
    public static int index;

    public void addMusica(Musica musica){
        musicas.add(musica);
    }


    public void modificarMusica(Musica musica){
            musicas.get(index).setNombre(musica.getNombre());
            musicas.get(index).setRuta(musica.getRuta());
            musicas.get(index).setDuracion(musica.getDuracion());
            musicas.get(index).setArtista(musica.getArtista());
            musicas.get(index).setAlbum(musica.getAlbum());
            musicas.get(index).setNroCancion(musica.getNroCancion());
            musicas.get(index).setGenero(musica.getGenero());

    }

    public void modificarCampoMusica(Integer campo, Object object){
        switch (campo){
            case 1:
                    musicas.get(index).setNombre((String)object);
                break;
            case 2:
                    musicas.get(index).setRuta((String)object);
            case 3:
                    musicas.get(index).setDuracion((String)object);
                break;
            case 4:
                    musicas.get(index).setArtista((String)object);
                break;
            case 5:
                    musicas.get(index).setAlbum((String)object);
                break;
            case 6:
                    musicas.get(index).setNroCancion((String)object);
                break;
            case 7:
                    musicas.get(index).setGenero((String)object);
                break;
            default:
                System.out.println("¡Comando no reconocido, vuelva a intentar!");
        }

    }


    public boolean existeMusica(Long id){
        for (Musica musica : musicas) {
            if(musica.getId().equals(id)){
                index = musicas.indexOf(musica);
                return true;
            }
        }
        return false;
    }

    public void eliminarMusica(Long id){
        System.out.println("Se ha eliminado la cancion de id: " + id);
        musicas.remove(index);
        System.out.println("\n");
    }

    public void verInfo(Long id){
        System.out.println("La cancion de id " + id + " es: ");
        System.out.println(musicas.get(index).toString());
    }

    public void buscarMusica(String string) {
        for (Musica musica : musicas) {
            if (musica.getNombre().toUpperCase().contains(string.toUpperCase())) {
                System.out.println("Nombre: " + musica.getNombre());
            }
            if (musica.getArtista().toUpperCase().contains(string.toUpperCase())) {
                System.out.println("Artista: " + musica.getArtista());
            }
            if (musica.getAlbum().toUpperCase().contains(string.toUpperCase())) {
                System.out.println("Album: " + musica.getAlbum());
            }
            if (musica.getGenero().toUpperCase().contains(string.toUpperCase())) {
                System.out.println("Genero: " + musica.getGenero());
            }
            System.out.println("\n");
            }
        System.out.println("\n");
        }

    public void buscarCampoMusica(Integer campo, String string){
        for (Musica musica : musicas) {
            switch (campo){
                case 1:
                    if (musica.getNombre().toUpperCase().contains(string.toUpperCase()))
                        System.out.println("Nombre: " + musica.getNombre());
                    break;
                case 2:
                    if (musica.getArtista().toUpperCase().contains(string.toUpperCase()))
                        System.out.println("Artista: " + musica.getArtista());
                    break;
                case 3:
                    if (musica.getAlbum().toUpperCase().contains(string.toUpperCase()))
                        System.out.println("Album: " + musica.getAlbum());
                    break;
                case 4:
                    if (musica.getGenero().toUpperCase().contains(string.toUpperCase()))
                        System.out.println("Genero: " + musica.getGenero());
                    break;
            }
        }

    }


    public void lecturaMusica(){
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARCHIVO))) {
            List<Musica> musicas1 = (List<Musica>) in.readObject();
            System.out.println("Se ha cargado el archivo Musica.ser");
            musicas = musicas1;
        } catch(ClassNotFoundException e){
            System.out.println("El objeto Musicas no esta en el sistema");
        } catch(IOException e){
            e.printStackTrace();
            System.out.println("Error en la lectura del archivo");
        }
    }

    public void escrituraMusica(){
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            out.writeObject(musicas);
        } catch(NotSerializableException e){
            System.out.println("El objeto no se puede serializar porque no implementa la interface Serializable");
        } catch(IOException e){
            e.printStackTrace();
            System.out.println("Error en la escritura del archivo");
        }
    }

    public void listarMusica(){
        System.out.println("Listado de Musica: ");
        for (Musica musica : musicas) {
            System.out.println("Nombre: " + musica.getNombre() + "\n" +  "Duracion: " + musica.getDuracion() + "\n" + "Artista: " + musica.getArtista() + "\n" + "Album: " + musica.getAlbum());
            System.out.println("\n");
        }
    }

    public void listarTodo(){
        for (Musica musica : musicas){
            System.out.printf(musica.toString());
            System.out.printf("\n");
        }
        System.out.printf("\n");
    }

}
