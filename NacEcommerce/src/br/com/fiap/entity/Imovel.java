package br.com.fiap.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_NAC_IMOVEL")
@SecondaryTable(name="T_NAC_ENDERECO",
pkJoinColumns= {@PrimaryKeyJoinColumn(name="cd_imovel")})
@SequenceGenerator(name="imovel", sequenceName="SEQ_NAC_IMOVEL")
public class Imovel {
	
	@Id
	@GeneratedValue(generator="imovel", strategy=GenerationType.SEQUENCE)
	@Column(name="cd_imovel")
	private int codigo;
	
	@Column(name="fl_foto")
	@Lob
	private byte[] foto;
	
	@Column(name="ds_detalhes", nullable=false, length=500)
	private String detalhes;
	
	@Column(name="ds_logradouro",length=100, nullable=false, table="T_NAC_ENDERECO")
	private String logradouro;
	
	@Column(name="nr_cep", nullable=false, table="T_NAC_ENDERECO")
	private int cep;
	
	@OneToMany(mappedBy="imovel")
	private List<Locacao> locacoes;

	public Imovel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Imovel(byte[] foto, String detalhes, String logradouro, int cep) {
		super();
		this.foto = foto;
		this.detalhes = detalhes;
		this.logradouro = logradouro;
		this.cep = cep;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public String getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public List<Locacao> getLocacoes() {
		return locacoes;
	}

	public void setLocacoes(List<Locacao> locacoes) {
		this.locacoes = locacoes;
	}
	
	

}
