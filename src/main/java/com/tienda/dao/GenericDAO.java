/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.dao;

import com.tienda.entities.TiposUsuarios;
import com.tienda.entities.Usuarios;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author MBN USER
 */
public interface GenericDAO<T> {
    boolean guardar(Object T);
    
    Usuarios login(String nombre_usuario, String contrasena);
    
    //Tipos usuarios
    List<TiposUsuarios> buscarTodosTiposUsuarios();
    
    Session getSesion();
}
