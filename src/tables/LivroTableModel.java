/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tables;

import java.util.List;
import model.bean.Livro;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author heric
 */
public class LivroTableModel extends AbstractTableModel{
    private static final int COL_TITULO = 0;
    private static final int COL_AUTOR = 1;
    private static final int COL_EDITORA = 2;
    private static final int COL_EDICAO = 3;
    private static final int COL_TOMBAMENTO = 4;
    
    private final String[] colunas = new String[]{"Título", "Autor", "Editora", "Edição", "Tombamento"};
    
    private List<Livro> linhas;

    public LivroTableModel(List<Livro> linhas) {
        this.linhas = linhas;
    }
    
    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Livro item = linhas.get(rowIndex);
        switch (columnIndex){
            case COL_TITULO:
                return item.getTitulo();
            case COL_AUTOR:
                return item.getAutor();
            case COL_EDITORA:
                return item.getEditora();
            case COL_EDICAO:
                return item.getEdicao();
            case COL_TOMBAMENTO:
                return item.getTombamento();
            default:
                break;
        }
        return null;
    }
    
    public void add(Livro item){
        linhas.add(item);
        int ultimalinha = getRowCount() - 1;
        fireTableRowsInserted(ultimalinha, ultimalinha);
    }
    
    public void atualizar(int indiceLinha, Livro item){
        linhas.set(indiceLinha, item);
        fireTableRowsUpdated(indiceLinha, indiceLinha);
    }
    
    public void excluir(int indiceLinha){
        linhas.remove(indiceLinha);
        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }
    
    public Livro getItem(int indiceLinha){
        return linhas.get(indiceLinha);
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
    
}
