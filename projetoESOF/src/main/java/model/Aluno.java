package model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "aluno")
public class Aluno implements Serializable{	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "cpf")
	private String Cpf;
	@Column(name = "nome_aluno")
	private String Nome;
	@Column(name = "email_aluno")
	private String Email;
	@Column(name = "fone_aluno")
	private String Telefone;
	@Column(name = "curriculo")
	private String Curriculo;
	@Column(name = "cod_curso")
	private String Curso;

	
	@ManyToOne
	@JoinColumn(name = "cod_prof")
	private ProfessorOrientador professor;
	
	@ManyToOne
	@JoinColumn(name = "cod_coordenador")
	private Coordenador coordenador;

	public Aluno(String nome, String email, String telefone,
			String curriculo, String cpf) {
		super();
		this.Cpf = cpf;
		this.Nome = nome;
		this.Email = email;
		this.Telefone = telefone;
		this.Curriculo = curriculo;
		this.Cpf = cpf;
	}
	
	public Aluno() {}

	public String getCpf() {
		return Cpf;
	}

	public void setCpf(String cpf) {
		this.Cpf = cpf;
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
	

	public String getCurriculo() {
		return Curriculo;
	}

	public void setCurriculo(String lattes) {
		this.Curriculo = lattes;
	}	
	
	public String getCurso() {
		return Curso;
	}

	public void setCurso(String curso) {
		this.Curso = curso;
	}	
	
	public ProfessorOrientador getProfessor() {
		return professor;
	}

	public void setProfessor(ProfessorOrientador professor) {
		this.professor = professor;
	}
	
	public Coordenador getCoordenador() {
		return coordenador;
	}

	public void setCoordenador(Coordenador coordenador) {
		this.coordenador = coordenador;
	}
}
