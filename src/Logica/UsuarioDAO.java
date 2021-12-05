/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.vUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class UsuarioDAO {
    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
   
    public Integer totalregistros;
    
    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"Clave", "Nombre", "Apaterno", "Amaterno", "Domicilio", "Telefono", "Usuario", "Contraseña", "Tipo_Usuario"};

        String[] registro = new String[14];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

      sSQL="select * from usuario where nombre like '%"+ buscar + "%'  order by clave";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("clave");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("ap");
                registro[3] = rs.getString("am");
                registro[4] = rs.getString("direccion");
                registro[5] = rs.getString("telefono");
                registro[6] = rs.getString("usuario");
                registro[7] = rs.getString("contraseña");
                registro[8] = rs.getString("tipo_user");
                
                
                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }
    
    public boolean insertar(vUsuario dts) {
        sSQL = "insert into usuario (clave,nombre,ap,am,direccion,telefono,usuario,contraseña,tipo_user)"
                + "values (?,?,?,?,?,?,?,?,?)";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getClave());
            pst.setString(2, dts.getNombre());
            pst.setString(3, dts.getApaterno());
            pst.setString(4, dts.getAmaterno());
            pst.setString(5, dts.getDireccion());
            pst.setString(6, dts.getTel());
            pst.setString(7, dts.getUsuario());
            pst.setString(8, dts.getContraseña());
            pst.setString(9, dts.getTipoUser());
            
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
    
    public boolean editar(vUsuario dts) {
        sSQL = "update usuario set nombre=?,ap=?,am=?,direccion=?,tel=?,"
                + " usuario=?,contraseña=?,tipo_user=? where clave=?";
        
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            

            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getApaterno());
            pst.setString(3, dts.getAmaterno());
            pst.setString(4, dts.getDireccion());
            pst.setString (5, dts.getTel());
            pst.setString(6, dts.getUsuario());
            pst.setString(7, dts.getContraseña());
            pst.setString(8, dts.getTipoUser());
            pst.setInt(9, dts.getClave());

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
    public boolean eliminar(vUsuario dts) {
        sSQL = "delete from usuario where clave=?";
       

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            
            pst.setInt(1, dts.getClave());

           

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
public DefaultTableModel login(String usuario,String contraseña) {
        DefaultTableModel modelo;

        String[] titulos = {"Clave", "Nombre", "Apaterno", "Amaterno","Direccion","Telefono","Usuario","Contraseña","Tipo-User"};

        String[] registro = new String[9];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select clave,nombre,ap,am,"
                + "direccion,telefono,usuario,contraseña,tipo_user from usuario "
                + " where usuario='"
                + usuario + "' and contraseña='" + contraseña + "' and tipo_user='ADMINISTRADOR'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("clave");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("ap");
                registro[3] = rs.getString("am");
                registro[4] = rs.getString("direccion");
                registro[5] = rs.getString("telefono");
                registro[6] = rs.getString("usuario");
                registro[7] = rs.getString("contraseña");
                registro[8] = rs.getString("tipo_user");
               
                
                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

    
}
