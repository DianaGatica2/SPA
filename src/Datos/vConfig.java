/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author DELL
 */
public class vConfig {
     
   private int idConfig,tarifaA,tarifaC,cupo,pensionA,pensionC;
   public vConfig(){
       
   } 
   
   public vConfig(int idConfig,int tarifaA,int tarifaC, int cupo, int pensionA, int pensionC){
       this.idConfig=idConfig;
       this.tarifaA=tarifaA;
       this.tarifaC=tarifaC;
       this.cupo=cupo;
       this.pensionA=pensionA;
       this.pensionC=pensionC;
   }

    public int getIdConfig() {
        return idConfig;
    }

    public void setIdConfig(int idConfig) {
        this.idConfig = idConfig;
    }

    public void setTarifaA(int tarifaA) {
        this.tarifaA = tarifaA;
    }

    public void setTarifaC(int tarifaC) {
        this.tarifaC = tarifaC;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    public void setPensionA(int pensionA) {
        this.pensionA = pensionA;
    }

    public void setPensionC(int pensionC) {
        this.pensionC = pensionC;
    }

    public int getTarifaA() {
        return tarifaA;
    }

    public int getTarifaC() {
        return tarifaC;
    }

    public int getCupo() {
        return cupo;
    }

    public int getPensionA() {
        return pensionA;
    }

    public int getPensionC() {
        return pensionC;
    }
   
}
