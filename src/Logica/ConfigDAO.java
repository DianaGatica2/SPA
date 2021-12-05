/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vConfig;
import Datos.vUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class ConfigDAO {
     private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
   
    public Integer totalregistros;
    
     public boolean insertar(vConfig dts) {
        sSQL = "insert into configuracion (tarifa_auto,tarifa_camioneta,cupo,pensionA,pensionC)"
                + "values (?,?,?,?,?)";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getTarifaA());
            pst.setInt(2, dts.getTarifaC());
            pst.setInt(3, dts.getCupo());
            pst.setInt(4, dts.getPensionA());
            pst.setInt(5, dts.getPensionC());
                       
            int n = pst.executeUpdate();

            if (n != 0) {
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
public boolean editar(vConfig dts) {
        sSQL = "update configuracion set tarifa_auto=?,tarifa_camioneta=?,cupo=?,pensionA=?,"
                + " pensionC=? where idCon=?";
        
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            

            pst.setInt(1, dts.getTarifaA());
            pst.setInt(2, dts.getTarifaC());
            pst.setInt(3, dts.getCupo());
            pst.setInt(4, dts.getPensionA());
            pst.setInt (5, dts.getPensionC());
            pst.setInt(6, dts.getIdConfig());

            int n = pst.executeUpdate();

            if (n != 0) {
                
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
