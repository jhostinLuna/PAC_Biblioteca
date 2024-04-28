package database;
import java.io.File;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import biblioteca.Libro;

public class HibernateDB {
	private static final String CFG = "src/main/resources/hibernate.cfg.xml";
	private static SessionFactory sessionFactory = null;
	public HibernateDB() {
		
	}
	public static SessionFactory getSessionfactory() {
		if (sessionFactory == null) {
			try {
				//Crea la configuracion desde la ruta del fichero hibernate.cfg.xml
				Configuration cfg = new Configuration().configure();
				System.out.println("Se ha cargado la configuracion............");
				//ServiceRegistry serviceRegistry = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
				
				//Crea SessionFactory usando propiedades de configuracion y mapeo
				sessionFactory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
				return sessionFactory;
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println("Error al cargar configuracion");
			}			
		}
		return sessionFactory;
	}
	
}
