package com.imoveis.raymara2.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.imoveis.raymara2.modelo.Profissional;
import com.imoveis.raymara2.servico.ProfissionalServico;

@Controller
@RequestMapping("/profissional")
public class ProfissionalControle {
	
	private static final String FORM_PROFISSIONAL = "profissional/form-profissional";
	private static final String LISTA_PROFISSIONAL = "profissional/lista-profissional";
	private static final String PESQUISA_PROFISSIONAL = "profissional/pesquisa-profissional";

	@Autowired
	private ProfissionalServico profissionalservico;
	
	@GetMapping("/form")
	public String form(Profissional profissional) {
		return FORM_PROFISSIONAL;
	}
	
	@PostMapping("/salva")
	public String salva(@Validated Profissional profissional, Errors validacao, RedirectAttributes redirect) {	
		if ( validacao.hasErrors()) {
			return FORM_PROFISSIONAL;
		}
		profissionalservico.salva(profissional);
		
		redirect.addFlashAttribute("mensagem", "Profissional [" + profissional.getNome() + "] foi salvo com sucesso");
		String rota = profissional.ehNovo() ? "redirect:/profissional/form" : "redirect:/profissional/lista";
    	return rota;
	}
	
	@GetMapping("/lista")
	public ModelAndView listagem() {
		ModelAndView modelAndView = new ModelAndView(LISTA_PROFISSIONAL);		
		modelAndView.addObject("profissionais", profissionalservico.todosProfissionais() );
		return modelAndView;	
	}
	
	@GetMapping("/edicao/{codigo}")
	public ModelAndView edicao(@PathVariable("codigo") Profissional profissional) {
		ModelAndView modelAndView = new ModelAndView(FORM_PROFISSIONAL);
		modelAndView.addObject("profissional", profissional);		
		return modelAndView;
	}
}
