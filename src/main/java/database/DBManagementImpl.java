package database;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import biblioteca.Lector;
import biblioteca.Libro;

public class DBManagementImpl implements DBManagement {
	public static DBManagement getDBManagement() {
		return new DBManagementImpl();
	}
	
	public DBManagementImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Integer saveLibro(Libro libro) {
		SessionFactory sessionFactory = HibernateDB.getSessionfactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		Integer idLibro = -1;
		try {
			transaction = session.beginTransaction();
			idLibro = (Integer) session.save(libro);
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) transaction.rollback();
			e.printStackTrace();
			System.err.println("Error al Guardar un libro ->" + libro.toString());
		} finally {
			session.close();
		}
		return idLibro;
	}

	@Override
	public Integer saveLector(Lector lector) {
		SessionFactory sessionFactory = HibernateDB.getSessionfactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		Integer id = -1;
		try {
			transaction = session.beginTransaction();
			id = (Integer) session.save(lector);
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null) transaction.rollback();
			e.printStackTrace();
			System.err.println("Error al Guardar un Lector ->" + lector.toString());
		} finally {
			session.close();
		}
		return id;
	}
	/**
	 * Devuelve todos los libros de base de datos, si no puede hacerlo devuelve null
	 */
	@Override
	public List<Libro> getAllLibros() {
		SessionFactory sessionFactory = HibernateDB.getSessionfactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		List lista = null;
		try {
			transaction = session.beginTransaction();
			lista = session.createQuery("FROM Libro").list();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error al cargar lista de Libros ");
		} finally {
			session.close();
		}
		return lista;
	}
	
	@Override
	public Libro getLibro(Integer id) {
		SessionFactory sessionFactory = HibernateDB.getSessionfactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		Libro libro = new Libro();
		try {
			transaction = session.beginTransaction();
			libro = session.get(Libro.class, id);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("No se ha podido cargar libro de base de datos: "+id);
		} finally {
			session.close();
		}
		return libro;
	}

	@Override
	public Lector getLector(Integer id) {
		SessionFactory sessionFactory = HibernateDB.getSessionfactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		Lector lector = new Lector();
		try {
			transaction = session.beginTransaction();
			lector = session.get(Lector.class, id);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("No se ha podido cargar libro de base de datos: "+id);
		} finally {
			session.close();
		}
		return lector;
	}

	@Override
	public List<Lector> getAllLector() {
		SessionFactory sessionFactory = HibernateDB.getSessionfactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		List lista = null;
		try {
			transaction = session.beginTransaction();
			lista = session.createQuery("FROM Lector").list();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error al cargar lista de LECTOR ");
		} finally {
			session.close();
		}
		return lista;
	}
	
}
