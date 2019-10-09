package console;

import data.DataFile;
import data.MusicaData;
import data.PeliculaData;

import java.util.Scanner;

public class Menu implements ConsoleMenu {

    @Override
    public void mostrar() {
        MusicaData musicaData = new MusicaData();
        PeliculaData peliculaData = new PeliculaData();
        ConsoleMenu subMenu;
        Scanner s = new Scanner(System.in);

        DataFile dataFile = new DataFile();
        dataFile.cargar();
        musicaData.lecturaMusica();
        System.out.println("\n");
        peliculaData.lecturaPelicula();
        System.out.println("\n");

        int opcion = 0;
        do{
            System.out.println("\t **** Biblioteca Mulitimedia ****");
            System.out.println("1. Administrar Musica");
            System.out.println("2. Administrar Peliculas");
            System.out.println("3. Salir");
            opcion = s.nextInt();
            switch (opcion){
                case 1:
                    subMenu = new SubMenu(opcion);
                    subMenu.mostrar();
                    break;
                case 2:
                    subMenu = new SubMenu(opcion);
                    subMenu.mostrar();
                    break;
                case 3:
                    System.out.println("¡Hasta luego!");
                    musicaData.escrituraMusica();
                    peliculaData.escrituraPelicula();
                    break;
                default:
                    System.out.println("¡Comando no reconocido, vuelva a intentar!");
            }
        }while(opcion != 3);

    }

}
