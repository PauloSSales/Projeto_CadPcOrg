/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.bean.CadSec;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author paulo
 */
public class CadSecDAOTest {
    
    public CadSecDAOTest() {
    }

    @Test
    public void inserir() {
        
        
        
        CadSec cadsec = new CadSec();
        cadsec.setSecId("SEMTASC");
        cadsec.setSecNome("Semtasc");
        
        CadSecDAO dao = new CadSecDAO();
        
        if(dao.save(cadsec)){
            System.out.println("Cadastrado com sucesso!");
        
        }else{
            fail("Erro ao salvar");
        }
        
    }
    
    @Test
    @Ignore
    public void listar(){
        
        CadSecDAO dao = new CadSecDAO();
        
        for(CadSec c: dao.finAll()){
            
            System.out.println("Orgão: "+c.getSecNome());
            
        }
        
    }
}
