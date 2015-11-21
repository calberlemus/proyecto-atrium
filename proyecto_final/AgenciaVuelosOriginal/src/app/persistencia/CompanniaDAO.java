package app.persistencia;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import app.modelo.Aeropuerto;
import app.modelo.Compannia;
import app.modelo.Pasajero;
import app.modelo.Vuelo;


public class CompanniaDAO implements ItfzCompannia{

	@Override
	public boolean altaCompannia(Compannia compannia)  {
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.getTransaction();

		boolean resultado = false;

		try {
			tx.begin();

			session.save(compannia);

			tx.commit();
			resultado = true;
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
			sf.close();
		}
		return resultado;
	}

	@Override
	public boolean editarCompannia(Compannia compannia, long id) {
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.getTransaction();

		int resultado = 0;
		try {
			tx.begin();		
			
			session.update(compannia);
			

			tx.commit();		

		} catch (HibernateException e) {
			e.printStackTrace();			
		} finally {
			session.close();
			sf.close();
		}
		return (resultado == 1);
	}

	@Override
	public boolean eliminarCompannia(long id){		
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.getTransaction();
		int count = -1;

		try {		
			
			tx.begin();		
			Query sql = session.createQuery("DELETE Compannia c WHERE c.Id=:id");
			sql.setLong("id", id);
			count = sql.executeUpdate();
			
			tx.commit();		

		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();			
		} finally {
			session.close();
			sf.close();
		}

		return (count > 0);
	}

	@Override
	public List<Compannia> consultarCompannias() {
		List<Compannia> lista = new ArrayList<Compannia>();
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();

		try {
			Query sql = session.createQuery("SELECT c FROM Compannia c");			
			lista = sql.list();				
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
			sf.close();
		}
		return lista;
	}

	@Override
	public Compannia consultarCompannia(long id){
		Compannia compannia = new Compannia();
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();

		try {			
			compannia = (Compannia)session.get(Compannia.class, id);
			Hibernate.initialize(compannia.getVuelos());
			for(Vuelo v: compannia.getVuelos()){
				Hibernate.initialize(v.getAsientos());
				Hibernate.initialize(v.getDestino());
				Hibernate.initialize(v.getOrigen());
			}
			Hibernate.initialize(compannia.getAdministradores());
			
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
			sf.close();
		}
		return compannia;
	}

	@Override
	public Compannia consultarCompannia(String codigo) {
		Compannia c = null;

		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();

		try {
			Query sql = session.createQuery("SELECT c FROM Compannia c WHERE c.codigo=:codigo");
			sql.setString("codigo", codigo);
			c=(Compannia)sql.uniqueResult();				
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
			sf.close();
		}
		return c;
	}

	

}