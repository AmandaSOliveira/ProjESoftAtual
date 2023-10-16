package control;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Coordenador;

public class CoordenadorControle {
	private EntityManager em;
	
	public CoordenadorControle() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Eng_Software");
		em = emf.createEntityManager();
	}
	
	public void inserir(Coordenador coordenador) {
		 try {
	            em.getTransaction().begin();
	            em.persist(coordenador);
	            em.getTransaction().commit();
	         } catch (Exception ex) {
	            ex.printStackTrace();
	            em.getTransaction().rollback();
	         }
	}
	
	public void alterar(Coordenador coordenador) {
		 try {
	            em.getTransaction().begin();
	            em.merge(coordenador);
	            em.getTransaction().commit();
	         } catch (Exception ex) {
	            ex.printStackTrace();
	            em.getTransaction().rollback();
	         }
	}
	
	public void excluir(Coordenador coordenador) {
		try {
           em.getTransaction().begin();
           em.remove(coordenador);
           em.getTransaction().commit();
        } catch (Exception ex) {
           ex.printStackTrace();
           em.getTransaction().rollback();
        }
	}
	
	public Coordenador buscarPorCodigo(String codigo) {
		return em.find(Coordenador.class, codigo);
	}
	
	public void excluirPorId(String codigo) {
		try {
			Coordenador coordenador = buscarPorCodigo(codigo);
           excluir(coordenador);
        } catch (Exception ex) {
           ex.printStackTrace();
        }
	}
	
	public List<Coordenador> buscarTodos() {
		String Coordenador = Coordenador.class.getName();
		return em.createQuery("FROM " + Coordenador).getResultList();
	}
}
