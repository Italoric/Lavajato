package modelos;

public class Lavagem extends Agendamento {

    protected String placa;
    protected String tipoPagamento;
    protected String descricao;
    protected String pertence;
    protected String usuario;

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPertence() {
        return pertence;
    }

    public void setPertence(String pertence) {
        this.pertence = pertence;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
