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
public class CadPc {
    
    private int c_id;
    private String os;
    private String modelo;
    private String placamae;
    private String processador;
    private String ram;
    private String fonte;
    private String dataentra;
    private String datasai;
    
    private CadSec sec_id;

    public CadPc() {
    }

    public CadPc(String os, String modelo, String placamae, String processador, String ram, String fonte, String dataentra, String datasai, CadSec sec_id) {
        this.os = os;
        this.modelo = modelo;
        this.placamae = placamae;
        this.processador = processador;
        this.ram = ram;
        this.fonte = fonte;
        this.dataentra = dataentra;
        this.datasai = datasai;
        this.sec_id = sec_id;
    }
    
    public int getC_Id() {
        return c_id;
    }

    public void setC_Id(int c_id) {
        this.c_id = c_id;
    }
    
    public String getOs(){
        return os;
    }
    
    public void setOs(String os){
        this.os = os;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlacaMae() {
        return placamae;
    }

    public void setPlacaMae(String placamae) {
        this.placamae = placamae;
    }

    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public String getRam(){
        return ram;
    }
    
    public void setRam(String ram) {
        this.ram = ram;
    }
    
    public String getFonte(){
        return fonte;
    }
    
    public void setFonte(String fonte){
        this.fonte = fonte;
    }
    
    public String getDataEntra(){
        return dataentra;
    }
    
    public void setDataEntra(String dataentra){
        this.dataentra = dataentra; 
    }
    
    public String getDataSai(){
        return datasai;
    }
    
    public void setDataSai(String datasai){
        this.datasai = datasai; 
    }
    
    public CadSec getCadSec() {
        return sec_id;
    }
    
    public void setCadSec(CadSec sec_id) {
        this.sec_id = sec_id;
    }
    
    
    
}
