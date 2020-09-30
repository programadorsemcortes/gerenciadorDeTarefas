package br.com.mardonio.domain;

import java.io.Serializable;
import java.util.Date;

public class Tarefa  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String titulo;
	private Integer status;
	private String descricao;
	private Date dataCriacao;
	private Date dataAtualizacao;
	private Date remocao;
	private Date conclusao;
	private Integer statusRemocao;
	
	public Tarefa() {}

	public Tarefa(Integer id, String titulo, Integer status, String descricao, Date dataCriacao, Date dataAtualizacao,
			Date remocao, Date conclusao, Integer statusRemocao) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.status = status;
		this.descricao = descricao;
		this.dataCriacao = dataCriacao;
		this.dataAtualizacao = dataAtualizacao;
		this.remocao = remocao;
		this.conclusao = conclusao;
		this.statusRemocao = statusRemocao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public Date getRemocao() {
		return remocao;
	}

	public void setRemocao(Date remocao) {
		this.remocao = remocao;
	}

	public Date getConclusao() {
		return conclusao;
	}

	public void setConclusao(Date conclusao) {
		this.conclusao = conclusao;
	}

	public Integer getStatusRemocao() {
		return statusRemocao;
	}

	public void setStatusRemocao(Integer statusRemocao) {
		this.statusRemocao = statusRemocao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Tarefa other = (Tarefa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
