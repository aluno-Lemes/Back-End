package view;

import controller.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


public class TelaDeLoginView extends JFrame{

    public static JLabel lblLogin;
    public static JTextField txtLogin;   
    public static JLabel lblSenha;
    public static JPasswordField txtSenha;
    public static JButton btnLogar;
    public static JLabel lblNotificacoes;
 
    public TelaDeLoginView(){

        super("Tela De Login");
        setLayout(new FlowLayout());

        lblLogin = new JLabel("Login:");   //cria o texto "Login:"
        add(lblLogin);   //adiciona (lblLogin) a (JFrame)

        txtLogin = new JTextField(10);   //cria a barra de texto para login
        add(txtLogin);   //adiciona (txtLogin) a (JFrame)

        lblSenha = new JLabel("Senha:");   //cria o texto "Senha:"
        add(lblSenha);   //adiciona (lblSenha) a (JFrame)

        txtSenha = new JPasswordField(10);   //cria a barra de texto para senha
        add(txtSenha);   //adiciona (txtSenha) a (JFrame)

        btnLogar = new JButton("Logar");   //cria o botão "Logar"
        add(btnLogar);  //adiciona (btnLogar) a (JFrame)

        lblNotificacoes = new JLabel("Notificações:"); //cria o texto "Notificações:"
        add(lblNotificacoes); //adiciona (lblNotificacoes) a (JFrame)

        ButtonHandler buttonHandler = new ButtonHandler();
        btnLogar.addActionListener(buttonHandler);

        txtSenha.addKeyListener(
            new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    if (String.valueOf(txtSenha.getPassword()).trim().length() > 0) {
                        if (e.getKeyCode() == 10) {
                            TelaDeLoginController.logarController();
                        }
                    }
                }
            }
        );
    }
    
    private class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            TelaDeLoginController.logarController();
        }
    }


    public static String setHtmlFormat(String txt) {
        return "<html><body>" + txt + "</body></html>";
    }

    public static void notificarUsuario(String strTexto) {
        lblNotificacoes.setText(setHtmlFormat(strTexto));
    }
    public static TelaDeLoginView appTelaDeLoginView;
    public static void main(String[] args) {
        TelaDeLoginView appTelaDeLogin = new TelaDeLoginView();
        appTelaDeLogin.setDefaultCloseOperation(EXIT_ON_CLOSE);
        appTelaDeLogin.setSize(600,100);
        appTelaDeLogin.setVisible(true);
    }
}