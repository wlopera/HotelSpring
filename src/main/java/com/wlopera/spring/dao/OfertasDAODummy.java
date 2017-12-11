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
	 * Genera hipoteticamente, las ofertas para una semana de hospedaje
	 * 
	 * @param mes: Mes de la oferta
	 * @return Listado de ofertas para el mes solicitado 
	 */
	public List<Oferta> getOfertasDelMes(Mes mes) {
		int dias = getNumeroAleatorio(10);		
		List<Oferta> ofertas = new ArrayList<Oferta>();
		Oferta oferta;
		double base = 100d;
		int descuento = 20;
		
		if (dias > 8) {
			return null;
		} else {
			for (int i = 1; i < dias; i++) {
				oferta = new Oferta();
				oferta.setMes(mes);
				oferta.setMinNoches(i);
				BigDecimal precio = new BigDecimal((i * base) - ((descuento + (i + 10)) * (100 / base)));
				oferta.setPrecio(precio.setScale(2));
				int tipo = (int)Math.round( Math.random());		
				oferta.setTipoHab((tipo == 0)?TipoHabitacion.INDIVIDUAL:TipoHabitacion.DOBLE);
				ofertas.add(oferta);
			}
			return ofertas;
		}
	}

	private int getNumeroAleatorio(int base) {
		return (int) (Math.random() * base);
	}
	
}
