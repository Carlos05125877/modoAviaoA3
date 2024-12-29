package br.com.a3.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class Voo {
    private int idVoo;
    public String origem;
    public String destino;
    public Date data;
    public String horario;
    public float valor; // Ajustado para float
   

    public Date getData() {
    return data;
    }

    public void setData(Date data) {
    this.data = data;
    }
    
    public void setIdVoo(int idVoo) {
        this.idVoo = idVoo;
    }

    public int getIdVoo() {
        return idVoo;
    }

    public String getHorario() {
        return horario;
    }

    public float getValor() {
        return valor;
    }
    
    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getDestino() {
        return destino;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getOrigem() {
        return origem;
    }

    // Método para carregar voos do banco de dados
    public static ArrayList<Voo> carregarVoos() {
        String sql = "SELECT * FROM voo ORDER BY dataVoo ASC, horarioVoo ASC;";
        ResultSet resultado = ConexaoBD.buscar(sql);

        ArrayList<Voo> listaVoo = new ArrayList<>();
        try {
            while (resultado.next()) {
                Voo vooEncontrado = new Voo();
                vooEncontrado.idVoo = resultado.getInt("idVoo");
                vooEncontrado.origem = resultado.getString("origem");
                vooEncontrado.destino = resultado.getString("destino");
                vooEncontrado.data = resultado.getDate("dataVoo");
                vooEncontrado.horario = resultado.getString("horarioVoo");
                vooEncontrado.valor = resultado.getFloat("valor"); // Ajustado para float
                listaVoo.add(vooEncontrado);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao carregar voos: " + e.getMessage());
        }
        return listaVoo;
    }

    // Representação em String para facilitar seleção e comparação


   
    
}