package utilitaries;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import dal.models.User;

public class Hibernate {
	
	private Configuration configuration;
	private ServiceRegistry serviceRegistry;
	private SessionFactory factory;
	private Session session;
	private Transaction tx;	
	
	private static Hibernate instance;
	public static Hibernate instance(){
		if(instance == null){
			instance = new Hibernate();
		}
		return instance;
	}
	
	private Hibernate(){
		configuration = new Configuration();
		configuration.configure();
		configuration.addAnnotatedClass(User.class);
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		factory = configuration.buildSessionFactory(serviceRegistry);
		session = factory.openSession();
	}

	public Criteria createCriteria(Class<User> c) {
		return session.createCriteria(c);
	}
	
	//Insert an object
	public void insert(Object o){
		try
		{
			tx = session.beginTransaction();
			session.save(o);
			tx.commit();
		}
		catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}
	
	//Select a list with criteria
	public List<?> select(Criteria cr){
		List<?> list = cr.list();
		return list;
	}
	
	//Select one object with criteria
	public Object selectOne(Criteria cr){
		List<?> result = select(cr);
		if(result.size() > 0)
			return result.get(0);
		return null;
	}
}
