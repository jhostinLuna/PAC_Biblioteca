import java.util.Scanner;

import biblioteca.Lector;
import biblioteca.Libro;
import database.DBManagement;
import database.DBManagementImpl;

public class Vista {
	Integer opcion = 0;
	DBManagement database;
	public Vista() {
		database = DBManagementImpl.getDBManagement();
	}
	public void pintarMenu() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("-----------------------------------------------------");
		System.out.println("					BIBLIOTECA");
		System.out.println("-----------------------------------------------------");
		System.out.println("1- Insertar Libro");
		System.out.println("2- Insertar Lector");
		System.out.println("3- Listado de Libros");
		System.out.println("4- Listado de Lectores");
		System.out.println("5- Ver Libro por ID");
		System.out.println("6- Ver Lector por ID");
		System.out.println("Salir");
		System.out.println("-----------------------------------------------------");
		System.out.print("Seleccione una Opción: ");
		opcion = scanner.nextInt();
		switch (opcion) {
		case 1:
			insertarLibro();
			break;
		case 2:
			insertarLector();
			break;
		case 3:
			pintarListaLibros();
			break;
		case 4:
			pintarListaLectores();
			break;
		case 5:
			pintarLibroPorID();
			break;
		case 6:
			pintarLectorPorID();
			break;
		default:
			break;
		}
	}
	private void insertarLibro() {
		try (Scanner scanner = new Scanner(System.in)) {
			Libro newLibro = new Libro();
			System.out.println("Escribe el título: ");
			newLibro.setTitulo(scanner.nextLine());
			System.out.println("Escribe el autor del Libro: ");
			newLibro.setAutor(scanner.nextLine());
			System.out.println("Año de publicación del Libro: ");
			newLibro.setAnioPublicacion(scanner.nextInt());
			newLibro.setDisponible(true);
			database.saveLibro(newLibro);
		}
	}
	private void insertarLector() {
		try (Scanner scanner = new Scanner(System.in)) {
			Lector newLector = new Lector();
			System.out.println("Escribe el nombre del Lector: ");
			newLector.setNombre(scanner.nextLine());
			System.out.println("Escribe el apellido del Lector: ");
			newLector.setApellido(scanner.nextLine());
			System.out.println("Email del Lector: ");
			newLector.setEmail(scanner.nextLine());
			database.saveLector(newLector);
		}
	}
	private void pintarListaLibros() {
		database.getAllLibros().forEach((a) -> {
			System.out.println(a.toString());
		});
	}
	private void pintarListaLectores() {
		database.getAllLector().forEach((a) -> {
			System.out.println(a.toString());
		});
	}
	
	private void pintarLibroPorID() {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Escribe el ID del Libro a buscar: ");
			Integer id = scanner.nextInt();
			Libro libro = database.getLibro(id);
			
			System.out.println(libro.toString());
		}
		
	}
	private void pintarLectorPorID() {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Escribe el ID del Lector a buscar: ");
			Integer id = scanner.nextInt();
			Lector lector = database.getLector(id);
			
			System.out.println(lector.toString());
		}
		
	}
}
