public class Produto {
    private int id;
    private String nome;
    private String descricao;
    private double custoProducao;
    private double precoVenda;

    public Produto(int id, String nome, String descricao, double custoProducao, double precoVenda) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.custoProducao = custoProducao;
        this.precoVenda = precoVenda;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getCustoProducao() {
        return custoProducao;
    }

    public void setCustoProducao(double custoProducao) {
        this.custoProducao = custoProducao;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }
}
