/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.controlador;

import com.eam.modelo.Usuario;
import org.json.simple.JSONObject;

/**
 *
 * @author Cristian
 */
public class CtlUsuario {
    
    public boolean Loguear(String correo, String password){
        Usuario usuario = new Usuario(correo, password);
        usuario = (Usuario) (Main.dao.buscar(correo, Usuario.class));
        if(usuario!=null){
            if(usuario.getContrasena().equalsIgnoreCase(password)){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
}
