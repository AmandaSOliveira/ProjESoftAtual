package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.Frame;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaPrincipal {

	private JFrame frmInternPro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frmInternPro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * Construtor da Tela Principal
	 */
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInternPro = new JFrame();
		frmInternPro.setTitle("InternPro");
		frmInternPro.setBounds(100, 100, 450, 300);
		frmInternPro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInternPro.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmInternPro.getContentPane().setLayout(null);
		
		final JDesktopPane desktop = new JDesktopPane();
		desktop.setBounds(0, 0, 1350, 658);
		desktop.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		frmInternPro.getContentPane().add(desktop);
		
		JMenuBar barraMenu = new JMenuBar();
		barraMenu.setBounds(0, 0, 434, 22);
		frmInternPro.setJMenuBar(barraMenu);
		
		JMenu menuCadastrar = new JMenu("Cadastro");
		barraMenu.add(menuCadastrar);
		
		JMenuItem menuProfessor = new JMenuItem("Professor Orientador");
		menuProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCrudProfessorOrientador tela = new TelaCrudProfessorOrientador();
				tela.setVisible(true);
				desktop.add(tela);
			}
		});
		menuProfessor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.ALT_DOWN_MASK));
		menuCadastrar.add(menuProfessor);
		
		JMenuItem menuCoordenador = new JMenuItem("Coordenador");
		menuCoordenador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCrudCoordenador tela = new TelaCrudCoordenador();
				tela.setVisible(true);
				desktop.add(tela);
			}
		});
		menuCoordenador.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.ALT_DOWN_MASK));
		menuCadastrar.add(menuCoordenador);
		
		JMenuItem menuAluno = new JMenuItem("Aluno");
		menuAluno.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.ALT_DOWN_MASK));
		menuAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCrudAluno tela = new TelaCrudAluno();
				tela.setVisible(true);
				desktop.add(tela);
			}
		});
		menuCadastrar.add(menuAluno);
		
		JMenu menuConsultar = new JMenu("Consulta");
		barraMenu.add(menuConsultar);
		
		JMenu menuAjuda = new JMenu("Ajuda");
		menuAjuda.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "this");
			}
		});
		barraMenu.add(menuAjuda);
	}
}
