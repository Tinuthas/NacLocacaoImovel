package br.com.fiap.dao;

import java.util.Calendar;
import java.util.List;

import br.com.fiap.entity.Locacao;

public interface LocacaoDAO extends GenericDAO<Locacao, Integer> {
	
	List<Locacao> getLocacoesByDate(Calendar start, Calendar end);
	
	long countLocacaoByClient(int codigo);

}
