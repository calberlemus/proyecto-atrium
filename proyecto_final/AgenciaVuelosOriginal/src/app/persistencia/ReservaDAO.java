package app.persistencia;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;


import app.modelo.Aeropuerto;
import app.modelo.Asiento;
import app.modelo.Reserva;
import app.modelo.Vuelo;

public class ReservaDAO implements ItfzReserva {

	@Override
	public boolean altaReserva(Reserva reserva)  {
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.getTransaction();

		boolean resultado = false;

		try {
			tx.begin();

			session.save(reserva);

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
	public boolean editarReserva(Reserva reserva, long id) {
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.getTransaction();

		int resultado = 0;
		try {
			tx.begin();		
			
			session.update(reserva);
			

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
	public boolean eliminarReserva(long id){		
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.getTransaction();
		int count = -1;

		try {		
			
			tx.begin();		
			Query sql = session.createQuery("DELETE Reserva r WHERE r.Id=:id");
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
	public List<Reserva> consultarReserva(){
		List<Reserva> lista = new ArrayList<Reserva>();

		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();

		try {
			Query sql = session.createQuery("SELECT r FROM Reserva r");			
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
	public Reserva consultarReserva(long id){
		Reserva reserva = new Reserva();
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();

		try {			
			reserva = (Reserva)session.get(Reserva.class, id);			
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
			sf.close();
		}
		return reserva;
	}

	@Override
	public List<Reserva> consultaReservasCliente(long idCliente){
		List<Reserva> lista = new ArrayList<Reserva>();

		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();

		try {
			Query sql = session.createQuery("SELECT r FROM Reserva r where r.cliente=:idCliente");
			sql.setLong("idCliente", idCliente);
			lista = sql.list();
			for(Reserva r: lista){
				Hibernate.initialize(r.getClaseIda());
				Hibernate.initialize(r.getCliente());
				Hibernate.initialize(r.getPasajeros());
				Hibernate.initialize(r.getVueloIda());
				Hibernate.initialize(r.getVueloIda().getDestino());
				Hibernate.initialize(r.getVueloIda().getOrigen());
				Hibernate.initialize(r.getVueloVuelta().getDestino());
				Hibernate.initialize(r.getVueloVuelta().getOrigen());
			}
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
			sf.close();
		}
		return lista;
	}

	
}
