/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;


public class vEntrada {
    
   private String placa,marca,tipo_v,horaE,fechaE, propietario;
   private int modelo, totalpagar;
   public vEntrada(){
       
   } 
   
   public vEntrada(String placa,String marca, int modelo,String propietario, String tipo_v,int totalpagar,String horaE, String fechaE){
       this.placa=placa;
       this.marca=marca;
       this.modelo=modelo;
       this.propietario=propietario;
       this.tipo_v=tipo_v;
       this.horaE=horaE;
       this.fechaE=fechaE;
   }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setTipo_v(String tipo_v) {
        this.tipo_v = tipo_v;
    }

    public void setHoraE(String horaE) {
        this.horaE = horaE;
    }

    public void setFechaE(String fechaE) {
        this.fechaE = fechaE;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    
    public void setTotalpagar(int totalpagar) {
        this.totalpagar = totalpagar;
    }

    public String getMarca() {
        return marca;
    }

    public String getTipo_v() {
        return tipo_v;
    }

    public String getHoraE() {
        return horaE;
    }

    public String getFechaE() {
        return fechaE;
    }

    public int getModelo() {
        return modelo;
    }

    public int getTotalpagar() {
        return totalpagar;
    }
    
}
