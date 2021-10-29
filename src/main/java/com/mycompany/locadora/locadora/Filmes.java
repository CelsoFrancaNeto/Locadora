package com.mycompany.locadora.locadora;
/**
 *
 * @author Luan Felipe Santos Alves
 *         RA: 20203020891
 */
public class Filmes {
    private String nome;
    private String categoria;
    private String preco;
    private boolean estado; 
    
    public Filmes(String nome, String categoria, String preco, boolean estado) {
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.estado = estado;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
