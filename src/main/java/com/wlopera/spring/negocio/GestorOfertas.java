package com.wlopera.spring.negocio;

import java.math.BigDecimal;
import java.util.List;

import com.wlopera.spring.dominio.Mes;
import com.wlopera.spring.dominio.Oferta;
	
public interface GestorOfertas {
	
	/**
	 * Permite consultar las ofertas del mes por 'n' dias y por 'm' precio maximo
	 * @param mes Mes a consultar la oferta
	 * @param dias Dias a solicitar maximo
	 * @param precioMax Precio maximo dispuesto a cancelar
	 * @return Ofertas del mes
	 */
	List<Oferta> getOfertasDelMes(Mes mes, Integer dias, BigDecimal precioMax);
}
