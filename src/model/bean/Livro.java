/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author Heric
 */
public class Livro {
    private String Titulo, Autor, Editora, Edicao, Tombamento;

    public Livro(String Titulo, String Autor, String Editora, String Edicao, String Tombamento) {
        this.Titulo = Titulo;
        this.Autor = Autor;
        this.Editora = Editora;
        this.Edicao = Edicao;
        this.Tombamento = Tombamento;
    }

    public Livro() {
    
    }
    
    

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String Autor) {
        this.Autor = Autor;
    }

    public String getEditora() {
        return Editora;
    }

    public void setEditora(String Editora) {
        this.Editora = Editora;
    }

    public String getEdicao() {
        return Edicao;
    }

    public void setEdicao(String Edicao) {
        this.Edicao = Edicao;
    }

    public String getTombamento() {
        return Tombamento;
    }

    public void setTombamento(String Tombamento) {
        this.Tombamento = Tombamento;
    }
    
    
}
