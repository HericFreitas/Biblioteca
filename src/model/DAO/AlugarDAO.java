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
import model.bean.Alugar;

/**
 *
 * @author Heric
 */
public class AlugarDAO {
    public void insert (Alugar a){
        Connection conn = ConnectionLibrary.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = conn.prepareStatement("INSERT INTO alugar (Nome, Titulo, Autor, Editora, Edição, Tombamento, Data) VALUES (?,?,?,?,?,?,?)");
            stmt.setString(1, a.getPessoa().toUpperCase());
            stmt.setString(2, a.getTitulo().toUpperCase());
            stmt.setString(3, a.getAutor().toUpperCase());
            stmt.setString(4, a.getEditora().toUpperCase());
            stmt.setString(5, a.getEdicao().toUpperCase());
            stmt.setString(6, a.getTombamento().toUpperCase());
            stmt.setString(7, a.getData().toUpperCase());
            
            stmt.executeUpdate();
        
            JOptionPane.showMessageDialog(null, "AGENDADO COM SUCESSO!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "PROBLEMAS");
        }finally{
            ConnectionLibrary.closeConnection(conn, stmt);
        }
    }
    
    public void delete (Alugar a){
        Connection conn = ConnectionLibrary.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = conn.prepareStatement("DELETE FROM alugar WHERE Tombamento = ?");
            stmt.setString(1, a.getTombamento().toUpperCase());
            
            stmt.executeUpdate();
        
            JOptionPane.showMessageDialog(null, "DEVOLVIDO COM SUCESSO!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "PROBLEMAS");
        }finally{
            ConnectionLibrary.closeConnection(conn, stmt);
        }
    }
    
    public List<Alugar> read (){
        Connection conn = ConnectionLibrary.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Alugar> livros = new ArrayList<>();
        
        try {
            stmt = conn.prepareStatement("SELECT * FROM alugar");
            rs = stmt.executeQuery();
            while(rs.next()){
            
                Alugar a = new Alugar();
                a.setPessoa(rs.getString("Nome"));
                a.setTitulo(rs.getString("Titulo"));
                a.setAutor(rs.getString("Autor"));
                a.setEditora(rs.getString("Editora"));
                a.setEdicao(rs.getString("Edição"));
                a.setTombamento(rs.getString("Tombamento"));
                a.setData(rs.getString("Data"));
                livros.add(a);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(LivroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionLibrary.closeConnection(conn, stmt, rs);
        }
        return livros;
    }
}
