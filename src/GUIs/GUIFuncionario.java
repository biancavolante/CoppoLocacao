package GUIs;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.*;
import java.io.File;
import javax.swing.text.JTextComponent;
import Auxiliar.*;
import DAOs.*;
import Entidades.*;

public class GUIFuncionario extends JFrame {
    public static void main(String[] args) {
        new GUIFuncionario();
    }
    private Container cp;
    private JLabel labelAviso = new JLabel("Avisos");
    private JLabel labelTitulo = new JLabel("ID: ");
    private JLabel lbId = new JLabel("ID");
    private JTextField fdId = new JTextField(15);

    private JLabel lbNomeFuncionario = new JLabel("Nome Funcionario");
    private JTextField fdNomeFuncionario = new JTextField(45);

    private JLabel lbEndereco = new JLabel("Endereco");
    private JTextField fdEndereco = new JTextField(45);

    private JLabel lbTelefone = new JLabel("Telefone");
    private JTextField fdTelefone = new JTextField(45);

    private JLabel lbEmail = new JLabel("Email");
    private JTextField fdEmail = new JTextField(45);


    private JPanel painelNortes = new JPanel(new GridLayout(2, 1));
    private JPanel painelNorteCima = new JPanel();
    private JPanel painelNorteBaixo = new JPanel();
    private JPanel painelCentralFora = new JPanel(new BorderLayout());
    private JPanel painelCentral = new JPanel();
    private JPanel painelSul = new JPanel();
    private JLabel labelBranco = new JLabel();

    JButton btInserir = new JButton(new ImageIcon(getClass().getResource("/icones/add.png")));
    JButton btSalvar = new JButton(new ImageIcon(getClass().getResource("/icones/confirmar.png")));
    JButton btRemover = new JButton(new ImageIcon(getClass().getResource("/icones/deletar.png")));
    JButton btAtualizar = new JButton(new ImageIcon(getClass().getResource("/icones/att.png")));
    JButton btBuscar = new JButton(new ImageIcon(getClass().getResource("/icones/search.png")));
    JButton btCancelar = new JButton(new ImageIcon(getClass().getResource("/icones/cancelar.png")));
    JButton btListar = new JButton(new ImageIcon(getClass().getResource("/icones/listar.png")));
    JButton btVoltar = new JButton("VOLTAR AO MENU");

    DAOFuncionario controle = new DAOFuncionario();
    ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
    Boolean acao;
    Font fonte = new Font("Courier New", Font.BOLD, 20);
    Font fonteL = new Font("Courier New", Font.PLAIN, 14);

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    Funcionario funcionario = new Funcionario();

