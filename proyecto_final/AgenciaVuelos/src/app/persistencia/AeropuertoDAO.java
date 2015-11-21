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
import app.modelo.Pasajero;


public class AeropuertoDAO implements ItfzAeropuerto{

	@Override
	public boolean altaAeropuerto(Aeropuerto aeropuerto)  {
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.getTransaction();

		boolean resultado = false;

		try {
			tx.begin();

			session.save(aeropuerto);

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
	public boolean editarAeropuerto(Aeropuerto aeropuerto, long id) {
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.getTransaction();

		int resultado = 0;
		try {
			tx.begin();		
			
			session.update(aeropuerto);
			

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
	public boolean eliminarAeropuerto(long id){		
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.getTransaction();
		int count = -1;

		try {		
			
			tx.begin();		
			Query sql = session.createQuery("DELETE Aeropuerto a WHERE a.Id=:id");
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
	public List<Aeropuerto> consultarAeropuertos(){
		List<Aeropuerto> lista = new ArrayList<Aeropuerto>();

		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();

		try {
			Query sql = session.createQuery("SELECT distinct a FROM Aeropuerto a left join fetch a.vuelosOrigen left join fetch a.vuelosDestino");			
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
	public List<Aeropuerto> consultarAeropuertos(String paramString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Aeropuerto consultarAeropuertos(long id) {
		Aeropuerto aeropuerto = new Aeropuerto();
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();

		try {			
			aeropuerto = (Aeropuerto)session.get(Aeropuerto.class, id);
			Hibernate.initialize(aeropuerto.getVuelosDestino());
			Hibernate.initialize(aeropuerto.getVuelosOrigen());
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
			sf.close();
		}
		return aeropuerto;
	}

	@Override
	public Aeropuerto consultarAeropuertosCodigo(String codigo){
		Aeropuerto a = null;

		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();

		try {
			Query sql = session.createQuery("SELECT a FROM Aeropuerto a WHERE a.codigo=:codigo");
			sql.setString("codigo", codigo);
			a=(Aeropuerto)sql.uniqueResult();				
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
			sf.close();
		}
		return a;
	}


	

}