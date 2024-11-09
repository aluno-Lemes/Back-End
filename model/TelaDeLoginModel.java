package model;
import controller.*;
import java.sql.*;
import java.util.*;

public class TelaDeLoginModel {
    public static ArrayList<String> logarModel(String login,String senha){
        ArrayList<String> resultados = new ArrayList<String>();
        resultados.add("resultados1");

        try {
            Connection conexao = MySQLConnector.conectar();
            String strSqlLogin = "select * from `db_senac`.`tbl_senac` where email = '" + login + "' and senha = '" + senha + "';";
            Statement stmSqlLogin = conexao.createStatement();
            ResultSet rstSqlLogin = stmSqlLogin.executeQuery(strSqlLogin);
            if (rstSqlLogin.next()) {
                TelaDeLoginController.notificarUsuario("Login realizado com sucesso.");
                // aqui vamos notificar o usuario que o login e senha foram encontrados
            } else {
                TelaDeLoginController.notificarUsuario("Não foi possível encontrar o login e/ou senha digitados. Por favor, verifique e tente novamente.");
                // aqui vamos notificar o usuario que o login e senha não foram encontrados
            }
        } catch (Exception e) {
            TelaDeLoginController.notificarUsuario("Houve um problema e não será possível realizar o login neste momento. Por favor, tente novamente mais tarde.");
            System.err.println("Ops! Deu ruim, se liga no erro: " + e);
        }

        return resultados;
    }
    
}
