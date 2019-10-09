package console;

import model.Musica;
import model.Pelicula;

import java.util.Scanner;

public class SubMenuBuscar implements ConsoleMenu{

    private Integer code;

    public SubMenuBuscar(Integer code) {
        this.code = code;
    }

    @Override
    public void mostrar() {
        Scanner s = new Scanner(System.in);
        int opcion = 0;
        Musica musica = new Musica();
        Pelicula pelicula = new Pelicula();
        do{
            System.out.println("1. Buscar todo");
            System.out.println("2. Buscar por campo");
            System.out.println("3. Volver");
            opcion = Integer.parseInt(s.nextLine());
            switch (opcion){
                case 1:
                    if(code == 1)
                        musica.buscar();
                    else
                        pelicula.buscar();
                    break;
                case 2:
                    if(code == 1)
                        musica.buscarCampo();
                    else
                        pelicula.buscarCampo();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("¡Comando no reconocido, vuelva a intentar!");
            }
        }while(opcion != 3);
    }
}
