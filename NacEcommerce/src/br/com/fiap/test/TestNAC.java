package br.com.fiap.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.LocacaoDAO;
import br.com.fiap.dao.impl.LocacaoDAOImpl;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Genero;
import br.com.fiap.entity.Imovel;
import br.com.fiap.entity.Locacao;
import br.com.fiap.exception.CodigoInvalidoException;
import br.com.fiap.exception.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

class TestNAC {

	private static LocacaoDAO locacaoDao;
	Cliente c;
	Imovel i;
	Locacao l;
	
	@BeforeAll
	public static void init() {
		locacaoDao = new LocacaoDAOImpl(EntityManagerFactorySingleton.getInstance()
				.createEntityManager());
	}
	
	@BeforeEach
	void cadastro(){
		c = new Cliente("Marcio", Genero.MASCULINO, new GregorianCalendar(2019, 5,19));
		i = new Imovel(null, "Hiper mobiliado e tudo mais", "Rua campinas", 23546432);
		l = new Locacao(c, i, Calendar.getInstance(), 200000.00);
		try {
			locacaoDao.cadastrar(l);
			locacaoDao.commit();
		} catch (CommitException e) {
			fail("Deu Ruim");
			e.printStackTrace();
		}
	}
	
	@Test
	@DisplayName("Cadastro de cliente com sucesso")
	void cadastrarLocacao() {
			
			Locacao locacaoBusca;
			try {
				//(new LocacaoPK(1,1,1)).getCodigo()
				locacaoBusca = locacaoDao.buscar(1);
				assertEquals(locacaoBusca.getValor(), l.getValor());
			} catch (CodigoInvalidoException e) {
				fail("Deu ruim");
				e.printStackTrace();
			}	

	}

	@Test
	@DisplayName("Busca Locacoes")
	void buscarLocacoes() {
		List<Locacao> loca = locacaoDao.getLocacoesByDate(new GregorianCalendar(2018, 5,19), Calendar.getInstance());
		assertNotEquals(0, loca);
		
	}
	
	@Test
	@DisplayName("Quantidade Locacoes")
	void buscarQuantidadeLocacoes() {
		long count = locacaoDao.countLocacaoByClient(1);
		assertEquals(1, count);
	}
	
	
}
