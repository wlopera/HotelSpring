package com.wlopera.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.wlopera.spring.dominio.Formulario;
import com.wlopera.spring.dominio.Mes;
import com.wlopera.spring.negocio.GestorOfertas;
import com.wlopera.spring.validator.OfertaValidator;

@Controller
@RequestMapping("/listaOfertas.wrl")
public class OfertaController {

	@Autowired
	private GestorOfertas gestor;

	@Autowired
	OfertaValidator validator;
	
	public OfertaController() {
		System.out.println("##=> Creando OfertaController");
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView preparaForm() {

		ModelAndView modelo = new ModelAndView("consultaData");
		Formulario formulario = new Formulario();
		formulario.setMes(new Integer(0));

		modelo.addObject("formulario", formulario);

		return modelo;

	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView procesaForm(Formulario formulario, BindingResult result) {

		System.out.println("##=< mes: " + formulario.getMes().toString());
		
		//Validation code
	    validator.validate(formulario, result);
	    
		ModelAndView modelo;
		
		if (result.hasErrors()) {
			modelo = new ModelAndView("consultaData");
			modelo.addObject("formulario", formulario);
		} else {
			modelo = new ModelAndView("listaOfertas");

			if (formulario.getMes() > 0) {
				Mes mes = getListadoMeses().get(formulario.getMes());
				modelo.addObject("ofertas",
						gestor.getOfertasDelMes(mes, formulario.getDias(), formulario.getPrecioMax()));
			} else {
				modelo.addObject("ofertas", null);
			}
		}
		return modelo;

	}

	@ModelAttribute("listadoMeses")
	public List<Mes> getListadoMeses() {
		List<Mes> meses = new ArrayList<>();
		meses.add(new Mes(0, "Seleccione"));
		meses.add(new Mes(1, "Enero"));
		meses.add(new Mes(2, "Febrero"));
		meses.add(new Mes(3, "Marzo"));
		meses.add(new Mes(4, "Abril"));
		meses.add(new Mes(5, "Mayo"));
		meses.add(new Mes(6, "Junio"));
		meses.add(new Mes(7, "Julio"));
		meses.add(new Mes(8, "Agosto"));
		meses.add(new Mes(9, "Septiembre"));
		meses.add(new Mes(10, "Octubre"));
		meses.add(new Mes(11, "Noviembre"));
		meses.add(new Mes(12, "Diciembre"));
		return meses;
	}

}
