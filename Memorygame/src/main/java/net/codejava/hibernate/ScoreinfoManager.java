package net.codejava.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class ScoreinfoManager {
	protected SessionFactory sessionFactory;
	 
    protected void setup() {
        // code to load Hibernate Session factory
    	final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
    	        .configure() // configures settings from hibernate.cfg.xml
    	        .build();
    	try {
    	    sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    	} catch (Exception ex) {
    	    StandardServiceRegistryBuilder.destroy(registry);
    	}
    }
 
    protected void exit() {
        // code to close Hibernate Session factory
    	sessionFactory.close();
    	
    }
 
    protected void create(String user_name, int score) {
        // code to save scoreinfo
    	Scoreinfo scoreinfo = new Scoreinfo();
        scoreinfo.setUser_name(user_name);
        scoreinfo.setScore(score);

     
        Session session = sessionFactory.openSession();
        session.beginTransaction();
     
        session.save(scoreinfo);
     
        session.getTransaction().commit();
        session.close();
    }
 
    protected void read(int id) {
        // code to get a scoreinfo
    	Session session = sessionFactory.openSession();
   	 
        Scoreinfo scoreinfo = session.get(Scoreinfo.class, id);
     
        System.out.println("Nimimerkki: " + scoreinfo.getUser_name());
        System.out.println("Tulos: " + scoreinfo.getScore());

     
        session.close();
    }
 
    protected void update(int id, String user_name, int score) {
        // code to modify a scoreinfo
    	Scoreinfo scoreinfo = new Scoreinfo();
        scoreinfo.setId(id);
        scoreinfo.setUser_name(user_name);
        scoreinfo.setScore(score);

     
        Session session = sessionFactory.openSession();
        session.beginTransaction();
     
        session.update(scoreinfo);
     
        session.getTransaction().commit();
        session.close();
    }
 
    protected void delete(int id) {
        // code to remove a scoreinfo
        Scoreinfo scoreinfo = new Scoreinfo();
        scoreinfo.setId(id);
     
        Session session = sessionFactory.openSession();
        session.beginTransaction();
     
        session.delete(scoreinfo);
     
        session.getTransaction().commit();
        session.close();
    }

	public static void main(String[] args) {
		System.out.println("hello");
    	ScoreinfoManager manager = new ScoreinfoManager();
        manager.setup();
        System.out.println("setup done");
        //manager.create("paraspelaaja", 4);
        manager.read(3);
        //manager.update(3, "Sara", 7);
        //manager.delete(5);
        
        manager.exit();

	}

}
