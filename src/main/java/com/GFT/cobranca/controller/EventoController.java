package com.GFT.cobranca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.GFT.cobranca.model.Evento;
import com.GFT.cobranca.repository.EventoRepositorio;

@Controller
public class EventoController {
	private static final String CADASTRO_VIEW = "CadastroEvento";
  
	
	@Autowired
	  private EventoRepositorio eventos;

	
	@GetMapping("/novo")
	public ModelAndView novo() {
	ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
	mv.addObject(new Evento());
    return mv;
	}
	
	@PostMapping("/novo")
	public ModelAndView CadastrarEventos(Evento evento , RedirectAttributes attributes) {
	ModelAndView mv = new ModelAndView("redirect:/novo");
	eventos.save(evento);
	
	mv.addObject(new Evento());
	
	attributes.addFlashAttribute("mensagem", " Evento  cadastrado com sucesso ");
	
    return mv;
	}
	
	
	
}
