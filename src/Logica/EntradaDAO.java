/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vEntrada;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class EntradaDAO {
    private conexion mysql=new conexion();
   private Connection cn=mysql.conectar();
   private String sSQL="";
   public Integer totalregistros;
   
   public DefaultTableModel mostrar(String buscar){
       DefaultTableModel modelo;
       
       String [] titulos = {"Placa","Marca","Modelo","Propietario","Tipo Vehiculo","Tota pagar","Hora Entrada","Fecha Entrada"};
       
       String [] registro =new String [8];
       
       totalregistros=0;
       modelo = new DefaultTableModel(null,titulos);
       
       sSQL="select * from entrada where marca like '%"+ buscar + "%' order by placa";
       
       try {
           Statement st= cn.createStatement();
           ResultSet rs=st.executeQuery(sSQL);
           
           while(rs.next()){
               registro [0]=rs.getString("Placa");
               registro [1]=rs.getString("Marca");
               registro [2]=rs.getString("Modelo");
               registro [3]=rs.getString("Propietario");
               registro [4]=rs.getString("TipoV");
               registro [5]=rs.getString("Totalpagar");
               registro [6]=rs.getString("HoraE");
               registro [7]=rs.getString("FechaE");
               
               
               totalregistros=totalregistros+1;
               modelo.addRow(registro);
               
           }
           return modelo;
           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return null;
       }
     } 
   
   
   public DefaultTableModel mostrarvista(String buscar){
       DefaultTableModel modelo;
       
       String [] titulos = {"Placa","Marca","Modelo","Propietario","tipo_v","totalpagar","horaE","FechaE"};
       
       String [] registro =new String [8];
       
       totalregistros=0;
       modelo = new DefaultTableModel(null,titulos);
       
       sSQL="select * from entrada where marca like '%"+ buscar + "%'  order by placa";
       
       try {
           Statement st= cn.createStatement();
           ResultSet rs=st.executeQuery(sSQL);
           
           while(rs.next()){
               registro [0]=rs.getString("placa");
               registro [1]=rs.getString("marca");
               registro [2]=rs.getString("modelo");
               registro [3]=rs.getString("Propietario");
               registro [4]=rs.getString("tipo_v");
               registro [5]=rs.getString("totalpagar");
               registro [6]=rs.getString("horaE");
               registro [7]=rs.getString("FechaE");
               
               
               totalregistros=totalregistros+1;
               modelo.addRow(registro);
               
           }
           return modelo;
           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return null;
       }
     }
 public boolean insertar (vEntrada dts){
       sSQL="insert into Entrada (placa,marca,modelo,propietario,tipo_v,totalpagar,horaE,fechaE)" +
               "values (?,?,?,?,?,?,?,?)";
       try {
           
           PreparedStatement pst=cn.prepareStatement(sSQL);
           pst.setString(1, dts.getPlaca());
           pst.setString(2, dts.getMarca());
           pst.setInt(3, dts.getModelo());
           pst.setString(4, dts.getPropietario());
           pst.setString(5, dts.getTipo_v());
           pst.setInt(6, dts.getTotalpagar());
           pst.setString(7, dts.getHoraE());
           pst.setString(8, dts.getFechaE());
           
           int n=pst.executeUpdate();
           
           if (n!=0){
               return true;
           }
           else {
               return false;
           }
           
           
           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return false;
       }
   }
    public boolean editar (vEntrada dts){
       sSQL="update entrada set marca=?,modelo=?,propietario=?,tipo-v=?,totalpagar=?,horaE=?,fechaE=?"+
               " where placa=?";
           
       
       try {
           PreparedStatement pst=cn.prepareStatement(sSQL);
           pst.setString(1, dts.getMarca());
           pst.setInt(2, dts.getModelo());
           pst.setString(3, dts.getPropietario());
           pst.setString(4, dts.getTipo_v());
           pst.setInt(5, dts.getTotalpagar());
           pst.setString(6, dts.getHoraE());
           pst.setString(7, dts.getFechaE());
           pst.setString(8, dts.getPlaca());
           
           int n=pst.executeUpdate();
           
           if (n!=0){
               return true;
           }
           else {
               return false;
           }
           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return false;
       }
   } 
}
