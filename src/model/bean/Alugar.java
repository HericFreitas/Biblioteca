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
public class Alugar extends Livro{
    String Data, Pessoa;

    public Alugar() {
    }

    
    public Alugar(String Data, String Pessoa, String Titulo, String Autor, String Editora, String Edicao, String Tombamento) {
        super(Titulo, Autor, Editora, Edicao, Tombamento);
        this.Data = Data;
        this.Pessoa = Pessoa;
    }

    public String getData() {
        return Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }

    @Override
    public String getAutor() {
        return super.getAutor(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEdicao() {
        return super.getEdicao(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditora() {
        return super.getEditora(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getTitulo() {
        return super.getTitulo(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getTombamento() {
        return super.getTombamento(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setAutor(String Autor) {
        super.setAutor(Autor); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setEdicao(String Edicao) {
        super.setEdicao(Edicao); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setEditora(String Editora) {
        super.setEditora(Editora); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setTitulo(String Titulo) {
        super.setTitulo(Titulo); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setTombamento(String Tombamento) {
        super.setTombamento(Tombamento); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String getPessoa() {
        return Pessoa;
    }

    public void setPessoa(String Pessoa) {
        this.Pessoa = Pessoa;
    }
    
    

    
    
}
