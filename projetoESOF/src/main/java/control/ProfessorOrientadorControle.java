package control;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import model.ProfessorOrientador;

public class ProfessorOrientadorControle {
	private EntityManager em;

	public ProfessorOrientadorControle() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Eng_Software");
		em = emf.createEntityManager();
	}

	public void inserir(ProfessorOrientador professor) throws Exception {
		try {
			em.getTransaction().begin();
			em.persist(professor);
			em.getTransaction().commit();
		} catch (Exception ex) {			
			em.getTransaction().rollback();
			throw ex;
		}

	}

	public void alterar(ProfessorOrientador professor) throws Exception{
		try {
			em.getTransaction().begin();
			em.merge(professor);
			em.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
			throw ex;
		}
	}

	public void excluir(ProfessorOrientador professor) {
		try {
			em.getTransaction().begin();
			em.remove(professor);
			em.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}
	}

	public ProfessorOrientador buscarPorCodigo(String codigo) {
		return em.find(ProfessorOrientador.class, codigo);
	}

	public void excluirPorId(String codigo) {
		try {
			ProfessorOrientador professor = buscarPorCodigo(codigo);
			excluir(professor);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public List<ProfessorOrientador> buscarTodos() {
		String professorOrientador = ProfessorOrientador.class.getName();
		return em.createQuery("FROM " + professorOrientador).getResultList();
	}
}
