package br.com.sattra.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.ParseConversionEvent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.sattra.api.Validation;
import br.com.sattra.dao.ClienteDAO;
import br.com.sattra.dao.EnderecoDAO;
import br.com.sattra.exception.CPFValidationException;
import br.com.sattra.model.Cliente;
import br.com.sattra.model.Endereco;
import br.com.sattra.viacep.ClienteWs;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	boolean cepVerificado = false;

	@RequestMapping(value = "/paginaCadastroCliente", method = RequestMethod.GET)
	public ModelAndView paginaCadastroCliente() {
		Cliente cliente = new Cliente();
		ModelAndView modelAndView = new ModelAndView("cliente", "command", cliente);	
		return modelAndView;
	}
	@RequestMapping(value = "/listaClientes", method = RequestMethod.GET)
	public ModelAndView paginaListarCliente(@RequestParam(value = "cpf", required = false) Long cpf, ModelMap model) {

		ModelAndView modelAndView = new ModelAndView("listaClientes");
		modelAndView.addAllObjects(model);
		if(cpf != null) {
			ClienteDAO clienteDAO = new ClienteDAO();
			List<Cliente> clientes = clienteDAO.buscarCliente();				
			model.addAttribute("clientes", clientes);
		}					
		modelAndView.addAllObjects(model);
		return modelAndView;
	}
	@RequestMapping(value = "/cadastroCliente", method = RequestMethod.POST)
	public ModelAndView adicionarCliente(@ModelAttribute("cliente") Cliente cliente, ModelMap model,
			HttpServletRequest request) {

		boolean deuErro = false;	
		try {			
			Validation.validaCPF(cliente.getCpf());			
		}
		catch(CPFValidationException cpfException) {						
			model.addAttribute("error_cpc", cpfException.getMessage());	
			deuErro = true;
		}
		if ((cliente.getEndereco().getCep() != null || cliente.getEndereco().getCep() != "") && !cepVerificado) {
			try {
				Endereco endereco = ClienteWs.getEnderecoPorCep(cliente.getEndereco().getCep());
				cliente.setEndereco(endereco);	
				ModelAndView modelAndView = new ModelAndView("cliente", "command", cliente);
				modelAndView.addAllObjects(model);
				cepVerificado = true;
				if(endereco == null) {
					cepVerificado = false;
				}
				return modelAndView;				
			}
			catch (Exception e) {
				// TODO: handle exception
				model.addAttribute("error_cep", "Endereco não encontrado");	
				deuErro = true;
				cepVerificado = false;
			}			
		}
		if(deuErro) {
			ModelAndView modelAndView = new ModelAndView("cliente", "command", cliente);
			modelAndView.addAllObjects(model);
			return modelAndView;
		}
		
		ClienteDAO clienteDAO = new ClienteDAO();
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		System.out.println("Endereco:"+ cliente.getEndereco().getCep());
		enderecoDAO.inserirEndereco(cliente.getEndereco());
		Long codEndereco = Long.valueOf(enderecoDAO.ultimoEnderecoInserido());
		cliente.getEndereco().setCodEndereco(codEndereco);
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
	public ModelAndView buscarCliente(@RequestParam(value = "cpf", required = false) Long cpf, ModelMap model) {

		Cliente cliente = new Cliente();
		if(cpf !=null) {
			ClienteDAO clienteDAO = new ClienteDAO();		
			List<Cliente> clientes = clienteDAO.buscarCliente(cpf);			
			if(clientes.size() > 0) {
				cliente = clientes.get(0);
			}		
			else {
				model.addAttribute("error", "Cliente não encontrado");
			}
		}		
		ModelAndView modelAndView = new ModelAndView("editarCliente", "command", cliente);
		modelAndView.addAllObjects(model);
		return modelAndView;
	}
	@RequestMapping(value = "/buscaCliente", method = RequestMethod.POST)
	public ModelAndView editarCliente(@RequestParam(value = "cpf", required = false) Long cpf, ModelMap model) {

		Cliente cliente = new Cliente();
		if(cpf !=null) {
			ClienteDAO clienteDAO = new ClienteDAO();
			List<Cliente> clientes = clienteDAO.buscarCliente(cpf);
			if(clientes.size() > 0) {
				cliente = clientes.get(0);
			}						
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
