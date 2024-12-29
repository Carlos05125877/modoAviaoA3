package br.com.a3.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Usuario {
    private static List<Usuario> usuarios = new ArrayList<>();
    private static int contadorIdUsuario = 1;

    private int idUsuario;
    private String nomeUsuario;
    private String emailUsuario;
    private String senhaUsuario;
    private String cpfUsuario;
    private String telefoneUsuario;
    private Date dataNascUsuario;

    public Usuario() {}

    public Usuario(int idUsuario, String nomeUsuario, String emailUsuario, String senhaUsuario, String cpfUsuario, String telefoneUsuario, Date dataNascUsuario) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.emailUsuario = emailUsuario;
        this.senhaUsuario = senhaUsuario;
        this.cpfUsuario = cpfUsuario;
        this.telefoneUsuario = telefoneUsuario;
        this.dataNascUsuario = dataNascUsuario;
    }

    // Getters e Setters
    public int getIdUsuario() {
        return idUsuario; }
    
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario; }
    
    public String getNomeUsuario() {
        return nomeUsuario; }
    
    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario; }
    
    public String getEmailUsuario() {
        return emailUsuario; }
    
    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario; }
    
    public String getSenhaUsuario() {
        return senhaUsuario; }
    
    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario; }
    
    public String getCpfUsuario() {
        return cpfUsuario; }
    
    public void setCpfUsuario(String cpfUsuario) {
        this.cpfUsuario = cpfUsuario; }
    
    public String getTelefoneUsuario() {
        return telefoneUsuario; }
    
    public void setTelefoneUsuario(String telefoneUsuario) {
        this.telefoneUsuario = telefoneUsuario; }
    
    public Date getDataNascUsuario() {
        return dataNascUsuario; }
    
    public void setDataNascUsuario(Date dataNascUsuario) {
        this.dataNascUsuario = dataNascUsuario; }

    // Método para carregar usuários do banco de dados
    public static void carregarUsuariosDoBanco() {
        String sql = "SELECT idUsuario, nomeUsuario, emailUsuario, senhaUsuario, cpfUsuario, telefoneUsuario, dataNascimento FROM usuario";
        try (ResultSet rs = ConexaoBD.buscar(sql)) {
            while (rs.next()) {
                int id = rs.getInt("idUsuario");
                String nome = rs.getString("nomeUsuario");
                String email = rs.getString("emailUsuario");
                String senha = rs.getString("senhaUsuario");
                String cpf = rs.getString("cpfUsuario");
                String telefone = rs.getString("telefoneUsuario");
                Date dataNasc = rs.getDate("dataNascimento");

                Usuario usuario = new Usuario(id, nome, email, senha, cpf, telefone, dataNasc);
                usuarios.add(usuario);

                // Atualizar o contador de ID
                if (id >= contadorIdUsuario) {
                    contadorIdUsuario = id + 1;
                }
            }
            System.out.println("Usuários carregados do banco de dados com sucesso.");
        } catch (SQLException e) {
            System.err.println("Erro ao carregar usuários: " + e.getMessage());
        }
    }
    public static Usuario cadastrarUsuario(String nome, String email, String senha, String cpf, String telefone, Date dataNascimento) {
        
     // Verifica se o CPF ou o e-mail já existem no banco
    if (verificarDuplicidade("emailUsuario", email)) {
        System.out.println("Erro: O e-mail já está cadastrado.");
        return null;
    }

    if (verificarDuplicidade("cpfUsuario", cpf)) {
        System.out.println("Erro: O CPF já está cadastrado.");
        return null;
    }    
        
    Usuario novoUsuario = new Usuario(contadorIdUsuario++, nome, email, senha, cpf, telefone, dataNascimento);
    usuarios.add(novoUsuario);
    
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String dataFormatada = dateFormat.format(dataNascimento);

    String sql = "INSERT INTO usuario (nomeUsuario, emailUsuario, senhaUsuario, cpfUsuario, telefoneUsuario, dataNascimento) " +
                 "VALUES ('" + nome + "', '" + email + "', '" + senha + "', '" + cpf + "', '" + telefone + "', '" + dataFormatada + "');";

    boolean salvo = ConexaoBD.salvar(sql);
    if (salvo) {
        System.out.println("\nUsuário cadastrado com sucesso!\n");
    } else {
        System.out.println("\nProblemas ao adicionar o usuário!\n");
    }

    return novoUsuario;
    }
    
     //Permete ao usuario alterar sua senha, caso tenha esquecido
    public static boolean esqueciSenha(String email, String cpf, String novaSenha) {
        // Consulta para validar o e-mail e CPF
        String sql = "SELECT * FROM usuario WHERE emailUsuario = ? AND cpfUsuario = ?";
        boolean dadosValidados = false;

        try {
            // Usa buscarComParametros da ConexaoBD para verificar os dados
            ResultSet realizarBusca = ConexaoBD.buscarComParametros(sql, email, cpf);

            // Se os dados forem encontrados, atualiza a senha
            if (realizarBusca != null && realizarBusca.next()) {
                dadosValidados = true;

                // Atualiza a senha chamando o método atualizar da ConexaoBD
                String updateSql = "UPDATE usuario SET senhaUsuario = ? WHERE emailUsuario = ?";
                boolean senhaAtualizada = ConexaoBD.atualizar(updateSql, novaSenha, email);

                if (senhaAtualizada) {
                    System.out.println("Senha atualizada com sucesso!");
                } else {
                    System.out.println("Erro ao atualizar a senha.");
                    dadosValidados = false;
                }
            } else {
                System.out.println("E-mail ou CPF inválidos.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao validar ou atualizar a senha: " + e.getMessage());
        }

        return dadosValidados;
    }
    // Método para verificar duplicidade
    public static boolean verificarDuplicidade(String coluna, String valor) {
        String sql = "SELECT COUNT(*) AS total FROM usuario WHERE " + coluna + " = ?";
        try (ResultSet rs = ConexaoBD.buscarComParametros(sql, valor)) {
            if (rs != null && rs.next()) {
                return rs.getInt("total") > 0;
            }
        } catch (SQLException e) {
            System.err.println("Erro ao verificar duplicidade: " + e.getMessage());
        }
        return false;
    }

    // Método para realizar login
    public static Usuario realizarLogin(String email, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.emailUsuario.equals(email) && usuario.senhaUsuario.equals(senha)) {
                Sessao.usuarioLogado = usuario;
                System.out.println("Login realizado com sucesso! Bem-vindo, " + usuario.nomeUsuario);
                return usuario;
            }
        }
        System.out.println("Email ou senha incorretos.");
        return null;
    }

    // Classe interna para gerenciar a sessão
    public static class Sessao {
        public static Usuario usuarioLogado;
    }
}