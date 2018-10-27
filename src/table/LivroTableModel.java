/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.bean.Livro;

/**
 *
 * @author Heric
 */
public class LivroTableModel extends AbstractTableModel{

    private List<Livro> dados = new ArrayList<>();
    private String[] colunas = {"Titulo", "Autor","Editora","Edição", "Tombamento"};

    public LivroTableModel(List<Livro> dados) {
        this.dados = dados;
    }
    
    
    
    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna){
            case 0:
                return dados.get(linha).getTitulo();
            case 1:
                return dados.get(linha).getAutor();
            case 2:
                 return dados.get(linha).getEditora();
            case 3:
                return dados.get(linha).getEdicao();
            case 4:
                return dados.get(linha).getTombamento();        
        }
        
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
    
    public void adicionar(Livro l){
        dados.add(l);
        int ultimaLinha = getRowCount() - 1;
        fireTableRowsInserted(ultimaLinha, ultimaLinha);
    }
    
    public void atualizar (int iLinha, Livro l){
        dados.set(iLinha, l);
        fireTableRowsUpdated(iLinha, iLinha);
    }
    
    public void excluir(int iLinha){
        dados.remove(iLinha);
        fireTableRowsDeleted(iLinha, iLinha);
    }
    
}
