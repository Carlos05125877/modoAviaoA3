package br.com.a3.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Reserva {
    private int idReserva;
    private String assento;
    private Date dataReserva;
    private Usuario usuario;
    private Voo voo;
    
    public Reserva() {
    
    }
    
    public Date getDataReserva() {
        return dataReserva;
    }
    
    public Voo getVoo() {
        return voo;
    }

    public String getAssento() {
        return assento;
    }
        public void setAssento(String assento) {
        this.assento = assento;
    }

    public void setDataReserva(Date dataReserva) {
        this.dataReserva = dataReserva;
    }     



    public Reserva(int idReserva, Date dataReserva, String assento, Usuario usuario, Voo voo) {
    this.idReserva = idReserva;
    this.dataReserva = dataReserva;
    this.assento = assento;
    this.usuario = usuario;
    this.voo = voo;
}

    public boolean salvarNoBanco() {
        String sql = String.format(
            "INSERT INTO reserva (idUsuario, idVoo, assento, dataReserva) VALUES (%d, %d, '%s', '%s')",
            usuario.getIdUsuario(),
            voo.getIdVoo(),
            assento,
            new java.text.SimpleDateFormat("yyyy-MM-dd").format(dataReserva)
        );

        return ConexaoBD.salvar(sql);
    }

public List<Reserva> buscarReservas() {
    List<Reserva> reservas = new ArrayList<>();
    Usuario usuarioLogado = Usuario.Sessao.usuarioLogado;

    if (usuarioLogado == null) {
        System.err.println("Nenhum usuário logado.");
        return reservas;
    }

    String sql = "SELECT r.idReserva, r.assento, r.dataReserva, u.idUsuario, u.nomeUsuario AS usuarioNome, " +
                 "v.idVoo, v.destino, v.origem, v.dataVoo AS dataVoo " +
                 "FROM reserva r " +
                 "JOIN usuario u ON r.idUsuario = u.idUsuario " +
                 "JOIN voo v ON r.idVoo = v.idVoo " +
                 "WHERE r.idUsuario = " + usuarioLogado.getIdUsuario();

    try (ResultSet resultado = ConexaoBD.buscar(sql)) {
        while (resultado.next()) {
            Usuario usuarioReserva = new Usuario();
            usuarioReserva.setIdUsuario(resultado.getInt("idUsuario"));
            usuarioReserva.setNomeUsuario(resultado.getString("usuarioNome"));

            Voo voo = new Voo();
            voo.setIdVoo(resultado.getInt("idVoo"));
            voo.setDestino(resultado.getString("destino"));
            voo.setOrigem(resultado.getString("origem"));
            voo.setData(resultado.getDate("dataVoo")); // Configuração separada

            Reserva reserva = new Reserva(
                resultado.getInt("idReserva"),
                resultado.getDate("dataReserva"),
                resultado.getString("assento"),
                usuarioReserva,
                voo
            );

            reservas.add(reserva);
        }
    } catch (SQLException e) {
        System.err.println("Erro ao executar consulta: " + e.getMessage());
    }

    return reservas;
}
    @Override
    public String toString() {
    return String.format(" %s | %s | %s",
    voo != null && voo.getData() != null ? new java.text.SimpleDateFormat("dd/MM/yyyy").format(voo.getData()) : "N/A",
    voo != null ? voo.getOrigem() : "N/A",
    voo != null ? voo.getDestino() : "N/A");
    }

}