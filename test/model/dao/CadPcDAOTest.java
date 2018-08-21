/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.bean.CadSec;
import model.bean.CadPc;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author paulo
 */

/* Testando a chave estrangeira
 * inserindo dados na tabela produto. 
 */
public class CadPcDAOTest {
    
    public CadPcDAOTest() {
    }

    @Test
    @Ignore
    public void inserir() {
        
        CadSec cadsec = new CadSec();
        cadsec.setSecId("SEMTASC");
        
        CadPc cadpc = new CadPc();
        
        cadpc.setOs("1234");
        cadpc.setModelo("VCHN 20");
        cadpc.setPlacaMae("SDSD 3");
        cadpc.setProcessador("i7");
        cadpc.setRam("4 GB");
        cadpc.setFonte("250");
        cadpc.setDataEntra("10/05/2018");
        cadpc.setDataSai("");
        cadpc.setCadSec(cadsec);
        
        CadPcDAO dao = new CadPcDAO();
        
        if (dao.save(cadpc)) {
            System.out.println("Salvo com sucesso");
        }else{
            fail("Erro ao salvar");
        }
    }
    
    
    /* Testando o listar ou findALL para consultar as
     * tabelas usando o inner join
     */
    
    @Test
    
    public void listar () {
        CadPcDAO dao = new CadPcDAO();
        
        for(CadPc p: dao.finAll())
            
            System.out.println("Identificador:"+p.getC_Id()+" - Secretaria: "+p.getCadSec().getSecId()+" - Modelo: "+p.getModelo()+" - Data de chagada: "+p.getDataEntra());
        
    }
}
