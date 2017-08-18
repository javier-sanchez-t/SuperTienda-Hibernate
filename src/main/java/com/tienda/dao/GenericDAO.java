/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.dao;

import com.tienda.entities.CategoriasProductos;
import com.tienda.entities.Productos;
import com.tienda.entities.Proveedores;
import com.tienda.entities.TiposUsuarios;
import com.tienda.entities.Usuarios;
import com.tienda.entities.Ventas;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author MBN USER
 */
public interface GenericDAO<T> {

    boolean guardar(Object T);

    //Usuarios
    Usuarios login(String nombre_usuario, String contrasena);

    List<Usuarios> buscarUsuarios(String parametros);

    //Tipos usuarios
    List<TiposUsuarios> buscarTodosTiposUsuarios();

    //Proveedores
    List<Proveedores> buscarTodosProveedores();

    //categorias productos
    List<CategoriasProductos> buscarTodasCategoriasProductos();

    //Productos
    Productos buscarProductoPorCodigo(String codigo);

    List<Productos> buscarTodosProductos();

    //Ventas
    List<Ventas> buscarVentasEntreFechas(String fechaInicio, String fechaFin);

    Session getSesion();
}
