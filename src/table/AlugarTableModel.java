/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.bean.Alugar;

/**
 *
 * @author Heric
 */
public class AlugarTableModel extends AbstractTableModel {

    private List<Alugar> dados = new ArrayList<>();
    private String[] colunas = {"Nome","Titulo", "Autor","Editora","Edição", "Tombamento","Data"};

    public AlugarTableModel(List<Alugar> dados) {
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
                return dados.get(linha).getPessoa();
            case 1:
                return dados.get(linha).getTitulo();
            case 2:
                return dados.get(linha).getAutor();
            case 3:
                 return dados.get(linha).getEditora();
            case 4:
                return dados.get(linha).getEdicao();
            case 5:
                return dados.get(linha).getTombamento();        
            case 6:
                return dados.get(linha).getData();
        }
        
        return null;
    }
    
    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
    
    public void adicionar(Alugar a){
        dados.add(a);
        int ultimaLinha = getRowCount() - 1;
        fireTableRowsInserted(ultimaLinha, ultimaLinha);
    }
    
    public void excluir(int iLinha){
        dados.remove(iLinha);
        fireTableRowsDeleted(iLinha, iLinha);
    }
    
}
