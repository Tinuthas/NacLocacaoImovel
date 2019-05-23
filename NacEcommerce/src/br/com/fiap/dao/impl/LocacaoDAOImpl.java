package br.com.fiap.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.LocacaoDAO;
import br.com.fiap.entity.Locacao;

public class LocacaoDAOImpl extends GenericDAOImpl<Locacao, Integer> implements LocacaoDAO{

	public LocacaoDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Locacao> getLocacoesByDate(Calendar start, Calendar end) {
		return em.createQuery("from Locacao l where l.data between :inicio and :fim", Locacao.class)
				.setParameter("inicio", start)
				.setParameter("fim", end)
				.getResultList();
	}

	@Override
	public long countLocacaoByClient(int codigo) {
		return em.createQuery("select count(l) from Locacao l where l.cliente.codigo = :c", Long.class)
				.setParameter("c", codigo)
				.getSingleResult();
	}

}
