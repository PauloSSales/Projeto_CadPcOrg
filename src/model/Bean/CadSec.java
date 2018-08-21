/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author paulo
 */
public class CadSec {
    
    private String sec_id;
    private String secnome;

    public CadSec() {
    }

    public CadSec(String secnome) {
        this.secnome = secnome;
    }

    public String getSecId() {
        return sec_id;
    }

    public void setSecId(String sec_id) {
        this.sec_id = sec_id;
    }

    public String getSecNome() {
        return secnome;
    }

    public void setSecNome(String secnome) {
        this.secnome = secnome;
    }
    
    
    
}