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


import app.modelo.Asiento;
import app.modelo.Vuelo;
import app.util.Fecha;

public class VueloDAO implements ItfzVuelo {

	@Override
	public boolean altaVuelo(Vuelo vuelo) {
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.getTransaction();

		boolean resultado = false;

		try {
			tx.begin();		
			session.save(vuelo);
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
	public boolean editarVuelo(Vuelo vuelo, long id) {
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.getTransaction();

		int resultado = 0;
		try {
			tx.begin();		
			
			session.update(vuelo);		

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
	public boolean eliminarVuelo(long id){		
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.getTransaction();
		int count = -1;

		try {		
			
			tx.begin();		
			Query sql = session.createQuery("DELETE Vuelo v WHERE v.Id=:id_vuelo");
			sql.setLong("id_vuelo", id);
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
	public List<Vuelo> consultarVuelos() {
		List<Vuelo> lista = new ArrayList<Vuelo>();

		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();
		try {
			Query sql = session
					.createQuery("SELECT distinct v FROM Vuelo v left join fetch v.origen left join fetch v.destino "
							+ "left join fetch v.compannia left join fetch v.asientos left join fetch v.reservasIda "
							+ "left join fetch v.reservasVuelta");
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
	public List<Vuelo> consultarVuelosCompannia(long idCompannia){
		List<Vuelo> lista = new ArrayList<Vuelo>();

		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();
		try {
			Query sql = session
					.createQuery("SELECT distinct v FROM Vuelo v left join fetch v.origen left join fetch v.destino "
							+ "left join fetch v.compannia left join fetch v.asientos left join fetch v.reservasIda "
							+ "left join fetch v.reservasVuelta where v.compannia=:idCompannia");
			sql.setLong("idCompannia", idCompannia);
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
	public List<Vuelo> consultarVuelos(long origen,long destino, Date ida) {
		List<Vuelo> lista = new ArrayList<Vuelo>();

		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();
		try {
			Query sql = session
					.createQuery("SELECT distinct v FROM Vuelo v left join fetch v.origen left join fetch v.destino "
							+ "left join fetch v.compannia left join fetch v.asientos left join fetch v.reservasIda "
							+ "left join fetch v.reservasVuelta WHERE v.origen.Id=:id_origen AND v.destino.Id=:id_destino" +
							" AND v.diaSalida =:dia_salida");
			sql.setLong("id_destino", destino);
			sql.setLong("id_origen", origen);
			System.out.println(Fecha.fechaSinHora(ida));
			System.out.println(destino);
			System.out.println(origen);
			sql.setDate("dia_salida", Fecha.fechaSinHora(ida));			
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
	public Vuelo consultarVuelo(long id) {
		Vuelo vuelo = new Vuelo();
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();

		try {
			vuelo = (Vuelo) session.get(Vuelo.class, id);
			Hibernate.initialize(vuelo.getAsientos());
			Hibernate.initialize(vuelo.getOrigen());
			Hibernate.initialize(vuelo.getDestino());
			Hibernate.initialize(vuelo.getCompannia());
			Hibernate.initialize(vuelo.getReservasIda());
			Hibernate.initialize(vuelo.getReservasVuelta());

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
			sf.close();
		}
		return vuelo;
	}

	@Override
	public boolean altaAsiento(Asiento asiento) {
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.getTransaction();

		boolean resultado = false;

		try {
			tx.begin();

			session.save(asiento);

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
	public boolean editarAsiento(Asiento asiento){
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.getTransaction();

		int resultado = 0;
		try {
			tx.begin();		
			
			session.update(asiento);		

			tx.commit();		

		} catch (HibernateException e) {
			e.printStackTrace();			
		} finally {
			session.close();
			sf.close();
		}
		return (resultado == 1);
	}
	
	public boolean eliminarAsiento(long id){		
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.getTransaction();
		int count = -1;

		try {		
			
			tx.begin();		
			Query sql = session.createQuery("DELETE Asiento a WHERE a.Id=:id_asiento");
			sql.setLong("id_asiento", id);
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
	public List<Asiento> consultaAsientosVuelo(long id_vuelo){
		List<Asiento> lista = new ArrayList<Asiento>();

		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();
		try {
			Query sql = session
					.createQuery("SELECT a FROM Asiento a left join fetch a.vuelo WHERE a.vuelo.Id=:id_vuelo");
			sql.setLong("id_vuelo", id_vuelo);
			lista = sql.list();
			for (Asiento a: lista){
				Hibernate.initialize(a.getVuelo().getOrigen());
				Hibernate.initialize(a.getVuelo().getDestino());
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
			sf.close();
		}
		return lista;
	}
	
	@Override
	public List<Vuelo> consultarVuelosVuelta(Vuelo vuelo, Date vuelta) {
		List<Vuelo> lista = new ArrayList<Vuelo>();

		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();
		try {
			Query sql = session
					.createQuery("SELECT distinct v FROM Vuelo v left join fetch v.origen left join fetch v.destino "
							+ "left join fetch v.compannia left join fetch v.asientos left join fetch v.reservasIda "
							+ "left join fetch v.reservasVuelta WHERE v.origen.Id=:id_destino AND v.destino.Id=:id_origen" +
							" AND v.diaSalida =:fecha_vuelta");
			sql.setLong("id_destino", vuelo.getDestino().getId());
			sql.setLong("id_origen", vuelo.getOrigen().getId());			
			sql.setDate("fecha_vuelta", vuelta);
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
	public Asiento consultarAsiento(long id){
		Asiento asiento = new Asiento();
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();

		try {
			asiento = (Asiento) session.get(Asiento.class, id);

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
			sf.close();
		}
		return asiento;
	}

	@Override
	public List<Asiento> consultaAsientosDisponiblesVuelo(long id_vuelo, String clase){ 
		List<Asiento> lista = new ArrayList<Asiento>();
	
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();
		try {
			Query sql = session
					.createQuery("SELECT a FROM Asiento a left join fetch a.vuelo WHERE a.vuelo.Id=:id_vuelo AND a.disponible=1 AND a.clase=:clase AND a.disponible=true" +
							" ORDER BY a.numero ASC");
			sql.setLong("id_vuelo", id_vuelo);
			sql.setString("clase", clase);
			lista = sql.list();
			for (Asiento a: lista){
				Hibernate.initialize(a.getVuelo().getOrigen());
				Hibernate.initialize(a.getVuelo().getDestino());
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
			sf.close();
		}
		return lista;
	}

	@Override
	public List<Asiento> reservarAsientosVuelo(long id_vuelo, String clase, int num) { 
		List<Asiento> lista = new ArrayList<Asiento>();
	
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();
		try {
			Query sql = session
					.createQuery("SELECT a FROM Asiento a left join fetch a.vuelo WHERE a.vuelo.Id=:id_vuelo AND a.disponible=1 AND a.clase=:clase AND a.disponible=true" +
							" ORDER BY a.numero ASC");
			sql.setMaxResults(num);
			sql.setLong("id_vuelo", id_vuelo);
			sql.setString("clase", clase);
			lista = sql.list();
			for (Asiento a: lista){
				Hibernate.initialize(a.getVuelo().getOrigen());
				Hibernate.initialize(a.getVuelo().getDestino());
				a.setDisponible(false);
				Transaction tx = session.getTransaction();
				
				tx.begin();	
				session.update(a);
				tx.commit();
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
			sf.close();
		}
		return lista;
	}

	@Override
	public boolean anularReservaAsientosVuelo(long id_vuelo, List<Asiento> asientos) {
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.getTransaction();

		int resultado = 0;
		try {
			for (Asiento a: asientos){
				tx.begin();		
				a.setDisponible(true);
				session.update(a);		

				tx.commit();
			}	

		} catch (HibernateException e) {
			e.printStackTrace();			
		} finally {
			session.close();
			sf.close();
		}
		return (resultado == 1);
	}

	@Override
	public boolean eliminarAsientosVuelo(long id_vuelo) {		
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.getTransaction();
		int count = -1;

		try {		
			
			tx.begin();		
			Query sql = session.createQuery("DELETE Asiento a WHERE a.vuelo.Id=:id_vuelo");
			sql.setLong("id_vuelo", id_vuelo);
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
	public List<Vuelo> consultarVuelosNacionales()  {
		List<Vuelo> lista = new ArrayList<Vuelo>();

		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();
		try {
			Query sql = session
					.createQuery("SELECT distinct v FROM Vuelo v left join fetch v.origen left join fetch v.destino "
							+ "left join fetch v.compannia left join fetch v.asientos left join fetch v.reservasIda "
							+ "left join fetch v.reservasVuelta WHERE upper(v.origen.pais)='ESPAÑA' AND upper(v.destino.pais)='ESPAÑA'" +
							" AND v.diaSalida >=:hoy ORDER BY v.diaSalida ASC");						
			sql.setDate("hoy", Fecha.fechaSinHora(new Date()));
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
	public List<Vuelo> consultarVuelosInternacionales()  {
		List<Vuelo> lista = new ArrayList<Vuelo>();

		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();
		try {
			Query sql = session
					.createQuery("SELECT distinct v FROM Vuelo v left join fetch v.origen left join fetch v.destino "
							+ "left join fetch v.compannia left join fetch v.asientos left join fetch v.reservasIda "
							+ "left join fetch v.reservasVuelta WHERE upper(v.origen.pais)='ESPAÑA' AND upper(v.destino.pais)<>'ESPAÑA'" +
							" AND v.diaSalida >=:hoy ORDER BY v.diaSalida ASC");						
			sql.setDate("hoy",Fecha.fechaSinHora(new Date()));
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
	public List<Vuelo> consultarVuelos(long origen, long destino) {
		List<Vuelo> lista = new ArrayList<Vuelo>();

		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();
		try {
			Query sql = session
					.createQuery("SELECT distinct v FROM Vuelo v left join fetch v.origen left join fetch v.destino "
							+ "left join fetch v.compannia left join fetch v.asientos left join fetch v.reservasIda "
							+ "left join fetch v.reservasVuelta WHERE v.origen.Id=:id_origen AND v.destino.Id=:id_destino" +
							" AND v.diaSalida >=:dia_salida");
			sql.setLong("id_destino", destino);
			sql.setLong("id_origen", origen);
			sql.setDate("dia_salida", new Date());			
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
	public List<Vuelo> consultarVuelosDestino(long destino) {
		List<Vuelo> lista = new ArrayList<Vuelo>();

		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();
		try {
			Query sql = session
					.createQuery("SELECT distinct v FROM Vuelo v left join fetch v.origen left join fetch v.destino "
							+ "left join fetch v.compannia left join fetch v.asientos left join fetch v.reservasIda "
							+ "left join fetch v.reservasVuelta WHERE v.destino.Id=:id_destino" +
							" AND upper(v.origen.pais)='ESPAÑA' AND v.diaSalida >=:dia_salida");
			sql.setLong("id_destino", destino);			
			sql.setDate("dia_salida", new Date());			
			lista = sql.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
			sf.close();
		}
		return lista;
	}
	

}
