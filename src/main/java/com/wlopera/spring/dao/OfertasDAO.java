package com.wlopera.spring.dao;

import java.util.List;

import com.wlopera.spring.dominio.Oferta;

public interface OfertasDAO {

	List<Oferta> getOfertasDelMes(int idMes);
}
