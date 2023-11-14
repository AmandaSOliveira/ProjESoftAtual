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

	private JFrame frmSistemaDeVeterinria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frmSistemaDeVeterinria.setVisible(true);
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
		frmSistemaDeVeterinria = new JFrame();
		frmSistemaDeVeterinria.setTitle("Sistema de Veterin\u00E1ria");
		frmSistemaDeVeterinria.setBounds(100, 100, 450, 300);
		frmSistemaDeVeterinria.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSistemaDeVeterinria.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmSistemaDeVeterinria.getContentPane().setLayout(null);
		
		final JDesktopPane desktop = new JDesktopPane();
		desktop.setBounds(0, 0, 1350, 658);
		desktop.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		frmSistemaDeVeterinria.getContentPane().add(desktop);
		
		JMenuBar barraMenu = new JMenuBar();
		barraMenu.setBounds(0, 0, 434, 22);
		frmSistemaDeVeterinria.setJMenuBar(barraMenu);
		
		JMenu menuCadastrar = new JMenu("Cadastro");
		barraMenu.add(menuCadastrar);
		
		JMenuItem menuUsuario = new JMenuItem("Professor Orientador");
		menuUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCrudProfessorOrientador tela = new TelaCrudProfessorOrientador();
				tela.setVisible(true);
				desktop.add(tela);
			}
		});
		menuUsuario.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.ALT_DOWN_MASK));
		menuCadastrar.add(menuUsuario);
		
		JMenuItem menuVeterinario = new JMenuItem("Coordenador");
		menuVeterinario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCrudCoordenador tela = new TelaCrudCoordenador();
				tela.setVisible(true);
				desktop.add(tela);
			}
		});
		menuVeterinario.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.ALT_DOWN_MASK));
		menuCadastrar.add(menuVeterinario);
		
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
