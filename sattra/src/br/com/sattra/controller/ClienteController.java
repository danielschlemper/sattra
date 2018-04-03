package br.com.sattra.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.sattra.dao.ClienteDAO;
import br.com.sattra.model.Cliente;
import br.com.sattra.model.Endereco;
import br.com.sattra.viacep.ClienteWs;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	boolean cepVerificado = false;

	@RequestMapping(value = "/listaClientes", method = RequestMethod.GET)
	public ModelAndView paginaListarCliente(@RequestParam(value = "nome", required = false) Long cpf, ModelMap model) {

		ModelAndView modelAndView = new ModelAndView("listaClientes");
		modelAndView.addAllObjects(model);
		if(cpf != null) {
			ClienteDAO clienteDAO = new ClienteDAO();
			List<Cliente> clientes = clienteDAO.buscarCliente(cpf);				
			model.addAttribute("clientes", clientes);
		}					
		modelAndView.addAllObjects(model);
		return modelAndView;
	}

	@RequestMapping(value = "/cadastroCliente", method = RequestMethod.POST)
	public ModelAndView adicionarCliente(@ModelAttribute("cliente") Cliente cliente, ModelMap model,
			HttpServletRequest request) {

		if ((cliente.getEndereco().getCep() != null || cliente.getEndereco().getCep() != "") && !cepVerificado) {

			Endereco endereco = ClienteWs.getEnderecoPorCep(cliente.getEndereco().getCep());
			cliente.setEndereco(endereco);
			ModelAndView modelAndView = new ModelAndView("cliente", "command", cliente);
			cepVerificado = true;
			return modelAndView;
		}

		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.inserirCliente(cliente);

		/// model.addAttribute("endereco", cliente.getEndereco());
		model.addAttribute("nome", cliente.getNome());
		model.addAttribute("cpf", cliente.getCpf());
		model.addAttribute("contatos", cliente.getContatos());
		model.addAttribute("email", cliente.getEmail());
		model.addAttribute("telefone", cliente.getTelefone());
		model.addAttribute("logradouro", cliente.getNome());
		model.addAttribute("numero", cliente.getCpf());
		model.addAttribute("complemento", cliente.getContatos());
		model.addAttribute("bairro", cliente.getEmail());
		model.addAttribute("localidade", cliente.getTelefone());
		model.addAttribute("uf", cliente.getTelefone());
		ModelAndView modelAndView = new ModelAndView("exibeCliente", "command", cliente);
		return modelAndView;		
	}
	
	@RequestMapping(value = "/buscaCliente", method = RequestMethod.GET)
	public ModelAndView buscarCliente(@RequestParam(value = "nome", required = false) Long cpf, ModelMap model) {

		Cliente cliente = new Cliente();
		if(cpf !=null) {
			ClienteDAO clienteDAO = new ClienteDAO();
			List<Cliente> clientes = clienteDAO.buscarCliente(cpf);	
			cliente = clientes.get(0);			
		}		
		ModelAndView modelAndView = new ModelAndView("editarCliente", "command", cliente);		
		return modelAndView;
	}
	
	@RequestMapping(value = "/editarCliente", method = RequestMethod.POST)
	public ModelAndView editarCliente(@ModelAttribute("cliente") Cliente cliente, ModelMap model,
			HttpServletRequest request) {	

		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.inserirCliente(cliente);

		/// model.addAttribute("endereco", cliente.getEndereco());
		model.addAttribute("nome", cliente.getNome());
		model.addAttribute("cpf", cliente.getCpf());
		model.addAttribute("contatos", cliente.getContatos());
		model.addAttribute("email", cliente.getEmail());
		model.addAttribute("telefone", cliente.getTelefone());
		model.addAttribute("logradouro", cliente.getNome());
		model.addAttribute("numero", cliente.getCpf());
		model.addAttribute("complemento", cliente.getContatos());
		model.addAttribute("bairro", cliente.getEmail());
		model.addAttribute("localidade", cliente.getTelefone());
		model.addAttribute("uf", cliente.getTelefone());
		ModelAndView modelAndView = new ModelAndView("exibeCliente", "command", cliente);
		return modelAndView;		
	}
	// antigo redirecionamento para cliente (arquivo cliente_old) sem Model
	// @RequestMapping(value = "/cliente", method = RequestMethod.GET)
	// public String formCliente() {
	//
	// return "cliente";
	// }

	// Antiga chamada para pagina listar clientes
	// @RequestMapping(value = "/listaClientes", method = RequestMethod.GET)
	// public String listarClientes(@ModelAttribute("cliente") ModelMap model,
	// HttpServletRequest request) {
	//
	// List<Cliente> clientes = (List<Cliente>) request.getAttribute("clientes");
	//
	// model.addAttribute("clientes", clientes);
	//
	// return "listaClientes";
	// }
}
