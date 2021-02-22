package com.dam.DAMHibernate_NaM;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.dam.DAMHibernate_NaM.Actor;


public class Principal {

	public static void main(String[] args) {
		
		StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();
		
		Session session = sf.openSession();
		
		
		session.getTransaction().begin();
		
			Pelicula pelicula1 = new Pelicula(1, "El bueno, el feo y el malo");
			Pelicula pelicula2 = new Pelicula(2, "Nubes pasajeras");
			
			Actor actor1 = new Actor(100, "Clint Eastwood");
			Actor actor2 = new Actor(200, "Eli Wallach");
			Actor actor3 = new Actor(300, "Kari Väänänen");
			
			actor1.anhadirPelicula(pelicula1);
			actor2.anhadirPelicula(pelicula1);
			actor3.anhadirPelicula(pelicula2);
			
			session.save(pelicula1);
			session.save(pelicula2);
			session.save(actor1);
			session.save(actor2);
			session.save(actor3);
		
		
		session.getTransaction().commit();
		
		session.close();
		sf.close();

	}

}
