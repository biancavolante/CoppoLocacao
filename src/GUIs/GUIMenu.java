/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIs;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import static java.awt.SystemColor.menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import main.CaixaDeFerramentas;

/**
 *
 * @author Asus
 */
public class GUIMenu extends JFrame {

    Container cp;

    JPanel pnTotal = new JPanel();

    JMenuBar menubarMenu = new JMenuBar();
    JMenu menu = new JMenu("Cadastros");//aqui o que vai aparecer no nome do menu
    JMenuItem cliente = new JMenuItem("Cliente");//as partes do menu
    JMenuItem funcionario = new JMenuItem("Funcionario");
    JMenuItem maquina = new JMenuItem("Máquina");

    CaixaDeFerramentas caixaDeFerramentas = new CaixaDeFerramentas();
    Font fonte = new Font("Courier New", Font.BOLD, 20);
    Font fonteL = new Font("Courier New", Font.PLAIN, 14);
    
    public GUIMenu() {
        setTitle("Coppo Locação de Máquinas");
        setSize(500, 320);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cp = getContentPane();
        menu.setBackground(Color.WHITE);
        cliente.setBackground(Color.WHITE);
        funcionario.setBackground(Color.WHITE);
        maquina.setBackground(Color.WHITE);
        
        
        menu.setFont(new Font ("Courier New", Font.BOLD,20));
        cliente.setFont(new Font ("Courier New", Font.BOLD,20));
        funcionario.setFont(new Font ("Courier New", Font.BOLD,20));
        maquina.setFont(new Font ("Courier New", Font.BOLD,20));

        setJMenuBar(menubarMenu);
        menubarMenu.add(menu);
        menu.add(cliente);//só ta adicionando essas porra
        menu.addSeparator();
        menu.add(funcionario);
        menu.addSeparator();
        menu.add(maquina);
        menu.addSeparator();

        cp.add(pnTotal);

        cliente.addActionListener(new ActionListener() {//faz listener de todos os componentes do menu e só vai
            @Override
            public void actionPerformed(ActionEvent ae) {
                GUICliente guiCliente = new GUICliente();
            }
        });

        funcionario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                GUIFuncionario guiFuncionario = new GUIFuncionario();
            }
        });

        maquina.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                GUIMaquina guiMaquina = new GUIMaquina();
            }
        });


        setVisible(true);
        setLocationRelativeTo(null);
    }
}

