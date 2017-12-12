package com.wlopera.spring.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.wlopera.spring.dominio.Formulario;

@Component
public class OfertaValidator implements Validator {

	public OfertaValidator() {
		System.out.println("##=> Validator OfertaValidator");
	}

	@Override
	public boolean supports(Class<?> clase) {
		return clase.isAssignableFrom(Formulario.class);
	}

	@Override
	public void validate(Object obj, Errors errores) {
		ValidationUtils.rejectIfEmpty(errores, "dias", "diasVacio", "Agregar días a permanecer en nuestras instalaciones");
		ValidationUtils.rejectIfEmpty(errores, "precioMax", "precioMaxVacio", "Agregar un precio mayor a 200 y menor a 3000");

		Formulario formulario = (Formulario) obj;

		if (formulario.getMes() == 0) {
			errores.rejectValue("mes", "mesNoVal","Debe seleccionar un mes a consultar");
		}
		
		if (formulario.getDias() == null || formulario.getPrecioMax() == null) {
			return;
		}
		
		if (formulario.getDias() < 0 || formulario.getDias() > 10) {
			errores.rejectValue("dias", "diasNoVal", "Para disfrutar de nuestros descuentos, la cantidad de días debe ser menor a  10.");
		}

		if (formulario.getPrecioMax() == null) {
			return;
		}
		if (formulario.getPrecioMax().doubleValue() < 200 || formulario.getPrecioMax().doubleValue() > 3000) {
			errores.rejectValue("precioMax", "precioMaxNoVal", "Precio no válido. Debe ser  mayor a 200 y menor a 3000");
		}

	}

}
