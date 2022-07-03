package entities;

public class ItemPedido {
    private Integer qtdPedido;
    private Double preco;
    private Produto produto;

    public ItemPedido( ){

    }

    public ItemPedido(Integer qtdPedido, Double preco, Produto produto) {
        this.qtdPedido = qtdPedido;
        this.preco = preco;
        this.produto = produto;
    }

    public Integer getQtdPedido() {
        return qtdPedido;
    }

    public void setQtdPedido(Integer qtdPedido) {
        this.qtdPedido = qtdPedido;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Produto getProduto(){
        return produto;
    }

    public void setProduto(Produto produto){
        this.produto = produto;
    }

    public Double subTotal(){  // Metodo para calcular o subtotal dos produtos do pedido.
        return preco * qtdPedido;
    }
    @Override
    public String toString(){
        return produto.getNome()
                        + ", $"
                        + String.format("%.2f",preco)
                        + ", Quantidade : "
                        + qtdPedido
                        + "Subtotal: $"
                        + String.format("%.2f", subTotal());
    }

}
