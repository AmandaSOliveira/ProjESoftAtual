package model;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	@OneToMany(mappedBy = "professor")
	private List<Aluno> alunos;
	
	public ProfessorOrientador(String codigo, String nome, String email, String telefone,
			String lattes, String cpf, List<Aluno> alunos) {
		super();
		this.Codigo = codigo;
		this.Nome = nome;
		this.Email = email;
		this.Telefone = telefone;
		this.Lattes = lattes;
		this.Cpf = cpf;
		this.alunos = alunos;
	}
	
	public ProfessorOrientador() {}

	public List<Aluno> getAlunos() {
		return alunos;
	}
	
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	public String getCodigo() {
		return Codigo;
	}

	public void setCodigo(String codigo) {
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

	public void setEmail(String email) {
		this.Email = email;
	}

	public String getFone() {
		return Telefone;
	}

	public void setFone(String foneProfessor) {
		this.Telefone = foneProfessor;
	}

	public String getLattes() {
		return Lattes;
	}

	public void setLattes(String lattes) {
		this.Lattes = lattes;
	}

	public String getCpf() {
		return Cpf;
	}

	public void setCpf(String cpf) {
		this.Cpf = cpf;
	}
	
}
