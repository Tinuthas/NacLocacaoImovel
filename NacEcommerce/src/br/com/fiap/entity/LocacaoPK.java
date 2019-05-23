package br.com.fiap.entity;

import java.io.Serializable;

public class LocacaoPK implements Serializable {

	private static final long serialVersionUID = 5688565975295713195L;

	private int codigo;
	
	private int imovel;
	
	private int cliente;
	
	

	public LocacaoPK(int codigo, int imovel, int cliente) {
		super();
		this.codigo = codigo;
		this.imovel = imovel;
		this.cliente = cliente;
	}

	public LocacaoPK() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getImovel() {
		return imovel;
	}

	public void setImovel(int imovel) {
		this.imovel = imovel;
	}

	public int getCliente() {
		return cliente;
	}

	public void setCliente(int cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cliente;
		result = prime * result + codigo;
		result = prime * result + imovel;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LocacaoPK other = (LocacaoPK) obj;
		if (cliente != other.cliente)
			return false;
		if (codigo != other.codigo)
			return false;
		if (imovel != other.imovel)
			return false;
		return true;
	}
	
	
}
