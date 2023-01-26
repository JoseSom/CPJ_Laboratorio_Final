package mx.com.jsomven.peliculas.presentacion;

import mx.com.jsomven.peliculas.servicio.CatalogoPeliculasImpl;
import mx.com.jsomven.peliculas.servicio.ICatalogoPeliculas;

import java.util.Scanner;

public class CatalogoPeliculasPresentacion {
    public static void main(String[] args) {
        int opcion = -1;
        Scanner scanner = new Scanner(System.in);
        String pelicula;
        ICatalogoPeliculas catalogo = new CatalogoPeliculasImpl();

        while(opcion != 0){
            System.out.println("""
                    Elige una opcion:\s
                    1. Iniciar catalogo peliculas
                    2. Agregar pelicula
                    3. Listar peliculas
                    4. Buscar pelicula
                    0. Salir""");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion){
                case 1:
                    catalogo.iniciarCatalogoPeliculas();
                    break;
                case 2:
                    System.out.println("Inserte la pelicula");
                    pelicula = scanner.nextLine();
                    catalogo.agregarPelicula(pelicula);
                    break;
                case 3:
                    catalogo.listarPeliculas();
                    break;
                case 4:
                    System.out.println("Inserte la pelicula a buscar");
                    pelicula = scanner.nextLine();
                    catalogo.buscarPelicula(pelicula);
                    break;
                default:
                    System.out.println("Opcion no valida");
            }


        }
    }
}
