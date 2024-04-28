package database;

import java.util.List;

import biblioteca.Lector;
import biblioteca.Libro;

public interface DBManagement {
	/**
	 * Guarda el libro que se le pasa por parametro y devuelve el ID de l objeto si se ha guardado correectamente
	 * @param libro
	 * @return 
	 */
	public Integer saveLibro(Libro libro);
	/**
	 * Guarda el Lector que se le pasa por parametro y devuelve el ID de l objeto si se ha guardado correectamente
	 * @param lector
	 * @return
	 */
	public Integer saveLector(Lector lector);
	/**
	 * Devuelve todos los libros
	 * @return
	 */
	public List<Libro> getAllLibros();
	/**
	 * Devuelve todos los libros
	 * @return
	 */
	public List<Lector> getAllLector();
	/**
	 * Devuelve el libro con el id que se pasa por parametro
	 * @param id
	 * @return
	 */
	public Libro getLibro(Integer id);
	/**
	 * Devuelve el Lector con el id que se pasa por parametro
	 * @param id
	 * @return
	 */
	public Lector getLector(Integer id);
}
