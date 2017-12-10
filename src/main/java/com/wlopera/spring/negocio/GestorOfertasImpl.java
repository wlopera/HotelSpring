package com.wlopera.spring.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wlopera.spring.dao.OfertasDAO;
import com.wlopera.spring.dominio.Oferta;

@Service
public class GestorOfertasImpl implements GestorOfertas {

	@Autowired
	private OfertasDAO ofertasRepo;
	
	public GestorOfertasImpl() {
		System.out.println("##=> Creando Gestor GestorOfertasImpl");
	}

	public List<Oferta> getOfertasDelMes(int idMes) {
		 List<Oferta> ofertas =  ofertasRepo.getOfertasDelMes(idMes);
		 
		return ofertas;
	}

}
