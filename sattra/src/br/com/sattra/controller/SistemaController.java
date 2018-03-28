package br.com.sattra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.sattra.dao.ClienteDAO;
import br.com.sattra.model.Cliente;

@Controller
@RequestMapping("/sistema")
public class SistemaController {
	@RequestMapping(value = "/paginaCadastroCliente", method = RequestMethod.GET)
	public ModelAndView paginaCadastroCliente() {

		ModelAndView modelAndView = new ModelAndView("cliente");	
		return modelAndView;
	}
	@RequestMapping(value = "/paginaEditarCliente", method = RequestMethod.GET)
	public ModelAndView paginaEditarCliente() {

		ModelAndView modelAndView = new ModelAndView("clienteEditar");	
		return modelAndView;
	}
	@RequestMapping(value = "/paginaInserirCliente", method = RequestMethod.GET)
	public ModelAndView paginaInserirCliente() {

		Cliente cliente = new Cliente();
		cliente.setNome("Daniel");
		cliente.setContatos("Pessoa 1 e 2");
		cliente.setCpf(123456789);
		cliente.setTelefone("32611111");
		cliente.setEmail("email@gmail.com");		
		
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.inserirCliente(cliente);
		
		ModelAndView modelAndView = new ModelAndView("clienteEditar");	
		return modelAndView;
	}
	
}