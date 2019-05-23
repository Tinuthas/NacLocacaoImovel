package br.com.fiap.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_NAC_CLIENTE")
@SequenceGenerator(name="cliente", sequenceName="SEQ_NAC_CLIENTE")
public class Cliente {

	@Id
	@GeneratedValue(generator="cliente", strategy= GenerationType.SEQUENCE)
	@Column(name="cd_cliente")
	private int codigo;
	
	@Column(name="nm_cliente", nullable=false, length=50)
	private String nome;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_genero")
	private Genero genero;
	
	@Column(name="dt_nascimento")
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;
	
	@OneToMany(mappedBy="cliente")
	private List<Locacao> locacoes;

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cliente(String nome, Genero genero, Calendar dataNascimento) {
		super();
		this.nome = nome;
		this.genero = genero;
		this.dataNascimento = dataNascimento;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<Locacao> getLocacoes() {
		return locacoes;
	}

	public void setLocacoes(List<Locacao> locacoes) {
		this.locacoes = locacoes;
	}
	
	
	
}
