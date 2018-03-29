package br.com.sattra.testCase;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.sattra.dao.ClienteDAO;
import br.com.sattra.model.Cliente;

public class ClienteDAOTest {

	@Test
	public void testInserirCliente() {
									
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.inserirCliente(mockCliente());
	}
	
	@Test
	public void testSalvarTXT() {
									
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.salvarTXT(mockCliente());
	}

	public Cliente mockCliente() {
		Cliente cliente = new Cliente();
		cliente.setNome("Daniel");
		cliente.setContatos("Pessoa 1 e 2");
		cliente.setCpf(123456789);
		cliente.setTelefone("32611111");
		cliente.setEmail("email@gmail.com");
		
		return cliente;
	}
}

