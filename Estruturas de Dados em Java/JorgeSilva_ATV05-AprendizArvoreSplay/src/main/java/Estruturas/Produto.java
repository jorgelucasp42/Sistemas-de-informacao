/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estruturas;

/**
 *
 * @author jorge
 */
import java.time.LocalDate;
import java.util.Objects;

public class Produto implements Comparable<Produto> {
    private int id;
    private String nome;
    private int quantidade;
    private String nomeFuncionarioResponsavel;
    private LocalDate data;

    public Produto(int id, String nome, int quantidade, String nomeFuncionarioResponsavel, LocalDate data) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.nomeFuncionarioResponsavel = nomeFuncionarioResponsavel;
        this.data = data;
    }

    // Getters e setters para os atributos
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getNomeFuncionarioResponsavel() {
        return nomeFuncionarioResponsavel;
    }

    public void setNomeFuncionarioResponsavel(String nomeFuncionarioResponsavel) {
        this.nomeFuncionarioResponsavel = nomeFuncionarioResponsavel;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public int compareTo(Produto outroProduto) {
        return Integer.compare(this.id, outroProduto.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto)) return false;
        Produto produto = (Produto) o;
        return id == produto.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", quantidade=" + quantidade +
                ", nomeFuncionarioResponsavel='" + nomeFuncionarioResponsavel + '\'' +
                ", data=" + data +
                '}';
    }
}
