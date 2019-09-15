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
import com.imoveis.raymara2.repositorio.Imoveis;
import com.imoveis.raymara2.repositorio.Profissionais;
import com.imoveis.raymara2.repositorio.TipoImoveis;
import com.imoveis.raymara2.repositorio.filtro.ImovelFiltro;
import com.imoveis.raymara2.servico.ImovelServico;
import com.imoveis.raymara2.modelo.Cliente;
import com.imoveis.raymara2.modelo.Imovel;
import com.imoveis.raymara2.modelo.Profissional;
import com.imoveis.raymara2.modelo.TipoImovel;

@Controller
@RequestMapping("/imovel")
public class ImovelControle {
	
	private static final String FORM_IMOVEL = "imovel/form-imovel";
	private static final String LISTA_IMOVEL = "imovel/lista-imovel";
	private static final String PESQUISA_IMOVEL = "imovel/pesquisa-imovel";

	@Autowired
	private ImovelServico imovelservico;
	
	@Autowired
	private Clientes clientes;
	
	@ModelAttribute("clientes")
	public List<Cliente> todoClientes() {
		return clientes.findAll();
	}
	
	@Autowired
	private TipoImoveis tipoimoveis;
	
	@ModelAttribute("tipoimoveis")
	public List<TipoImovel> todoTipoImoveis() {
		return tipoimoveis.findAll();
	}
	
	@GetMapping("/form")
	public String form(Imovel imovel) {
		return FORM_IMOVEL;
	}
	
	@PostMapping("/salva")
	public String salva(@Validated Imovel imovel, Errors validacao, RedirectAttributes redirect) {	
		if ( validacao.hasErrors()) {
			return FORM_IMOVEL;
		}
		imovelservico.salva(imovel);
		
		redirect.addFlashAttribute("mensagem", "Imovel [" + imovel.getNome() + "] foi salvo com sucesso");
		String rota = imovel.ehNovo() ? "redirect:/imovel/form" : "redirect:/imovel/lista";
    	return rota;
	}
	
	@GetMapping("/lista")
	public ModelAndView listagem() {
		ModelAndView modelAndView = new ModelAndView("imovel/lista-imovel");		
		modelAndView.addObject("imoveis", imovelservico.todosImoveis() );
		return modelAndView;	
	}
	
	@GetMapping("/edicao/{codigo}")
	public ModelAndView edicao(@PathVariable("codigo") Imovel imovel) {
		ModelAndView modelAndView = new ModelAndView(FORM_IMOVEL);
		modelAndView.addObject("imovel", imovel);		
		return modelAndView;
	}	
	
	@GetMapping("/pesquisa")
	public ModelAndView pesquisar(ImovelFiltro filtro, BindingResult result ) {
		ModelAndView modelAndView = new ModelAndView(PESQUISA_IMOVEL);
		modelAndView.addObject("imoveis", imovelservico.filtrar(filtro));
		return modelAndView;
	}
}
