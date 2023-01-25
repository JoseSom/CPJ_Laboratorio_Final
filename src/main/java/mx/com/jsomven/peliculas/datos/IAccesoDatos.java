package mx.com.jsomven.peliculas.datos;

import mx.com.jsomven.peliculas.domain.Pelicula;
import mx.com.jsomven.peliculas.excepciones.AccesoDatosEx;
import mx.com.jsomven.peliculas.excepciones.EscrituraDatosException;
import mx.com.jsomven.peliculas.excepciones.LecturaDatosException;

import java.util.List;

public interface IAccesoDatos {
    boolean existe(String nombreRecurso) throws AccesoDatosEx;

    List<Pelicula> listar(String nombreRecurso) throws LecturaDatosException;

    void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosException;

    String buscar(String nombreRecurso, String buscar) throws LecturaDatosException;

    void crear(String nombreRecurso) throws AccesoDatosEx;

    void borrar(String nombreRecurso) throws AccesoDatosEx;
}