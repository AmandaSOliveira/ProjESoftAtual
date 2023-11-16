package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import model.Coordenador;
import control.CoordenadorControle;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class TelaCrudCoordenador extends JInternalFrame {
	private Coordenador coordenador;
	private CoordenadorControle controle = new CoordenadorControle();

	// campos da tela
	private JTextField txtCode;
	private JTextField txtName;
	private JTextField txtEmail;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnInsert;
	private JButton btnSearch;
	private JButton btnSave;
	private JTextField txtPhone;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCrudCoordenador frame = new TelaCrudCoordenador();
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
	public TelaCrudCoordenador() {
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		JLabel lblTitulo = new JLabel("Coordenador");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitulo.setBounds(10, 11, 414, 14);
		getContentPane().add(lblTitulo);

		JPanel panelFields = new JPanel();
		panelFields.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Dados do Coordenador", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelFields.setBounds(10, 36, 299, 194);
		getContentPane().add(panelFields);
		panelFields.setLayout(null);

		JLabel lblCode = new JLabel("CPF : ");
		lblCode.setBounds(10, 26, 46, 14);
		panelFields.add(lblCode);

		txtCode = new JTextField();
		txtCode.setEnabled(false);
		txtCode.setBounds(92, 23, 197, 20);
		panelFields.add(txtCode);
		txtCode.setColumns(10);

		JLabel lblName = new JLabel("Nome : ");
		lblName.setBounds(10, 60, 46, 14);
		panelFields.add(lblName);

		txtName = new JTextField();
		txtName.setEnabled(false);
		txtName.setBounds(92, 57, 197, 20);
		panelFields.add(txtName);
		txtName.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setEnabled(false);
		txtEmail.setColumns(10);
		txtEmail.setBounds(92, 95, 197, 20);
		panelFields.add(txtEmail);

		JLabel lblEmail = new JLabel("Email : ");
		lblEmail.setBounds(10, 98, 90, 14);
		panelFields.add(lblEmail);

		JLabel lblPhone = new JLabel("Telefone : ");
		lblPhone.setBounds(10, 129, 90, 14);
		panelFields.add(lblPhone);

		txtPhone = new JTextField();
		txtPhone.setEnabled(false);
		txtPhone.setColumns(10);
		txtPhone.setBounds(92, 126, 197, 20);
		panelFields.add(txtPhone);

		btnSave = new JButton("Salvar");
		btnSave.setEnabled(false);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtName.getText().length() < 5) {
					JOptionPane.showMessageDialog(btnSave, "O nome precisa ter no minimo 5 caracteres!!!");
				} else {
					if (controle.buscarPorCodigo(txtCode.getText()) != null) {
						JOptionPane.showMessageDialog(btnSave, "Já existe um usuário com este cpf!");
					} else {
						// novo coordenador
						if (coordenador == null) {
							coordenador = new Coordenador();
							coordenador.setNome(txtName.getText());
							coordenador.setEmail(txtEmail.getText());
							coordenador.setTelefone(txtPhone.getText());
							coordenador.setCodigo(txtCode.getText());
							controle.inserir(coordenador);
							JOptionPane.showMessageDialog(btnSave, "Coordenador cadastrado.");
						} else {
							// alterar
							coordenador.setNome(txtName.getText());
							coordenador.setEmail(txtEmail.getText());
							coordenador.setTelefone(txtPhone.getText());
							controle.alterar(coordenador);
							JOptionPane.showMessageDialog(btnSave, "Coordenador atualizado.");
						}
						definirEstadoConsulta();
					}
				}
			}
		});
		btnSave.setBounds(200, 160, 89, 23);
		panelFields.add(btnSave);

		JButton btnCancel = new JButton("Cancelar");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				definirEstadoInicial();
			}
		});
		btnCancel.setBounds(102, 160, 89, 23);
		panelFields.add(btnCancel);

		JPanel panelButtons = new JPanel();
		panelButtons.setBounds(319, 36, 105, 194);
		getContentPane().add(panelButtons);
		panelButtons.setLayout(null);

		btnInsert = new JButton("Novo");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				definirEstadoEdicao();
				limparCampos();
				txtCode.requestFocus();
			}
		});
		btnInsert.setBounds(10, 13, 89, 23);
		panelButtons.add(btnInsert);

		btnUpdate = new JButton("Alterar");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				definirEstadoEdicao();
				txtCode.requestFocus();
			}
		});
		btnUpdate.setEnabled(false);
		btnUpdate.setBounds(10, 49, 89, 23);
		panelButtons.add(btnUpdate);

		btnDelete = new JButton("Excluir");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (coordenador != null) {
					controle.excluir(coordenador);
					coordenador = null;
					definirEstadoInicial();
				}
			}
		});

		btnDelete.setEnabled(false);
		btnDelete.setBounds(10, 85, 89, 23);
		panelButtons.add(btnDelete);

		btnSearch = new JButton("Consultar");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codigo = JOptionPane.showInputDialog("Digite o cpf do usuario: ");
				coordenador = controle.buscarPorCodigo(codigo);
				if (coordenador != null) {
					txtCode.setText(coordenador.getCodigo());
					txtName.setText(coordenador.getNome());
					txtEmail.setText(coordenador.getEmail());
					txtPhone.setText(coordenador.getTelefone());
					definirEstadoConsulta();
				} else {
					JOptionPane.showMessageDialog(null, "Nao existe coordenador com esse cpf!");
				}
			}
		});

		btnSearch.setBounds(10, 121, 89, 23);
		panelButtons.add(btnSearch);

		JButton btnClose = new JButton("Fechar");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setBounds(10, 157, 89, 23);
		panelButtons.add(btnClose);

	}

	private void definirEstadoInicial() {
		limparCampos();
		txtName.setEnabled(false);
		txtEmail.setEnabled(false);
		txtCode.setEnabled(false);
		txtPhone.setEnabled(false);
		btnInsert.setEnabled(true);
		btnDelete.setEnabled(false);
		btnUpdate.setEnabled(false);
		btnSearch.setEnabled(true);
		btnSave.setEnabled(false);
	}

	private void definirEstadoEdicao() {
		txtName.setEnabled(true);
		txtEmail.setEnabled(true);
		txtCode.setEnabled(true);
		txtPhone.setEnabled(true);
		btnInsert.setEnabled(false);
		btnDelete.setEnabled(false);
		btnUpdate.setEnabled(false);
		btnSearch.setEnabled(false);
		btnSave.setEnabled(true);
	}

	private void definirEstadoConsulta() {
		txtName.setEnabled(false);
		txtEmail.setEnabled(false);
		txtCode.setEnabled(false);
		txtPhone.setEnabled(false);
		btnInsert.setEnabled(true);
		btnDelete.setEnabled(true);
		btnUpdate.setEnabled(true);
		btnSearch.setEnabled(true);
		btnSave.setEnabled(false);
	}

	private void limparCampos() {
		txtCode.setText("");
		txtName.setText("");
		txtEmail.setText("");
		txtPhone.setText("");
	}
}
