package com.imoveis.raymara2.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import com.imoveis.raymara2.repositorio.Imoveis;
import com.imoveis.raymara2.repositorio.Profissionais;
import com.imoveis.raymara2.servico.ClienteServico;
import com.imoveis.raymara2.servico.LocacaoServico;
import com.imoveis.raymara2.modelo.Cliente;
import com.imoveis.raymara2.modelo.Imovel;
import com.imoveis.raymara2.modelo.Locacao;
import com.imoveis.raymara2.modelo.Profissional;

@Controller
@RequestMapping("/locacao")
public class LocacaoControle {
	
	private static final String FORM_LOCACAO = "locacao/form-locacao";
	private static final String LISTA_LOCACAO = "locacao/lista-locacao";
	private static final String PESQUISA_LOCACAO = "locacao/pesquisa-locacao";

	@Autowired
	private Imoveis imoveis;
	
	@ModelAttribute("imoveis")
	public List<Imovel> todoImoveis() {
		return imoveis.findAll();
	}
	
	@Autowired
	private Clientes clientes;
	
	@ModelAttribute("clientes")
	public List<Cliente> todoClientes() {
		return clientes.findAll();
	}
	
	@Autowired
	private Profissionais profissionais;
	
	@ModelAttribute("profissionais")
	public List<Profissional> todoProfissionais() {
		return profissionais.findAll();
	}
	
	
	@Autowired
	private LocacaoServico locacaoservico;
	
	@GetMapping("/form")
	public String form(Locacao locacao) {
		return FORM_LOCACAO;
	}
	
	@PostMapping("/salva")
	public String salva(@Validated Locacao locacao, Errors validacao, RedirectAttributes redirect) {	
		if ( validacao.hasErrors()) {
			return FORM_LOCACAO;
		}
		locacaoservico.salva(locacao);
		
		redirect.addFlashAttribute("mensagem", "Locacao [" + locacao.getNome() + "] foi salvo com sucesso");
		String rota = locacao.ehNovo() ? "redirect:/locacao/form" : "redirect:/locacao/lista";
    	return rota;
	}
	
	@GetMapping("/lista")
	public ModelAndView listagem() {
		ModelAndView modelAndView = new ModelAndView("locacao/lista-locacao");		
		modelAndView.addObject("locacoes", locacaoservico.todosLocacoes() );
		return modelAndView;	
	}
	
	@GetMapping("/edicao/{codigo}")
	public ModelAndView edicao(@PathVariable("codigo") Locacao locacao) {
		ModelAndView modelAndView = new ModelAndView(FORM_LOCACAO);
		modelAndView.addObject("locacao", locacao);		
		return modelAndView;
	}	
}
