package br.com.sattra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.sattra.model.Endereco;
import br.com.sattra.viacep.ClienteWs;

@Controller
@RequestMapping("/endereco")
public class EnderecoController {
	@RequestMapping(value = "/paginaBuscarEndereco", method = RequestMethod.GET)
	public ModelAndView paginaCadastroCliente() {

		ModelAndView modelAndView = new ModelAndView("buscarEndereco");
		return modelAndView;
	}

	@RequestMapping(value = "/resultadoEndereco", method = RequestMethod.GET)
	public ModelAndView buscaEndereco(
			@RequestParam(value = "cep", required = false, defaultValue = "88000000") String cep) {

		Endereco endereco = ClienteWs.getEnderecoPorCep(cep);	
		ModelAndView modelAndView = new ModelAndView("resultadoEndereco");
		
		if(endereco == null) {			
		    modelAndView.addObject("mensagem", "Erro: Endereco nao encontrado");
		    return modelAndView;
		}
		
	    modelAndView.addObject("cep", "cep: " + endereco.getCep());
		modelAndView.addObject("logradouro", "logradouro:  " + endereco.getLogradouro());
		modelAndView.addObject("numero", "numero: " + endereco.getNumero());
		modelAndView.addObject("complemento", "complemento: " +endereco.getComplemento());
		modelAndView.addObject("bairro", "bairro: " + endereco.getBairro());

		return modelAndView;
	}
}
