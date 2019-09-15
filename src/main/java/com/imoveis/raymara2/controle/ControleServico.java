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

import com.imoveis.raymara2.repositorio.Imoveis;
import com.imoveis.raymara2.repositorio.Profissionais;
import com.imoveis.raymara2.repositorio.Servicos;
import com.imoveis.raymara2.servico.ServicoServico;

import com.imoveis.raymara2.modelo.Imovel;
import com.imoveis.raymara2.modelo.Profissional;
import com.imoveis.raymara2.modelo.Servico;

@Controller
@RequestMapping("/servico")
public class ControleServico {
	
	private static final String FORM_SERVICO = "servico/form-servico";
	private static final String LISTA_SERVICO = "servico/lista-servico";
	private static final String PESQUISA_SERVICO = "servico/pesquisa-servico";

	@Autowired
	private ServicoServico servicoservico;
	
	@Autowired
	private Profissionais profissionais;
	
	@ModelAttribute("profissionais")
	public List<Profissional> todoProfissionais() {
		return profissionais.findAll();
	}
	
	@Autowired
	private Imoveis imoveis;
	
	@ModelAttribute("imoveis")
	public List<Imovel> todoImoveis() {
		return imoveis.findAll();
	}
	
	@GetMapping("/form")
	public String form(Servico servico) {
		return FORM_SERVICO;
	}
	
	@PostMapping("/salva")
	public String salva(@Validated Servico servico, Errors validacao, RedirectAttributes redirect) {	
		if ( validacao.hasErrors()) {
			return FORM_SERVICO;
		}
		servicoservico.salva(servico);
		
		redirect.addFlashAttribute("mensagem", "Servico foi salvo com sucesso");
		String rota = servico.ehNovo() ? "redirect:/servico/form" : "redirect:/servico/lista";
    	return rota;
	}
	
	@GetMapping("/lista")
	public ModelAndView listagem() {
		ModelAndView modelAndView = new ModelAndView("servico/lista-servico");		
		modelAndView.addObject("servicos", servicoservico.todosServicos() );
		return modelAndView;	
	}
	
	@GetMapping("/edicao/{codigo}")
	public ModelAndView edicao(@PathVariable("codigo") Servico servico) {
		ModelAndView modelAndView = new ModelAndView(FORM_SERVICO);
		modelAndView.addObject("servico", servico);		
		return modelAndView;
	}	
}
