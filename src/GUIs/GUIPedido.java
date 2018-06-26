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

public class GUIPedido extends JFrame {
    public static void main(String[] args) {
        new GUIPedido();
    }
    private Container cp;
    private JLabel labelAviso = new JLabel("Avisos");
    private JLabel labelTitulo = new JLabel("ID: ");
    private JLabel lbIdPedido = new JLabel("ID");
    private JTextField fdIdPedido = new JTextField(15);

    private JSpinner spinnerdataPedido = new JSpinner(new SpinnerDateModel());
    private final JSpinner.DateEditor spinnerEditordataPedido = new JSpinner.DateEditor(spinnerdataPedido, "dd/MM/yyyy");
    private JLabel lbDataPedido = new JLabel("Data");
    private JLabel lbClienteRG = new JLabel("RG Cliente");
    private List<String> stringclienteRG = new ArrayList<>();
    private JComboBox comboClienteRG = new JComboBox();
    private JLabel lbFuncionario = new JLabel("Funcionario");
    private List<String> stringfuncionario = new ArrayList<>();
    private JComboBox comboFuncionario = new JComboBox();

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
     
    DAOPedido controle = new DAOPedido();
    ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
    Boolean acao;
    Font fonte = new Font("Courier New", Font.BOLD, 20);
    Font fonteL = new Font("Courier New", Font.PLAIN, 14);

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    JTextComponent editor = (JTextComponent) comboClienteRG.getEditor().getEditorComponent();

    Pedido pedido = new Pedido();
    DAOPedido daoPedido = new DAOPedido();

