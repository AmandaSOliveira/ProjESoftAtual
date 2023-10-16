package view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;
import javax.swing.JOptionPane;

import java.util.List;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Iterator;

import model.Coordenador;
import model.ProfessorOrientador;
import control.ProfessorOrientadorControle;
import control.CoordenadorControle;

public class Programa {
	public static void main(String[] args) {
		// inserindo
		ProfessorOrientador novoProfessor = new ProfessorOrientador("73355645010", "Andre", "andre@iftm.edu.br",
				"3432214800", "lattes", "73355645010");
		ProfessorOrientadorControle controle = new ProfessorOrientadorControle();
		try {
			controle.inserir(novoProfessor);
		} catch (RollbackException e) {			
			JOptionPane.showMessageDialog(null, "Código já cadastrado.");
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Erro desconhecido.");
		}

		// buscando
		novoProfessor = controle.buscarPorCodigo("73355645010"); 
		System.out.println(novoProfessor.getNome()); 

		// modificando
		novoProfessor.setNome("Andre Lemos"); 
		controle.alterar(novoProfessor);

		// buscar todos
		List<ProfessorOrientador> professores = controle.buscarTodos();
		for (Iterator iterator = professores.iterator(); iterator.hasNext();) {
			ProfessorOrientador obj = (ProfessorOrientador) iterator.next();
			System.out.println(obj.getNome());
		}

	}
}