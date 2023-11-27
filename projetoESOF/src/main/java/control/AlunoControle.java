package control;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import model.Aluno;

public class AlunoControle {
	private EntityManager em;

	public AlunoControle() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Eng_Software");
		em = emf.createEntityManager();
	}

	public void inserir(Aluno aluno) throws Exception {
		try {
			em.getTransaction().begin();
			em.persist(aluno);
			em.getTransaction().commit();
		} catch (Exception ex) {			
			em.getTransaction().rollback();
			throw ex;
		}

	}

	public void alterar(Aluno aluno) {
		try {
			em.getTransaction().begin();
			em.merge(aluno);
			em.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}
	}

	public void excluir(Aluno aluno) {
		try {
			em.getTransaction().begin();
			em.remove(aluno);
			em.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}
	}

	public Aluno buscarPorCodigo(String codigo) {
		return em.find(Aluno.class, codigo);
	}

	public void excluirPorId(String codigo) {
		try {
			Aluno aluno = buscarPorCodigo(codigo);
			excluir(aluno);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public List<Aluno> buscarTodos() {
		String aluno = Aluno.class.getName();
		return em.createQuery("FROM " + aluno).getResultList();
	}
}
