import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class TelaDeAtualizacao extends JFrame {
    public static JLabel lblId;
    public static JComboBox<String> cbxId;

    public static JLabel lblNome;
    public static JTextField txtNome;

    public static JLabel lblEmail;
    public static JTextField txtEmail;

    public static JLabel lblSenha;
    public static JPasswordField txtSenha;

    public static JButton btnAtualizar;
    public static JButton btnCancelar;

    public static JLabel lblNotificacoes;

    public static GridBagLayout gbLayout;
    public static GridBagConstraints gbConstraints;

    public TelaDeAtualizacao() {
        super("Tela De Atualização");

        gbLayout = new GridBagLayout();
        setLayout(gbLayout);
        gbConstraints = new GridBagConstraints();

        lblId = new JLabel("Id:",SwingConstants.RIGHT);
        addComponent(rootPane, 0, 0, 1, 1);
        cbxId = new JComboBox<String>();
        popularCbxId();
        addComponent(rootPane, 0, 1, 1, 1);

        lblNome = new JLabel("Nome:");
        addComponent(lblNome,1,0,1,1);

        txtNome = new JTextField();
        addComponent(lblNome,1,1,1,1);

        lblEmail = new JLabel("Email:");
        addComponent(lblEmail,2,0,1,1);

        txtEmail = new JTextField();
        addComponent(txtEmail,2,1,1,1);

        lblSenha = new JLabel("Senha:");
        addComponent(lblSenha,3,0,1,1);

        txtSenha = new JPasswordField();
        addComponent(txtSenha,3,1,1,1);

        btnAtualizar = new JButton("Atualizar");
        addComponent(btnAtualizar, 4, 0, 1, 1);

        btnCancelar = new JButton("Cancelar");
        addComponent(btnCancelar, 4, 0, 1, 1);

        setSize(500,500);
        setVisible(true);
    }
    public void addComponent(Component component, int row, int column, int width, int height) {
        if(height > 1 && width > 1) {
            gbConstraints.fill = GridBagConstraints.BOTH;
        } else if (height >1) {
            gbConstraints.fill =GridBagConstraints.VERTICAL;
        } else {
            gbConstraints.fill =GridBagConstraints.HORIZONTAL;
        }
        gbConstraints.gridy = row;
        gbConstraints.gridx = column;
        gbConstraints.gridwidth = width;
        gbConstraints.gridheight = height;
        gbLayout.setConstraints(component, gbConstraints);
        add(component);
    }

    public static void popularCbxId() {
        try{
            Connection conexao = MySQLConnector.conectar();
            String strSqlPopularCbxId = "select * from `db_senac`.`tbl_senac` order by `id` asc;";
            Statement stmSqlPopularCbxId = conexao.createStatement();
            ResultSet rstSqlPopularCbxId = stmSqlPopularCbxId.executeQuery(strSqlPopularCbxId);
            while (rstSqlPopularCbxId.next()) {
                cbxId.addItem(rstSqlPopularCbxId.getString("id"));
            }
            stmSqlPopularCbxId.close();
        } catch (Exception e) {
            lblNotificacoes.setText("Ops! algo de errado não esta certo");
            System.err.println("!!! Erro !!! :" + e);      
        }
    }
    public static void notificarUsuario(String str) {
        lblNotificacoes.setText(str);
    }

    public static String setHtmlFormat(String str) {
        return "<html><body>" + str + "</body><>/html>";
    }

    public static TelaDeAtualizacao appTelaDeAtualizacao;
    public static void main(String[] args) {
        appTelaDeAtualizacao = new TelaDeAtualizacao();
        appTelaDeAtualizacao.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
