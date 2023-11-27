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

import model.ProfessorOrientador;
import control.ProfessorOrientadorControle;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTabbedPane;

public class TelaCrudAluno extends JInternalFrame {
	private ProfessorOrientador professor;
	private ProfessorOrientadorControle controle = new ProfessorOrientadorControle();

	// campos da tela
	private JTextField txtCpf;
	private JTextField txtName;
	private JTextField txtEmail;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnInsert;
	private JButton btnSearch;
	private JButton btnSave;
	private JTextField txtPhone;
	private JLabel lblCurriculum;
	private JTextField txtCurriculum;
	private JTabbedPane tabbedPane;
	private JPanel panelFields_1;
	private JLabel lblCpf_1;
	private JTextField textField;
	private JLabel lblName_1;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblEmail_1;
	private JButton btnSave_1;
	private JButton btnCancel_1;
	private JLabel lblPhone_1;
	private JTextField textField_3;
	private JLabel lblCurriculum_1;
	private JTextField textField_4;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCrudAluno frame = new TelaCrudAluno();
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
	public TelaCrudAluno() {
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		JLabel lblTitulo = new JLabel("Aluno");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitulo.setBounds(10, 11, 414, 14);
		getContentPane().add(lblTitulo);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 36, 299, 224);
		getContentPane().add(tabbedPane);

		JPanel panelFields = new JPanel();
		tabbedPane.addTab("Dados pessoais", null, panelFields, null);
		panelFields.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Dados do Aluno", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelFields.setLayout(null);

		JLabel lblCpf = new JLabel("CPF : ");
		lblCpf.setBounds(10, 26, 46, 14);
		panelFields.add(lblCpf);

		txtCpf = new JTextField();
		txtCpf.setEnabled(false);
		txtCpf.setBounds(92, 23, 197, 20);
		panelFields.add(txtCpf);
		txtCpf.setColumns(10);

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

