package br.com.helloworld.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "estado", schema = "public")
public class Estado implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(length = 2)
	private String uf;

	@NotNull
	@Column(name = "nome", length = 100, nullable = false)
	private String nome;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "_pais", foreignKey = @ForeignKey(name = "fk_pais"))
	private Pais pais;
	
	public Estado() {}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Pais getPais() {
		return pais;
	}
	
	public void setPais(Pais pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "Estado [uf=" + uf + ", nome=" + nome + "]";
	}
}