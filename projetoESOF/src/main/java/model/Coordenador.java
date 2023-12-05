package model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "coordenador")
public class Coordenador implements Serializable, Comparable<Coordenador> {
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

	@OneToMany(mappedBy = "coordenador")
	private List<Aluno> alunos;

	public Coordenador(String codigo, String nome, String email, String telefone, List<Aluno> alunos) {

		this.Codigo = codigo;
		this.Nome = nome;
		this.Email = email;
		this.Telefone = telefone;
		this.alunos = alunos;
	}

	public Coordenador() {
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
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

	public String getTelefone() {
		return Telefone;
	}

	public void setTelefone(String telefone) {
		this.Telefone = telefone;
	}

	public String getCodigo() {
		return Codigo;
	}

	public void setCodigo(String codigo) {
		this.Codigo = codigo;
	}
	
	@Override
	public String toString() {
		return Nome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordenador other = (Coordenador) obj;
		return Objects.equals(Codigo, other.Codigo);
	}

	@Override
	public int compareTo(Coordenador o) {
		return Nome.compareToIgnoreCase(o.getNome());
	}

}
