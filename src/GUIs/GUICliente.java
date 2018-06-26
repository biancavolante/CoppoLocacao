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

public class GUICliente extends JFrame {
    public static void main(String[] args) {
        new GUICliente();
    }
    private Container cp;
    private JLabel labelAviso = new JLabel("Avisos");
    private JLabel labelTitulo = new JLabel("RG: ");
    private JLabel lbRg = new JLabel("RG");
    private JTextField fdRg = new JTextField(15);

    private JLabel lbNomeCliente = new JLabel("Nome Cliente");
    private JTextField fdNomeCliente = new JTextField(45);

    private JLabel lbEndereco = new JLabel("Endereco");
    private JTextField fdEndereco = new JTextField(45);

    private JLabel lbEmail = new JLabel("Email");
    private JTextField fdEmail = new JTextField(45);

    private JLabel lbTelefone = new JLabel("Telefone");
    private JTextField fdTelefone = new JTextField(45);

    JPanel painelImagem = new JPanel(new GridLayout(1, 1));
    Image img;
    Image imagemAux;
    String origem;
    String destino = "src/fotos/";
    String semImagem = "src/fotos/0.png";
    String escolherImagem = "src/fotos/0a.png";
    JLabel labelFoto = new JLabel("");
    Boolean uploadFoto = false;

    private JPanel painelNortes = new JPanel(new GridLayout(2, 1));
    private JPanel painelNorteCima = new JPanel();
    private JPanel painelNorteBaixo = new JPanel();
    private JPanel painelCentralFora = new JPanel(new BorderLayout());
    private JPanel painelCentral = new JPanel();
    private JPanel painelSul = new JPanel(new GridLayout(2,1));
    private JLabel labelBranco = new JLabel();

    JButton btInserir = new JButton(new ImageIcon(getClass().getResource("/icones/add.png")));
    JButton btSalvar = new JButton(new ImageIcon(getClass().getResource("/icones/confirmar.png")));
    JButton btRemover = new JButton(new ImageIcon(getClass().getResource("/icones/deletar.png")));
    JButton btAtualizar = new JButton(new ImageIcon(getClass().getResource("/icones/att.png")));
    JButton btBuscar = new JButton(new ImageIcon(getClass().getResource("/icones/search.png")));
    JButton btCancelar = new JButton(new ImageIcon(getClass().getResource("/icones/cancelar.png")));
    JButton btListar = new JButton(new ImageIcon(getClass().getResource("/icones/listar.png")));
    JButton btVoltar = new JButton("VOLTAR AO MENU");

    DAOCliente controle = new DAOCliente();
    ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
    Boolean acao;
    Font fonte = new Font("Courier New", Font.BOLD, 20);
    Font fonteL = new Font("Courier New", Font.PLAIN, 14);

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    Cliente cliente = new Cliente();

    public GUICliente(){
        setSize(725, 420);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cp = getContentPane();
        cp.setLayout(new BorderLayout());
        setTitle("Cadastro de Clientes");

        try {
            origem = "/fotos/0.png";
            ImageIcon icone = new ImageIcon(getClass().getResource(origem));
            imagemAux = icone.getImage();
            icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));
            labelFoto.setIcon(icone);

        } catch (Exception erro) {
            System.out.println("erro ao carregar a imagem");
        }

        painelCentral.setLayout(new GridLayout(5, 2));
        painelCentral.add(lbNomeCliente);
        painelCentral.add(fdNomeCliente);
        painelCentral.add(lbEndereco);
        painelCentral.add(fdEndereco);
        painelCentral.add(lbEmail);
        painelCentral.add(fdEmail);
        painelCentral.add(lbTelefone);
        painelCentral.add(fdTelefone);

        fdNomeCliente.setEnabled(false);
        fdEndereco.setEnabled(false);
        fdEmail.setEnabled(false);
        fdTelefone.setEnabled(false);

        List<String> combo = new ArrayList<>();


