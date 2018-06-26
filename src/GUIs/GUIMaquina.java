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

public class GUIMaquina extends JFrame {
    public static void main(String[] args) {
        new GUIMaquina();
    }
    private Container cp;
    private JLabel labelAviso = new JLabel("Avisos");
    private JLabel labelTitulo = new JLabel("ID Maquina: ");
    private JLabel lbIdMaquina = new JLabel("ID Maquina");
    private JTextField fdIdMaquina = new JTextField(15);

    private JLabel lbNomeMaquina = new JLabel("Nome Maquina");
    private JTextField fdNomeMaquina = new JTextField(45);

    private JLabel lbValorHora = new JLabel("Valor Hora");
    private JTextField fdValorHora = new JTextField(0);


    private JPanel painelNortes = new JPanel(new GridLayout(2, 1));
    private JPanel painelNorteCima = new JPanel();
    private JPanel painelNorteBaixo = new JPanel();
    private JPanel painelCentralFora = new JPanel(new BorderLayout());
    private JPanel painelCentral = new JPanel();
    private JPanel painelSul = new JPanel( new GridLayout(2,1));
    private JLabel labelBranco = new JLabel();

    JButton btInserir = new JButton(new ImageIcon(getClass().getResource("/icones/add.png")));
    JButton btSalvar = new JButton(new ImageIcon(getClass().getResource("/icones/confirmar.png")));
    JButton btRemover = new JButton(new ImageIcon(getClass().getResource("/icones/deletar.png")));
    JButton btAtualizar = new JButton(new ImageIcon(getClass().getResource("/icones/att.png")));
    JButton btBuscar = new JButton(new ImageIcon(getClass().getResource("/icones/search.png")));
    JButton btCancelar = new JButton(new ImageIcon(getClass().getResource("/icones/cancelar.png")));
    JButton btListar = new JButton(new ImageIcon(getClass().getResource("/icones/listar.png")));
    JButton btVoltar = new JButton("VOLTAR AO MENU");
    
    DAOMaquina controle = new DAOMaquina();
    ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
    Boolean acao;
    Font fonte = new Font("Courier New", Font.BOLD, 20);
    Font fonteL = new Font("Courier New", Font.PLAIN, 14);

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    Maquina maquina = new Maquina();

    public GUIMaquina(){
        setSize(725, 340);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cp = getContentPane();
        cp.setLayout(new BorderLayout());
        setTitle("Cadastro de Maquinas");

        painelCentral.setLayout(new GridLayout(3, 2));
        painelCentral.add(lbNomeMaquina);
        painelCentral.add(fdNomeMaquina);
        painelCentral.add(lbValorHora);
        painelCentral.add(fdValorHora);

        fdNomeMaquina.setEnabled(false);
        fdValorHora.setEnabled(false);

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
        painelNorteCima.add(fdIdMaquina);
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
        fdIdMaquina.setFont(new Font("Courier New", Font.PLAIN, 20));
        lbIdMaquina.setFont(new Font("Courier New", Font.BOLD, 17));
        lbNomeMaquina.setFont(new Font("Courier New", Font.BOLD, 17));
        lbValorHora.setFont(new Font("Courier New", Font.BOLD, 17));
        fdIdMaquina.setFont(new Font("Courier New", Font.PLAIN, 17));
        fdNomeMaquina.setFont(new Font("Courier New", Font.PLAIN, 17));
        fdValorHora.setFont(new Font("Courier New", Font.PLAIN, 17));
        labelAviso.setFont(new Font("Courier New", Font.BOLD, 20));
        btVoltar.setFont(new Font ("Courier New", Font.BOLD,20));
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
                    maquina = new Maquina();
                    int idMaquina = Integer.valueOf(fdIdMaquina.getText());
                    maquina.setIdMaquina(Integer.valueOf(fdIdMaquina.getText()));
                    maquina = controle.obter(maquina.getIdMaquina());
                    labelAviso.setBackground(Color.green);
                    if (maquina != null) {
                        fdIdMaquina.setText(maquina.getIdMaquina() + "");
                        fdNomeMaquina.setText(maquina.getNomeMaquina() + "");
                        fdValorHora.setText(maquina.getValorHora() + "");
                        btAtualizar.setVisible(true);
                        btRemover.setVisible(true);
                        btInserir.setVisible(false);
                        btListar.setVisible(false);
                        labelAviso.setText("Encontrado na lista!");
                        labelAviso.setBackground(Color.green);
                    } else {
                        fdNomeMaquina.setEnabled(false);
                        fdNomeMaquina.setText(null);
                        fdValorHora.setEnabled(false);
                        fdValorHora.setText(null);
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
                fdIdMaquina.setEnabled(false);
                fdNomeMaquina.setEnabled(true);
                fdValorHora.setEnabled(true);
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
                    maquina = new Maquina();
                        maquina.setIdMaquina(Integer.valueOf(fdIdMaquina.getText()));
                        maquina.setNomeMaquina(fdNomeMaquina.getText());
                        maquina.setValorHora(Double.valueOf(fdValorHora.getText()));
                        controle.inserir(maquina);
                        labelAviso.setText("Registro inserido com sucesso!");
                        fdIdMaquina.setEnabled(true);
                        fdIdMaquina.requestFocus();
                        fdNomeMaquina.setEnabled(false);
                        fdValorHora.setEnabled(false);
                        btSalvar.setVisible(false);
                        btCancelar.setVisible(false);
                        btBuscar.setVisible(true);
                        btListar.setVisible(true);
                    } catch (Exception erro) {
                        labelAviso.setText("Erro nos dados!");
                    }
                } else { //btAlterar
                    try {
                        maquina = new Maquina();
                        maquina.setIdMaquina(Integer.valueOf(fdIdMaquina.getText()));
                        maquina.setNomeMaquina(fdNomeMaquina.getText());
                        maquina.setValorHora(Double.valueOf(fdValorHora.getText()));
                        controle.atualizar(maquina);
                        labelAviso.setText("Registro alterado com sucesso!");
                        fdIdMaquina.setEnabled(true);
                        fdIdMaquina.requestFocus();
                        fdNomeMaquina.setEnabled(false);
                        fdValorHora.setEnabled(false);
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
                fdIdMaquina.setEnabled(false);
                fdIdMaquina.setText("");
                fdNomeMaquina.setEnabled(false);
                fdNomeMaquina.setText("");
                fdValorHora.setEnabled(false);
                fdValorHora.setText("");
                fdIdMaquina.setEnabled(true);
                fdIdMaquina.requestFocus();
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
                fdNomeMaquina.setEnabled(true);
                fdValorHora.setEnabled(true);
                fdNomeMaquina.requestFocus();
                fdIdMaquina.setEnabled(false);
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
                if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "Confirma a exclusão do registro <Chave = " + maquina.getIdMaquina() + " >?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
                    controle.remover(maquina);
                    labelAviso.setText("Removido!");
                    fdIdMaquina.setText("");
                    fdNomeMaquina.setText("");
                    fdNomeMaquina.setEnabled(false);
                    fdValorHora.setText("");
                    fdValorHora.setEnabled(false);
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
                new MaquinaGUIListagem(controle.listInOrderNomeStrings("tanto faz"), cp);
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
