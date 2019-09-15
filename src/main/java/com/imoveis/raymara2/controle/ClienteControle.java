package com.imoveis.raymara2.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.imoveis.raymara2.repositorio.Clientes;
import com.imoveis.raymara2.repositorio.filtro.ClienteFiltro;
import com.imoveis.raymara2.servico.ClienteServico;
import com.imoveis.raymara2.modelo.Cliente;

@Controller
@RequestMapping("/cliente")
public class ClienteControle {
	
	private static final String FORM_CLIENTE = "cliente/form-cliente";
	private static final String LISTA_CLIENTE = "cliente/lista-cliente";
	private static final String PESQUISA_CLIENTE = "cliente/pesquisa-cliente";

	@Autowired
	private ClienteServico clienteservico;
	
	@GetMapping("/form")
	public String form(Cliente cliente) {
		return FORM_CLIENTE;
	}
	
	@PostMapping("/salva")
	public String salva(@Validated Cliente cliente, Errors validacao, RedirectAttributes redirect) {	
		if ( validacao.hasErrors()) {
			return FORM_CLIENTE;
		}
		clienteservico.salva(cliente);
		
		redirect.addFlashAttribute("mensagem", "Cliente [" + cliente.getNome() + "] foi salvo com sucesso");
		String rota = cliente.ehNovo() ? "redirect:/cliente/form" : "redirect:/cliente/lista";
    	return rota;
	}
	
	@GetMapping("/lista")
	public ModelAndView listagem() {
		ModelAndView modelAndView = new ModelAndView("cliente/lista-cliente");		
		modelAndView.addObject("clientes", clienteservico.todosClientes() );
		return modelAndView;	
	}
	
	@GetMapping("/edicao/{codigo}")
	public ModelAndView edicao(@PathVariable("codigo") Cliente cliente) {
		ModelAndView modelAndView = new ModelAndView(FORM_CLIENTE);
		modelAndView.addObject("cliente", cliente);		
		return modelAndView;
	}	
	
	@GetMapping("/pesquisa")
	public ModelAndView pesquisar(ClienteFiltro filtro, BindingResult result ) {
		ModelAndView modelAndView = new ModelAndView(PESQUISA_CLIENTE);
		modelAndView.addObject("clientes", clienteservico.filtrar(filtro));
		return modelAndView;
	}
}
