package com.imoveis.raymara2.repositorio.helper.cliente;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.imoveis.raymara2.modelo.Cliente;
import com.imoveis.raymara2.repositorio.filtro.ClienteFiltro;


public class ClientesImpl implements ClientesQueries {
	
	@Autowired
	private EntityManager manager;

	@Override
	public List<Cliente> filtrar(ClienteFiltro filtro) {
		
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Cliente.class);
		
		if (filtro != null) {
			if (temCpf(filtro)) {
				criteria.add(Restrictions.eq("cpf", filtro.getCpf() ));
			}
			
			if (temNome(filtro) ) {
				criteria.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));
			}

			if (temRg(filtro)) {
				criteria.add(Restrictions.eq("rg", filtro.getRg() ));
			}
		}
		
		return criteria.list();
	}

	private boolean temNome(ClienteFiltro filtro) {
		return filtro.getNome() != null && !filtro.getNome().isEmpty();
	}

	private boolean temCpf(ClienteFiltro filtro) {
		return filtro.getCpf() != null && !filtro.getCpf().isEmpty();
	}
	
	private boolean temRg(ClienteFiltro filtro) {
		return filtro.getRg() != null && !filtro.getRg().isEmpty();
	}
}