    public GUIFuncionario(){
        setSize(725, 420);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cp = getContentPane();
        cp.setLayout(new BorderLayout());
        setTitle("Cadastro de Funcionarios");

        painelCentral.setLayout(new GridLayout(5, 2));
        painelCentral.add(lbNomeFuncionario);
        painelCentral.add(fdNomeFuncionario);
        painelCentral.add(lbEndereco);
        painelCentral.add(fdEndereco);
        painelCentral.add(lbTelefone);
        painelCentral.add(fdTelefone);
        painelCentral.add(lbEmail);
        painelCentral.add(fdEmail);

        fdNomeFuncionario.setEnabled(false);
        fdEndereco.setEnabled(false);
        fdTelefone.setEnabled(false);
        fdEmail.setEnabled(false);

        List<String> combo = new ArrayList<>();


cp.setBackground(Color.white);
        cp.add(painelNortes, BorderLayout.NORTH);
        cp.add(painelCentralFora, BorderLayout.CENTER);
        cp.add(painelSul, BorderLayout.SOUTH);

        painelCentralFora.add(labelBranco, BorderLayout.NORTH);
        painelCentralFora.add(painelCentral, BorderLayout.SOUTH);
        painelNortes.add(painelNorteCima);
        painelNortes.add(painelNorteBaixo);
        painelNorteCima.add(labelTitulo);
        painelNorteCima.add(fdId);
        painelNorteBaixo.add(btBuscar);
        painelNorteBaixo.add(btInserir);
        painelNorteBaixo.add(btAtualizar);
        painelNorteBaixo.add(btRemover);
        painelNorteBaixo.add(btSalvar);
        painelNorteBaixo.add(btCancelar);
        painelNorteBaixo.add(btListar);
        painelNorteCima.setBackground(Color.white);
        painelNorteBaixo.setBackground(Color.white);
        painelCentralFora.setBackground(Color.white);
        painelCentral.setBackground(Color.white);
        painelSul.setBackground(Color.white);
        btInserir.setBackground(Color.WHITE);
        btSalvar.setBackground(Color.WHITE);
        btRemover.setBackground(Color.WHITE);
        btAtualizar.setBackground(Color.WHITE);
        btBuscar.setBackground(Color.WHITE);
        btCancelar.setBackground(Color.WHITE);
        btListar.setBackground(Color.WHITE);
        btVoltar.setBackground(Color.WHITE);

        labelTitulo.setFont(new Font("Courier New", Font.BOLD, 20));
        fdId.setFont(new Font("Courier New", Font.PLAIN, 20));
        lbId.setFont(new Font("Courier New", Font.BOLD, 17));
        lbNomeFuncionario.setFont(new Font("Courier New", Font.BOLD, 17));
        lbEndereco.setFont(new Font("Courier New", Font.BOLD, 17));
        lbTelefone.setFont(new Font("Courier New", Font.BOLD, 17));
        lbEmail.setFont(new Font("Courier New", Font.BOLD, 17));
        fdId.setFont(new Font("Courier New", Font.PLAIN, 17));
        fdNomeFuncionario.setFont(new Font("Courier New", Font.PLAIN, 17));
        fdEndereco.setFont(new Font("Courier New", Font.PLAIN, 17));
        fdTelefone.setFont(new Font("Courier New", Font.PLAIN, 17));
        fdEmail.setFont(new Font("Courier New", Font.PLAIN, 17));
        labelAviso.setFont(new Font("Courier New", Font.BOLD, 20));
        btVoltar.setFont(new Font("Courier New", Font.BOLD, 20));
        btInserir.setVisible(false);
        btAtualizar.setVisible(false);
        btRemover.setVisible(false);
        btSalvar.setVisible(false);
        btCancelar.setVisible(false);

        painelSul.add(labelAviso);
        painelSul.add(btVoltar);

        btBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    funcionario = new Funcionario();
                    int id = Integer.valueOf(fdId.getText());
                    funcionario.setId(Integer.valueOf(fdId.getText()));
                    funcionario = controle.obter(funcionario.getId());
                    labelAviso.setBackground(Color.green);
                    if (funcionario != null) {
                        fdId.setText(funcionario.getId() + "");
                        fdNomeFuncionario.setText(funcionario.getNomeFuncionario() + "");
                        fdEndereco.setText(funcionario.getEndereco() + "");
                        fdTelefone.setText(funcionario.getTelefone() + "");
                        fdEmail.setText(funcionario.getEmail() + "");
                        btAtualizar.setVisible(true);
                        btRemover.setVisible(true);
                        btInserir.setVisible(false);
                        btListar.setVisible(false);
                        labelAviso.setText("Encontrado na lista!");
                        labelAviso.setBackground(Color.green);
                    } else {
                        fdNomeFuncionario.setEnabled(false);
                        fdNomeFuncionario.setText(null);
                        fdEndereco.setEnabled(false);
                        fdEndereco.setText(null);
                        fdTelefone.setEnabled(false);
                        fdTelefone.setText(null);
                        fdEmail.setEnabled(false);
                        fdEmail.setText(null);
                        labelAviso.setText("Não encontrado!");
                        labelAviso.setBackground(Color.red);
                        btInserir.setVisible(true);
                        btAtualizar.setVisible(false);
                        btRemover.setVisible(false);
                        btListar.setVisible(false);
                    }
                } catch (Exception erro) {
                    labelAviso.setText("Preencha os campos corretamente!");
                    labelAviso.setBackground(Color.red);
                }
            }
        }
        );

        btInserir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                acao = true;
                fdId.setEnabled(false);
                fdNomeFuncionario.setEnabled(true);
                fdEndereco.setEnabled(true);
                fdTelefone.setEnabled(true);
                fdEmail.setEnabled(true);
                btSalvar.setVisible(true);
                btCancelar.setVisible(true);
                btBuscar.setVisible(false);
                btInserir.setVisible(false);
                btListar.setVisible(false);
            }
        }
        );

        btSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(acao){ //btInserir
                    try {
                    funcionario = new Funcionario();
                        funcionario.setId(Integer.valueOf(fdId.getText()));
                        funcionario.setNomeFuncionario(fdNomeFuncionario.getText());
                        funcionario.setEndereco(fdEndereco.getText());
                        funcionario.setTelefone(fdTelefone.getText());
                        funcionario.setEmail(fdEmail.getText());
                        controle.inserir(funcionario);
                        labelAviso.setText("Registro inserido com sucesso!");
                        fdId.setEnabled(true);
                        fdId.requestFocus();
                        fdNomeFuncionario.setEnabled(false);
                        fdEndereco.setEnabled(false);
                        fdTelefone.setEnabled(false);
                        fdEmail.setEnabled(false);
                        btSalvar.setVisible(false);
                        btCancelar.setVisible(false);
                        btBuscar.setVisible(true);
                        btListar.setVisible(true);
                    } catch (Exception erro) {
                        labelAviso.setText("Erro nos dados!");
                    }
                } else { //btAlterar
                    try {
                        funcionario = new Funcionario();
                        funcionario.setId(Integer.valueOf(fdId.getText()));
                        funcionario.setNomeFuncionario(fdNomeFuncionario.getText());
                        funcionario.setEndereco(fdEndereco.getText());
                        funcionario.setTelefone(fdTelefone.getText());
                        funcionario.setEmail(fdEmail.getText());
                        controle.atualizar(funcionario);
                        labelAviso.setText("Registro alterado com sucesso!");
                        fdId.setEnabled(true);
                        fdId.requestFocus();
                        fdNomeFuncionario.setEnabled(false);
                        fdEndereco.setEnabled(false);
                        fdTelefone.setEnabled(false);
                        fdEmail.setEnabled(false);
                        btSalvar.setVisible(false);
                        btCancelar.setVisible(false);
                        btBuscar.setVisible(true);
                        btListar.setVisible(true);
                    } catch (Exception erro) {
                        labelAviso.setText("Erro nos dados!");
                    }
                }
            }
        }
    );

        btCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelAviso.setText("Cancelado!");
                fdId.setEnabled(false);
                fdId.setText("");
                fdNomeFuncionario.setEnabled(false);
                fdNomeFuncionario.setText("");
                fdEndereco.setEnabled(false);
                fdEndereco.setText("");
                fdTelefone.setEnabled(false);
                fdTelefone.setText("");
                fdEmail.setEnabled(false);
                fdEmail.setText("");
                fdId.setEnabled(true);
                fdId.requestFocus();
                btSalvar.setVisible(false);
                btCancelar.setVisible(false);
                btBuscar.setVisible(true);
                btListar.setVisible(true);
            }
        }
        );

        btAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                acao = false;
                fdNomeFuncionario.setEnabled(true);
                fdEndereco.setEnabled(true);
                fdTelefone.setEnabled(true);
                fdEmail.setEnabled(true);
                fdNomeFuncionario.requestFocus();
                fdId.setEnabled(false);
                btSalvar.setVisible(true);
                btCancelar.setVisible(true);
                btBuscar.setVisible(false);
                btRemover.setVisible(false);
                btAtualizar.setVisible(false);
                btListar.setVisible(false);
            }
        }
        );

        btRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btRemover.setVisible(false);
                btListar.setVisible(false);
                btAtualizar.setVisible(false);
                if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "Confirma a exclusão do registro <Chave = " + funcionario.getId() + " >?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
                    controle.remover(funcionario);
                    labelAviso.setText("Removido!");
                    fdId.setText("");
                    fdNomeFuncionario.setText("");
                    fdNomeFuncionario.setEnabled(false);
                    fdEndereco.setText("");
                    fdEndereco.setEnabled(false);
                    fdTelefone.setText("");
                    fdTelefone.setEnabled(false);
                    fdEmail.setText("");
                    fdEmail.setEnabled(false);
                    btListar.setVisible(true);
                } else {
                    labelAviso.setText("Remoção cancelada!");
                    btAtualizar.setVisible(true);
                    btRemover.setVisible(true);
                }
            }
        }
        );


        btListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FuncionarioGUIListagem(controle.listInOrderNomeStrings("tanto faz"), cp);
            }
        }
        );
            btVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            
                GUIMenu guiMenu = new GUIMenu(); 
            dispose();}
        });
        

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        }
        );
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
