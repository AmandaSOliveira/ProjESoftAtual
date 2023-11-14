package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import control.VeterinarioControle;
import model.Veterinario;

import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCrudVeterinario extends JInternalFrame {
	// atributos do projeto 
	private Veterinario veterinario;
	private VeterinarioControle controle = new VeterinarioControle();

	// campos da tela
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtEspecialidade;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JButton btnInserir;
	private JButton btnConsultar;
	private JButton btnSalvar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCrudVeterinario frame = new TelaCrudVeterinario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCrudVeterinario() {
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		JLabel lblTitulo = new JLabel("Veterin\u00E1rio");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitulo.setBounds(10, 11, 414, 14);
		getContentPane().add(lblTitulo);

		JPanel painelCampos = new JPanel();
		painelCampos.setBorder(new TitledBorder(null, "Dados do Veterin\u00E1rio", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		painelCampos.setBounds(10, 36, 299, 194);
		getContentPane().add(painelCampos);
		painelCampos.setLayout(null);

		JLabel lblId = new JLabel("Id : ");
		lblId.setBounds(10, 26, 46, 14);
		painelCampos.add(lblId);

		txtId = new JTextField();
		txtId.setEnabled(false);
		txtId.setBounds(92, 23, 197, 20);
		painelCampos.add(txtId);
		txtId.setColumns(10);

		JLabel lblNome = new JLabel("Nome : ");
		lblNome.setBounds(10, 60, 46, 14);
		painelCampos.add(lblNome);

		txtNome = new JTextField();
		txtNome.setEnabled(false);
		txtNome.setBounds(92, 57, 197, 20);
		painelCampos.add(txtNome);
		txtNome.setColumns(10);

		txtEspecialidade = new JTextField();
		txtEspecialidade.setEnabled(false);
		txtEspecialidade.setColumns(10);
		txtEspecialidade.setBounds(92, 95, 197, 20);
		painelCampos.add(txtEspecialidade);

		JLabel lblEspecialidade = new JLabel("Especialidade : ");
		lblEspecialidade.setBounds(10, 98, 90, 14);
		painelCampos.add(lblEspecialidade);

		btnSalvar = new JButton("Salvar");
		btnSalvar.setEnabled(false);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtNome.getText().length() < 5) {
					JOptionPane.showMessageDialog(btnSalvar, "O nome precisa ter no mínimo 5 caracteres!!!");
				} else {
					//novo veterinario
					if (veterinario == null) {
						veterinario = new Veterinario();
						veterinario.setNome(txtNome.getText());
						veterinario.setEspecialidade(txtEspecialidade.getText());
						controle.inserir(veterinario);
						JOptionPane.showMessageDialog(btnSalvar, "Veterinário cadastrado.");
						txtId.setText(String.valueOf(veterinario.getIdVeterinario()));
					}else {
						//alterar
						veterinario.setNome(txtNome.getText());
						veterinario.setEspecialidade(txtEspecialidade.getText());
						controle.alterar(veterinario);
						JOptionPane.showMessageDialog(btnSalvar, "Veterinário atualizado.");
					}
					definirEstadoConsulta();
				}
			}
		});
		btnSalvar.setBounds(200, 126, 89, 23);
		painelCampos.add(btnSalvar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				definirEstadoInicial();
			}
		});
		btnCancelar.setBounds(102, 126, 89, 23);
		painelCampos.add(btnCancelar);

		JPanel panel = new JPanel();
		panel.setBounds(319, 36, 105, 194);
		getContentPane().add(panel);
		panel.setLayout(null);

		btnInserir = new JButton("Novo");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				definirEstadoEdicao();
				limparCampos();
				txtNome.requestFocus();
			}
		});
		btnInserir.setBounds(10, 13, 89, 23);
		panel.add(btnInserir);

		btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				definirEstadoEdicao();
				txtNome.requestFocus();
			}
		});
		btnAlterar.setEnabled(false);
		btnAlterar.setBounds(10, 49, 89, 23);
		panel.add(btnAlterar);

		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (veterinario != null) {
					controle.excluir(veterinario);
					veterinario = null;
					definirEstadoInicial();
				}
			}
		});
		btnExcluir.setEnabled(false);
		btnExcluir.setBounds(10, 85, 89, 23);
		panel.add(btnExcluir);

		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = JOptionPane.showInputDialog("Digite o id do usuário: ");
				veterinario = controle.buscarPorId(Integer.parseInt(id));
				if (veterinario != null) {
					txtId.setText(String.valueOf(veterinario.getIdVeterinario()));
					txtNome.setText(veterinario.getNome());
					txtEspecialidade.setText(veterinario.getEspecialidade());
					definirEstadoConsulta();
				} else {
					JOptionPane.showMessageDialog(null, "Não existe veterinário com esse código");
				}
			}
		});
		btnConsultar.setBounds(10, 121, 89, 23);
		panel.add(btnConsultar);

		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFechar.setBounds(10, 157, 89, 23);
		panel.add(btnFechar);

	}

	private void definirEstadoInicial() {
		limparCampos();
		txtNome.setEnabled(false);
		txtEspecialidade.setEnabled(false);
		btnInserir.setEnabled(true);
		btnExcluir.setEnabled(false);
		btnAlterar.setEnabled(false);
		btnConsultar.setEnabled(true);
		btnSalvar.setEnabled(false);
	}

	private void definirEstadoEdicao() {
		txtNome.setEnabled(true);
		txtEspecialidade.setEnabled(true);
		btnInserir.setEnabled(false);
		btnExcluir.setEnabled(false);
		btnAlterar.setEnabled(false);
		btnConsultar.setEnabled(false);
		btnSalvar.setEnabled(true);
	}

	private void definirEstadoConsulta() {
		txtNome.setEnabled(false);
		txtEspecialidade.setEnabled(false);
		btnInserir.setEnabled(true);
		btnExcluir.setEnabled(true);
		btnAlterar.setEnabled(true);
		btnConsultar.setEnabled(true);
		btnSalvar.setEnabled(false);
	}

	private void limparCampos() {
		txtId.setText("");
		txtNome.setText("");
		txtEspecialidade.setText("");
	}
}
