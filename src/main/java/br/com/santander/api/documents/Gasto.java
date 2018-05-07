package br.com.santander.api.documents;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Gasto {

	@Id
	private String id;
	private String descricao;
	private String valor;
	private String codigousuario;
	private String data;
	private Categorizacao categorizacao;

	public Categorizacao getCategorizacao() {
		return categorizacao;
	}

	public void setCategorizacao(Categorizacao categorizacao) {
		this.categorizacao = categorizacao;
	}

	public Gasto() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@NotEmpty(message = "Descrição não pode ser vazio")
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@NotEmpty(message = "Valor não pode ser vazio")
	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	@NotEmpty(message = "Código do Usuário não pode ser vazio")
	public String getCodigousuario() {
		return codigousuario;
	}

	public void setCodigousuario(String codigousuario) {
		this.codigousuario = codigousuario;
	}

	@NotEmpty(message = "Data não pode ser vazio")
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}