/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.CadSec;

/**
 * CRUD (create result update delete)
 *   
 * @author paulo
 */
public class CadSecDAO {
    
    private Connection con = null;

    public CadSecDAO() {
        con = ConnectionFactory.getConnection();
    }
    
    /*Inserir */
    public boolean save(CadSec secid){
        
        String sql = "INSERT INTO Cadsec (Sec_id,SecNome) VALUES (?,?)";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, secid.getSecId());
            stmt.setString(2, secid.getSecNome());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro: "+ex);
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
    /*Consultar */
    public List<CadSec> finAll(){
        
        String sql = "SELECT * FROM categoria";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<CadSec> categorias = new ArrayList<>();
        
        try {
            
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                CadSec categoria = new CadSec();
                
                categoria.setSecNome(rs.getString("Orgão"));
                categorias.add(categoria);
            }
            
        } catch (SQLException ex) {
            System.err.println("Erro: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return categorias;
        
    }
    
    /*Atualizar */
    public boolean update(CadSec secid){
        
        String sql = "UPDATE Cadsec SET SecNome = ? WHERE Sec_id = ?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, secid.getSecNome());
            stmt.setString(2, secid.getSecId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro: "+ex);
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }    
    
    /*Deletar */
    public boolean delete(CadSec secid){
        
        String sql = "DELETE FROM Cadsec WHERE Sec_id = ?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, secid.getSecId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro: "+ex);
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }    
    
}
