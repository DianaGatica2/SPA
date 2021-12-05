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
public class InicioDao {
     private String Usuario;
     private String Contraseña;

    public InicioDao() {
    }

    public InicioDao(String Usuario, String Contraseña) {
        this.Usuario=Usuario;
        this.Contraseña=Contraseña;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }
    public String Contraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }
}