		btnSave = new JButton("Salvar");
		btnSave.setEnabled(false);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtName.getText().length() < 5) {
					JOptionPane.showMessageDialog(btnSave, "O nome precisa ter no minimo 5 caracteres!!!");
				} else {
					if (controle.buscarPorCodigo(txtCpf.getText()) != null) {
						JOptionPane.showMessageDialog(btnSave, "Já existe um usuário com este cpf!");
					} else {
						// novo professor
						if (professor == null) {
							professor = new ProfessorOrientador();
							professor.setNome(txtName.getText());
							professor.setEmail(txtEmail.getText());
							professor.setFone(txtPhone.getText());
							professor.setCodigo(txtCpf.getText());
							professor.setCpf(txtCpf.getText());
							professor.setLattes(txtCurriculum.getText());
							// controle.inserir(professor);
							JOptionPane.showMessageDialog(btnSave, "Aluno cadastrado.");
						} else {
							// alterar
							professor.setNome(txtName.getText());
							professor.setCodigo(txtCpf.getText());
							professor.setEmail(txtEmail.getText());
							professor.setFone(txtPhone.getText());
							professor.setCpf(txtCpf.getText());
							professor.setLattes(txtCurriculum.getText());
							controle.alterar(professor);
							JOptionPane.showMessageDialog(btnSave, "Aluno atualizado.");
						}
						definirEstadoConsulta();
					}
				}
			}
		});
		btnSave.setBounds(200, 190, 89, 23);
		panelFields.add(btnSave);

		JButton btnCancel = new JButton("Cancelar");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				definirEstadoInicial();
			}
		});
		btnCancel.setBounds(102, 190, 89, 23);
		panelFields.add(btnCancel);

		JLabel lblPhone = new JLabel("Telefone : ");
		lblPhone.setBounds(10, 129, 90, 14);
		panelFields.add(lblPhone);

		txtPhone = new JTextField();
		txtPhone.setEnabled(false);
		txtPhone.setColumns(10);
		txtPhone.setBounds(92, 126, 197, 20);
		panelFields.add(txtPhone);

		lblCurriculum = new JLabel("Curriculo : ");
		lblCurriculum.setBounds(10, 162, 90, 14);
		panelFields.add(lblCurriculum);

		txtCurriculum = new JTextField();
		txtCurriculum.setEnabled(false);
		txtCurriculum.setColumns(10);
		txtCurriculum.setBounds(92, 159, 197, 20);
		panelFields.add(txtCurriculum);
		
		panelFields_1 = new JPanel();
		panelFields_1.setLayout(null);
		panelFields_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Dados do Aluno", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		tabbedPane.addTab("Dados Institucionais", null, panelFields_1, null);
		
		lblCpf_1 = new JLabel("CPF : ");
		lblCpf_1.setBounds(10, 26, 46, 14);
		panelFields_1.add(lblCpf_1);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setColumns(10);
		textField.setBounds(92, 23, 197, 20);
		panelFields_1.add(textField);
		
		lblName_1 = new JLabel("Nome : ");
		lblName_1.setBounds(10, 60, 46, 14);
		panelFields_1.add(lblName_1);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setColumns(10);
		textField_1.setBounds(92, 57, 197, 20);
		panelFields_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setColumns(10);
		textField_2.setBounds(92, 95, 197, 20);
		panelFields_1.add(textField_2);
		
		lblEmail_1 = new JLabel("Email : ");
		lblEmail_1.setBounds(10, 98, 90, 14);
		panelFields_1.add(lblEmail_1);
		
		btnSave_1 = new JButton("Salvar");
		btnSave_1.setEnabled(false);
		btnSave_1.setBounds(200, 190, 89, 23);
		panelFields_1.add(btnSave_1);
		
		btnCancel_1 = new JButton("Cancelar");
		btnCancel_1.setBounds(102, 190, 89, 23);
		panelFields_1.add(btnCancel_1);
		
		lblPhone_1 = new JLabel("Telefone : ");
		lblPhone_1.setBounds(10, 129, 90, 14);
		panelFields_1.add(lblPhone_1);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setColumns(10);
		textField_3.setBounds(92, 126, 197, 20);
		panelFields_1.add(textField_3);
		
		lblCurriculum_1 = new JLabel("Curriculo : ");
		lblCurriculum_1.setBounds(10, 162, 90, 14);
		panelFields_1.add(lblCurriculum_1);
		
		textField_4 = new JTextField();
		textField_4.setEnabled(false);
		textField_4.setColumns(10);
		textField_4.setBounds(92, 159, 197, 20);
		panelFields_1.add(textField_4);

		JPanel panelButtons = new JPanel();
		panelButtons.setBounds(319, 36, 105, 194);
		getContentPane().add(panelButtons);
		panelButtons.setLayout(null);

		btnInsert = new JButton("Novo");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				definirEstadoEdicao();
				limparCampos();
				txtCpf.requestFocus();
			}
		});
		btnInsert.setBounds(10, 13, 89, 23);
		panelButtons.add(btnInsert);

		btnUpdate = new JButton("Alterar");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				definirEstadoEdicao();
				txtCpf.requestFocus();
			}
		});
		btnUpdate.setEnabled(false);
		btnUpdate.setBounds(10, 49, 89, 23);
		panelButtons.add(btnUpdate);

		btnDelete = new JButton("Excluir");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (professor != null) {
					controle.excluir(professor);
					professor = null;
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
				professor = controle.buscarPorCodigo(codigo);
				if (professor != null) {
					txtCpf.setText(professor.getCodigo());
					txtName.setText(professor.getNome());
					txtEmail.setText(professor.getEmail());
					txtPhone.setText(professor.getFone());
					txtCurriculum.setText(professor.getLattes());
					definirEstadoConsulta();
				} else {
					JOptionPane.showMessageDialog(null, "Nao existe Aluno com esse cpf!");
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
		txtCpf.setEnabled(false);
		txtPhone.setEnabled(false);
		txtCurriculum.setEnabled(false);
		btnInsert.setEnabled(true);
		btnDelete.setEnabled(false);
		btnUpdate.setEnabled(false);
		btnSearch.setEnabled(true);
		btnSave.setEnabled(false);
	}

	private void definirEstadoEdicao() {
		txtName.setEnabled(true);
		txtEmail.setEnabled(true);
		txtCpf.setEnabled(true);
		txtPhone.setEnabled(true);
		txtCurriculum.setEnabled(true);
		btnInsert.setEnabled(false);
		btnDelete.setEnabled(false);
		btnUpdate.setEnabled(false);
		btnSearch.setEnabled(false);
		btnSave.setEnabled(true);
	}

	private void definirEstadoConsulta() {
		txtName.setEnabled(false);
		txtEmail.setEnabled(false);
		txtCpf.setEnabled(false);
		txtPhone.setEnabled(false);
		txtCurriculum.setEnabled(false);
		btnInsert.setEnabled(true);
		btnDelete.setEnabled(true);
		btnUpdate.setEnabled(true);
		btnSearch.setEnabled(true);
		btnSave.setEnabled(false);
	}

	private void limparCampos() {
		txtCpf.setText("");
		txtName.setText("");
		txtEmail.setText("");
		txtPhone.setText("");
		txtCurriculum.setText("");
	}
}
