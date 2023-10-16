package model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "coordenador")
public class Coordenador implements Serializable{	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "cod_coordenador")
	private String Codigo;
	@Column(name = "nome_coordenador")
	private String Nome;
	@Column(name = "email_coordenador")
	private String Email;
	@Column(name = "fone_coordenador")
	private String Telefone;

	public Coordenador(String codigo, String nome, String email, String telefone) {

		this.Codigo = codigo;
		this.Nome = nome;
		this.Email = email;
		this.Telefone = telefone;

	}
	
	public Coordenador(){}
	

	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		this.Nome = nome;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		this.Email = email;
	}
	public String getTelefone() {
		return Telefone;
	}
	public void setTelefone(String telefone) {
		this.Telefone = telefone;
	}
	
}
