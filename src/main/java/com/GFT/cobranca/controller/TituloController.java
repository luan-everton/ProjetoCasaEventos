package com.GFT.cobranca.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.GFT.cobranca.model.StatusTitulo;
import com.GFT.cobranca.model.Titulo;
import com.GFT.cobranca.repository.Titulos;



@Controller
public class TituloController {
	private static final String CADASTRO_VIEW = "financa";
	private static final String CASA_VIEW = "CadastroCasa";
	private static final String CASA_HOME = "home";

	
	
	
	
	
	
	@GetMapping("/Cadastro")
	public ModelAndView Cadastro() {
		ModelAndView mv = new ModelAndView(CASA_VIEW);
		mv.addObject(new Titulo());

		return  mv;
	

	}
	
	@Autowired
	private Titulos titulos;
	
	
	
	
	@RequestMapping("/home")
	public ModelAndView home() {
	ModelAndView mv = new ModelAndView(CASA_HOME);
	mv.addObject(new Titulo());
    return mv;
	}
	
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
	ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
	mv.addObject(new Titulo());
    return mv;
	}
	
	@RequestMapping("/")
	public ModelAndView barra() {
	ModelAndView mv = new ModelAndView(CASA_HOME);
	mv.addObject(new Titulo());
    return mv;
	}
	
	
	@PostMapping(value = CASA_VIEW)
	public String salvar(Titulo titulo) {
		titulos.save(titulo);
		return CASA_VIEW;
	}
	
	@RequestMapping(method = RequestMethod.POST )
	public String salvar(@Validated Titulo titulo,  Errors errors ,RedirectAttributes attributes) {
		
		
		if (errors.hasErrors())
			return CADASTRO_VIEW;
		
		
		
			titulos.save(titulo);
			attributes.addFlashAttribute("mensagem", "Evento cadastrado com sucesso");
			
		return "redirect:/novo";
     
	} 
	
	
	@RequestMapping("/pesquisa")
	public ModelAndView pesquisar() {
		List<Titulo> todosTitulos = titulos.findAll();
		ModelAndView mv = new ModelAndView("pesquisa");
		mv.addObject("titulos", todosTitulos);
		return mv;
	}
	
	@RequestMapping("{codigo}")
	public ModelAndView edicao(@PathVariable("codigo") Titulo titulo) {
		
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
	
	
}
	
	
	



