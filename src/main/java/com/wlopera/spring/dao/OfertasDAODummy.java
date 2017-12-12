package com.wlopera.spring.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.wlopera.spring.dominio.Mes;
import com.wlopera.spring.dominio.Oferta;
import com.wlopera.spring.dominio.TipoHabitacion;

@Repository
public class OfertasDAODummy implements OfertasDAO {

	
	public OfertasDAODummy() {
		System.out.println("##=> Creando DAO OfertasDAODummy");
	}

	/**
	 * Permite consultar hipoteticamente, las ofertas del mes por 'n' dias y por 'm' precio maximo
	 * @param mes Mes a consultar la oferta
	 * @param dias Dias a solicitar maximo
	 * @param precioMax Precio maximo dispuesto a cancelar
	 * @return Ofertas del mes
	 */
	public List<Oferta> getOfertasDelMes(Mes mes, Integer dias, BigDecimal precioMax) {
		List<Oferta> ofertas = new ArrayList<Oferta>();
		Oferta oferta;		
		if (!getDisponibilidad()) {
			return null;
		} else {
			int descuento = 20;
			double base = precioMax.doubleValue() - (dias*((int) (Math.random() * 5))); 
			for (int i = 1; i < dias; i++) {
				oferta = new Oferta();
				oferta.setMes(mes);
				oferta.setMinNoches(i);
				BigDecimal precio = new BigDecimal((i * base) - ((descuento + (i + 10)) * (100 / base)));
				oferta.setPrecio(precio.setScale(2, BigDecimal.ROUND_HALF_DOWN));
				int tipo = (int)Math.round( Math.random());		
				oferta.setTipoHab((tipo == 0)?TipoHabitacion.INDIVIDUAL:TipoHabitacion.DOBLE);
				ofertas.add(oferta);
			}
			return ofertas;
		}
	}

	// Simular disponibilidad
	private boolean getDisponibilidad() {
		if ( ((int) (Math.random() * 10)) < 6) {
			return true;
		}
		return false;
	}
	
}
