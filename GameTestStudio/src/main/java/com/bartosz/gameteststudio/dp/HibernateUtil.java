package com.bartosz.gameteststudio.dp;
import org.hibernate.SessionFactory;

import java.io.File;
import org.hibernate.cfg.Configuration;

/**
 * Klasa potrzebna do użycia Hibrnate.
 * @author Bartosz
 *
 */
public class HibernateUtil {
	 private static final SessionFactory sessionFactory = buildSessionFactory();

	    private static SessionFactory buildSessionFactory() {
	        try {
	            final File configFile = new File("src\\main\\resources\\hibernate.cfg.xml");
	            return new Configuration()
	                    .configure(configFile)
	                    .buildSessionFactory();
	        }
	        catch (Throwable ex) {
	            System.err.println("Initial SessionFactory creation failed." + ex);
	            throw new ExceptionInInitializerError(ex);
	        }
	    }

	    public static SessionFactory getSessionFactory() {
	        return sessionFactory;
	    }

	    public static void shutdown() {
	        getSessionFactory().close();
	    }
}

