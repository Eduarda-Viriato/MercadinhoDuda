
package br.com.projeto.model;


public class Produtos {
    
private int código;
    private String nome;
    private String descricao;
    private double preco;
    private String qtd_estoque;
    private int fornecedorId;
    //private Fornecedores fornecedores;

    public Produtos() {
    }

    public int getCódigo() {
        return código;
    }

    public void setCódigo(int código) {
        this.código = código;
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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getQtd_estoque() {
        return qtd_estoque;
    }

    public void setQtd_estoque(String qtd_estoque) {
        this.qtd_estoque = qtd_estoque;
    } 
    
    
/*
    public Fornecedores getFornecedores() {
        return fornecedores;
    }

    public void setFornecedores(Fornecedores fornecedores) {
        this.fornecedores = fornecedores;
    }
*/

    public int getFornecedorId() {
        return fornecedorId;
    } 

    public void setFornecedorId(int fornecedorId) {
        this.fornecedorId = fornecedorId;
    }
    
    
    
}
