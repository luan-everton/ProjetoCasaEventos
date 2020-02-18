package com.GFT.cobranca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.GFT.cobranca.model.Casa;
import com.GFT.cobranca.repository.CasaRepositorio;



@Controller
public class CasaController {
	private static final String CASA_VIEW = "CadastroCasa";
	private static final String CASA_HOME = "home";
  ;
	
	
	@Autowired
	private CasaRepositorio casas;
	
	
	
	
	
	@GetMapping("/Cadastro")
	public ModelAndView listaCadastroCasa() {
		ModelAndView mv = new ModelAndView(CASA_VIEW);
		List<Casa>listaCasas= casas.findAll();
		mv.addObject(new Casa());
		mv.addObject("casas",listaCasas);

		return  mv;
		
	}
	
	@PostMapping("/Cadastro")
	public String CadastroPost( Casa casa , RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView(CASA_VIEW);
		
		casas.save(casa);
		mv.addObject(new Casa());
		attributes.addFlashAttribute("mensagem", " Casa cadastrada  com sucesso ");

		return  "redirect:/Cadastro";
		
	}
	
	@RequestMapping({"/home","/"})
	public ModelAndView home() {
	ModelAndView mv = new ModelAndView(CASA_HOME);
	mv.addObject(new Casa());
    return mv;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	@GetMapping("/pesquisa")
	public ModelAndView pesquisaShow() {
		ModelAndView mv = new ModelAndView(CASA_PESQUISA);
		mv.addObject(new Casa());

		return  mv;
	
	}
	
	@RequestMapping("/pesquisa")
	public ModelAndView  pesquisaCasa() {
	  List<Casa> todasCasas = casas.findAll();
	  ModelAndView mv = new ModelAndView("pesquisaShow");
	  mv.addObject("listasCasas", todasCasas);
	
		return mv;
	}
	*/
	
	
	
	

	
	/*
	@RequestMapping("{codigo}")
	public ModelAndView edicao(@PathVariable("codigo") Casa titulo) {
		
	ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		
		mv.addObject(titulo);
		return mv;
	
	
	}
	
	@RequestMapping(value="{codigo}", method=RequestMethod.POST)
	public String excluir(@PathVariable Long codigo ,RedirectAttributes attributes) {
		titulos.deleteById(codigo);
		attributes.addFlashAttribute("mensagem", " Evento foi excluido com sucesso ");

		return "redirect:/financa";
	}
	
	
	@ModelAttribute("todosStatusTitulo")
	public List<StatusTitulo> todosStatusTitulo(){
		return  Arrays.asList(StatusTitulo.values());
	}
	
	*/
}
	
	
	



