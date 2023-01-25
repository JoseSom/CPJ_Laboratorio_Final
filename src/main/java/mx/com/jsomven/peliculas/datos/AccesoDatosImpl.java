package mx.com.jsomven.peliculas.datos;

import mx.com.jsomven.peliculas.domain.Pelicula;
import mx.com.jsomven.peliculas.excepciones.AccesoDatosEx;
import mx.com.jsomven.peliculas.excepciones.EscrituraDatosException;
import mx.com.jsomven.peliculas.excepciones.LecturaDatosException;

import javax.swing.plaf.basic.BasicDesktopIconUI;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AccesoDatosImpl implements IAccesoDatos {
    @Override
    public boolean existe(String nombreRecurso){
        File archivo = new File(nombreRecurso);
        return archivo.exists();
    }

    @Override
    public List<Pelicula> listar(String nombreRecurso) throws LecturaDatosException {
        File archivo = new File(nombreRecurso);
        List<Pelicula> peliculas = new ArrayList<>();
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea;
            linea = entrada.readLine();
            while (linea != null) {
                Pelicula pelicula = new Pelicula(linea);
                peliculas.add(pelicula);
                linea = entrada.readLine();
            }
            entrada.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new LecturaDatosException("Excepcion al listar peliculas: " + e.getMessage());
        }
        return peliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosException {
        File archivo = new File(nombreRecurso);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(pelicula.toString());
            salida.close();
            System.out.println("Se ha escrito informacion al archivo" + pelicula);
        } catch (IOException e) {
            e.printStackTrace();
            throw new EscrituraDatosException("Excepcion al escribir peliculas: " + e.getMessage());
        }
    }

    @Override
    public String buscar(String nombreRecurso, String buscar) throws LecturaDatosException {
        File archivo = new File(nombreRecurso);
        String resultado = null;

        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea;
            linea = entrada.readLine();
            int indice = 1;
            while (linea != null) {
                if (buscar != null && buscar.equalsIgnoreCase(linea)) {
                    resultado = "Pelicula: " + linea + " encontrada en el indice " + indice;
                    break;
                }
                linea = entrada.readLine();
                indice++;
            }
            entrada.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new LecturaDatosException("Excepcion al buscar peliculas: " + e.getMessage());
        }
        return resultado;
    }

    @Override
    public void crear(String nombreRecurso) throws AccesoDatosEx {
        File archivo = new File(nombreRecurso);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
            System.out.println("Se ha creado el archivo");
        } catch (IOException e) {
            e.printStackTrace();
            throw new AccesoDatosEx("Excepcion al crear archivo: " + e.getMessage());
        }
    }

    @Override
    public void borrar(String nombreRecurso){
        File archivo = new File(nombreRecurso);
        if (archivo.exists()) {archivo.delete();}
        System.out.println("Se ha borrado el archivo");

    }
}