    public GUIPedido(){
        setSize(725, 380);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cp = getContentPane();
        cp.setLayout(new BorderLayout());
        setTitle("Cadastro de Pedidos");

        painelCentral.setLayout(new GridLayout(4, 2));


        painelCentral.add(lbDataPedido);
        painelCentral.add(spinnerdataPedido);
        spinnerdataPedido.setEditor(spinnerEditordataPedido);
        spinnerdataPedido.setEnabled(false);
        List<String> combo = new ArrayList<>();
        combo = new ManipulaArquivo().abrirArquivo("Pedido.txt");
        for(int x = 0; x < combo.size(); x++) {
            stringclienteRG.add(combo.get(x).split(";")[0]);
        }
        comboClienteRG = new JComboBox(stringclienteRG.toArray());
        painelCentral.add(lbClienteRG);
        painelCentral.add(comboClienteRG);
        comboClienteRG.setEnabled(false);
        editor.setDocument(new SearchableComboBox(comboClienteRG));
        combo = new ManipulaArquivo().abrirArquivo("Funcionario.txt");
        for(int x = 0; x < combo.size(); x++) {
            stringfuncionario.add(combo.get(x).split(";")[0]);
        }
        comboFuncionario = new JComboBox(stringfuncionario.toArray());
        painelCentral.add(lbFuncionario);
        painelCentral.add(comboFuncionario);
        comboFuncionario.setEnabled(false);
        editor.setDocument(new SearchableComboBox(comboFuncionario));


cp.setBackground(Color.white);
        cp.add(painelNortes, BorderLayout.NORTH);
        cp.add(painelCentralFora, BorderLayout.CENTER);
        cp.add(painelSul, BorderLayout.SOUTH);

        painelCentralFora.add(labelBranco, BorderLayout.NORTH);
        painelCentralFora.add(painelCentral, BorderLayout.SOUTH);
        painelNortes.add(painelNorteCima);
        painelNortes.add(painelNorteBaixo);
        painelNorteCima.add(labelTitulo);
        painelNorteCima.add(fdIdPedido);
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
        fdIdPedido.setFont(new Font("Courier New", Font.PLAIN, 20));
        lbIdPedido.setFont(new Font("Courier New", Font.BOLD, 17));
        lbDataPedido.setFont(new Font("Courier New", Font.BOLD, 17));
        lbClienteRG.setFont(new Font("Courier New", Font.BOLD, 17));
        lbFuncionario.setFont(new Font("Courier New", Font.BOLD, 17));
        fdIdPedido.setFont(new Font("Courier New", Font.PLAIN, 17));
        spinnerdataPedido.setFont(new Font("Courier New", Font.PLAIN, 17));
        comboClienteRG.setFont(new Font("Courier New", Font.PLAIN, 17));
        comboFuncionario.setFont(new Font("Courier New", Font.PLAIN, 17));
        labelAviso.setFont(new Font("Courier New", Font.BOLD, 20));
        btVoltar.setFont(new Font ("Courier New", Font.BOLD,20));
        btInserir.setVisible(false);
        btAtualizar.setVisible(false);
        btRemover.setVisible(false);
        btSalvar.setVisible(false);
        btCancelar.setVisible(false);

        painelSul.add(labelAviso);
        painelSul.add(btVoltar);
        
        List<String> ltc = daoPedido.listInOrderNomeStrings("id"); //lista tipo carteira (ltc)
        for (int i = 0; i < ltc.size(); i++) {
            comboClienteRG.addItem(ltc.get(i));
            comboFuncionario.addItem(ltc.get(i));
        }
        
        btBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    pedido = new Pedido();
                    int idPedido = Integer.valueOf(fdIdPedido.getText());
                    pedido.setIdPedido(Integer.valueOf(fdIdPedido.getText()));
                    pedido = controle.obter(pedido.getIdPedido());
                    labelAviso.setBackground(Color.green);
                    if (pedido != null) {
                        fdIdPedido.setText(pedido.getIdPedido() + "");
                        spinnerdataPedido.setValue(pedido.getDataPedido());
                        
                        String x = (String) comboClienteRG.getSelectedItem();
                        String[] aux = x.split(";");
                        Pedido clienteRg = daoPedido.obter(Integer.valueOf(aux[0]));
//                        pedido.setClienteRg(clienteRg);
                        
                        btAtualizar.setVisible(true);
                        btRemover.setVisible(true);
                        btInserir.setVisible(false);
                        btListar.setVisible(false);
                        labelAviso.setText("Encontrado na lista!");
                        labelAviso.setBackground(Color.green);
                    } else {
                        spinnerdataPedido.setEnabled(false);
                        spinnerdataPedido.setValue(new Date());
                        comboClienteRG.setEnabled(false);
                        comboClienteRG.setSelectedIndex(0);
                        comboFuncionario.setEnabled(false);
                        comboFuncionario.setSelectedIndex(0);
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
                fdIdPedido.setEnabled(false);
                spinnerdataPedido.setEnabled(true);
                comboClienteRG.setEnabled(true);
                comboFuncionario.setEnabled(true);
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
                    pedido = new Pedido();
                        pedido.setIdPedido(Integer.valueOf(fdIdPedido.getText()));
                        pedido.setDataPedido((Date) spinnerdataPedido.getValue());
//                        pedido.setClienteRG(comboClienteRG.getSelectedItem().toString());
//                        pedido.setFuncionario(comboFuncionario.getSelectedItem().toString());
                        controle.inserir(pedido);
                        labelAviso.setText("Registro inserido com sucesso!");
                        fdIdPedido.setEnabled(true);
                        fdIdPedido.requestFocus();
                        spinnerdataPedido.setEnabled(false);
                        comboClienteRG.setEnabled(false);
                        comboFuncionario.setEnabled(false);
                        btSalvar.setVisible(false);
                        btCancelar.setVisible(false);
                        btBuscar.setVisible(true);
                        btListar.setVisible(true);
                    } catch (Exception erro) {
                        labelAviso.setText("Erro nos dados!");
                    }
                } else { //btAlterar
                    try {
                        pedido = new Pedido();
                        pedido.setIdPedido(Integer.valueOf(fdIdPedido.getText()));
                        pedido.setDataPedido((Date) spinnerdataPedido.getValue());
//                        pedido.setClienteRG(comboClienteRG.getSelectedItem().toString());
//                        pedido.setFuncionario(comboFuncionario.getSelectedItem().toString());
                        controle.atualizar(pedido);
                        labelAviso.setText("Registro alterado com sucesso!");
                        fdIdPedido.setEnabled(true);
                        fdIdPedido.requestFocus();
                        spinnerdataPedido.setEnabled(false);
                        comboClienteRG.setEnabled(false);
                        comboFuncionario.setEnabled(false);
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
                fdIdPedido.setEnabled(false);
                fdIdPedido.setText("");
                spinnerdataPedido.setEnabled(false);
                spinnerdataPedido.setValue(new Date());
                comboClienteRG.setEnabled(false);
                comboClienteRG.setSelectedIndex(0);
                comboFuncionario.setEnabled(false);
                comboFuncionario.setSelectedIndex(0);
                fdIdPedido.setEnabled(true);
                fdIdPedido.requestFocus();
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
                spinnerdataPedido.setEnabled(true);
                comboClienteRG.setEnabled(true);
                comboFuncionario.setEnabled(true);
                fdIdPedido.setEnabled(false);
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
                if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "Confirma a exclusão do registro <Chave = " + pedido.getIdPedido() + " >?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
                    controle.remover(pedido);
                    labelAviso.setText("Removido!");
                    fdIdPedido.setText("");
                    spinnerdataPedido.setEnabled(false);
                    spinnerdataPedido.setValue(new Date());
                comboClienteRG.setEnabled(false);
                comboClienteRG.setSelectedIndex(0);
                comboFuncionario.setEnabled(false);
                comboFuncionario.setSelectedIndex(0);
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
                new PedidoGUIListagem(controle.listInOrderNomeStrings("tanto faz"), cp);
            }
        }
        );

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        }
        );
         btVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            
                GUIMenu guiMenu = new GUIMenu(); 
            dispose();}
        });
        
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
