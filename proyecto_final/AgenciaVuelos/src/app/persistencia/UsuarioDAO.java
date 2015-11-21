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

import app.modelo.AdminCompannia;
import app.modelo.Cliente;
import app.modelo.Compannia;
import app.modelo.Pasajero;
import app.modelo.Usuario;

public class UsuarioDAO implements ItfzUsuario {

	@Override
	public boolean altaUsuario(Usuario usuario) {
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.getTransaction();

		boolean resultado = false;

		try {
			tx.begin();

			session.save(usuario);

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
	public boolean altaCliente(Cliente cliente) {
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.getTransaction();

		boolean resultado = false;

		try {
			tx.begin();

			session.save(cliente);

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
	public boolean altaAdminCompannia(AdminCompannia adminCompannia) {
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.getTransaction();

		boolean resultado = false;

		try {
			tx.begin();
			
			
			session.save(adminCompannia);

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
	public boolean editarUsuario(Usuario usuario, long id){
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.getTransaction();

		int resultado = 0;
		try {
			tx.begin();		
			
			session.update(usuario);		
			

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
	public boolean editarCliente(Cliente cliente, long id)  {
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.getTransaction();

		int resultado = 0;
		try {
			tx.begin();		
			
			session.update(cliente);		
			

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
	public boolean editarAdminCompannia(AdminCompannia adminCompannia, long id) {
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.getTransaction();

		int resultado = 0;
		try {
			tx.begin();		
			
			session.update(adminCompannia);
			
			

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
	public boolean eliminarAdministrador(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminarCliente(long id) {		
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.getTransaction();
		int count = -1;

		try {		
			
			tx.begin();		
			Query sql = session.createQuery("DELETE Cliente c WHERE c.Id=:id_cliente");
			sql.setLong("id_cliente", id);
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
	public boolean eliminarAdminCompannia(long id){		
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.getTransaction();
		int count = -1;

		try {		
			
			tx.begin();		
			Query sql = session.createQuery("DELETE AdminCompannia a WHERE a.Id=:id_admin");
			sql.setLong("id_admin", id);
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
	public List<Cliente> consultarClientes() {
		List<Cliente> lista = new ArrayList<Cliente>();

		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();

		try {
			Query sql = session.createQuery("SELECT c FROM Cliente c ");			
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
	public String ConsultaPass(String nick) {
		String pass="";

		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();

		try {
			String consulta = "SELECT PASS FROM usuario WHERE nick='"+nick+"'";
			Query sqlClasico = session.createSQLQuery(consulta);				
			pass = (String) sqlClasico.uniqueResult();				
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
			sf.close();
		}
		return pass;
	
	}

	@Override
	public List<AdminCompannia> consultarAdminCompannias() {
		List<AdminCompannia> lista = new ArrayList<AdminCompannia>();

		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();

		try {
			Query sql = session.createQuery("SELECT a FROM AdminCompannia a left join fetch a.compannia");			
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
	public AdminCompannia consultarAdminCompannias(long id) {
		AdminCompannia admin = new AdminCompannia();
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();

		try {			
			admin = (AdminCompannia)session.get(AdminCompannia.class, id);
			Hibernate.initialize(admin.getCompannia());
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
			sf.close();
		}
		return admin;
	}
    @Override
	public Cliente consultarCliente(long id){
		Cliente cliente = new Cliente();
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();

		try {			
			cliente = (Cliente)session.get(Cliente.class, id);
			Hibernate.initialize(cliente.getReservas());
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
			sf.close();
		}
		return cliente;
	}

	@Override
	public Pasajero consultarPasajero(String dni){
		Pasajero p = null;

		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();

		try {
			Query sql = session.createQuery("SELECT p FROM Pasajero p WHERE p.dni=:dni");
			sql.setString("dni", dni);
			p=(Pasajero)sql.uniqueResult();				
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
			sf.close();
		}
		return p;
	}

	@Override
	public AdminCompannia consultarAdminCompanniasNick(String nick)  {
		AdminCompannia a =null;

		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();

		try {
			Query sql = session.createQuery("SELECT a FROM AdminCompannia a left join fetch a.compannia WHERE a.nick=:nick");
			sql.setString("nick", nick);
			a = (AdminCompannia)sql.uniqueResult();				
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
			sf.close();
		}
		return a;
	}
	
	
	
	@Override
	public Usuario ConsultaUsuario(String nick){
		Usuario u =null;

		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();

		try {
			Query sql = session.createQuery("SELECT u FROM Usuario u WHERE u.nick=:nick");
			sql.setString("nick", nick);
			u = (Usuario)sql.uniqueResult();				
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
			sf.close();
		}
		return u;
	}

	@Override
	public AdminCompannia consultarAdminCompanniasDni(String dni)  {
		AdminCompannia a =null;

		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();

		try {
			Query sql = session.createQuery("SELECT a FROM AdminCompannia a left join fetch a.compannia WHERE a.dni=:dni");
			sql.setString("dni", dni);
			a = (AdminCompannia)sql.uniqueResult();				
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
			sf.close();
		}
		return a;
	}

	@Override
	public AdminCompannia consultarAdminCompanniasEmail(String email) {
		AdminCompannia a =null;

		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();

		try {
			Query sql = session.createQuery("SELECT a FROM AdminCompannia a left join fetch a.compannia WHERE a.email=:email");
			sql.setString("email", email);
			a = (AdminCompannia)sql.uniqueResult();				
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
			sf.close();
		}
		return a;
	}

	@Override
	public AdminCompannia consultarAdminCompanniasRegistro(long numRegistro) {
		AdminCompannia a =null;

		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();

		try {
			Query sql = session.createQuery("SELECT a FROM AdminCompannia a left join fetch a.compannia WHERE a.numRegistro=:numRegistro");
			sql.setLong("numRegistro", numRegistro);
			a = (AdminCompannia)sql.uniqueResult();				
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
			sf.close();
		}
		return a;
	}

	@Override
	public List<Usuario> ConsultaUsuarios() {
		List<Usuario> lista = new ArrayList<Usuario>();

		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();

		try {
			Query sql = session.createQuery("SELECT u FROM Usuario u ");			
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
	public Usuario consultarUsuario(long id) {
		Usuario usuario = new Cliente();
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();

		try {			
			usuario = (Usuario)session.get(Usuario.class, id);			
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
			sf.close();
		}
		return usuario;
	}

	@Override
	public Cliente consultarClientesEmail(String email) {
		Cliente c =null;

		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();

		try {
			Query sql = session.createQuery("SELECT c FROM Cliente c  WHERE c.email=:email");
			sql.setString("email", email);
			c = (Cliente)sql.uniqueResult();				
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
			sf.close();
		}
		return c;
	}

	@Override
	public Cliente consultarClientesNumero(long numCliente) {
		Cliente cliente =null;

		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();

		try {
			Query sql = session.createQuery("SELECT c FROM Cliente c WHERE c.numCliente=:numCliente");
			sql.setLong("numCliente", numCliente);
			cliente = (Cliente)sql.uniqueResult();				
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
			sf.close();
		}
		return cliente;
	}


	@Override
	public Cliente consultarClientesDni(String dni) {
		Cliente c =null;

		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session session = sf.openSession();

		try {
			Query sql = session.createQuery("SELECT c FROM Cliente c WHERE c.dni=:dni");
			sql.setString("dni", dni);
			c = (Cliente)sql.uniqueResult();				
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
			sf.close();
		}
		return c;
	}
	
    
}
