package console;

import model.Musica;
import model.Pelicula;

import java.util.Scanner;

public class SubMenuEditar implements ConsoleMenu {

    private Integer code;

    public SubMenuEditar(Integer code) {
        this.code = code;
    }



    @Override
    public void mostrar() {
        Scanner s = new Scanner(System.in);
        int opcion = 0;
        Musica musica = new Musica();
        Pelicula pelicula = new Pelicula();
        do{
            System.out.println("1. Editar todo");
            System.out.println("2. Editar un campo");
            System.out.println("3. Volver");
            opcion = Integer.parseInt(s.nextLine());
            switch (opcion){
                case 1:
                    if(code == 1)
                        musica.editar();
                    else
                        pelicula.editar();
                    break;
                case 2:
                    if(code == 1)
                        musica.editarCampo();
                    else
                        pelicula.editarCampo();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("¡Comando no reconocido, vuelva a intentar!");
            }
        }while(opcion != 3);
    }
}