cp.setBackground(Color.white);
        painelImagem.setBackground(Color.white);
        painelImagem.add(labelFoto);
        cp.add(painelNortes, BorderLayout.NORTH);
        cp.add(painelCentralFora, BorderLayout.WEST);
        cp.add(painelImagem, BorderLayout.EAST);
        cp.add(painelSul, BorderLayout.SOUTH);

        painelCentralFora.add(labelBranco, BorderLayout.NORTH);
        painelCentralFora.add(painelCentral, BorderLayout.SOUTH);
        painelNortes.add(painelNorteCima);
        painelNortes.add(painelNorteBaixo);
        painelNorteCima.add(labelTitulo);
        painelNorteCima.add(fdRg);
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
        fdRg.setFont(new Font("Courier New", Font.PLAIN, 20));
        lbRg.setFont(new Font("Courier New", Font.BOLD, 17));
        lbNomeCliente.setFont(new Font("Courier New", Font.BOLD, 17));
        lbEndereco.setFont(new Font("Courier New", Font.BOLD, 17));
        lbEmail.setFont(new Font("Courier New", Font.BOLD, 17));
        lbTelefone.setFont(new Font("Courier New", Font.BOLD, 17));
        fdRg.setFont(new Font("Courier New", Font.PLAIN, 17));
        fdNomeCliente.setFont(new Font("Courier New", Font.PLAIN, 17));
        fdEndereco.setFont(new Font("Courier New", Font.PLAIN, 17));
        fdEmail.setFont(new Font("Courier New", Font.PLAIN, 17));
        fdTelefone.setFont(new Font("Courier New", Font.PLAIN, 17));
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
            uploadFoto = false;
                try{
                    cliente = new Cliente();
                    int rg = Integer.valueOf(fdRg.getText());
                    cliente.setRg(Integer.valueOf(fdRg.getText()));
                    cliente = controle.obter(cliente.getRg());
                    labelAviso.setBackground(Color.green);
                    if (cliente != null) {
                        fdRg.setText(cliente.getRg() + "");
                        fdNomeCliente.setText(cliente.getNomeCliente() + "");
                        fdEndereco.setText(cliente.getEndereco() + "");
                        fdEmail.setText(cliente.getEmail() + "");
                        fdTelefone.setText(cliente.getTelefone() + "");
                        btAtualizar.setVisible(true);
                        btRemover.setVisible(true);
                        btInserir.setVisible(false);
                        btListar.setVisible(false);
                        labelAviso.setText("Encontrado na lista!");
                        labelAviso.setBackground(Color.green);
                        try {
                            String aux = String.valueOf(cliente.getRg()).trim();
                            origem = "/fotos/" + aux + ".png";
                            ImageIcon icone = new ImageIcon(getClass().getResource(origem));
                            imagemAux = icone.getImage();
                            icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));

                            labelFoto.setIcon(icone);

                        } catch (Exception erro) {
                            origem = "/fotos/0.png";
                            ImageIcon icone = new ImageIcon(getClass().getResource(origem));
                            imagemAux = icone.getImage();
                            icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));
                            labelFoto.setIcon(icone);
                        }
                    } else {
        try {
            origem = "/fotos/0.png";
            ImageIcon icone = new ImageIcon(getClass().getResource(origem));
            imagemAux = icone.getImage();
            icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));
            labelFoto.setIcon(icone);

        } catch (Exception erro) {
            System.out.println("erro ao carregar a imagem");
        }
                        fdNomeCliente.setEnabled(false);
                        fdNomeCliente.setText(null);
                        fdEndereco.setEnabled(false);
                        fdEndereco.setText(null);
                        fdEmail.setEnabled(false);
                        fdEmail.setText(null);
                        fdTelefone.setEnabled(false);
                        fdTelefone.setText(null);
                        labelAviso.setText("Não encontrado!");
                        labelAviso.setBackground(Color.red);
                        btInserir.setVisible(true);
                        btAtualizar.setVisible(false);
                        btRemover.setVisible(false);
                        btListar.setVisible(false);
        try {
            origem = "/fotos/0.png";
            ImageIcon icone = new ImageIcon(getClass().getResource(origem));
            imagemAux = icone.getImage();
            icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));
            labelFoto.setIcon(icone);

        } catch (Exception erro) {
            System.out.println("erro ao carregar a imagem");
        }
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
        try {
            origem = "/fotos/0a.png";
            ImageIcon icone = new ImageIcon(getClass().getResource(origem));
            imagemAux = icone.getImage();
            icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));
            labelFoto.setIcon(icone);

        } catch (Exception erro) {
            System.out.println("erro ao carregar a imagem");
        }
                fdRg.setEnabled(false);
                fdNomeCliente.setEnabled(true);
                fdEndereco.setEnabled(true);
                fdEmail.setEnabled(true);
                fdTelefone.setEnabled(true);
            uploadFoto = true;
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
            uploadFoto = false;
                if(acao){ //btInserir
                    try {
                    cliente = new Cliente();
                        cliente.setRg(Integer.valueOf(fdRg.getText()));
                        cliente.setNomeCliente(fdNomeCliente.getText());
                        cliente.setEndereco(fdEndereco.getText());
                        cliente.setEmail(fdEmail.getText());
                        cliente.setTelefone(fdTelefone.getText());
                        controle.inserir(cliente);
                        labelAviso.setText("Registro inserido com sucesso!");
                        fdRg.setEnabled(true);
                        fdRg.requestFocus();
                        fdNomeCliente.setEnabled(false);
                        fdEndereco.setEnabled(false);
                        fdEmail.setEnabled(false);
                        fdTelefone.setEnabled(false);
                        btSalvar.setVisible(false);
                        btCancelar.setVisible(false);
                        btBuscar.setVisible(true);
                        btListar.setVisible(true);
                    } catch (Exception erro) {
                        labelAviso.setText("Erro nos dados!");
                    }
                } else { //btAlterar
                    try {
                        cliente = new Cliente();
                        cliente.setRg(Integer.valueOf(fdRg.getText()));
                        cliente.setNomeCliente(fdNomeCliente.getText());
                        cliente.setEndereco(fdEndereco.getText());
                        cliente.setEmail(fdEmail.getText());
                        cliente.setTelefone(fdTelefone.getText());
                        controle.atualizar(cliente);
                        labelAviso.setText("Registro alterado com sucesso!");
                        fdRg.setEnabled(true);
                        fdRg.requestFocus();
                        fdNomeCliente.setEnabled(false);
                        fdEndereco.setEnabled(false);
                        fdEmail.setEnabled(false);
                        fdTelefone.setEnabled(false);
                        btSalvar.setVisible(false);
                        btCancelar.setVisible(false);
                        btBuscar.setVisible(true);
                        btListar.setVisible(true);
                    } catch (Exception erro) {
                        labelAviso.setText("Erro nos dados!");
                    }
                }
                destino = destino + cliente.getRg() + ".png";
                CopiaImagem.copiar(origem, destino);
                destino = "src/fotos/";
            }
        }
    );

        btCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        try {
            origem = "/fotos/0.png";
            ImageIcon icone = new ImageIcon(getClass().getResource(origem));
            imagemAux = icone.getImage();
            icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));
            labelFoto.setIcon(icone);

        } catch (Exception erro) {
            System.out.println("erro ao carregar a imagem");
        }
                labelAviso.setText("Cancelado!");
                fdRg.setEnabled(false);
                fdRg.setText("");
                fdNomeCliente.setEnabled(false);
                fdNomeCliente.setText("");
                fdEndereco.setEnabled(false);
                fdEndereco.setText("");
                fdEmail.setEnabled(false);
                fdEmail.setText("");
                fdTelefone.setEnabled(false);
                fdTelefone.setText("");
                fdRg.setEnabled(true);
                fdRg.requestFocus();
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
            uploadFoto = false;
                acao = false;
                fdNomeCliente.setEnabled(true);
                fdEndereco.setEnabled(true);
                fdEmail.setEnabled(true);
                fdTelefone.setEnabled(true);
                fdNomeCliente.requestFocus();
                fdRg.setEnabled(false);
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
                if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "Confirma a exclusão do registro <Chave = " + cliente.getRg() + " >?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)) {
                    controle.remover(cliente);
                    labelAviso.setText("Removido!");
                    fdRg.setText("");
                    fdNomeCliente.setText("");
                    fdNomeCliente.setEnabled(false);
                    fdEndereco.setText("");
                    fdEndereco.setEnabled(false);
                    fdEmail.setText("");
                    fdEmail.setEnabled(false);
                    fdTelefone.setText("");
                    fdTelefone.setEnabled(false);
