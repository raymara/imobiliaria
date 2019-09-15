package com.imoveis.raymara2.repositorio.helper.cliente;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.imoveis.raymara2.modelo.Imovel;
import com.imoveis.raymara2.repositorio.filtro.ImovelFiltro;

public class ImoveisImpl implements ImoveisQueries {
	
	@Autowired
	private EntityManager manager;

	@Override
	public List<Imovel> filtrar(ImovelFiltro filtro) {
		
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Imovel.class);
		
		if (filtro != null) {

			if (temNome(filtro) ) {
				criteria.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));
			}

		}
		
		return criteria.list();
	}

	private boolean temNome(ImovelFiltro filtro) {
		return filtro.getNome() != null && !filtro.getNome().isEmpty();
	}

}
