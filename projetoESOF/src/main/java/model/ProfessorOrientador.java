package model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "prof_orientador")
public class ProfessorOrientador implements Serializable{	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "cod_prof")
	private String Codigo;
	@Column(name = "nome_prof")
	private String Nome;
	@Column(name = "email_prof")
	private String Email;
	@Column(name = "fone_prof")
	private String Telefone;
	@Column(name = "lattes")
	private String Lattes;
	@Column(name = "cpf")
	private String Cpf;
	
	public ProfessorOrientador(String codigo, String nome, String email, String telefone,
			String lattes, String cpf) {
		super();
		this.Codigo = codigo;
		this.Nome = nome;
		this.Email = email;
		this.Telefone = telefone;
		this.Lattes = lattes;
		this.Cpf = cpf;
	}
	
	public ProfessorOrientador() {}

	public String getCodigo() {
		return Codigo;
	}

	protected void setCodigo(String codigo) {
		this.Codigo = codigo;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		this.Nome = nome;
	}

	public String getEmail() {
		return Email;
	}

	protected void setEmail(String email) {
		this.Email = email;
	}

	public String getFone() {
		return Telefone;
	}

	protected void setFone(String foneProfessor) {
		this.Telefone = foneProfessor;
	}

	public String getLattes() {
		return Lattes;
	}

	protected void setLattes(String lattes) {
		this.Lattes = lattes;
	}

	public String getCpf() {
		return Cpf;
	}

	protected void setCpf(String cpf) {
		this.Cpf = cpf;
	}
	
}
