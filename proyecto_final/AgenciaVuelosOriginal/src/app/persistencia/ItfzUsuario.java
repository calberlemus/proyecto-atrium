package app.persistencia;
import app.modelo.*;
import java.util.List;
public interface ItfzUsuario {
	
	public boolean altaUsuario(Usuario usuario);
	public boolean altaCliente(Cliente cliente);
	public boolean altaAdminCompannia(AdminCompannia adminCompannia);
	
	public boolean editarUsuario(Usuario usuario, long id);
	public boolean editarCliente(Cliente cliente, long id);
	public boolean editarAdminCompannia(AdminCompannia adminCompannia, long id);
	
	public boolean eliminarAdministrador(long id);
	public boolean eliminarCliente(long id);
	public boolean eliminarAdminCompannia(long id);
	
	
	public List<Cliente> consultarClientes();
	public Cliente consultarCliente(long id);
	public Pasajero consultarPasajero(String dni);
	public List<AdminCompannia> consultarAdminCompannias();
	public AdminCompannia consultarAdminCompannias(long id);
	public AdminCompannia consultarAdminCompanniasNick(String nick);
	public AdminCompannia consultarAdminCompanniasDni(String dni);
	public AdminCompannia consultarAdminCompanniasEmail(String email);
	public AdminCompannia consultarAdminCompanniasRegistro(long numRegistro);
	
	public Cliente consultarClientesEmail(String email);
	public Cliente consultarClientesNumero(long numCliente);
	public Cliente consultarClientesDni(String dni);
	
	public String ConsultaPass(String nick);
	public Usuario ConsultaUsuario(String nick);
	public List<Usuario> ConsultaUsuarios();
	public Usuario consultarUsuario(long id);

}
