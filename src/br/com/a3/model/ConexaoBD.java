package br.com.a3.model;
import br.com.a3.model.Usuario;
import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConexaoBD {

    private static final String URL = "jdbc:mysql://sql10.freemysqlhosting.net:3306/sql10748719";
    private static final String USER = "sql10748719";
    private static final String PASSWORD = "XlsCsq3LzY";

    // Método para conectar ao banco de dados
    public static Connection conectar() {
        try {
            Connection conexao = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexão estabelecida com sucesso!");
            return conexao;
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            return null;
        }
    }

    // Método para buscar dados do banco
    public static ResultSet buscar(String sql) {
        try {
            Connection conexao = conectar();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            return resultado;
        } catch (SQLException e) {
            System.out.println("Erro ao buscar dados: " + e.getMessage());
            return null;
        }
    }
    public static ResultSet buscarComParametros(String sql, Object... parametros) {
    try {
        Connection conexao = conectar(); // Estabelece a conexão
        PreparedStatement stmt = conexao.prepareStatement(sql); // Prepara o SQL

        // Adiciona os parâmetros ao PreparedStatement
        if (parametros != null) {
            for (int i = 0; i < parametros.length; i++) {
                stmt.setObject(i + 1, parametros[i]); // Configura o parâmetro na posição i + 1
            }
        }

        return stmt.executeQuery(); // Executa a consulta e retorna o ResultSet
    } catch (SQLException e) {
        System.err.println("Erro ao buscar dados com parâmetros: " + e.getMessage());
        return null; // Retorna null em caso de erro
    }
}

    // Método para salvar dados no banco
    public static boolean salvar(String sql) {
        try (Connection conexao = conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao salvar dados: " + e.getMessage());
            return false;
        }
    }

    // Método para atualizar dados no banco
    public static boolean atualizar(String sql, Object... parametros) {
    try (Connection conexao = conectar();
         PreparedStatement stmt = conexao.prepareStatement(sql)) {

        // Configurar os parâmetros
        if (parametros != null) {
            for (int i = 0; i < parametros.length; i++) {
                stmt.setObject(i + 1, parametros[i]); // Configura os parâmetros na posição correta
            }
        }

        // Executa o update
        int rowsAffected = stmt.executeUpdate();
        return rowsAffected > 0; // Retorna true se ao menos uma linha foi atualizada
    } catch (SQLException e) {
        System.err.println("Erro ao atualizar dados: " + e.getMessage());
        return false;
    }
}

    // Método para deletar dados do banco
    public static boolean deletar(String sql) {
        return salvar(sql); // Reutiliza o método de salvar com SQL de deleção
    }
    
}
