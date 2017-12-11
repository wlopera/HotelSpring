package com.wlopera.spring.negocio;

import java.util.List;

import com.wlopera.spring.dominio.Mes;
import com.wlopera.spring.dominio.Oferta;
	
public interface GestorOfertas {
	List<Oferta> getOfertasDelMes(Mes mes);
}
