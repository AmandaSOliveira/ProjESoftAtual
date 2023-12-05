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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;

import model.Aluno;
import model.Coordenador;
import model.ProfessorOrientador;
import control.AlunoControle;
import control.CoordenadorControle;
import control.ProfessorOrientadorControle;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class TelaCrudAluno extends JInternalFrame {
	private Aluno aluno;
	private AlunoControle controle = new AlunoControle();
	private List<ProfessorOrientador> listaProf = new ArrayList<>();
	private List<Coordenador> listaCoordenador = new ArrayList<>();

	// campos da tela
	private JTextField txtCpf;
	private JTextField txtName;
	private JTextField txtEmail;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnInsert;
	private JButton btnSearch;
	private JTextField txtPhone;
	private JLabel lblCurriculum;
	private JTextField txtCurriculum;
	private JTabbedPane tabbedPane;
	private JPanel panelFields_1;
	private JLabel lblTeacherCode;
	private JLabel lblCoordinatorCode;
	private JTextField txtCurso;
	private JLabel lblCourseCode;
	private JButton btnSave;
	private JButton btnCancel;
	private JComboBox cbProfessor;
	private JComboBox cbCoordenador;

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
		listaProf = (new ProfessorOrientadorControle()).buscarTodos();
		listaCoordenador = (new CoordenadorControle()).buscarTodos();
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		JLabel lblTitulo = new JLabel("Aluno");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitulo.setBounds(319, 11, 105, 14);
		getContentPane().add(lblTitulo);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 299, 249);
		getContentPane().add(tabbedPane);

		JPanel panelFields = new JPanel();
		tabbedPane.addTab("Dados pessoais", null, panelFields, null);
		panelFields.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Dados do Aluno", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelFields.setLayout(null);

		JLabel lblCpf = new JLabel("Matrícula: ");
		lblCpf.setBounds(10, 26, 74, 14);
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
		panelFields_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Dados do Aluno", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		tabbedPane.addTab("Dados Institucionais", null, panelFields_1, null);

		lblTeacherCode = new JLabel("Professor : ");
		lblTeacherCode.setBounds(10, 26, 109, 14);
		panelFields_1.add(lblTeacherCode);

		lblCoordinatorCode = new JLabel("Coordenador : ");
		lblCoordinatorCode.setBounds(10, 60, 109, 14);
		panelFields_1.add(lblCoordinatorCode);

		txtCurso = new JTextField();
		txtCurso.setEnabled(false);
		txtCurso.setColumns(10);
		txtCurso.setBounds(129, 95, 160, 20);
		panelFields_1.add(txtCurso);

		lblCourseCode = new JLabel("Cód. Curso: ");
		lblCourseCode.setBounds(10, 98, 109, 14);
		panelFields_1.add(lblCourseCode);

		btnSave = new JButton("Salvar");
		btnSave.setEnabled(false);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtName.getText().length() < 5) {
					JOptionPane.showMessageDialog(btnSave, "O nome precisa ter no minimo 5 caracteres!!!");
				} else {
					// novo aluno
					if (aluno == null) {
						aluno = new Aluno();
						aluno.setNome(txtName.getText());
						aluno.setEmail(txtEmail.getText());
						aluno.setFone(txtPhone.getText());
						aluno.setCpf(txtCpf.getText());
						aluno.setMatricula(txtCpf.getText());
						aluno.setCurriculo(txtCurriculum.getText());
						aluno.setCodigoCurso(txtCurso.getText());
						aluno.setProfessor((ProfessorOrientador) cbProfessor.getSelectedItem());
						aluno.setCoordenador((Coordenador) cbCoordenador.getSelectedItem());
						try {
							controle.inserir(aluno);
							JOptionPane.showMessageDialog(btnSave, "Aluno cadastrado.");
							definirEstadoConsulta();
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(btnSave,
									"Não foi possível cadastrar aluno! \n" + e1.getMessage(),
									"Erro no cadastro de Aluno!", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						// alterar
						aluno.setNome(txtName.getText());
						aluno.setEmail(txtEmail.getText());
						aluno.setFone(txtPhone.getText());
						aluno.setCpf(txtCpf.getText());
						aluno.setMatricula(txtCpf.getText());
						aluno.setCurriculo(txtCurriculum.getText());
						aluno.setCodigoCurso(txtCurso.getText());
						aluno.setProfessor((ProfessorOrientador) cbProfessor.getSelectedItem());
						aluno.setCoordenador((Coordenador) cbCoordenador.getSelectedItem());
						try {
							controle.alterar(aluno);
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(btnSave,
									"Não foi possível atualizar aluno! \n" + e1.getMessage(),
									"Erro na alteração do Aluno!", JOptionPane.ERROR_MESSAGE);
						}
						definirEstadoConsulta();
						JOptionPane.showMessageDialog(btnSave, "Aluno atualizado.");
					}
				}
			}
		});
		btnSave.setEnabled(false);
		btnSave.setBounds(200, 190, 89, 23);
		panelFields_1.add(btnSave);

		btnCancel = new JButton("Cancelar");
		btnCancel.setBounds(102, 190, 89, 23);
		panelFields_1.add(btnCancel);

		cbProfessor = new JComboBox();
		Object[] profs = listaProf.toArray();
		Arrays.sort(profs);
		cbProfessor.setModel(new DefaultComboBoxModel(profs));

		cbProfessor.setBounds(129, 22, 160, 22);
		panelFields_1.add(cbProfessor);

		cbCoordenador = new JComboBox();
		Object[] coordenadores = listaCoordenador.toArray();
		Arrays.sort(coordenadores);
		cbCoordenador.setModel(new DefaultComboBoxModel(coordenadores));
		cbCoordenador.setBounds(129, 56, 160, 22);
		panelFields_1.add(cbCoordenador);

		JPanel panelButtons = new JPanel();
		panelButtons.setBounds(319, 36, 105, 194);
		getContentPane().add(panelButtons);
		panelButtons.setLayout(null);

		btnInsert = new JButton("Novo");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aluno = null;
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
				if (aluno != null) {
					controle.excluir(aluno);
					aluno = null;
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
				aluno = controle.buscarPorCodigo(codigo);
				if (aluno != null) {
					txtCpf.setText(aluno.getCpf());
					txtName.setText(aluno.getNome());
					txtEmail.setText(aluno.getEmail());
					txtPhone.setText(aluno.getFone());
					txtCurriculum.setText(aluno.getCurriculo());
					txtCurso.setText(aluno.getCodigoCurso());
					cbProfessor.setSelectedItem(aluno.getProfessor());
					cbCoordenador.setSelectedItem(aluno.getCoordenador());
					definirEstadoConsulta();
				} else {
					JOptionPane.showMessageDialog(null, "Nao existe Aluno com essa matrícula!");
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
		txtCurso.setEnabled(false);
		cbProfessor.setEnabled(false);
		cbCoordenador.setEnabled(false);
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
		txtCurso.setEnabled(true);
		cbProfessor.setEnabled(true);
		cbCoordenador.setEnabled(true);
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
		txtCurso.setEnabled(false);
		cbProfessor.setEnabled(false);
		cbCoordenador.setEnabled(false);
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
		txtCurso.setText("");
		cbProfessor.setSelectedIndex(-1);
		cbCoordenador.setSelectedIndex(-1);
	}
}
