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
import org.springframework.web.servlet.ModelAndView;

import br.com.sattra.model.Cliente;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@RequestMapping(value = "/paginaCadastroCliente", method = RequestMethod.GET)
	public ModelAndView paginaCadastroCliente() {

		ModelAndView modelAndView = new ModelAndView("cliente", "command", new Cliente());		
		return modelAndView;
	}
	
//antigo redirecionamento para cliente (arquivo cliente_old) sem Model
//	@RequestMapping(value = "/cliente", method = RequestMethod.GET)
//	public String formCliente() {	
//
//		return "cliente";
//	}

	@RequestMapping(value = "/cadastroCliente", method = RequestMethod.POST)
	public String adicionarCliente(@ModelAttribute("cliente") Cliente cliente,  ModelMap model,
			HttpServletRequest request) {
		
		  

		model.addAttribute("nome", cliente.getNome());
		model.addAttribute("cpf", cliente.getCpf());
		model.addAttribute("contatos", cliente.getContatos());
		model.addAttribute("email", cliente.getEmail());
		model.addAttribute("telefone", cliente.getTelefone());
		
		
		
		///model.addAttribute("endereco", cliente.getEndereco());
	

		List<Cliente> clientes = (List<Cliente>) request.getSession().getAttribute("clientes");
		if (clientes == null) {
			clientes = new ArrayList<Cliente>();
		}
		clientes.add(cliente);
		request.getSession().setAttribute("clientes", clientes);

		return "exibeCliente";
	}

	@RequestMapping(value = "/listaClientes", method = RequestMethod.GET)
	public String listarClientes(@ModelAttribute("cliente") ModelMap model, HttpServletRequest request) {

		List<Cliente> clientes = (List<Cliente>) request.getAttribute("clientes");

		model.addAttribute("clientes", clientes);

		return "listaClientes";
	}
}


