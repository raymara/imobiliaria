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

import com.imoveis.raymara2.modelo.TipoImovel;
import com.imoveis.raymara2.servico.TipoImovelServico;

@Controller
@RequestMapping("/tipoimovel")
public class TipoImovelControle {
	
	private static final String FORM_TIPOIMOVEL = "form-tipoimovel";

	@Autowired
	private TipoImovelServico tipoimovelservico;
	
	@GetMapping("/form")
	public String form(TipoImovel tipoimovel) {
		return FORM_TIPOIMOVEL;
	}
	
	@PostMapping("/salva")
	public String salva(@Validated TipoImovel tipoimovel, Errors validacao, RedirectAttributes redirect) {	
		if ( validacao.hasErrors()) {
			return FORM_TIPOIMOVEL;
		}
		tipoimovelservico.salva(tipoimovel);
		
		redirect.addFlashAttribute("mensagem", "TipoImovel [" + tipoimovel.getDescricao() + "] foi salvo com sucesso");
		return "redirect:/tipoimovel/form";
	}
	
	@GetMapping("/lista")
	public ModelAndView listagem() {
		ModelAndView modelAndView = new ModelAndView("lista-tipoimovel");		
		modelAndView.addObject("tipoimoveis", tipoimovelservico.todosTipoImoveis() );
		return modelAndView;	
	}
	
	@GetMapping("/edicao/{codigo}")
	public ModelAndView edicao(@PathVariable("codigo") TipoImovel tipoimovel) {
		ModelAndView modelAndView = new ModelAndView(FORM_TIPOIMOVEL);
		modelAndView.addObject("tipoimovel", tipoimovel);		
		return modelAndView;
	}
}
