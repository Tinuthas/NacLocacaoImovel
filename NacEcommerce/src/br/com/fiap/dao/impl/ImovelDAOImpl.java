package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ImovelDAO;
import br.com.fiap.entity.Imovel;

public class ImovelDAOImpl extends GenericDAOImpl<Imovel, Integer> implements ImovelDAO {

	public ImovelDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}


}
