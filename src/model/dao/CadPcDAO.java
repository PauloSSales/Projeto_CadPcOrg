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
import model.bean.CadPc;

/**
 *
 * @author paulo
 */
public class CadPcDAO {

    private Connection con = null;

    public CadPcDAO() {

        con = ConnectionFactory.getConnection();
    }

    public boolean save(CadPc cadpc) {

        String sql = "INSERT INTO CadPc (C_id, OS, Sec_id, Modelo, PlacaMae, Processador, RAM,Fonte,DataEntrada,DataSaida) VALUES (?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, cadpc.getC_Id());
            stmt.setString(2, cadpc.getOs());
            stmt.setString(3, cadpc.getCadSec().getSecId());
            stmt.setString(4, cadpc.getModelo());
            stmt.setString(5, cadpc.getPlacaMae());
            stmt.setString(6, cadpc.getProcessador());
            stmt.setString(7, cadpc.getRam());
            stmt.setString(8, cadpc.getFonte());
            stmt.setString(9, cadpc.getDataEntra());
            stmt.setString(10, cadpc.getDataSai());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
    /*Consultar */
    public List<CadPc> finAll(){
        
        /*Pode-se fazer desta forma mais demorada e não aconceilhavel
         * String sql = "select p.id as P_ID, p.descricao as PDESC, qtd, valor, categoria_id, c.id as C_ID, c.descricao as CDESC from dbloja.produto p inner join dbloja.categoria c on c.id = p.categoria_id";
         */
         /*Ou desta maneira usando uma view criada no mysql*/
         String sql = "select * from vw_PcsESec ";
         
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<CadPc> cadpcs = new ArrayList<>();
        
        try {
            
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                CadPc cadpc = new CadPc();
                
                cadpc.setC_Id(rs.getInt("Indetificação"));
                cadpc.setModelo(rs.getString("Modelo"));
                cadpc.setDataEntra(rs.getString("Data de chagada"));
                cadpc.setDataSai(rs.getString("Data de Saida"));
                
                CadSec cadsec = new CadSec("Secretaria");
                cadsec.setSecId(rs.getString("Secretaria"));
                
                cadpc.setCadSec(cadsec);
                
                cadpcs.add(cadpc);
            }
            
        } catch (SQLException ex) {
            System.err.println("Erro: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return cadpcs;
        
    }

}
