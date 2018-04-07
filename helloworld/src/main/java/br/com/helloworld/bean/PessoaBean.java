package br.com.helloworld.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.helloworld.entity.Cidade;
import br.com.helloworld.entity.Estado;
import br.com.helloworld.entity.Pessoa;
import br.com.helloworld.service.CidadeServico;
import br.com.helloworld.service.EstadoServico;

@Named
@ViewScoped
public class PessoaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EJB
	private EstadoServico estadoServico;
	@EJB
	private CidadeServico cidadeServico;
	
	private Pessoa pessoa;
	private List<Estado> estados;
	private List<Cidade> cidades;
	private Integer cidadeSelecionada;
	private String estadoSelecionado;
	
	@PostConstruct
	public void inicializar() {
		try {
			estados = estadoServico.obterTodos();
//			estados = new ArrayList<>();
			cidades = new ArrayList<>();
			pessoa = new Pessoa();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void obterCidadesPorEstadoSelecionado() {
		try {
			if (estadoSelecionado == null) {
				return;
			}
			Estado estado = estadoServico.obterPorUf(estadoSelecionado);
			cidades = cidadeServico.obterPorEstado(estado);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	
	public List<Cidade> getCidades() {
		return cidades;
	}
	
	public List<Estado> getEstados() {
		return estados;
	}
	
	public Integer getCidadeSelecionada() {
		return cidadeSelecionada;
	}
	
	public void setCidadeSelecionada(Integer cidadeSelecionada) {
		this.cidadeSelecionada = cidadeSelecionada;
	}
	
	public String getEstadoSelecionado() {
		return estadoSelecionado;
	}
	
	public void setEstadoSelecionado(String estadoSelecionado) {
		this.estadoSelecionado = estadoSelecionado;
	}
}