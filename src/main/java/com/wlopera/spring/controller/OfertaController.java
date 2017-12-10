package com.wlopera.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wlopera.spring.negocio.GestorOfertas;

@Controller
@RequestMapping("/listaOfertas.wrl")
public class OfertaController {

	@Autowired
	private GestorOfertas gestor;
	
	public OfertaController() {
		System.out.println("##=> Creando OfertaController");
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView ListaOfertaController(@RequestParam("idMes") int idMes) {
		
		System.out.println("##=> Procesar url: http://localhost:8080/HotelSpring/listaOfertas.wrl?idMes=1");
		System.out.println("##=< idMes: "+ idMes);
		ModelAndView  modelo = new ModelAndView("listaOfertas");
		
		modelo.addObject("ofertas", gestor.getOfertasDelMes(idMes));
		
		return modelo;
		
	}
	

}
