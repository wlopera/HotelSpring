package com.wlopera.spring.negocio;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wlopera.spring.dao.OfertasDAO;
import com.wlopera.spring.dominio.Mes;
import com.wlopera.spring.dominio.Oferta;

@Service
public class GestorOfertasImpl implements GestorOfertas {

	@Autowired
	private OfertasDAO ofertasRepo;
	
	public GestorOfertasImpl() {
		System.out.println("##=> Creando Gestor GestorOfertasImpl");
	}

	/**
	 * Permite consultar las ofertas del mes por 'n' dias y por 'm' precio maximo
	 * @param mes Mes a consultar la oferta
	 * @param dias Dias a solicitar maximo
	 * @param precioMax Precio maximo dispuesto a cancelar
	 * @return Ofertas del mes
	 */
	public List<Oferta> getOfertasDelMes(Mes mes, Integer dias, BigDecimal precioMax) {
		 List<Oferta> ofertas =  ofertasRepo.getOfertasDelMes(mes, dias, precioMax);
		 
		return ofertas;
	}

}