String aux = String.valueOf(cliente.getRg()).trim();
                    origem = "src/fotos/" + aux + ".png";
                    System.out.println(origem);
                    try {
                        File f = new File(origem);
                        if (f.exists()) {
                            f.delete();
                        }
                    } catch (Exception erro) {
                        System.out.println("Erro");
                    }
                    btListar.setVisible(true);
                } else {
                    labelAviso.setText("Remoção cancelada!");
                    btAtualizar.setVisible(true);
                    btRemover.setVisible(true);
                }
            }
        }
        );

 labelFoto.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                if (uploadFoto) {
                    JFileChooser fc = new JFileChooser();
                    fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                    if (fc.showOpenDialog(cp) == JFileChooser.APPROVE_OPTION) {
                        File img = fc.getSelectedFile();
                        origem = fc.getSelectedFile().getAbsolutePath();
                        try {
                            ImageIcon icone = new javax.swing.ImageIcon(img.getAbsolutePath());
                            Image imagemAux;
                            imagemAux = icone.getImage();
                            icone.setImage(imagemAux.getScaledInstance(300, 300, Image.SCALE_FAST));
                            labelFoto.setIcon(icone);

                        } catch (Exception ex) {
                            System.out.println("Erro: " + ex.getMessage());
                        }
                    }

                }

            }
        });

        btListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ClienteGUIListagem(controle.listInOrderNomeStrings("tanto faz"), cp);
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
