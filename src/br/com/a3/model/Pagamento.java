package br.com.a3.model;


import java.util.Date;

public class Pagamento {
    private int idPagamento;
    private String formaPagamento;
    private Date dataPagamento;
    private float valorPagamento;
    private String statusPagamento;

    public Pagamento(int idPagamento, String formaPagamento, Date dataPagamento, float valorPagamento, String statusPagamento) {
        this.idPagamento = idPagamento;
        this.formaPagamento = formaPagamento;
        this.dataPagamento = dataPagamento;
        this.valorPagamento = valorPagamento;
        this.statusPagamento = statusPagamento;
    }

    public boolean processarPagamento() {
        this.statusPagamento = "Processado";
        return true;
    }

    public String verificarStatusPagamento() {
        return statusPagamento;
    }
    public boolean ValidarNumero(String numeroCartao) {
        if (!numeroCartao.matches("\\d{13,19}")) {
            return false; // O número deve ter entre 13 e 19 dígitos
        }

        int soma = 0;
        boolean alternar = false;

        for (int i = numeroCartao.length() - 1; i >= 0; i--) {
            int digito = Character.getNumericValue(numeroCartao.charAt(i));
            if (alternar) {
                digito *= 2;
                if (digito > 9) {
                    digito -= 9;
                }
            }
            soma += digito;
            alternar = !alternar;
        }

        return soma % 10 == 0;
    }

    public boolean ValidarCvv(String cvv) {
        return cvv.matches("\\d{3,4}");
    }

    public boolean ValidarData(Date dataVencimento) {
        Date hoje = new Date();
        return dataVencimento != null &&
                dataVencimento.after(hoje);
    }

    public boolean ValidarPagemento(boolean cadastroPagamento) {
        int validacao =0;
        if (cadastroPagamento){
            System.out.println("Pagamento realizado com sucesso");
            validacao =1;
        }
        else{
            System.out.println("Cadastre um pagamento para poder finalizar a compra");
        }
        return validacao ==1;
    }
}