/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import connection.ConnectionLibrary;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Livro;

/**
 *
 * @author Heric
 */
public class LivroDAO {
    /**
     * 
     * @param l 
     */
    public void insert (Livro l){
        Connection conn = ConnectionLibrary.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = conn.prepareStatement("INSERT INTO livro (Titulo, Autor, Editora, Edição, Tombamento) VALUES (?,?,?,?,?)");
            stmt.setString(1, l.getTitulo().toUpperCase());
            stmt.setString(2, l.getAutor().toUpperCase());
            stmt.setString(3, l.getEditora().toUpperCase());
            stmt.setString(4, l.getEdicao().toUpperCase());
            stmt.setString(5, l.getTombamento().toUpperCase());
            
            stmt.executeUpdate();
        
            JOptionPane.showMessageDialog(null, "INSERIDO COM SUCESSO!");
        } catch (SQLException ex) {
            Logger.getLogger(LivroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionLibrary.closeConnection(conn, stmt);
        }
    }
    
    public List<Livro> read (){
        Connection conn = ConnectionLibrary.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Livro> livros = new ArrayList<>();
        
        try {
            stmt = conn.prepareStatement("SELECT * FROM livro");
            rs = stmt.executeQuery();
            while(rs.next()){
            
                Livro l = new Livro();
                l.setTitulo(rs.getString("Titulo"));
                l.setAutor(rs.getString("Autor"));
                l.setEditora(rs.getString("Editora"));
                l.setEdicao(rs.getString("Edição"));
                l.setTombamento(rs.getString("Tombamento"));
                livros.add(l);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(LivroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionLibrary.closeConnection(conn, stmt, rs);
        }
        return livros;
    }
    
    
    
}
