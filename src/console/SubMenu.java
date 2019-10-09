package console;

import data.MusicaData;
import data.PeliculaData;
import model.Musica;
import model.Pelicula;

import java.util.Scanner;

public class SubMenu implements ConsoleMenu {

    public Integer id;

    public SubMenu(){
        this.id = 0;
    }

    public SubMenu(Integer id) {
        this.id = id;
    }

    @Override
    public void mostrar() {
        ConsoleMenu SubMenuEditar;
        ConsoleMenu SubMenuBuscar;
        Scanner s = new Scanner(System.in);
        int opcion = 0;
        Musica musica = new Musica();
        Pelicula pelicula = new Pelicula();
        PeliculaData peliculaData = new PeliculaData();
        MusicaData musicaData = new MusicaData();

        if(id==1)
            musicaData.listarTodo();
        else
            peliculaData.listarTodo();

        do{
            System.out.println("1. Nuevo");
            System.out.println("2. Editar");
            System.out.println("3. Eliminar");
            System.out.println("4. Ver info");
            System.out.println("5. Listar");
            System.out.println("6. Buscar");
            System.out.println("7. Volver");
            opcion = s.nextInt();
            s.nextLine();

            switch (opcion){
                case 1:
                    if(id==1)
                        musica.nuevo();
                    else
                        pelicula.nuevo();
                    break;
                case 2:
                    if(id==1){
                        SubMenuEditar = new SubMenuEditar(id);
                        SubMenuEditar.mostrar();
                    }
                    else{
                        SubMenuEditar = new SubMenuEditar(id);
                        SubMenuEditar.mostrar();
                    }
                    break;
                case 3:
                    if(id == 1)
                        musica.eliminar();
                    else
                        pelicula.eliminar();
                    break;
                case 4:
                    if(id == 1)
                        musica.verInfo();
                    else
                        pelicula.verInfo();
                    break;
                case 5:
                    if(id == 1)
                        musica.listar();
                    else
                        pelicula.listar();
                    break;
                case 6:
                    if(id==1){
                        SubMenuBuscar = new SubMenuBuscar(id);
                        SubMenuBuscar.mostrar();
                    }
                    else{
                        SubMenuBuscar = new SubMenuBuscar(id);
                        SubMenuBuscar.mostrar();
                    }
                    break;
                case 7:
                    break;
                default:
                    System.out.println("¡Comando no reconocido, vuelva a intentar!");
            }
        }while(opcion != 7);

    }
}
